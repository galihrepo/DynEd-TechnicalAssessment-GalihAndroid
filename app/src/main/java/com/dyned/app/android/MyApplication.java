package com.dyned.app.android;

import android.support.multidex.MultiDexApplication;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.interceptors.HttpLoggingInterceptor;

import java.io.IOException;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;

/**
 * Created by galihadityo on 2017-09-17.
 */

public class MyApplication extends MultiDexApplication {

    private static Realm realm;

    @Override
    public void onCreate() {
        super.onCreate();
        setupNetwork();
        setupRealm();
    }

    private void setupRealm() {
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(this)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }

    private void setupNetwork() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        if (BuildConfig.DEBUG) {
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
        }

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(
                        new Interceptor() {
                            @Override
                            public Response intercept(Interceptor.Chain chain) throws IOException {
                                okhttp3.Request request = chain.request().newBuilder()
//                                        .addHeader("Content-Type", "application/json")
                                        .build();
                                return chain.proceed(request);
                            }
                        }
                )
                .addInterceptor(httpLoggingInterceptor)
                .build();

        AndroidNetworking.initialize(getApplicationContext(),okHttpClient);
    }

    public static Realm getRealm() {
        return realm;
    }
}
