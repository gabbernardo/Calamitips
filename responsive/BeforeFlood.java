package com.example.responsive;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class BeforeFlood extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_before_flood);

        getSupportActionBar().setTitle("Before the Flood");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}