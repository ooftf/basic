package com.ooftf.basic.armor

import androidx.lifecycle.MutableLiveData

/**
 *
 * @author ooftf
 * @email 994749769@qq.com
 * @date 2020/1/9
 */
class InitLiveData<T>(init: T) : MutableLiveData<T>(init) {
    override fun getValue(): T {
        return super.getValue()!!
    }

    override fun setValue(value: T) {
        super.setValue(value)
    }
}