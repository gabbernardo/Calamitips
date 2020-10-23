package com.example.responsive;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class TyphoonSignalFour extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_typhoon_signal_four);

        getSupportActionBar().setTitle("Typhoon Signal No.4");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}