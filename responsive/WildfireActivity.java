package com.example.responsive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WildfireActivity extends AppCompatActivity {
    private TextView wildfireSafetyRules;
    private Button beforeWildfire, duringWildfire, afterWildfire;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wildfire);

        getSupportActionBar().setTitle("Wildfire");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        wildfireSafetyRules = (TextView)findViewById(R.id.tv_Wildfire_PrecautionaryMeasures);
        beforeWildfire = (Button)findViewById(R.id.btn_before_the_wildfire);
        duringWildfire = (Button)findViewById(R.id.btn_during_the_wildfire);
        afterWildfire = (Button)findViewById(R.id.btn_after_the_wildfire);

        beforeWildfire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WildfireActivity.this, BeforeWildFire.class));
            }
        });

        duringWildfire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WildfireActivity.this, DuringWildfire.class));
            }
        });

        afterWildfire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WildfireActivity.this, AfterWildfire.class));
            }
        });


    }
}