package com.example.responsive;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class AfterEarthquake extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_earthquake);

        getSupportActionBar().setTitle("After the Earthquake");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}