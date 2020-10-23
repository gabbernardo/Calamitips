package com.example.responsive;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class DuringLandslide extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_during_landslide);

        getSupportActionBar().setTitle("During the Landslide");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}