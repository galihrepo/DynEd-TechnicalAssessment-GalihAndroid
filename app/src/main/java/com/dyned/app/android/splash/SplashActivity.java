package com.dyned.app.android.splash;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;

import com.dyned.app.android.R;
import com.dyned.app.android.base.BaseActivity;
import com.dyned.app.android.data.Example;
import com.dyned.app.android.data.realm.Address;
import com.dyned.app.android.data.realm.Company;
import com.dyned.app.android.data.realm.Geo;
import com.dyned.app.android.helper.GsonParser;
import com.dyned.app.android.home.HomeActivity;

import org.json.JSONArray;

import java.util.List;

import io.realm.Realm;
import su.levenetc.android.textsurface.Text;
import su.levenetc.android.textsurface.TextBuilder;
import su.levenetc.android.textsurface.TextSurface;
import su.levenetc.android.textsurface.animations.Alpha;
import su.levenetc.android.textsurface.animations.ChangeColor;
import su.levenetc.android.textsurface.animations.Delay;
import su.levenetc.android.textsurface.animations.Sequential;
import su.levenetc.android.textsurface.animations.Slide;
import su.levenetc.android.textsurface.contants.Align;
import su.levenetc.android.textsurface.contants.Side;

public class SplashActivity extends BaseActivity implements SplashContract.View {

    SplashPresenter splashPresenter;
    Realm realm;
    TextSurface textSurface;

    int delay = 1000;
    int maxDelay = 5000;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initial() {
        setupView();
        setupAnimation();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                setupRealm();
                setupPresenter();
                checkingDatabase();
            }
        }, maxDelay);
    }

    @Override
    public void checkingDatabase() {
        com.dyned.app.android.data.realm.Example sample = realm.where(com.dyned.app.android.data.realm.Example.class).findFirst();
        if (sample != null) {
            // realm has data
            navigateToHome();
        } else {
            splashPresenter.actionGetData();
        }
    }

    @Override
    public void setupRealm() {
        realm = Realm.getDefaultInstance();
    }

    @Override
    public void setupPresenter() {
        splashPresenter = new SplashPresenter(this);
    }

    @Override
    public void setupView() {
        textSurface = findViewById(R.id.text_surface);
    }

    @Override
    public void setupAnimation() {
        Text text = TextBuilder
                .create("DYNED")
                .setSize(64)
                .setAlpha(0)
                .setColor(Color.WHITE)
                .setPosition(Align.SURFACE_CENTER).build();

        textSurface.play(
                new Sequential(
                        Slide.showFrom(Side.TOP, text, delay),
                        Delay.duration(delay),
                        ChangeColor.fromTo(text, delay, Color.WHITE, Color.RED),
                        Delay.duration(delay),
                        Alpha.hide(text, delay)
                )
        );
    }

    @Override
    public void navigateToHome() {
        startActivity(new Intent(this, HomeActivity.class));
        finish();
    }

    @Override
    public void insertToRealm(JSONArray jsonArray) {
        final List<Example> list = GsonParser.fromJson(jsonArray.toString());
        for (Example ex : list) {
            realm.beginTransaction();

            Geo geo = new Geo();
            geo.setLat(ex.getAddress().getGeo().getLat());
            geo.setLng(ex.getAddress().getGeo().getLng());

            Address address = new Address();
            address.setCity(ex.getAddress().getCity());
            address.setGeo(geo);
            address.setStreet(ex.getAddress().getStreet());
            address.setSuite(ex.getAddress().getSuite());
            address.setZipcode(ex.getAddress().getZipcode());

            Company company = new Company();
            company.setBs(ex.getCompany().getBs());
            company.setCatchPhrase(ex.getCompany().getCatchPhrase());
            company.setName(ex.getCompany().getName());

            com.dyned.app.android.data.realm.Example example = new com.dyned.app.android.data.realm.Example();
            example.setEmail(ex.getEmail());
            example.setId(ex.getId());
            example.setName(ex.getName());
            example.setPhone(ex.getPhone());
            example.setUsername(ex.getUsername());
            example.setWebsite(ex.getWebsite());
            example.setCompany(company);
            example.setAddress(address);

            realm.insertOrUpdate(example);
            realm.commitTransaction();
        }

        navigateToHome();
    }
}