package com.ooftf.basic.utils

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

object KeyboardUtils {
    /**
     * 显示键盘
     *
     * @param context
     * @param editText
     */
    fun showKeyBoard(view: View) {
        (view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager)?.showSoftInput(
            view,
            InputMethodManager.RESULT_UNCHANGED_SHOWN
        )
    }

    /**
     * 隐藏键盘
     *
     * @param context
     * @param view
     */
    fun hideKeyBoard(view: View) {
        (view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager)?.hideSoftInputFromWindow(
            view.windowToken,
            InputMethodManager.RESULT_UNCHANGED_SHOWN
        )
    }

    /**
     * Hide the soft input.
     *
     * @param activity The activity.
     */
    fun hideKeyBoard(activity: Activity) {
        (activity.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager)?.hideSoftInputFromWindow(
            activity.window.decorView.windowToken,
            InputMethodManager.RESULT_UNCHANGED_SHOWN
        )
    }
}