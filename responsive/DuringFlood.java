package com.example.responsive;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class DuringFlood extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_during_flood);

        getSupportActionBar().setTitle("During the Flood");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}