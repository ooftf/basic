package com.ooftf.basic.holder

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ooftf.basic.utils.toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toast("SUCCESS")
    }
}