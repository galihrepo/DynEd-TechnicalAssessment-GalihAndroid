package com.dyned.app.android.data.realm;

import io.realm.RealmObject;

/**
 * Created by galihadityo on 2017-09-13.
 */

public class Geo extends RealmObject {

    public String lat;
    public String lng;

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

}
