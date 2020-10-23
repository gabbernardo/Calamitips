package com.example.responsive;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class AfterTsunami extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_tsunami);

        getSupportActionBar().setTitle("After Tsunami");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}