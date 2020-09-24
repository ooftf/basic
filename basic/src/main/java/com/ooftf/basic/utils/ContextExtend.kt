package com.ooftf.basic.utils

import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.ContextWrapper
import android.content.pm.ApplicationInfo
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 *
 * @author ooftf
 * @email 994749769@qq.com
 * @date 2020/9/23
 */
/**
 * Returns the [Activity] given a [Context] or null if there is no [Activity],
 * taking into account the potential hierarchy of [ContextWrappers][ContextWrapper].
 */
fun Context.getActivity(): Activity? {
    var context = this
    while (context is ContextWrapper) {
        if (context is Activity) {
            return context
        }
        context = context.baseContext
    }
    return null
}

fun Context.inflate(layoutId: Int, parent: ViewGroup? = null, isAttach: Boolean = false): View {
    return LayoutInflater.from(this).inflate(layoutId, parent, isAttach)
}