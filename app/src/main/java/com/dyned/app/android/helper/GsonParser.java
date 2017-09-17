package com.dyned.app.android.helper;

import com.dyned.app.android.data.Example;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by galihadityo on 2017-09-17.
 */

public class GsonParser {

    public static List<Example> fromJson(String data) {
        Type type = new TypeToken<List<Example>>() {}.getType();
        return new Gson().fromJson(data, type);
    }

}
