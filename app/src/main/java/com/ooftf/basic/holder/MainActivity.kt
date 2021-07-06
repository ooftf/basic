package com.ooftf.basic.holder

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.ooftf.arch.frame.mvvm.activity.BaseViewBindingActivity
import com.ooftf.basic.engine.serializable.SerializableObject
import com.ooftf.basic.holder.databinding.ActivityMainBinding
import com.ooftf.basic.holder.recycler.RecyclerActivity
import com.ooftf.basic.utils.genTagId
import com.ooftf.basic.utils.getVisibleRectOfScreen
import com.ooftf.basic.utils.getVisibleRectOfSelf

class MainActivity : BaseViewBindingActivity<ActivityMainBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val ar = arrayListOf("0", "1", "2", "2", "3")
        val ss = object : SerializableObject<ArrayList<String>>() {
            override fun getDefaultValue(): ArrayList<String> {
                return arrayListOf()
            }
        }
        //ss.set(ar)
        Log.e("getKey", ss.getKey())
        Log.e("SerializableObject", ss.get().toString())
        binding.button.setOnClickListener {
            startActivity(RecyclerActivity::class.java)
        }

    }

    private fun log() {
        Log.e("result", "" + binding.button.getVisibleRectOfScreen())
        Log.e("result", "" + binding.button.getVisibleRectOfSelf())
        Log.e("result", "" + binding.button.left)
        Log.e("result", "" + binding.button.top)
        Log.e("result", "" + binding.button.right)
        Log.e("result", "" + binding.button.bottom)

        supportFinishAfterTransition()
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)

    }
}