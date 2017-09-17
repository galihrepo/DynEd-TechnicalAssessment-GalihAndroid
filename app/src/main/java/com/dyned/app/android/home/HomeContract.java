package com.dyned.app.android.home;

import org.json.JSONArray;

/**
 * Created by galihadityo on 2017-09-17.
 */

public class HomeContract {

    interface View {

        void setupView();

        void setupToolbar();

        void setupDrawer();

        void setupNavigation();

        void setupFirstFragment();

        void onClickUser();

        void onClickAbout();

        void onClickExit();

    }

    interface Presenter {



    }

}
