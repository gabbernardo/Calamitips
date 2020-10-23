package com.example.responsive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LandslideActivity extends AppCompatActivity {

    private TextView landslideSafetyRules;
    private Button beforeLandslide, duringLandslide, afterLandslide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landslide);

        getSupportActionBar().setTitle("Landslide");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        landslideSafetyRules = (TextView)findViewById(R.id.tv_Landslide_PrecautionaryMeasures);
        beforeLandslide = (Button)findViewById(R.id.btn_before_the_landslide);
        duringLandslide = (Button)findViewById(R.id.btn_during_the_landslide);
        afterLandslide = (Button)findViewById(R.id.btn_after_the_landslide);

        beforeLandslide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LandslideActivity.this, BeforeLandslide.class));
            }
        });

        duringLandslide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LandslideActivity.this, DuringLandslide.class));
            }
        });

        afterLandslide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LandslideActivity.this, AfterLandslide.class));
            }
        });




    }
}