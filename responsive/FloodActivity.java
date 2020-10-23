package com.example.responsive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FloodActivity extends AppCompatActivity {

    private TextView floodSafetyRules;
    private Button beforeFlood, duringFlood, afterFlood, mitigateFlood, warnedFlood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flood);

        getSupportActionBar().setTitle("Flood");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        floodSafetyRules = (TextView)findViewById(R.id.tv_Flood_PrecautionaryMeasures);
        beforeFlood = (Button)findViewById(R.id.btn_before_the_flood);
        duringFlood = (Button)findViewById(R.id.btn_during_the_flood);
        afterFlood = (Button)findViewById(R.id.btn_after_the_flood);
        mitigateFlood = (Button)findViewById(R.id.btn_mitigate_the_flood);
        warnedFlood = (Button)findViewById(R.id.btn_when_warned_of_flood);


        beforeFlood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FloodActivity.this, BeforeFlood.class));
            }
        });

        duringFlood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FloodActivity.this, DuringFlood.class));
            }
        });

        afterFlood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FloodActivity.this, AfterFlood.class));
            }
        });

        warnedFlood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FloodActivity.this, WhenWarnedFlood.class));
            }
        });

        mitigateFlood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FloodActivity.this, MitigateFlood.class));
            }
        });

    }
}