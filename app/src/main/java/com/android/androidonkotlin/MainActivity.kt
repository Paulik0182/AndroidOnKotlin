package com.android.androidonkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.androidonkotlin.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}