package com.rezoapp.rezo.presentation.home.request;

import android.content.Context;
import android.widget.ExpandableListView;

import com.rezoapp.rezo.presentation.base.BaseModel;

public class RequestModel extends BaseModel {

    private Context context;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
