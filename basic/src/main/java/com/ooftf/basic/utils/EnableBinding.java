package com.ooftf.basic.utils;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;

/**
 * @author ooftf
 * @email 994749769@qq.com
 * @date 2019/7/24 0024
 */
public class EnableBinding {
    public static void binding(final View view, final TextView... textViews) {
        judgeEnable(view,textViews);
        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                judgeEnable(view,textViews);
            }
        };
        for (int i = 0; i < textViews.length; i++) {
            textViews[i].addTextChangedListener(textWatcher);
        }
    }

    public static void judgeEnable(View view, TextView[] textViews) {
        boolean enable = true;
        for (int i = 0; i < textViews.length; i++) {
            if (textViews[i].getText().length() == 0) {
                enable = false;
                break;
            }
        }
        view.setEnabled(enable);
    }
}
