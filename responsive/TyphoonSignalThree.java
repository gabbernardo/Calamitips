package com.example.responsive;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class TyphoonSignalThree extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_typhoon_signal_three);

        getSupportActionBar().setTitle("Typhoon Signal No.3");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}