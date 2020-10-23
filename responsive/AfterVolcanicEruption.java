package com.example.responsive;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class AfterVolcanicEruption extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_volcanic_eruption);

        getSupportActionBar().setTitle("After Volcanic Eruption");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}