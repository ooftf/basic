package com.ooftf.basic.utils

import android.view.View
import android.view.ViewGroup
import androidx.annotation.DimenRes
import kotlin.math.roundToInt

/**
 *
 * @author ooftf`
 * @email 994749769@qq.com
 * @date 2020/9/23
 */
fun View.inflate(layoutId: Int, parent: ViewGroup? = null, isAttach: Boolean = false): View {
    return context.inflate(layoutId, parent, isAttach)
}

fun View.setPadding(paddingPx: Int) {
    setPadding(paddingPx, paddingPx, paddingPx, paddingPx)
}

fun View.setPaddingLeft(paddingPx: Int) {
    setPadding(paddingPx, paddingTop, paddingRight, paddingBottom)
}

fun View.setPaddingTop(paddingPx: Int) {
    setPadding(paddingLeft, paddingPx, paddingRight, paddingBottom)
}

fun View.setPaddingRight(paddingPx: Int) {
    setPadding(paddingLeft, paddingTop, paddingPx, paddingBottom)
}

fun View.setPaddingBottom(paddingPx: Int) {
    setPadding(paddingLeft, paddingTop, paddingRight, paddingPx)
}

fun View.setPaddingVertical(paddingPx: Int) {
    setPadding(paddingLeft, paddingPx, paddingRight, paddingPx)
}

fun View.setPaddingHorizontal(paddingPx: Int) {
    setPadding(paddingPx, paddingTop, paddingPx, paddingBottom)
}


fun View.setPaddingRes(@DimenRes paddingRes: Int) {
    val paddingPx = context.getDimensionCompat(paddingRes).roundToInt()
    setPadding(paddingPx, paddingPx, paddingPx, paddingPx)
}

fun View.setPaddingLeftRes(@DimenRes paddingRes: Int) {
    val paddingPx = context.getDimensionCompat(paddingRes).roundToInt()
    setPadding(paddingPx, paddingTop, paddingRight, paddingBottom)
}

fun View.setPaddingTopRes(@DimenRes paddingRes: Int) {
    val paddingPx = context.getDimensionCompat(paddingRes).roundToInt()
    setPadding(paddingLeft, paddingPx, paddingRight, paddingBottom)
}

fun View.setPaddingRightRes(@DimenRes paddingRes: Int) {
    val paddingPx = context.getDimensionCompat(paddingRes).roundToInt()
    setPadding(paddingLeft, paddingTop, paddingPx, paddingBottom)
}

fun View.setPaddingBottomRes(@DimenRes paddingRes: Int) {
    val paddingPx = context.getDimensionCompat(paddingRes).roundToInt()
    setPadding(paddingLeft, paddingTop, paddingRight, paddingPx)
}

fun View.setPaddingVerticalRes(@DimenRes paddingRes: Int) {
    val paddingPx = context.getDimensionCompat(paddingRes).roundToInt()
    setPadding(paddingLeft, paddingPx, paddingRight, paddingPx)
}

fun View.setPaddingHorizontalRes(@DimenRes paddingRes: Int) {
    val paddingPx = context.getDimensionCompat(paddingRes).roundToInt()
    setPadding(paddingPx, paddingTop, paddingPx, paddingBottom)
}



