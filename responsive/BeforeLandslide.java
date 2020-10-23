package com.example.responsive;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class BeforeLandslide extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_before_landslide);

        getSupportActionBar().setTitle("Before the Landslide");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}