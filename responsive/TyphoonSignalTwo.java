package com.example.responsive;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class TyphoonSignalTwo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_typhoon_signal_two);

        getSupportActionBar().setTitle("Typhoon Signal No.2");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}