package com.rezoapp.rezo.core.home;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.rezoapp.rezo.R;
import com.rezoapp.rezo.core.base.BaseManager;
import com.rezoapp.rezo.presentation.base.BaseModel;
import com.rezoapp.rezo.presentation.home.HomeModel;
import com.rezoapp.rezo.presentation.home.contact.ContactFragment;
import com.rezoapp.rezo.presentation.home.discover.DiscoverFragment;
import com.rezoapp.rezo.presentation.home.profile.ProfileFragment;
import com.rezoapp.rezo.presentation.home.request.RequestFragment;

import java.util.ArrayList;
import java.util.List;

public class HomeManager extends BaseManager {

    private HomeModel homeModel;

    public HomeManager(BaseModel baseModel) {
        if (baseModel instanceof HomeModel) {
            homeModel = (HomeModel) baseModel;
        }
    }

    public void init() {
        setupViewPager();
        homeModel.getTabs().setupWithViewPager(homeModel.getViewPager());
        setupTabIcons();
    }


    private void setupTabIcons() {
        TabLayout tabs = homeModel.getTabs();
        tabs.getTabAt(0).setIcon(R.drawable.ic_person_white_24dp);
        tabs.getTabAt(1).setIcon(R.drawable.ic_public_white_24dp);
        tabs.getTabAt(2).setIcon(R.drawable.ic_people_white_24dp);
        tabs.getTabAt(3).setIcon(R.drawable.ic_flag_white_24dp);
    }

    private void setupViewPager() {
        ViewPagerAdapter adapter = new ViewPagerAdapter(homeModel.getActivity().getSupportFragmentManager());
        adapter.addFragment(new ProfileFragment(), homeModel.getContext().getResources().getString(R.string.profile));
        adapter.addFragment(new DiscoverFragment(), homeModel.getContext().getResources().getString(R.string.discover));
        adapter.addFragment(new ContactFragment(), homeModel.getContext().getResources().getString(R.string.contact));
        adapter.addFragment(new RequestFragment(), homeModel.getContext().getResources().getString(R.string.request));
        homeModel.getViewPager().setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return null;
        }
    }
}
