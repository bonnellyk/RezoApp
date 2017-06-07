package com.rezoapp.rezo.facade;

import android.content.Intent;

import com.rezoapp.rezo.core.dispatcher.LoginDispatcher;
import com.rezoapp.rezo.core.facebook.FacebookManager;
import com.rezoapp.rezo.core.google.GoogleManager;
import com.rezoapp.rezo.core.login.LoginManager;
import com.rezoapp.rezo.presentation.base.BaseModel;
import com.rezoapp.rezo.presentation.login.LoginModel;

public class LoginFacade {

    private FacebookManager facebookManager;
    private GoogleManager googleManager;
    private LoginManager loginManager;

    public LoginFacade(BaseModel baseModel) {
        this.facebookManager = new FacebookManager(baseModel);
        this.googleManager = new GoogleManager(baseModel);
        this.loginManager = new LoginManager(baseModel);
        LoginDispatcher loginDispatcher = new LoginDispatcher(facebookManager,googleManager,loginManager);
        this.facebookManager.setObserver(loginDispatcher);
        this.googleManager.setObserver(loginDispatcher);
        this.loginManager.setObserver(loginDispatcher);
    }

    public void initFacebook() {
        this.facebookManager.init();
    }

    public void initGoogle() {
        this.googleManager.init();
    }

    public void handleGoogleActivityResult(Intent data) {
        this.googleManager.handleActivityResult(data);
    }

    public void initLogin() {
        this.loginManager.init();
    }
}
