package com.example.responsive;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class BeforeVolcanicEruption extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_before_volcanic_eruption);

        getSupportActionBar().setTitle("Before Volcanic Eruption");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }
}