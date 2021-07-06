package com.ooftf.basic.holder.recycler

import android.app.Application
import com.ooftf.arch.frame.mvvm.vm.BaseListViewModel
import com.ooftf.basic.holder.R

/**
 * @author
 * @email
 * @date 2021-07-06
 */
class RecyclerViewModel(application: Application) : BaseListViewModel<String>(application) {

    init {
        (0..1000).forEach { it ->
            items.add("$it")
        }

    }

    override fun getItemLayout(): Int {
        return R.layout.item_text
    }

}