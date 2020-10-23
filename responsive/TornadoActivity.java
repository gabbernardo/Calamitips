package com.example.responsive;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TornadoActivity extends AppCompatActivity {

    private TextView tornadoSafetyRules;
    private Button beforeTornado, duringTornado, afterTornado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tornado);

        getSupportActionBar().setTitle("Tornado");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tornadoSafetyRules = (TextView)findViewById(R.id.tv_Tornado_PrecautionaryMeasures);
        beforeTornado = (Button)findViewById(R.id.btn_before_the_tornado);
        duringTornado = (Button)findViewById(R.id.btn_during_the_tornado);
        afterTornado = (Button)findViewById(R.id.btn_after_the_tornado);


        beforeTornado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TornadoActivity.this, BeforeTornado.class));
            }
        });

        duringTornado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TornadoActivity.this, DuringTornado.class));
            }
        });

        afterTornado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TornadoActivity.this, AfterTornado.class));
            }
        });

    }
}