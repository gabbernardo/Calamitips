package com.example.responsive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EarthquakeActivity extends AppCompatActivity {
    private TextView earthquakeSafetyRules;
    private Button beforeEarthquake, duringEarthquake, afterEarthquake;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earthquake);

        getSupportActionBar().setTitle("Earthquake");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        earthquakeSafetyRules = (TextView)findViewById(R.id.tv_Earthquake_PrecautionaryMeasures);
        beforeEarthquake = (Button)findViewById(R.id.btn_before_the_earthquake);
        duringEarthquake = (Button)findViewById(R.id.btn_during_the_earthquake);
        afterEarthquake = (Button)findViewById(R.id.btn_after_the_earthquake);


        beforeEarthquake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EarthquakeActivity.this, BeforeEarthquake.class));
            }
        });

        duringEarthquake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EarthquakeActivity.this, DuringEarthquake.class));
            }
        });

        afterEarthquake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EarthquakeActivity.this, AfterEarthquake.class));
            }
        });




    }
}