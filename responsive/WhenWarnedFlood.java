package com.example.responsive;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class WhenWarnedFlood extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_when_warned_flood);

        getSupportActionBar().setTitle("When warned of Flood");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}