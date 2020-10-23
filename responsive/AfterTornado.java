package com.example.responsive;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class AfterTornado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_tornado);

        getSupportActionBar().setTitle("After Tornado");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}