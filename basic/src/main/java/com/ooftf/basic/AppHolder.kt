package com.ooftf.basic

import android.app.Application
import android.util.Log
import com.blankj.utilcode.util.Utils
import java.lang.reflect.InvocationTargetException

/**
 *
 * @author ooftf
 * @email 994749769@qq.com
 * @date 2020/9/23
 */
object AppHolder {
    val app: Application by lazy {
        var result = Utils.getApp()
        if (result == null) {
            throw Exception("AppHolder.app == null ")
        }
        result
    }
}