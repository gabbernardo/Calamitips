package com.example.responsive;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class DuringTsunami extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_during_tsunami);

        getSupportActionBar().setTitle("During Tsunami");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}