package com.ooftf.basic.utils

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

/**
 * @author ooftf
 * @email 994749769@qq.com
 * @date 2019/7/4 0004
 */
fun Lifecycle.isShow(): Boolean {
    return currentState.isAtLeast(Lifecycle.State.STARTED)
}

fun Lifecycle.isTouch(): Boolean {
    return currentState.isAtLeast(Lifecycle.State.RESUMED)
}

fun Lifecycle.isDestroy(): Boolean {
    return currentState == Lifecycle.State.DESTROYED
}

fun Lifecycle.postOnResume(runnable: Runnable) {
    if (isTouch()) {
        runnable.run()
    } else {
        addObserver(object : LifecycleObserver {
            @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
            fun onResume() {
                runnable.run()
                removeObserver(this)
            }
        })
    }
}

fun Lifecycle.postOnStart(runnable: Runnable) {
    if (isShow()) {
        runnable.run()
    } else {
        addObserver(object : LifecycleObserver {
            @OnLifecycleEvent(Lifecycle.Event.ON_START)
            fun onStart() {
                runnable.run()
                removeObserver(this)
            }
        })
    }
}

fun Lifecycle.postOnDestroy(runnable: Runnable) {
    if (isDestroy()) {
        runnable.run()
    } else {
        addObserver(object : LifecycleObserver {
            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
            fun onDestroy() {
                runnable.run()
                removeObserver(this)
            }
        })
    }
}

fun Lifecycle.postOnNextStart(runnable: Runnable) {
    addObserver(object : LifecycleObserver {
        @OnLifecycleEvent(Lifecycle.Event.ON_START)
        fun onStart() {
            runnable.run()
            removeObserver(this)
        }
    })
}

fun Lifecycle.postNextOnResume(runnable: Runnable) {
    addObserver(object : LifecycleObserver {
        @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
        fun onResume() {
            runnable.run()
            removeObserver(this)
        }
    })
}

fun Lifecycle.addOnStartListener(runnable: Runnable): LifecycleObserver {
    val lifecycleObserver: LifecycleObserver = object : LifecycleObserver {
        @OnLifecycleEvent(Lifecycle.Event.ON_START)
        fun onStart() {
            runnable.run()
        }
    }
    addObserver(lifecycleObserver)
    return lifecycleObserver
}

fun Lifecycle.addOnResumeListener(runnable: Runnable): LifecycleObserver {
    val lifecycleObserver: LifecycleObserver = object : LifecycleObserver {
        @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
        fun onResume() {
            runnable.run()
        }
    }
    addObserver(lifecycleObserver)
    return lifecycleObserver
}