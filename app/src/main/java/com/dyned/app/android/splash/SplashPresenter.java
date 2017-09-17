package com.dyned.app.android.splash;

import com.rx2androidnetworking.Rx2AndroidNetworking;

import org.json.JSONArray;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by galihadityo on 2017-09-17.
 */

public class SplashPresenter implements SplashContract.Presenter {

    private SplashContract.View view;

    public SplashPresenter(SplashContract.View view) {
        this.view = view;
    }

    @Override
    public void actionGetData() {
        Rx2AndroidNetworking.get("https://jsonplaceholder.typicode.com/users")
                .build()
                .getJSONArrayObservable()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<JSONArray>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(JSONArray jsonArray) {
                        view.insertToRealm(jsonArray);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}