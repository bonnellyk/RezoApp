package com.rezoapp.rezo.facade;

import com.rezoapp.rezo.core.contact.ContactManager;
import com.rezoapp.rezo.core.discover.DiscoverManager;
import com.rezoapp.rezo.core.dispatcher.HomeDispatcher;
import com.rezoapp.rezo.core.home.HomeManager;
import com.rezoapp.rezo.core.profile.ProfileManager;
import com.rezoapp.rezo.core.request.RequestManager;
import com.rezoapp.rezo.presentation.base.BaseModel;
import com.rezoapp.rezo.presentation.home.HomeModel;

public class RequestFacade {

    private RequestManager requestManager;

    public RequestFacade(BaseModel baseModel) {
        this.requestManager = new RequestManager(baseModel);

        HomeDispatcher homeDispatcher = new HomeDispatcher(requestManager);

        this.requestManager.setObserver(homeDispatcher);
    }

    public void initRequest() {
        this.requestManager.init();
    }
}
