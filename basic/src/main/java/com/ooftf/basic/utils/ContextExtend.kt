package com.ooftf.basic.utils

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorRes
import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

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

fun Context.getColorCompat(@ColorRes id: Int): Int {
    return ContextCompat.getColor(this, id)
}

fun Context.getDrawableCompat(@DrawableRes id: Int): Drawable? {
    return ContextCompat.getDrawable(this, id)
}

fun Context.getDimensionCompat(@DimenRes id: Int): Float {
    return resources.getDimension(id)
}

fun Context.inflate(layoutId: Int, parent: ViewGroup? = null, isAttach: Boolean = false): View {
    return LayoutInflater.from(this).inflate(layoutId, parent, isAttach)
}

fun Context.getCurrentFragment(): Fragment? {
    return getActivity()?.getCurrentFragment()
}