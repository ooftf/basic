package com.ooftf.basic.utils

import android.os.Handler
import android.os.IBinder
import com.ooftf.basic.engine.ActivityManager

/**
 *
 * @author ooftf
 * @email 994749769@qq.com
 * @date 2021/3/8
 */
object CrashUtil {
    fun catchActivityException() {
        Class.forName("android.app.ActivityThread").reflectClassGetField("sCurrentActivityThread")
            ?.let { at ->
                (at.reflectGetField("mH") as? Handler)?.let { mH ->
                    mH.reflectSetField("mCallback", Handler.Callback { message ->
                        try {
                            message.target.handleMessage(message)
                        } catch (e: Throwable) {
                            e.printStackTrace()
                            when (message.what) {
                                159 -> {//EXECUTE_TRANSACTION
                                    (message.obj.reflectMethod("getActivityToken") as? IBinder)?.let {
                                        toastError("发生异常，自动关闭当前页面！")
                                        ActivityManager.finish(it)
                                    }
                                }

                                134 -> {//SCHEDULE_CRASH::RemoteServiceException
                                    //RemoteServiceException 直接忽略掉，不影响整体程序运行
                                }
                                else -> {
                                    throw e
                                }
                            }

                        }
                        true
                    }, Handler::class.java)
                }
            }
    }
}