package com.ooftf.basic.armor

import androidx.lifecycle.MutableLiveData
import java.util.*

/**
 *
 * @author ooftf
 * @email 994749769@qq.com
 * @date 2020/1/2
 */
class DiffLiveData<T> : MutableLiveData<T>() {

    override fun postValue(value: T?) {
        if (Objects.equals(value, getValue())) {
            return
        }
        super.postValue(value)
    }

    override fun setValue(value: T?) {
        if (Objects.equals(value, getValue())) {
            return
        }
        super.setValue(value)
    }


    fun forcePostValue(value: T?) {
        super.postValue(value)
    }

    fun forceSetValue(value: T?) {
        super.setValue(value)
    }
}