package com.example.responsive;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class BeforeTornado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_before_tornado);

        getSupportActionBar().setTitle("Before Tornado");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}