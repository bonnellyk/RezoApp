package com.rezoapp.rezo.presentation.login;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.rezoapp.rezo.R;
import com.rezoapp.rezo.core.google.GoogleManager;
import com.rezoapp.rezo.facade.LoginFacade;

public class LoginActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener {

    LoginModel loginModel;
    LoginFacade loginFacade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        setModel();
        setFacade();

        initFacebook();
        initGoogle();
        initLogin();
    }

    private void setModel() {
        loginModel = new LoginModel();

        loginModel.setContext(this);
        loginModel.setApplicationContext(getApplicationContext());
        loginModel.setActivity(this);

        loginModel.setFacebookLoginButton((LoginButton) findViewById(R.id.login_button_facebook));
        loginModel.setStatusFacebook((TextView) findViewById(R.id.status_facebook));

        loginModel.setLoginGoogle((SignInButton) findViewById(R.id.login_button_google));
        loginModel.setStatusGoogle((TextView) findViewById(R.id.status_google));

        loginModel.setCallbackManager(CallbackManager.Factory.create());
    }

    private void setFacade() {
        loginFacade = new LoginFacade(loginModel);
    }

    private void initFacebook() {
        this.loginFacade.initFacebook();
    }

    private void initGoogle() {
        this.loginFacade.initGoogle();
    }

    private void initLogin() {
        this.loginFacade.initLogin();
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        System.out.println("*********** FAILED");
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == GoogleManager.RC_SIGN_IN) {
            loginFacade.handleGoogleActivityResult(data);
        } else {
            loginModel.getCallbackManager().onActivityResult(requestCode, resultCode, data);
        }
    }

}
