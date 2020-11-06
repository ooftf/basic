package com.ooftf.basic.utils

import android.graphics.drawable.Drawable
import android.widget.TextView
import androidx.annotation.DrawableRes

/**
 *
 * @author ooftf
 * @email 994749769@qq.com
 * @date 2020/11/6
 */
fun TextView.setDrawableLeft(drawable: Drawable?) {
    val drawables = compoundDrawables
    setCompoundDrawablesWithIntrinsicBounds(drawable, drawables[1], drawables[2], drawables[3])
}


fun TextView.setDrawableTop(drawable: Drawable?) {
    val drawables = compoundDrawables
    setCompoundDrawablesWithIntrinsicBounds(drawables[0], drawable, drawables[2], drawables[3])
}

fun TextView.setDrawableRight(drawable: Drawable?) {
    val drawables = compoundDrawables
    setCompoundDrawablesWithIntrinsicBounds(drawables[0], drawables[1], drawable, drawables[3])
}

fun TextView.setDrawableBottom(drawable: Drawable?) {
    val drawables = compoundDrawables
    setCompoundDrawablesWithIntrinsicBounds(drawables[0], drawables[1], drawables[2], drawable)
}

fun TextView.setDrawableLeft(@DrawableRes drawable: Int) {
    val drawables = compoundDrawables
    setCompoundDrawablesWithIntrinsicBounds(
        context.getDrawableCompat(drawable),
        drawables[1],
        drawables[2],
        drawables[3]
    )
}

fun TextView.setDrawableTop(@DrawableRes drawable: Int) {
    val drawables = compoundDrawables
    setCompoundDrawablesWithIntrinsicBounds(
        drawables[0],
        context.getDrawableCompat(drawable),
        drawables[2],
        drawables[3]
    )
}

fun TextView.setDrawableRight(@DrawableRes drawable: Int) {
    val drawables = compoundDrawables
    setCompoundDrawablesWithIntrinsicBounds(
        drawables[0],
        drawables[1],
        context.getDrawableCompat(drawable),
        drawables[3]
    )
}

fun TextView.setDrawableBottom(@DrawableRes drawable: Int) {
    val drawables = compoundDrawables
    setCompoundDrawablesWithIntrinsicBounds(
        drawables[0],
        drawables[1],
        drawables[2],
        context.getDrawableCompat(drawable)
    )
}