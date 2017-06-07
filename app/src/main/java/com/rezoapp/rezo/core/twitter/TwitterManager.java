package com.rezoapp.rezo.core.twitter;

import android.util.Log;

import com.rezoapp.rezo.R;
import com.rezoapp.rezo.core.base.BaseManager;
import com.rezoapp.rezo.presentation.base.BaseModel;
import com.rezoapp.rezo.presentation.login.LoginModel;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.DefaultLogger;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterConfig;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.TwitterSession;

public class TwitterManager extends BaseManager {

    LoginModel loginModel;

    public TwitterManager(BaseModel baseModel) {
        if (baseModel instanceof LoginModel) {
            this.loginModel = (LoginModel) baseModel;
        }
    }

    public void init() {
        TwitterConfig config = new TwitterConfig.Builder(loginModel.getContext())
                .logger(new DefaultLogger(Log.DEBUG))
                .twitterAuthConfig(new TwitterAuthConfig(loginModel.getContext().getResources().getString(R.string.twitter_key), loginModel.getContext().getResources().getString(R.string.twitter_secret)))
                .debug(true)
                .build();
        Twitter.initialize(config);

        loginModel.getLoginTwitter().setCallback(new Callback<TwitterSession>() {
            @Override
            public void success(Result<TwitterSession> result) {
                StringBuilder textTwitter = new StringBuilder("Success twitter");
                textTwitter.append("\n USERID: " + result.data.getUserId());
                textTwitter.append("\n NAME: " + result.data.getUserName());
                loginModel.getStatusTwitter().setText(textTwitter);
            }

            @Override
            public void failure(TwitterException exception) {
                loginModel.getStatusTwitter().setText("Fail twitter");
            }
        });
    }
}
