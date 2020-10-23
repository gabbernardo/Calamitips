package com.example.responsive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TyphoonActivity extends AppCompatActivity {
    private TextView tropicalWarnings;
    private Button signal1, signal2, signal3,signal4,signal5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_typhoon);

        getSupportActionBar().setTitle("Typhoon");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        tropicalWarnings = (TextView)findViewById(R.id.tv_PrecautionaryMeasures);
        signal1 = (Button)findViewById(R.id.btn_signal_1);
        signal2 = (Button) findViewById(R.id.btn_signal_2);
        signal3 = (Button) findViewById(R.id.btn_signal_3);
        signal4 = (Button) findViewById(R.id.btn_signal_4);
        signal5 = (Button) findViewById(R.id.btn_signal_5);

        signal1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TyphoonActivity.this,TyphoonSignalOne.class));
            }
        });

        signal2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TyphoonActivity.this,TyphoonSignalTwo.class));
            }
        });

        signal3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TyphoonActivity.this,TyphoonSignalThree.class));
            }
        });

        signal4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TyphoonActivity.this, TyphoonSignalFour.class));
            }
        });

        signal5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TyphoonActivity.this, TyphoonSignalFive.class));
            }
        });


    }
}