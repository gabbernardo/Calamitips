package com.example.responsive;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class BeforeEarthquake extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_before_earthquake);

        getSupportActionBar().setTitle("Before the Earthquake");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}