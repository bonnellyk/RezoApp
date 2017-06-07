package com.rezoapp.rezo.core.linkedin;

import com.rezoapp.rezo.core.base.BaseManager;
import com.rezoapp.rezo.presentation.base.BaseModel;
import com.rezoapp.rezo.presentation.login.LoginModel;

public class LinkedInManager extends BaseManager {

    private LoginModel loginModel;

    public LinkedInManager(BaseModel baseModel) {
        if (baseModel instanceof LoginModel) {
            this.loginModel = (LoginModel) baseModel;
        }
    }

    public void init() {

    }
}
