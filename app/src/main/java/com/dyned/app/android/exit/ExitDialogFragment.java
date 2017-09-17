package com.dyned.app.android.exit;

import android.view.View;

import com.dyned.app.android.R;
import com.dyned.app.android.base.BaseDialogFragment;
import com.dyned.app.android.base.BaseTextView;

/**
 * Created by galihadityo on 2017-09-17.
 */

public class ExitDialogFragment extends BaseDialogFragment {

    BaseTextView tvYes;
    BaseTextView tvNo;

    @Override
    protected int getLayoutId() {
        return R.layout.custom_dialog_exit;
    }

    @Override
    protected void initial(View view) {
        tvYes = view.findViewById(R.id.btn_yes);
        tvYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finishAffinity();
            }
        });

        tvNo = view.findViewById(R.id.btn_no);
        tvNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }
}
