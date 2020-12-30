package com.ooftf.basic.armor

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

/**
 *
 * @author ooftf
 * @email 994749769@qq.com
 * @date 2020/9/24
 */
open class ItemBindingViewHolder<T : ViewDataBinding>(var binding: T) :
    RecyclerView.ViewHolder(binding.root) {
}