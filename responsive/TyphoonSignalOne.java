package com.example.responsive;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class TyphoonSignalOne extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_typhoon_signal_one);

        getSupportActionBar().setTitle("Typhoon Signal No.1");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}