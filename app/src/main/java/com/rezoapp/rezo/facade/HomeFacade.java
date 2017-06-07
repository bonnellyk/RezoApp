package com.rezoapp.rezo.facade;

import com.rezoapp.rezo.core.contact.ContactManager;
import com.rezoapp.rezo.core.discover.DiscoverManager;
import com.rezoapp.rezo.core.dispatcher.HomeDispatcher;
import com.rezoapp.rezo.core.dispatcher.LoginDispatcher;
import com.rezoapp.rezo.core.facebook.FacebookManager;
import com.rezoapp.rezo.core.google.GoogleManager;
import com.rezoapp.rezo.core.home.HomeManager;
import com.rezoapp.rezo.core.login.LoginManager;
import com.rezoapp.rezo.core.profile.ProfileManager;
import com.rezoapp.rezo.core.request.RequestManager;
import com.rezoapp.rezo.presentation.base.BaseModel;
import com.rezoapp.rezo.presentation.home.HomeModel;
import com.rezoapp.rezo.presentation.login.LoginModel;

public class HomeFacade {

    private HomeManager homeManager;

    public HomeFacade(BaseModel baseModel) {
        this.homeManager = new HomeManager(baseModel);

        HomeDispatcher homeDispatcher = new HomeDispatcher(homeManager);

        this.homeManager.setObserver(homeDispatcher);
    }

    public void initHome() {
        this.homeManager.init();
    }
}
