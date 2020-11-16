package com.ooftf.basic

import android.app.Application
import android.util.Log
import com.ooftf.basic.provider.FlashContentProvider
import java.lang.reflect.InvocationTargetException

/**
 *
 * @author ooftf
 * @email 994749769@qq.com
 * @date 2020/9/23
 */
object AppHolder {
    val app: Application by lazy {
        var result = FlashContentProvider.sApplication
        if (result == null) {
            result = getApplicationByReflect()
        }
        if (result == null) {
            throw Exception("AppHolder.app == null ")
        }
        result
    }

    private fun getApplicationByReflect(): Application? {
        try {
            val activityThreadClass = Class.forName("android.app.ActivityThread")
            getActivityThread()?.let {
                val app = activityThreadClass.getMethod("getApplication").invoke(it) ?: return null
                return app as Application
            }
        } catch (e: InvocationTargetException) {
            e.printStackTrace()
        } catch (e: NoSuchMethodException) {
            e.printStackTrace()
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        }
        return null
    }

    private fun getActivityThread(): Any? {
        var activityThread = getActivityThreadInActivityThreadStaticField()
        if (activityThread != null) return activityThread
        activityThread = getActivityThreadInActivityThreadStaticMethod()
        return activityThread
    }

    private fun getActivityThreadInActivityThreadStaticField(): Any? {
        return try {
            val activityThreadClass = Class.forName("android.app.ActivityThread")
            val sCurrentActivityThreadField =
                activityThreadClass.getDeclaredField("sCurrentActivityThread")
            sCurrentActivityThreadField.isAccessible = true
            sCurrentActivityThreadField[null]
        } catch (e: Exception) {
            Log.e(
                "UtilsActivityLifecycle",
                "getActivityThreadInActivityThreadStaticField: " + e.message
            )
            null
        }
    }

    private fun getActivityThreadInActivityThreadStaticMethod(): Any? {
        return try {
            val activityThreadClass = Class.forName("android.app.ActivityThread")
            activityThreadClass.getMethod("currentActivityThread").invoke(null)
        } catch (e: java.lang.Exception) {
            Log.e(
                "UtilsActivityLifecycle",
                "getActivityThreadInActivityThreadStaticMethod: " + e.message
            )
            null
        }
    }
}