package com.rezoapp.rezo.core.profile;

import android.view.View;

import com.rezoapp.rezo.R;
import com.rezoapp.rezo.core.base.BaseManager;
import com.rezoapp.rezo.core.profile.info.BaseProfile;
import com.rezoapp.rezo.core.profile.info.FacebookProfile;
import com.rezoapp.rezo.core.profile.info.GoogleProfile;
import com.rezoapp.rezo.core.profile.info.TwitterProfile;
import com.rezoapp.rezo.presentation.base.BaseModel;
import com.rezoapp.rezo.presentation.home.profile.ProfileModel;

import java.util.ArrayList;

public class ProfileManager extends BaseManager {

    private ProfileModel profileModel;

    public ProfileManager(BaseModel baseModel) {
        if (baseModel instanceof ProfileModel) {
            profileModel = (ProfileModel) baseModel;
        }
    }

    public void init() {
        profileModel.getFacebookLabel().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View facebookLayout = profileModel.getFacebookInfoLayout();
                if (facebookLayout.getVisibility() == View.GONE) {
                    facebookLayout.setVisibility(View.VISIBLE);
                } else {
                    facebookLayout.setVisibility(View.GONE);
                }
            }
        });

        profileModel.getGoogleLabel().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View googleLayout = profileModel.getGoogleInfoLayout();
                if (googleLayout.getVisibility() == View.GONE) {
                    googleLayout.setVisibility(View.VISIBLE);
                } else {
                    googleLayout.setVisibility(View.GONE);
                }
            }
        });
    }
}
