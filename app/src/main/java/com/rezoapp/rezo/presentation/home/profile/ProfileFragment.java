package com.rezoapp.rezo.presentation.home.profile;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.rezoapp.rezo.R;
import com.rezoapp.rezo.core.google.GoogleManager;
import com.rezoapp.rezo.facade.ProfileFacade;

public class ProfileFragment extends Fragment implements GoogleApiClient.OnConnectionFailedListener {

    private ProfileModel profileModel;
    private ProfileFacade profileFacade;

    public ProfileFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profile_fragment, container, false);
        setModel(view);
        setFacade();

        this.profileFacade.initFacebook();
        this.profileFacade.initGoogle();
        this.profileFacade.initProfile();

        return view;
    }

    private void setModel(View view) {
        this.profileModel = new ProfileModel();
        this.profileModel.setContext(getContext());
        this.profileModel.setFragment(this);
        this.profileModel.setActivity(getActivity());

        this.profileModel.setCallbackManager(CallbackManager.Factory.create());
        this.profileModel.setFacebookLabel((TextView) view.findViewById(R.id.facebook_label));
        this.profileModel.setFacebookInfoLayout(view.findViewById(R.id.facebook_info_layout));
        this.profileModel.setFacebookLoginButton((LoginButton) view.findViewById(R.id.facebook_login_button));
        this.profileModel.setFacebookUsername((TextView) view.findViewById(R.id.facebook_username));

        this.profileModel.setGoogleLabel((TextView) view.findViewById(R.id.google_label));
        this.profileModel.setGoogleInfoLayout(view.findViewById(R.id.google_info_layout));
        this.profileModel.setGoogleLoginButton((SignInButton) view.findViewById(R.id.google_login_button));
        this.profileModel.setGoogleUsername((TextView) view.findViewById(R.id.google_username));


    }

    private void setFacade() {
        this.profileFacade = new ProfileFacade(this.profileModel);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        System.out.println("**************FRAGMENT RESULT :"+requestCode+" *****************************");
        if (requestCode == GoogleManager.RC_SIGN_IN) {
            profileFacade.handleGoogleActivityResult(data);
        } else {
            profileModel.getCallbackManager().onActivityResult(requestCode, resultCode, data);
        }
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }

    @Override
    public void onPause() {
        super.onPause();
        profileFacade.stopGoogleAutoManage(getActivity());
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        profileFacade.stopGoogleAutoManage(getActivity());
    }
}
