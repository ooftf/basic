package com.ooftf.basic.immersion

import android.app.Activity
import android.graphics.Color
import android.os.Build
import android.view.*
import android.widget.FrameLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.WindowCompat
import com.blankj.utilcode.util.BarUtils
import com.blankj.utilcode.util.KeyboardUtils
import com.ooftf.basic.AppHolder
import com.ooftf.basic.R
import com.ooftf.basic.utils.setPaddingTop

/**
 *
 * @author ooftf
 * @email 994749769@qq.com
 * @date 2021/6/26
 */
object ImmersionUtil {
    val statusBarHeight: Int by lazy {
        AppHolder.app.resources.getDimensionPixelSize(
            AppHolder.app.resources.getIdentifier(
                "status_bar_height",
                "dimen",
                "android"
            )
        )
    }

    fun fitStatusBar(vararg view: View) {
        view.forEach {
            val hasSet = it.getTag(R.id.tag_immersion_status_padding_top)
            if (hasSet == true) {
                return@forEach
            }
            val layoutParams = it.layoutParams
            it.setTag(R.id.tag_immersion_status_padding_top, true)
            it.setPaddingTop(it.paddingTop + statusBarHeight)
            if (isNeedReset(layoutParams)) {
                layoutParams.height = layoutParams.height + statusBarHeight
                it.layoutParams = layoutParams
            }
        }
    }

    fun fitNavigationBar(window: Window) {
        if (!BarUtils.isSupportNavBar()) {
            return
        }
        listenerChange(window.decorView, window)
    }

    fun listenerChange(view: View, window: Window) {
        var tag = view.getTag(R.id.tag_content_layout_listener)
        if (tag == null) {
            tag =DecorViewOnLayoutChangeListener(window)
            view.addOnLayoutChangeListener(tag)
            view.setTag(R.id.tag_content_layout_listener, tag)
        }
    }




    private fun isNeedReset(layoutParams: ViewGroup.LayoutParams): Boolean {
        if (layoutParams.height == ViewGroup.LayoutParams.MATCH_PARENT) {
            return false
        }
        if (layoutParams.height == ViewGroup.LayoutParams.WRAP_CONTENT) {
            return false
        }
        if (layoutParams is ConstraintLayout.LayoutParams) {
            if (layoutParams.height == 0) {
                return false
            }
        }
        return true

    }


    fun setupPreOnCreate(activity: Activity) {
        hideToolbar(activity)
    }

    fun setupAfterOnCreate(activity: Activity, light: Boolean) {
        transparentStatusBar(activity.window)
        lightStatusBar(activity.window, light)
        lightNavigationBar(activity.window, light)
        fitNavigationBar(activity.window)
        val contentView: FrameLayout =
            activity.window.findViewById(android.R.id.content)
        val contentViewChild = contentView.getChildAt(0)
        if (contentViewChild != null) {
            KeyboardUtils.fixAndroidBug5497(activity)
        }
    }

    fun transparentStatusBar(window: Window) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = Color.TRANSPARENT
        }
        WindowCompat.setDecorFitsSystemWindows(window, false)
    }

    fun hideToolbar(activity: Activity) {
        activity.theme.applyStyle(R.style.afm_ooftf_NoActionBar, true)
    }

    fun lightStatusBar(window: Window, light: Boolean) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            BarUtils.setStatusBarLightMode(window, light)
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = Color.parseColor("#32000000")
        }
    }

    fun lightNavigationBar(window: Window, light: Boolean) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            BarUtils.setNavBarLightMode(window, light)
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.navigationBarColor = Color.parseColor("#32000000")
        }
    }



}