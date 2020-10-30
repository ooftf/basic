package com.ooftf.basic.armor
import androidx.databinding.ObservableArrayList

class ObservableArrayListPro<T> : ObservableArrayList<T>() {
    fun notifyChange(item: T) {
        notifyChange(indexOf(item))
    }

    fun notifyChange(index: Int) {
        set(index, get(index))
    }

    fun notifyChange() {
        val arrayList = ArrayList(this)
        clear()
        addAll(arrayList)
    }
}