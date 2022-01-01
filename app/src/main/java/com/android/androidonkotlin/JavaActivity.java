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

    private JavaCounter counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_counter );

        minusButton = findViewById ( R.id.button_minus );
        plusButton = findViewById ( R.id.button_plus );
        textViewCounter = findViewById ( R.id.text_view_counter );
        textView = findViewById ( R.id.text_view );

        textView.setText ( "JAVA" );

        if (savedInstanceState != null && savedInstanceState.containsKey ( "SAVE_JAVA_COUNTER_KEY" )) {
            counter = savedInstanceState.getParcelable ( "SAVE_JAVA_COUNTER_KEY" );
        } else {
            counter = new JavaCounter ( "counter", 0 );
        }

        counterUpdate ();

        minusButton.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                counter.decrement ();
                counterUpdate ();
            }
        } );

        plusButton.setOnClickListener ( v -> {
            counter.increment ();
            counterUpdate ();
        } );
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putParcelable ( SAVE_JAVA_COUNTER_KEY, counter );
        super.onSaveInstanceState ( outState );
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        if (savedInstanceState.containsKey ( SAVE_JAVA_COUNTER_KEY )) {
            counter = savedInstanceState.getParcelable ( SAVE_JAVA_COUNTER_KEY );
        }
        counterUpdate ();
        super.onRestoreInstanceState ( savedInstanceState );
    }

    private void counterUpdate() {
        textViewCounter.setText ( String.valueOf ( counter.getCounter () ) );
    }
}