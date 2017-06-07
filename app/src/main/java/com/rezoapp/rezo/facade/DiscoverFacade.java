package com.rezoapp.rezo.facade;

import com.rezoapp.rezo.core.contact.ContactManager;
import com.rezoapp.rezo.core.discover.DiscoverManager;
import com.rezoapp.rezo.core.dispatcher.HomeDispatcher;
import com.rezoapp.rezo.core.home.HomeManager;
import com.rezoapp.rezo.core.profile.ProfileManager;
import com.rezoapp.rezo.core.request.RequestManager;
import com.rezoapp.rezo.presentation.base.BaseModel;
import com.rezoapp.rezo.presentation.home.HomeModel;

public class DiscoverFacade {

    private DiscoverManager discoverManager;

    public DiscoverFacade(BaseModel baseModel) {
        this.discoverManager = new DiscoverManager(baseModel);

        HomeDispatcher homeDispatcher = new HomeDispatcher(discoverManager);

        this.discoverManager.setObserver(homeDispatcher);
    }

    public void initDiscover() {
        this.discoverManager.init();
    }
}
