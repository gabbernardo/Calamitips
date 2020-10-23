package com.example.responsive;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class AfterLandslide extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_landslide);

        getSupportActionBar().setTitle("After the Landslide");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}