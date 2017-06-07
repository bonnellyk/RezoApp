package com.rezoapp.rezo.presentation.home;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.rezoapp.rezo.presentation.base.BaseModel;

public class HomeModel extends BaseModel {

    private Context context;
    private Context applicationContext;
    private HomeActivity activity;

    private Toolbar toolbar;
    private ViewPager viewPager;
    private TabLayout tabs;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public Context getApplicationContext() {
        return applicationContext;
    }

    public void setApplicationContext(Context applicationContext) {
        this.applicationContext = applicationContext;
    }

    public HomeActivity getActivity() {
        return activity;
    }

    public void setActivity(HomeActivity activity) {
        this.activity = activity;
    }

    public Toolbar getToolbar() {
        return toolbar;
    }

    public void setToolbar(Toolbar toolbar) {
        this.toolbar = toolbar;
    }

    public ViewPager getViewPager() {
        return viewPager;
    }

    public void setViewPager(ViewPager viewPager) {
        this.viewPager = viewPager;
    }

    public TabLayout getTabs() {
        return tabs;
    }

    public void setTabs(TabLayout tabs) {
        this.tabs = tabs;
    }
}
