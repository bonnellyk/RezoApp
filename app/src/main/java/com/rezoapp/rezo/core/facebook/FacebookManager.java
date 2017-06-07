package com.rezoapp.rezo.core.facebook;

import android.view.View;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.rezoapp.rezo.core.base.BaseManager;
import com.rezoapp.rezo.presentation.base.BaseModel;
import com.rezoapp.rezo.presentation.home.profile.ProfileModel;
import com.rezoapp.rezo.presentation.login.LoginModel;

public class FacebookManager extends BaseManager {

    private LoginModel loginModel;
    private ProfileModel profileModel;
    private AccessToken accessToken;

    public FacebookManager(BaseModel baseModel) {
        if (baseModel instanceof LoginModel) {
            this.loginModel = (LoginModel) baseModel;
        } else if (baseModel instanceof ProfileModel) {
            this.profileModel = (ProfileModel) baseModel;
        }
    }

    public void init() {
        LoginButton loginButton;
        CallbackManager callbackManager;

        if (loginModel != null) {
            loginButton = loginModel.getFacebookLoginButton();
            callbackManager = loginModel.getCallbackManager();
        } else {
            loginButton = profileModel.getFacebookLoginButton();
            callbackManager = profileModel.getCallbackManager();
            loginButton.setFragment(profileModel.getFragment());
        }

        loginButton.setReadPermissions("email");
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                accessToken = loginResult.getAccessToken();
                if (loginModel != null) {
                    loginModel.getStatusFacebook().setText(accessToken.getUserId());
                } else {
                    profileModel.getFacebookLoginButton().setVisibility(View.GONE);
                    profileModel.getFacebookUsername().setText("USER ID: " + accessToken.getUserId());
                }
            }

            @Override
            public void onCancel() {
            }

            @Override
            public void onError(FacebookException exception) {
                exception.printStackTrace();
            }
        });
    }
}
