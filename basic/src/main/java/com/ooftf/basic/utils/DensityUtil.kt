package com.ooftf.basic.utils

import android.content.res.Resources

object DensityUtil {
    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    fun dip2pxInt(dpValue: Float): Int {
        val scale = Resources.getSystem().displayMetrics.density
        return (dpValue * scale + 0.5f).toInt()
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    fun px2dipInt(pxValue: Float): Int {
        val scale = Resources.getSystem().displayMetrics.density
        return (pxValue / scale + 0.5f).toInt()
    }

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    fun dip2px(dpValue: Float): Float {
        val scale = Resources.getSystem().displayMetrics.density
        return dpValue * scale
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    fun px2dip(pxValue: Float): Float {
        val scale = Resources.getSystem().displayMetrics.density
        return pxValue / scale
    }

    fun getScreenWidthPx(): Int {
        val displayMetrics = Resources.getSystem().displayMetrics
        return displayMetrics.widthPixels
    }

    fun getScreenHeightPx(): Int {
        val displayMetrics = Resources.getSystem().displayMetrics
        return displayMetrics.heightPixels
    }

    fun sp2px(spValue: Float): Int {
        val fontScale = Resources.getSystem().displayMetrics.scaledDensity
        return (spValue * fontScale + 0.5f).toInt()
    }
}
