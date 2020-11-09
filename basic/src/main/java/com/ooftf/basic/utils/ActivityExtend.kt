package com.ooftf.basic.utils

import android.app.Activity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

/**
 *
 * @author ooftf
 * @email 994749769@qq.com
 * @date 2020/11/9
 */
fun Activity.getCurrentFragment(): Fragment? {
    return if (this is FragmentActivity) {
        this.supportFragmentManager.fragments.firstOrNull { it.isVisible }
    } else {
        null
    }
}