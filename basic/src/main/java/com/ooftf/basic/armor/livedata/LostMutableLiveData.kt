package com.ooftf.basic.armor.livedata

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

/**
 *
 * @author ooftf
 * @email 994749769@qq.com
 * @date 2020/11/13
 */
open class LostMutableLiveData<T> : MutableLiveData<T>() {
    override fun observe(owner: LifecycleOwner, observer: Observer<in T>) {
        super.observe(owner, WrapperObserver(observer, this))
    }

    override fun observeForever(observer: Observer<in T>) {
        super.observeForever(WrapperObserver(observer, this))
    }

    private fun reflectGetVersion(): Int {
        return try {
            val method = LiveData::class.java.getDeclaredMethod("getVersion")
            method.isAccessible = true
            method.invoke(this) as Int
        } catch (e: Exception) {
            throw RuntimeException("LiveData has changed ,can't find method getVersion")
        }
    }

    internal class WrapperObserver<T>(var real: Observer<in T>, liveData: LostMutableLiveData<*>) :
        Observer<T> {
        var version = 0
        var liveData: LostMutableLiveData<*>
        override fun onChanged(o: T) {
            if (version >= liveData.reflectGetVersion()) {
                return
            }
            version++
            real.onChanged(o)
        }

        init {
            version = liveData.reflectGetVersion()
            this.liveData = liveData
        }
    }
}