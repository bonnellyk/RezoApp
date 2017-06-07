package com.rezoapp.rezo.core.discover;

import com.rezoapp.rezo.core.base.BaseManager;
import com.rezoapp.rezo.presentation.base.BaseModel;
import com.rezoapp.rezo.presentation.home.HomeModel;

public class DiscoverManager extends BaseManager {

    private HomeModel homeModel;

    public DiscoverManager(BaseModel baseModel) {
        if (baseModel instanceof HomeModel) {
            homeModel = (HomeModel) baseModel;
        }
    }

    public void init() {

    }

}
