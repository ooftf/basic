package com.ooftf.basic.provider

import android.app.Application
import android.content.Context
import androidx.startup.Initializer
import com.ooftf.basic.engine.ActivityManager

/**
 *
 * @author ooftf
 * @email 994749769@qq.com
 * @date 2021/7/2
 */
class OoftfBasicInitializer : Initializer<ActivityManager> {

    override fun create(context: Context): ActivityManager {
        ActivityManager.init(context as Application)
        return ActivityManager
    }

    override fun dependencies(): List<Class<out Initializer<*>>> {
        return emptyList()
    }
}