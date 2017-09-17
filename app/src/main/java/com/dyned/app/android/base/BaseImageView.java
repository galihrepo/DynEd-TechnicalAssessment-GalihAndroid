package com.dyned.app.android.base;

import android.content.Context;
import android.util.AttributeSet;

/**
 * Created by galihadityo on 2017-09-17.
 */

public class BaseImageView extends android.support.v7.widget.AppCompatImageView {

    public BaseImageView(Context context) {
        super(context);
    }

    public BaseImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
