package com.johannfjs.mod2class6;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.johannfjs.utils.GPSTracker;

public class MainActivity extends AppCompatActivity/* implements LocationListener*/ {
    private LocationManager locationManager;
    private LocationListener locationListener;
    private EditText txtLatitud, txtLongitud;
    private Button btnObtener;
    private GPSTracker gpsTracker;

    //@TargetApi(Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtLatitud = (EditText) findViewById(R.id.txtLatitud);
        txtLongitud = (EditText) findViewById(R.id.txtLongitud);
        btnObtener = (Button) findViewById(R.id.btnObtener);
        gpsTracker = new GPSTracker(MainActivity.this);
/*
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
        */
    }

    @Override
    protected void onResume() {
        super.onResume();
        btnObtener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Location location = gpsTracker.getLocation();
                if (gpsTracker.canGetLocation()) {
                    txtLatitud.setText(String.valueOf(location.getLatitude()));
                    txtLongitud.setText(String.valueOf(location.getLongitude()));
                } else {
                    gpsTracker.showSettingsAlert();
                }
            }
        });
    }

    /*
    //Cuando la posición a cambiado
    @Override
    public void onLocationChanged(Location location) {
        txtLatitud.setText(String.valueOf(location.getLatitude()));
        txtLongitud.setText(String.valueOf(location.getLongitude()));
    }

    //Si se a podido obtener
    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    //La locación activa
    @Override
    public void onProviderEnabled(String provider) {

    }

    //La locación desactiva
    @Override
    public void onProviderDisabled(String provider) {

    }
    */
}
