package com.ooftf.basic.armor

import androidx.databinding.ObservableList
import androidx.recyclerview.widget.RecyclerView

/**
 *
 * @author ooftf
 * @email 994749769@qq.com
 * @date 2020/9/14
 */
class AdapterOnListChangedCallback<T : ObservableList<*>>(val adapter: RecyclerView.Adapter<out RecyclerView.ViewHolder>) :
    ObservableList.OnListChangedCallback<T>() {
    override fun onChanged(sender: T?) {
        adapter.notifyDataSetChanged()
    }

    override fun onItemRangeChanged(
        sender: T?,
        positionStart: Int,
        itemCount: Int
    ) {
        adapter.notifyItemRangeChanged(positionStart, itemCount)
    }

    override fun onItemRangeInserted(
        sender: T?,
        positionStart: Int,
        itemCount: Int
    ) {
        adapter.notifyItemRangeInserted(positionStart, itemCount)
    }

    override fun onItemRangeMoved(
        sender: T?,
        fromPosition: Int,
        toPosition: Int,
        itemCount: Int
    ) {
        adapter.notifyItemMoved(fromPosition, itemCount)
    }

    override fun onItemRangeRemoved(
        sender: T?,
        positionStart: Int,
        itemCount: Int
    ) {
        adapter.notifyItemRangeRemoved(positionStart, itemCount)
    }
}