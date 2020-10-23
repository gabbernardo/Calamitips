package com.example.responsive;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class DuringEarthquake extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_during_earthquake);

        getSupportActionBar().setTitle("During the Earthquake");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}