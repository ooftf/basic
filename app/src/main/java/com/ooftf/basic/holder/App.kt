package com.ooftf.basic.holder

import android.app.Application
import android.util.Log

/**
 *
 * @author ooftf
 * @email 994749769@qq.com
 * @date 2020/9/24
 */
class App: Application() {
    override fun onCreate() {
        super.onCreate()
        Log.e("loggggg","Application   onCreate"+toString())
    }
}