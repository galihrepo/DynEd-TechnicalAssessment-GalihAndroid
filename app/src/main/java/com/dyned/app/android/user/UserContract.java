package com.dyned.app.android.user;

import com.dyned.app.android.data.realm.Example;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by galihadityo on 2017-09-17.
 */

public interface UserContract {

    interface View {

        Realm getRealm();

        String getKeyword();

        void setupPresenter();

        void setupDatabase();

        void setupView();

        void setupAdapter();

        void setupRecycleView();

        void setupSearch();

        void performSearch();

        void renderResult(RealmResults<Example> results);

        void findAll();

    }

    interface Presenter {

        void actionSelectAll();

        void actionFind();

    }

}
