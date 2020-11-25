package com.ooftf.basic.utils

import android.graphics.Color

object ColorUtils {

    fun interpolation(from: Int, to: Int, p: Float): Int {
        val red = Color.red(from) * (1-p) + Color.red(to) * p
        val green = Color.green(from) * (1-p) + Color.green(to) * p
        val blue = Color.blue(from) * (1-p) + Color.blue(to) * p
        val alpha = Color.alpha(from) * (1-p) + Color.alpha(to) * p
        return alpha.toInt() shl 24 or (red.toInt() shl 16) or (green.toInt() shl 8) or blue.toInt()
    }

}