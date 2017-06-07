package com.rezoapp.rezo.core.dispatcher;

import com.rezoapp.rezo.core.base.BaseDispatcher;
import com.rezoapp.rezo.core.base.BaseManager;
import com.rezoapp.rezo.core.contact.ContactManager;
import com.rezoapp.rezo.core.discover.DiscoverManager;
import com.rezoapp.rezo.core.facebook.FacebookManager;
import com.rezoapp.rezo.core.google.GoogleManager;
import com.rezoapp.rezo.core.home.HomeManager;
import com.rezoapp.rezo.core.profile.ProfileManager;
import com.rezoapp.rezo.core.request.RequestManager;

import java.util.Observable;

public class ProfileDispatcher extends BaseDispatcher {

    private ProfileManager profileManager;
    private FacebookManager facebookManager;
    private GoogleManager googleManager;

    public ProfileDispatcher(BaseManager... managers) {
        for (BaseManager manager : managers) {
            if (manager instanceof ProfileManager) {
                this.profileManager = (ProfileManager) manager;
            } else if (manager instanceof FacebookManager) {
                this.facebookManager = (FacebookManager) manager;
            } else if (manager instanceof GoogleManager) {
                this.googleManager = (GoogleManager) manager;
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
