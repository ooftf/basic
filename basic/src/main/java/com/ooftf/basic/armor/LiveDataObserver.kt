package com.ooftf.basic.armor

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ooftf.basic.utils.ThreadUtil

/**
 *
 * @author ooftf
 * @email 994749769@qq.com
 * @date 2020/11/4
 */
class LiveDataObserver<T> : MutableLiveData<T>() {
    fun <S> observeLiveData(source: LiveData<S>, adapter: (S?) -> T?) {
        ThreadUtil.runOnUiThread {
            source.observeForever {
                value = adapter.invoke(it)
            }
        }
    }

    fun <S> observeEachOther(
        source: MutableLiveData<S>,
        adapter: (S?) -> T?,
        adapter2: (T?) -> S?
    ) {
        ThreadUtil.runOnUiThread {
            source.observeForever {
                val invoke = adapter.invoke(it)
                if (value != invoke) {
                    ThreadUtil.runOnUiThread {
                        value = invoke
                    }
                }
            }

            this.observeForever {
                val invoke = adapter2.invoke(it)
                if (invoke != source.value) {
                    ThreadUtil.runOnUiThread {
                        source.value = invoke
                    }
                }
            }
        }

    }
}

fun <S, T> LiveData<S>.map(adapter: (S?) -> T?): LiveDataObserver<T> {
    return LiveDataObserver<T>().also { it ->
        it.observeLiveData(this, adapter)
    }
}

fun <S, T> MutableLiveData<S>.map(adapter: (S?) -> T?, adapter2: (T?) -> S?): LiveDataObserver<T> {
    return LiveDataObserver<T>().also { it ->
        it.observeEachOther(this, adapter, adapter2)
    }
}