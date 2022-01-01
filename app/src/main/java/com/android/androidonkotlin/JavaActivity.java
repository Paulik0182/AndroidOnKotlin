package com.android.androidonkotlin;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class JavaActivity extends AppCompatActivity {

    private static final String SAVE_JAVA_COUNTER_KEY = "save_java_counter_key";

    private Button minusButton = null;
    private Button plusButton = null;
    private TextView textViewCounter = null;
    private TextView textView = null;

    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_counter );

        minusButton = findViewById ( R.id.button_minus );
        plusButton = findViewById ( R.id.button_plus );
        textViewCounter = findViewById ( R.id.text_view_counter );
        textView = findViewById ( R.id.text_view );

        textView.setText ( "JAVA" );

        counterUpdate(counter);

        minusButton.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                counterUpdate ( --counter );
            }
        } );

        plusButton.setOnClickListener ( v ->
                counterUpdate ( ++counter ) );
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt(SAVE_JAVA_COUNTER_KEY, counter);
        super.onSaveInstanceState ( outState );
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        if (savedInstanceState.containsKey(SAVE_JAVA_COUNTER_KEY)) {
            counter = savedInstanceState.getInt(SAVE_JAVA_COUNTER_KEY);
        }
        counterUpdate(counter);
        super.onRestoreInstanceState ( savedInstanceState );
    }

    private  void counterUpdate (int counter){
        textViewCounter.setText ( String.valueOf ( counter ) );
    }
}