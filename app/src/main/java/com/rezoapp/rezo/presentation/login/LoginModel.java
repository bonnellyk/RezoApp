package com.rezoapp.rezo.presentation.login;

import android.content.Context;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.common.SignInButton;
import com.rezoapp.rezo.presentation.base.BaseModel;
import com.twitter.sdk.android.core.identity.TwitterLoginButton;

public class LoginModel extends BaseModel {

    Context context;
    Context applicationContext;
    LoginActivity activity;

    TextView statusFacebook;
    LoginButton facebookLoginButton;
    AccessTokenTracker tokenTrackerFacebook;

    TextView statusGoogle;
    SignInButton loginGoogle;

    TextView statusTwitter;
    TwitterLoginButton loginTwitter;

    TextView statusLinkedIn;
    Button loginLinkedIn;

    CallbackManager callbackManager;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public Context getApplicationContext() {
        return applicationContext;
    }

    public void setApplicationContext(Context applicationContext) {
        this.applicationContext = applicationContext;
    }

    public LoginActivity getActivity() {
        return activity;
    }

    public void setActivity(LoginActivity activity) {
        this.activity = activity;
    }

    public LoginButton getFacebookLoginButton() {
        return facebookLoginButton;
    }

    public void setFacebookLoginButton(LoginButton facebookLoginButton) {
        this.facebookLoginButton = facebookLoginButton;
    }

    public TextView getStatusFacebook() {
        return statusFacebook;
    }

    public void setStatusFacebook(TextView statusFacebook) {
        this.statusFacebook = statusFacebook;
    }

    public AccessTokenTracker getTokenTrackerFacebook() {
        return tokenTrackerFacebook;
    }

    public void setTokenTrackerFacebook(AccessTokenTracker tokenTrackerFacebook) {
        this.tokenTrackerFacebook = tokenTrackerFacebook;
    }
    public SignInButton getLoginGoogle() {
        return loginGoogle;
    }

    public void setLoginGoogle(SignInButton loginGoogle) {
        this.loginGoogle = loginGoogle;
    }

    public TextView getStatusGoogle() {
        return statusGoogle;
    }

    public void setStatusGoogle(TextView statusGoogle) {
        this.statusGoogle = statusGoogle;
    }

    public TwitterLoginButton getLoginTwitter() {
        return loginTwitter;
    }

    public void setLoginTwitter(TwitterLoginButton loginTwitter) {
        this.loginTwitter = loginTwitter;
    }

    public TextView getStatusTwitter() {
        return statusTwitter;
    }

    public void setStatusTwitter(TextView statusTwitter) {
        this.statusTwitter = statusTwitter;
    }

    public TextView getStatusLinkedIn() {
        return statusLinkedIn;
    }

    public void setStatusLinkedIn(TextView statusLinkedIn) {
        this.statusLinkedIn = statusLinkedIn;
    }

    public Button getLoginLinkedIn() {
        return loginLinkedIn;
    }

    public void setLoginLinkedIn(Button loginLinkedIn) {
        this.loginLinkedIn = loginLinkedIn;
    }

    public CallbackManager getCallbackManager() {
        return callbackManager;
    }

    public void setCallbackManager(CallbackManager callbackManager) {
        this.callbackManager = callbackManager;
    }


}
