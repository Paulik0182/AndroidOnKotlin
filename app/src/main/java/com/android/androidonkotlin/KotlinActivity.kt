package com.android.androidonkotlin

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Button

class KotlinActivity : AppCompatActivity() {

    private lateinit var minusButton: Button
    private lateinit var plusButton: Button
    private lateinit var textViewCounter: TextView
    private lateinit var textView: TextView

    private var counter = 0

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_counter)

        minusButton = findViewById(R.id.button_minus)
        plusButton = findViewById(R.id.button_plus)
        textViewCounter = findViewById(R.id.text_view_counter)
        textView = findViewById(R.id.text_view)

        textView.text = "KOTLIN"

        counterUpdate(counter)

        minusButton.setOnClickListener {
            counterUpdate(--counter)
        }

        plusButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                counterUpdate(++counter)
            }
        })
    }

    private fun counterUpdate(counter: Int) {
        textViewCounter.text = counter.toString()
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        outState.putInt(SAVE_KOTLIN_COUNTER_KEY, counter)

        Log.d(TAG, "onSaveInstanceState() called with: outState = $outState, outPersistentState = $outPersistentState")
        super.onSaveInstanceState(outState, outPersistentState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        if (savedInstanceState.containsKey(SAVE_KOTLIN_COUNTER_KEY)) {
            counter = savedInstanceState.getInt(SAVE_KOTLIN_COUNTER_KEY)
        }
        counterUpdate(counter)

        Log.d(TAG, "onRestoreInstanceState() called with: savedInstanceState = $savedInstanceState")
        super.onRestoreInstanceState(savedInstanceState)
    }

    companion object {
        private const val SAVE_KOTLIN_COUNTER_KEY = "save_kotlin_counter_key"
        private const val TAG = "@@@ KOTLIN"
    }
}