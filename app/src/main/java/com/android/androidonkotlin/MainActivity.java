package com.android.androidonkotlin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button minusButton = null;
    private Button plusButton = null;
    private TextView textViewCounter = null;

    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        minusButton = findViewById ( R.id.button_minus );
        plusButton = findViewById ( R.id.button_plus );
        textViewCounter = findViewById ( R.id.text_view_counter );

    }

}