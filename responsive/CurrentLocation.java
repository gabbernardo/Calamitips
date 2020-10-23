package com.example.responsive;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class CurrentLocation extends AppCompatActivity {
    //Initialize variables
    public Button btnGetCurrentLocation;
    public TextView showLatitude, showLongitude, showCountry, showLocality, showAddress;
    FusedLocationProviderClient fusedLocationProviderClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_location);

        getSupportActionBar().setTitle("Current Location");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Assigning variables
        btnGetCurrentLocation = findViewById(R.id.btn_get_current_location);
        showLatitude = findViewById(R.id.tv_show_latitude);
        showLongitude = findViewById(R.id.tv_show_longitude);
        showCountry = findViewById(R.id.tv_show_country);
        showLocality = findViewById(R.id.tv_show_locality);
        showAddress = findViewById(R.id.tv_show_address);

        //Initialize FusedLocationProviderClient
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(CurrentLocation.this);

        btnGetCurrentLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Check Permission
                if(ActivityCompat.checkSelfPermission(CurrentLocation.this,
                        Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
                    //When Permission granted
                    getLocation();
                }else{
                    //When Permission denied
                    ActivityCompat.requestPermissions(CurrentLocation.this,
                            new String[]{Manifest.permission.ACCESS_FINE_LOCATION},44);
                }
            }
        });


    }

    @SuppressLint("MissingPermission")
    private void getLocation() {
            fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
                @Override
                public void onComplete(@NonNull Task<Location> task) {
                    //Initialize Current location
                    Location location = task.getResult();
                    if(location != null){
                        try {
                            //Initialize geoCoder
                            Geocoder geocoder = new Geocoder(CurrentLocation.this, Locale.getDefault());
                            //Initialize address list
                            List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                            //Initialize Latitude on textView
                            showLatitude.setText(String.valueOf(+ addresses.get(0).getLatitude()));
                            //Initialize Longitude on textView
                            showLongitude.setText(String.valueOf(addresses.get(0).getLongitude()));
                            //Initialize Country
                            showCountry.setText(String.valueOf(addresses.get(0).getCountryName()));
                            //Initialize Locality
                            showLocality.setText(String.valueOf(addresses.get(0).getLocality()));
                            //Initialize Address
                            showAddress.setText(String.valueOf(addresses.get(0).getAddressLine(0)));

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                }
            });

        }
    }

