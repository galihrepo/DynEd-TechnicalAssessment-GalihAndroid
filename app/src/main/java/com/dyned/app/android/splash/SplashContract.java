package com.dyned.app.android.splash;

import com.dyned.app.android.data.Example;

import org.json.JSONArray;

/**
 * Created by galihadityo on 2017-09-17.
 */

public interface SplashContract {

    interface View {

        void setupView();

        void setupAnimation();

        void navigateToHome();

        void insertToRealm(JSONArray jsonArray);

        void checkingDatabase();

        void setupRealm();

        void setupPresenter();

    }

    interface Presenter {

        void actionGetData();

    }

}
