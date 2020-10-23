package com.example.responsive;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;
    private Button btnTyphoon, btnFlood, btnTornado, btnEarthquake, btnLandslide, btnTsunami, btnVolcanicEruption, btnWildfire;
    private Button btnCurrentLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTyphoon = (Button)findViewById(R.id.btn_typhoon);
        btnFlood = (Button)findViewById(R.id.btn_flood);
        btnTornado = (Button)findViewById(R.id.btn_tornado);
        btnEarthquake = (Button)findViewById(R.id.btn_earthquake);
        btnLandslide = (Button)findViewById(R.id.btn_landslide);
        btnTsunami = (Button)findViewById(R.id.btn_tsunami);
        btnVolcanicEruption = (Button)findViewById(R.id.btn_volcanic_eruption);
        btnWildfire = (Button)findViewById(R.id.btn_wildfire);
        btnCurrentLocation = (Button)findViewById(R.id.btn_get_current_location);


        btnTyphoon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TyphoonActivity.class));
            }
        });

        btnFlood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, FloodActivity.class));
            }
        });

        btnTornado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TornadoActivity.class));
            }
        });

        btnEarthquake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, EarthquakeActivity.class));
            }
        });

        btnLandslide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LandslideActivity.class));
            }
        });

        btnTsunami.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TsunamiActivity.class));
            }
        });

        btnVolcanicEruption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, VolcanicEruptionActivity.class));
            }
        });

        btnWildfire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, WildfireActivity.class));
            }
        });

        btnCurrentLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CurrentLocation.class));
            }
        });





        firebaseAuth = FirebaseAuth.getInstance();
    }



        /** If the user Logout in the Main Activity, they go back to Log In form **/
    private void Logout(){
        firebaseAuth.signOut();
        finish();
        startActivity(new Intent(MainActivity.this,LoginForm.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options, menu);
        return true;
    }


    /** The settings menu is located at the upper right corner of the app where in if the user he can choose. **/
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.logoutMenu:{
                Toast.makeText(MainActivity.this,"You successfully logged out",Toast.LENGTH_SHORT).show();
                Logout();
            }
        }

        return super.onOptionsItemSelected(item);

    }
}
