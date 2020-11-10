package com.example.responsive;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
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
                        Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(CurrentLocation.this,
                        Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED){
                    //When Permission granted
                    //Call method
                    getLocation();
                }else{
                    //When Permission denied
                    ActivityCompat.requestPermissions(CurrentLocation.this,
                            new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                                    Manifest.permission.ACCESS_COARSE_LOCATION},100);
                }
            }
        });
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        //Check condition
        if(requestCode == 100 && grantResults.length > 0  && (grantResults[0] + grantResults[1] == PackageManager.PERMISSION_GRANTED)){
            //When permission granted
            //Call method
            getLocation();
        }else{
            //When permission denied
            //Display toast message
            Toast.makeText(getApplicationContext(),"Permission denied", Toast.LENGTH_SHORT).show();
        }
    }

    @SuppressLint("MissingPermission")
    private void getLocation() {
        //Initialize location manager
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        //Check condition
        if(locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
                || locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
            //When location service is enabled
            //Get last location
            fusedLocationProviderClient.getLastLocation().addOnCompleteListener(new OnCompleteListener<Location>() {
                @Override
                public void onComplete(@NonNull Task<Location> task) {
                    //Initialize Current location
                    Location location = task.getResult();
                    if (location != null) {
                        try {
                            //Initialize geoCoder
                            Geocoder geocoder = new Geocoder(CurrentLocation.this, Locale.getDefault());
                            //Initialize address list
                            List<Address> addresses = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                            //Initialize Latitude on textView
                            showLatitude.setText(String.valueOf(+addresses.get(0).getLatitude()));
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
                    }else{
                        //When location is null
                        //Initialize location request
                        LocationRequest locationRequest = new LocationRequest()
                                .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
                                .setInterval(10000)
                                .setFastestInterval(1000)
                                .setNumUpdates(1);
                        //Initialize location callback
                        LocationCallback locationCallback = new LocationCallback(){
                            @Override
                            public void onLocationResult(LocationResult locationResult) {
                                //Initialize location
                                Location location1 = locationResult.getLastLocation();

                                try {
                                    //Initialize geoCoder
                                    Geocoder geocoder = new Geocoder(CurrentLocation.this, Locale.getDefault());
                                    //Initialize address list
                                    List<Address> addresses = geocoder.getFromLocation(location1.getLatitude(), location1.getLongitude(), 1);
                                    //Initialize Latitude on textView
                                    showLatitude.setText(String.valueOf(+addresses.get(0).getLatitude()));
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
                        };

                        //Request location updates
                        fusedLocationProviderClient.requestLocationUpdates(locationRequest,
                                locationCallback, Looper.myLooper());

                    }

                }
            });
        }else{
            //When location service is not enabled
            //Open location setting
            startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
        }
    }
}

