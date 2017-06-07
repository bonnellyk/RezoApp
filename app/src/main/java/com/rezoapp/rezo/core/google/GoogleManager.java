package com.rezoapp.rezo.core.google;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.rezoapp.rezo.R;
import com.rezoapp.rezo.core.base.BaseManager;
import com.rezoapp.rezo.facade.ProfileFacade;
import com.rezoapp.rezo.presentation.base.BaseModel;
import com.rezoapp.rezo.presentation.home.profile.ProfileModel;
import com.rezoapp.rezo.presentation.login.LoginModel;

public class GoogleManager extends BaseManager {

    LoginModel loginModel;
    ProfileModel profileModel;

    public static int RC_SIGN_IN = 9001;
    GoogleApiClient googleApiClient;

    public GoogleManager(BaseModel baseModel) {
        if (baseModel instanceof LoginModel) {
            this.loginModel = (LoginModel) baseModel;
        } else {
            this.profileModel = (ProfileModel) baseModel;
        }
    }

    public void init() {
        Context context;
        final GoogleApiClient.OnConnectionFailedListener listener;
        final FragmentActivity activity;
        SignInButton loginButton;

        if (loginModel != null) {
            context = loginModel.getContext();
            listener = loginModel.getActivity();
            activity = loginModel.getActivity();
            loginButton = loginModel.getLoginGoogle();
        } else {
            context = profileModel.getContext();
            listener = profileModel.getFragment();
            activity = profileModel.getActivity();
            loginButton = profileModel.getGoogleLoginButton();
        }

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();

        googleApiClient = new GoogleApiClient.Builder(context)
                .enableAutoManage(activity, listener)
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient);
                activity.startActivityForResult(signInIntent, RC_SIGN_IN);
            }
        });

        OptionalPendingResult<GoogleSignInResult> opr = Auth.GoogleSignInApi.silentSignIn(googleApiClient);
        if (opr.isDone()) {
            GoogleSignInResult result = opr.get();
            handleSignInResult(result);
        }
    }

    public void handleActivityResult(Intent data) {
        GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
        handleSignInResult(result);
    }

    private void handleSignInResult(GoogleSignInResult result) {
        if (result.isSuccess()) {
            GoogleSignInAccount acct = result.getSignInAccount();
            if (loginModel != null) {
                loginModel.getStatusGoogle().setText(acct.getDisplayName());
            } else {
                profileModel.getGoogleLoginButton().setVisibility(View.GONE);
                profileModel.getGoogleUsername().setText(acct.getDisplayName());
            }
        } else {
            if (loginModel != null) {
                loginModel.getStatusGoogle().setText("Failure google");
            } else {
                profileModel.getGoogleUsername().setText("ERROR");
            }
        }
    }

    public void stopAutoManage(FragmentActivity activity) {
        googleApiClient.stopAutoManage(activity);
        googleApiClient.disconnect();
    }
}
