package com.ooftf.basic.holder

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.ooftf.basic.utils.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toast("SUCCESS")
        button.setOnClickListener {
            toastSuccess("删除成功")
            toastWarn("删除成功")
            toastError("删除成功")
        }
        val ar = arrayListOf("0", "1", "2", "2", "3")
        ar.removeIf_ { it == "2" }
        button.postLayoutComplete {
            log()
        }

        button.postDelayed({ log() }, 2000)

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