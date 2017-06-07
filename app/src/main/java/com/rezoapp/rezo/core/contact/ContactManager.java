package com.rezoapp.rezo.core.contact;

import com.rezoapp.rezo.core.base.BaseManager;
import com.rezoapp.rezo.presentation.base.BaseModel;
import com.rezoapp.rezo.presentation.home.HomeModel;

public class ContactManager extends BaseManager {

    private HomeModel homeModel;

    public ContactManager(BaseModel baseModel) {
        if (baseModel instanceof HomeModel) {
            homeModel = (HomeModel) baseModel;
        }
    }

    public void init() {

    }
}
