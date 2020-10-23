package com.example.responsive;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class DuringWildfire extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_during_wildfire);

        getSupportActionBar().setTitle("During Wildfire");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }
}