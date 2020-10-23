package com.example.responsive;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class DuringTornado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_during_tornado);

        getSupportActionBar().setTitle("During Tornado");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}