package com.rezoapp.rezo.facade;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;

import com.rezoapp.rezo.core.contact.ContactManager;
import com.rezoapp.rezo.core.discover.DiscoverManager;
import com.rezoapp.rezo.core.dispatcher.HomeDispatcher;
import com.rezoapp.rezo.core.dispatcher.ProfileDispatcher;
import com.rezoapp.rezo.core.facebook.FacebookManager;
import com.rezoapp.rezo.core.google.GoogleManager;
import com.rezoapp.rezo.core.home.HomeManager;
import com.rezoapp.rezo.core.profile.ProfileManager;
import com.rezoapp.rezo.core.request.RequestManager;
import com.rezoapp.rezo.presentation.base.BaseModel;
import com.rezoapp.rezo.presentation.home.HomeModel;

public class ProfileFacade {

    private ProfileManager profileManager;
    private FacebookManager facebookManager;
    private GoogleManager googleManager;

    public ProfileFacade(BaseModel baseModel) {
        this.profileManager = new ProfileManager(baseModel);
        this.facebookManager = new FacebookManager(baseModel);
        this.googleManager = new GoogleManager(baseModel);

        ProfileDispatcher profileDispatcher = new ProfileDispatcher(profileManager, facebookManager,googleManager);

        this.profileManager.setObserver(profileDispatcher);
        this.facebookManager.setObserver(profileDispatcher);
        this.googleManager.setObserver(profileDispatcher);
    }

    public void initProfile() {
        this.profileManager.init();
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

    public void stopGoogleAutoManage(FragmentActivity activity) {
        this.googleManager.stopAutoManage(activity);
    }
}
