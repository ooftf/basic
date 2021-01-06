package com.ooftf.basic.armor.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.ooftf.basic.utils.getLiveData_START_VERSION
import com.ooftf.basic.utils.reflectGetVersion

/**
 * @author ooftf
 * @email 994749769@qq.com
 * @date 2021/1/5
 */
class ObserverLostCurrent<T>(bind: LiveData<T>, val real: Observer<T>) : Observer<T> {
    var convey = getLiveData_START_VERSION() == bind.reflectGetVersion()
    override fun onChanged(t: T) {
        if (convey) {
            real.onChanged(t)
        } else {
            convey = true
        }
    }
}

