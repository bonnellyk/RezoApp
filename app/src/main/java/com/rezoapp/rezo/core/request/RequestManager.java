package com.rezoapp.rezo.core.request;

import com.rezoapp.rezo.core.base.BaseManager;
import com.rezoapp.rezo.presentation.base.BaseModel;
import com.rezoapp.rezo.presentation.home.HomeModel;

public class RequestManager extends BaseManager {

    private HomeModel homeModel;

    public RequestManager(BaseModel baseModel) {
        if (baseModel instanceof HomeModel) {
            homeModel = (HomeModel) baseModel;
        }
    }

    public void init() {

    }
}
