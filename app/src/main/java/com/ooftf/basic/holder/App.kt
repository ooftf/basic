package com.ooftf.basic.holder

import android.app.Application
import android.util.Log
import kotlin.concurrent.thread

/**
 *
 * @author ooftf
 * @email 994749769@qq.com
 * @date 2020/9/24
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        Log.e("loggggg", "Application   onCreate" + toString())
        val s = ThreadLocal<String>()
        s.set("main")
        thread {
            Log.e("thread1-pre", ""+s.get())
            s.set("thread1")
            Log.e("thread1-after", ""+s.get())
        }
        thread {
            Log.e("thread2-pre", ""+s.get())
            s.set("thread2")
            Log.e("thread2-after", ""+s.get())
        }
        Log.e("main-after", ""+s.get())
    }
}