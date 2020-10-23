package com.example.responsive;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class BeforeWildFire extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_before_wild_fire);

        getSupportActionBar().setTitle("Before Wildfire");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}