package com.dyned.app.android.user;

import android.util.Log;

import com.dyned.app.android.data.realm.Example;
import com.dyned.app.android.data.repo.Repository;
import com.dyned.app.android.splash.SplashContract;
import com.rx2androidnetworking.Rx2AndroidNetworking;

import org.json.JSONArray;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import io.realm.RealmResults;

/**
 * Created by galihadityo on 2017-09-17.
 */

public class UserPresenter implements UserContract.Presenter {

    private UserContract.View view;

    public UserPresenter(UserContract.View view) {
        this.view = view;
    }


    @Override
    public void actionSelectAll() {
        RealmResults<Example> results = Repository.select(view.getRealm());
        view.renderResult(results);
    }

    @Override
    public void actionFind() {
        RealmResults<Example> results = Repository.find(view.getRealm(), view.getKeyword());
        view.renderResult(results);
    }
}