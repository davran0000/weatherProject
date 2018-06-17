package com.example.virus.weatherprojecttop;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CurrentLocationSetterActivity extends AppCompatActivity {
    LocationManager locationManager;
    LocationListener locationListener;
    Button btFindCurrentLocation;
    TextView tvCurrentLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_location_setter);

        initializeXmlAtributes();
        setupLocationManager();
    }




    private void initializeXmlAtributes() {
        btFindCurrentLocation = findViewById(R.id.bt_current_location);
        tvCurrentLocation = findViewById(R.id.tv_current_location);
        btFindCurrentLocation.setVisibility(View.INVISIBLE);
        btFindCurrentLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);
                startRequestForLocation();
            }
        });
    }

    private void setupLocationManager() {
            locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    requestPermissions(new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.INTERNET}, 10);
                }
                return;
            }
            else startRequestForLocation();
        }

    private void startRequestForLocation() {
        tvCurrentLocation.setText("Подождите...");
        try{
        locationManager.requestLocationUpdates("gps", 0, 0, new GPSTracker());
    }catch (SecurityException ex){}
    }

    public class GPSTracker implements LocationListener {

        @Override
        public void onLocationChanged(Location location) {
            btFindCurrentLocation.setVisibility(View.INVISIBLE);
            setConnectionWithApi(location.getLatitude(),location.getLongitude());
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {
            btFindCurrentLocation.setVisibility(View.INVISIBLE);

        }

        @Override
        public void onProviderDisabled(String provider) {
            tvCurrentLocation.setText(getResources().getString(R.string.gps_disabled_text));
            btFindCurrentLocation.setVisibility(View.VISIBLE);
        }
    }

    private void setConnectionWithApi(double latitude, double longitude) {
        tvCurrentLocation.setText(
        new RetrofitCreatorForCurrentLocation().initializeCurrentLocationDataFromJson
                ("6c4073d27817692d5ee59160e39a468f",Double.toString(latitude),Double.toString(longitude)));
    }

}
