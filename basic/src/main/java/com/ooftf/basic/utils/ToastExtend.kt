package com.ooftf.basic.utils

import android.content.Context
import android.view.Gravity
import android.widget.Toast
import com.ooftf.basic.AppHolder

/**
 *
 * @author ooftf
 * @email 994749769@qq.com
 * @date 2020/9/23
 */
var toastGravity: Int = Gravity.BOTTOM
fun toast(
    message: CharSequence,
    context: Context = AppHolder.app,
    duration: Int = Toast.LENGTH_SHORT
) {
    val toast = Toast.makeText(context, message, duration)
    if (toastGravity != Gravity.BOTTOM) {
        toast.setGravity(toastGravity, 0, 0)
    }
    toast.show()
}