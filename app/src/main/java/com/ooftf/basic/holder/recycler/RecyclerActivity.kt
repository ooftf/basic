package com.ooftf.basic.holder.recycler

import android.os.Bundle
import com.ooftf.arch.frame.mvvm.activity.BaseMvvmActivity
import com.ooftf.basic.holder.databinding.ActivityRecyclerBinding
import com.ooftf.basic.utils.scrollPositionToCenter

/**
 * @author
 * @email
 * @date 2021-07-06
 */
class RecyclerActivity : BaseMvvmActivity<ActivityRecyclerBinding, RecyclerViewModel>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.go.setOnClickListener {
            binding.recyclerView.scrollPositionToCenter(50)
        }
    }
}