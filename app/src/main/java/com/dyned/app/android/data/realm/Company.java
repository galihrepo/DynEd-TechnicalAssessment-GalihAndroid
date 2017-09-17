package com.dyned.app.android.data.realm;

import io.realm.RealmObject;

/**
 * Created by galihadityo on 2017-09-13.
 */

public class Company extends RealmObject {

    public String name;
    public String catchPhrase;
    public String bs;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public void setCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
    }

    public String getBs() {
        return bs;
    }

    public void setBs(String bs) {
        this.bs = bs;
    }
}
