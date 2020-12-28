package com.ooftf.basic.holder

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.ooftf.basic.engine.serializable.SerializableObject
import com.ooftf.basic.utils.genTagId
import com.ooftf.basic.utils.getVisibleRectOfScreen
import com.ooftf.basic.utils.getVisibleRectOfSelf
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ar = arrayListOf("0", "1", "2", "2", "3")
        val ss = object : SerializableObject<ArrayList<String>>() {
            override fun getDefaultValue(): ArrayList<String> {
                return arrayListOf()
            }
        }
        //ss.set(ar)
        Log.e("getKey", ss.getKey())
        Log.e("SerializableObject", ss.get().toString())
        (1..100000).forEach {
            button.setTag(genTagId(), "")
            Log.e("removeInvalid0", "" + genTagId())
        }

    }

    private fun log() {
        Log.e("result", "" + button.getVisibleRectOfScreen())
        Log.e("result", "" + button.getVisibleRectOfSelf())
        Log.e("result", "" + button.left)
        Log.e("result", "" + button.top)
        Log.e("result", "" + button.right)
        Log.e("result", "" + button.bottom)
    }
}