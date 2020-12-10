package com.ooftf.basic.utils

import android.content.res.Resources
import android.graphics.drawable.Drawable
import androidx.core.content.res.ResourcesCompat

/**
 *
 * @author ooftf
 * @email 994749769@qq.com
 * @date 2020/12/10
 */

fun Int.getResColor(theme: Resources.Theme? = null): Int {
    return ResourcesCompat.getColor(Resources.getSystem(), this, theme)
}

fun Int.getResDimension(): Float {
    return Resources.getSystem().getDimension(this)
}

fun Int.getResDimensionPixelSize(): Int {
    return Resources.getSystem().getDimensionPixelSize(this)
}

fun Int.getResText(): CharSequence {
    return Resources.getSystem().getText(this)
}

fun Int.getResString(): CharSequence {
    return Resources.getSystem().getString(this)
}

fun Int.getResDrawable(theme: Resources.Theme? = null): Drawable? {
    return ResourcesCompat.getDrawable(Resources.getSystem(), this, theme)
}