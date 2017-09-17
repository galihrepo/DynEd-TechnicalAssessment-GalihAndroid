package com.dyned.app.android.data.repo;

import com.dyned.app.android.data.realm.Example;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by galihadityo on 2017-09-17.
 */

public class Repository {

    public static RealmResults<Example> select(Realm realm) {
        realm.beginTransaction();

        RealmQuery<Example> query = realm.where(Example.class);
        RealmResults<Example> results = query.findAll();

        realm.commitTransaction();

        return results;
    }

    public static RealmResults<Example> find(Realm realm, String keyword) {
        realm.beginTransaction();

        RealmQuery<Example> query = realm.where(Example.class);
        RealmResults<Example> results = query.contains("name", keyword)
                .or()
                .contains("username", keyword)
                .or()
                .contains("email", keyword)
                .findAll();

        realm.commitTransaction();

        return results;
    }

}
