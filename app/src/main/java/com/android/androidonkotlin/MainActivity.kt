package com.android.androidonkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.androidonkotlin.R
import com.android.androidonkotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}