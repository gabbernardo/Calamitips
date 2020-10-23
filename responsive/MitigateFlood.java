package com.example.responsive;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MitigateFlood extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mitigate_flood);

        getSupportActionBar().setTitle("How to Mitigate Flood");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}