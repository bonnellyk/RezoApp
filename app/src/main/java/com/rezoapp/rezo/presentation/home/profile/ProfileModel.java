package com.rezoapp.rezo.presentation.home.profile;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.common.SignInButton;
import com.rezoapp.rezo.presentation.base.BaseModel;
import com.rezoapp.rezo.presentation.home.HomeActivity;

public class ProfileModel extends BaseModel {

    private Context context;
    private ProfileFragment fragment;
    private FragmentActivity activity;

    private CallbackManager callbackManager;
    private TextView facebookLabel;
    private View facebookInfoLayout;
    private LoginButton facebookLoginButton;
    private TextView facebookUsername;

    private TextView googleLabel;
    private View googleInfoLayout;
    private SignInButton googleLoginButton;
    private TextView googleUsername;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ProfileFragment getFragment() {
        return fragment;
    }

    public void setFragment(ProfileFragment fragment) {
        this.fragment = fragment;
    }

    public FragmentActivity getActivity() {
        return activity;
    }

    public void setActivity(FragmentActivity activity) {
        this.activity = activity;
    }

    public CallbackManager getCallbackManager() {
        return callbackManager;
    }

    public void setCallbackManager(CallbackManager callbackManager) {
        this.callbackManager = callbackManager;
    }

    public TextView getFacebookLabel() {
        return facebookLabel;
    }

    public void setFacebookLabel(TextView facebookLabel) {
        this.facebookLabel = facebookLabel;
    }

    public View getFacebookInfoLayout() {
        return facebookInfoLayout;
    }

    public void setFacebookInfoLayout(View facebookInfoLayout) {
        this.facebookInfoLayout = facebookInfoLayout;
    }

    public LoginButton getFacebookLoginButton() {
        return facebookLoginButton;
    }

    public void setFacebookLoginButton(LoginButton facebookLoginButton) {
        this.facebookLoginButton = facebookLoginButton;
    }

    public TextView getFacebookUsername() {
        return facebookUsername;
    }

    public void setFacebookUsername(TextView facebookUsername) {
        this.facebookUsername = facebookUsername;
    }

    public TextView getGoogleLabel() {
        return googleLabel;
    }

    public void setGoogleLabel(TextView googleLabel) {
        this.googleLabel = googleLabel;
    }

    public View getGoogleInfoLayout() {
        return googleInfoLayout;
    }

    public void setGoogleInfoLayout(View googleInfoLayout) {
        this.googleInfoLayout = googleInfoLayout;
    }

    public SignInButton getGoogleLoginButton() {
        return googleLoginButton;
    }

    public void setGoogleLoginButton(SignInButton googleLoginButton) {
        this.googleLoginButton = googleLoginButton;
    }

    public TextView getGoogleUsername() {
        return googleUsername;
    }

    public void setGoogleUsername(TextView googleUsername) {
        this.googleUsername = googleUsername;
    }
}
