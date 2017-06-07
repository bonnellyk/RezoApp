package com.rezoapp.rezo.core.login;

import com.rezoapp.rezo.core.base.BaseManager;
import com.rezoapp.rezo.presentation.base.BaseModel;
import com.rezoapp.rezo.presentation.login.LoginModel;

public class LoginManager extends BaseManager {

    private LoginModel loginModel;

    public LoginManager(BaseModel baseModel) {
        if (baseModel instanceof LoginModel) {
            this.loginModel = (LoginModel) baseModel;
        }
    }

    public void init() {

    }
}
