package com.example.responsive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class VolcanicEruptionActivity extends AppCompatActivity {

    private TextView VolcanicEruptionSafetyRules;
    private Button beforeVolcanicEruption, duringVolcanicEruption, afterVolcanicEruption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volcanic_eruption);

        getSupportActionBar().setTitle("Volcanic Eruption");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        VolcanicEruptionSafetyRules = (TextView)findViewById(R.id.tv_VolcanicEruption_PrecautionaryMeasures);
        beforeVolcanicEruption = (Button)findViewById(R.id.btn_before_the_volcanic_eruption);
        duringVolcanicEruption = (Button)findViewById(R.id.btn_during_the_volcanic_eruption);
        afterVolcanicEruption = (Button)findViewById(R.id.btn_after_the_volcanic_eruption);


        beforeVolcanicEruption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(VolcanicEruptionActivity.this, BeforeVolcanicEruption.class));
            }
        });

        duringVolcanicEruption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(VolcanicEruptionActivity.this, DuringVolcanicEruption.class));
            }
        });

        afterVolcanicEruption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(VolcanicEruptionActivity.this, AfterVolcanicEruption.class));
            }
        });
    }
}