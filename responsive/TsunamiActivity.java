package com.example.responsive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TsunamiActivity extends AppCompatActivity {

    private TextView tsunamiSafetyRules;
    private Button beforeTsunami, duringTsunami, afterTsunami;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tsunami);

        getSupportActionBar().setTitle("Tsunami");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        tsunamiSafetyRules = (TextView)findViewById(R.id.tv_Tsunami_PrecautionaryMeasures);
        beforeTsunami = (Button)findViewById(R.id.btn_before_the_tsunami);
        duringTsunami = (Button)findViewById(R.id.btn_during_the_tsunami);
        afterTsunami = (Button)findViewById(R.id.btn_after_the_tsunami);

        beforeTsunami.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TsunamiActivity.this, BeforeTsunami.class));
            }
        });

        duringTsunami.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TsunamiActivity.this, DuringTsunami.class));
            }
        });

        afterTsunami.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TsunamiActivity.this, AfterTsunami.class));
            }
        });

    }
}