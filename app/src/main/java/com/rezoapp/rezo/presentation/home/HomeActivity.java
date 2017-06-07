package com.rezoapp.rezo.presentation.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.rezoapp.rezo.R;
import com.rezoapp.rezo.facade.HomeFacade;

public class HomeActivity extends AppCompatActivity {

    private HomeModel homeModel;
    private HomeFacade homeFacade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        setModel();
        setToolbar();
        setFacade();

        initHome();
    }

    private void setModel() {
        homeModel = new HomeModel();
        homeModel.setContext(this);
        homeModel.setApplicationContext(getApplicationContext());
        homeModel.setActivity(this);
        homeModel.setToolbar((Toolbar) findViewById(R.id.toolbar));
        homeModel.setViewPager((ViewPager) findViewById(R.id.viewpager));
        homeModel.setTabs((TabLayout) findViewById(R.id.tabs));
    }

    private void setFacade() {
        this.homeFacade = new HomeFacade(homeModel);
    }

    private void setToolbar() {
        setSupportActionBar(homeModel.getToolbar());
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }

    private void initHome() {
        this.homeFacade.initHome();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        getSupportFragmentManager().getFragments().get(0).onActivityResult(requestCode,resultCode,data);
    }
}
