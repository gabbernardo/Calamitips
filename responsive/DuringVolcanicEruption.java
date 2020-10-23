package com.example.responsive;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class DuringVolcanicEruption extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_during_volcanic_eruption);

        getSupportActionBar().setTitle("During Volcanic Eruption");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }
}