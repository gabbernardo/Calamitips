package com.example.responsive;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class BeforeTsunami extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_before_tsunami);

        getSupportActionBar().setTitle("Before Tsunami");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}