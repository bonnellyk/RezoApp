package com.rezoapp.rezo.core.dispatcher;

import com.rezoapp.rezo.core.base.BaseDispatcher;
import com.rezoapp.rezo.core.base.BaseManager;
import com.rezoapp.rezo.core.contact.ContactManager;
import com.rezoapp.rezo.core.discover.DiscoverManager;
import com.rezoapp.rezo.core.home.HomeManager;
import com.rezoapp.rezo.core.profile.ProfileManager;
import com.rezoapp.rezo.core.request.RequestManager;

import java.util.Observable;

public class HomeDispatcher extends BaseDispatcher {

    private HomeManager homeManager;

    public HomeDispatcher(BaseManager... managers) {
        for (BaseManager manager : managers) {
            if (manager instanceof HomeManager) {
                this.homeManager = (HomeManager) manager;
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
