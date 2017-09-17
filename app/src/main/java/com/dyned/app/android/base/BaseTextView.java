package com.dyned.app.android.base;

import android.content.Context;
import android.util.AttributeSet;

/**
 * Created by galihadityo on 2017-09-17.
 */

public class BaseTextView extends android.support.v7.widget.AppCompatTextView {
    public BaseTextView(Context context) {
        super(context);
    }

    public BaseTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
