package com.ooftf.basic.armor

import android.app.Activity
import android.app.Application
import android.os.Bundle

/**
 *
 * @author ooftf
 * @email 994749769@qq.com
 * @date 2020/9/24
 */
open class ActivityLifecycleCallbacksArmor(var onActivityPreCreated: ((Activity, Bundle?) -> Unit)?,
                                           var onActivityCreated: ((Activity, Bundle?) -> Unit)?,
                                           var onActivityPostCreated: ((Activity, Bundle?) -> Unit)?,

                                           var onActivityPreStarted: ((Activity) -> Unit)?,
                                           var onActivityStarted: ((Activity) -> Unit)?,
                                           var onActivityPostStarted: ((Activity) -> Unit)?,

                                           var onActivityPreResumed: ((Activity) -> Unit)?,
                                           var onActivityResumed: ((Activity) -> Unit)?,
                                           var onActivityPostResumed: ((Activity) -> Unit)?,

                                           var onActivityPrePaused: ((Activity) -> Unit)?,
                                           var onActivityPaused: ((Activity) -> Unit)?,
                                           var onActivityPostPaused: ((Activity) -> Unit)?,

                                           var onActivityPreStopped: ((Activity) -> Unit)?,
                                           var onActivityStopped: ((Activity) -> Unit)?,
                                           var onActivityPostStopped: ((Activity) -> Unit)?,

                                           var onActivityPreSaveInstanceState: ((Activity, Bundle) -> Unit)?,
                                           var onActivitySaveInstanceState: ((Activity, Bundle) -> Unit)?,
                                           var onActivityPostSaveInstanceState: ((Activity, Bundle) -> Unit)?,

                                           var onActivityPreDestroyed: ((Activity) -> Unit)?,
                                           var onActivityDestroyed: ((Activity) -> Unit)?,
                                           var onActivityPostDestroyed: ((Activity) -> Unit)?,
                                           ) :
    Application.ActivityLifecycleCallbacks {
    override fun onActivityPreCreated(activity: Activity, savedInstanceState: Bundle?) {
        onActivityPreCreated?.invoke(activity,savedInstanceState)
    }

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        onActivityCreated?.invoke(activity,savedInstanceState)
    }
    override fun onActivityPostCreated(activity: Activity, savedInstanceState: Bundle?) {
        onActivityPostCreated?.invoke(activity,savedInstanceState)
    }

    override fun onActivityPreStarted(activity: Activity) {
        onActivityPreStarted?.invoke(activity)
    }

    override fun onActivityStarted(activity: Activity) {
        onActivityStarted?.invoke(activity)
    }
    override fun onActivityPostStarted(activity: Activity) {
        onActivityPostStarted?.invoke(activity)
    }

    override fun onActivityPreResumed(activity: Activity) {
        onActivityPreResumed?.invoke(activity)
    }

    override fun onActivityResumed(activity: Activity) {
        onActivityResumed?.invoke(activity)
    }
    override fun onActivityPostResumed(activity: Activity) {
        onActivityPostResumed?.invoke(activity)
    }

    override fun onActivityPrePaused(activity: Activity) {
        onActivityPrePaused?.invoke(activity)
    }

    override fun onActivityPaused(activity: Activity) {
        onActivityPaused?.invoke(activity)
    }
    override fun onActivityPostPaused(activity: Activity) {
        onActivityPostPaused?.invoke(activity)
    }

    override fun onActivityPreStopped(activity: Activity) {
        onActivityPreStopped?.invoke(activity)
    }

    override fun onActivityStopped(activity: Activity) {
        onActivityStopped?.invoke(activity)
    }
    override fun onActivityPostStopped(activity: Activity) {
        onActivityPostStopped?.invoke(activity)
    }

    override fun onActivityPreSaveInstanceState(activity: Activity, outState: Bundle) {
        onActivityPreSaveInstanceState?.invoke(activity,outState)
    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
        onActivitySaveInstanceState?.invoke(activity,outState)
    }
    override fun onActivityPostSaveInstanceState(activity: Activity, outState: Bundle) {
        onActivityPostSaveInstanceState?.invoke(activity,outState)
    }

    override fun onActivityPreDestroyed(activity: Activity) {
        onActivityPreDestroyed?.invoke(activity)
    }

    override fun onActivityDestroyed(activity: Activity) {
        onActivityDestroyed?.invoke(activity)
    }
    override fun onActivityPostDestroyed(activity: Activity) {
        onActivityPostDestroyed?.invoke(activity)
    }

}