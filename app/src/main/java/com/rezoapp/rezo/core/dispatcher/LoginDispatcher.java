package com.rezoapp.rezo.core.dispatcher;

import com.rezoapp.rezo.core.base.BaseDispatcher;
import com.rezoapp.rezo.core.base.BaseManager;
import com.rezoapp.rezo.core.facebook.FacebookManager;
import com.rezoapp.rezo.core.google.GoogleManager;
import com.rezoapp.rezo.core.login.LoginManager;

import java.util.Observable;

public class LoginDispatcher extends BaseDispatcher {

    private FacebookManager facebookManager;
    private GoogleManager googleManager;
    private LoginManager loginManager;

    public LoginDispatcher(BaseManager... managers) {
        for (BaseManager manager : managers) {
            if (manager instanceof FacebookManager) {
                this.facebookManager = (FacebookManager) manager;
            } else if (manager instanceof GoogleManager) {
                this.googleManager = (GoogleManager) manager;
            } else if (manager instanceof LoginManager) {
                this.loginManager = (LoginManager) manager;
            }
        }
    }

    @Override
    public void update(final Observable observable, final Object o) {
        DispatchObject dispatchObject = (DispatchObject) o;
        switch (dispatchObject.getDispatchAction()) {

        }
    }
}
