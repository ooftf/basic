package com.ooftf.basic.armor

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

/**
 *
 * @author ooftf
 * @email 994749769@qq.com
 * @date 2020/11/4
 */
class LiveDataObserver<T> : MutableLiveData<T>() {
    fun <S> observeLiveData(source: LiveData<S>, adapter: (S) -> T) {
        source.observeForever {
            value = adapter.invoke(it)
        }
    }
}

fun <S, T> LiveData<S>.map(adapter: (S) -> T): LiveDataObserver<T> {
    return LiveDataObserver<T>().also { it ->
        it.observeLiveData(this, adapter)
    }
}