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
open class ActivityLifecycleCallbacksArmor(var onActivityPreCreated: ((Activity, Bundle?) -> Unit)? = null,
                                           var onActivityCreated: ((Activity, Bundle?) -> Unit)? = null,
                                           var onActivityPostCreated: ((Activity, Bundle?) -> Unit)? = null,

                                           var onActivityPreStarted: ((Activity) -> Unit)? = null,
                                           var onActivityStarted: ((Activity) -> Unit)? = null,
                                           var onActivityPostStarted: ((Activity) -> Unit)? = null,

                                           var onActivityPreResumed: ((Activity) -> Unit)? = null,
                                           var onActivityResumed: ((Activity) -> Unit)? = null,
                                           var onActivityPostResumed: ((Activity) -> Unit)? = null,

                                           var onActivityPrePaused: ((Activity) -> Unit)? = null,
                                           var onActivityPaused: ((Activity) -> Unit)? = null,
                                           var onActivityPostPaused: ((Activity) -> Unit)? = null,

                                           var onActivityPreStopped: ((Activity) -> Unit)? = null,
                                           var onActivityStopped: ((Activity) -> Unit)? = null,
                                           var onActivityPostStopped: ((Activity) -> Unit)? = null,

                                           var onActivityPreSaveInstanceState: ((Activity, Bundle) -> Unit)? = null,
                                           var onActivitySaveInstanceState: ((Activity, Bundle) -> Unit)? = null,
                                           var onActivityPostSaveInstanceState: ((Activity, Bundle) -> Unit)? = null,

                                           var onActivityPreDestroyed: ((Activity) -> Unit)? = null,
                                           var onActivityDestroyed: ((Activity) -> Unit)? = null,
                                           var onActivityPostDestroyed: ((Activity) -> Unit)? = null,
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