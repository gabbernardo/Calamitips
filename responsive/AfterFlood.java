package com.example.responsive;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class AfterFlood extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_flood);

        getSupportActionBar().setTitle("After the Flood");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}