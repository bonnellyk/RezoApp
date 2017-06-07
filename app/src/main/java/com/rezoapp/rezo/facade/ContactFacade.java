package com.rezoapp.rezo.facade;

import com.rezoapp.rezo.core.contact.ContactManager;
import com.rezoapp.rezo.core.discover.DiscoverManager;
import com.rezoapp.rezo.core.dispatcher.HomeDispatcher;
import com.rezoapp.rezo.core.home.HomeManager;
import com.rezoapp.rezo.core.profile.ProfileManager;
import com.rezoapp.rezo.core.request.RequestManager;
import com.rezoapp.rezo.presentation.base.BaseModel;
import com.rezoapp.rezo.presentation.home.HomeModel;

public class ContactFacade {

    private ContactManager contactManager;

    public ContactFacade(BaseModel baseModel) {
        this.contactManager = new ContactManager(baseModel);

        HomeDispatcher homeDispatcher = new HomeDispatcher(contactManager);

        this.contactManager.setObserver(homeDispatcher);
    }

    public void initContact() {
        this.contactManager.init();
    }
}
