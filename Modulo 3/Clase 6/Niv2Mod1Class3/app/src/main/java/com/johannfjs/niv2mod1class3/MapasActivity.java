package com.johannfjs.niv2mod1class3;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.johannfjs.aplicacion.Configuracion;
import com.johannfjs.models.Persona;

import java.util.ArrayList;

/**
 * Created by johannfjs on 23/11/2015.
 */
public class MapasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mapas);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {

                googleMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
                    @Override
                    public View getInfoWindow(Marker marker) {
                        View view = getLayoutInflater().inflate(R.layout.item_info_window, null);

                        TextView lblNombre = (TextView) view.findViewById(R.id.lblNombre);
                        TextView lblCelular = (TextView) view.findViewById(R.id.lblCelular);
                        TextView lblTelefonoFijo = (TextView) view.findViewById(R.id.lblTelefonoFijo);

                        int posicion=getIntent().getIntExtra("posicion", -1);
                        Persona item=MainActivity.lista.get(posicion);

                        lblNombre.setText(item.getNombre());
                        lblCelular.setText(item.getCelular());
                        lblTelefonoFijo.setText(item.getTelefonoFijo());

                        return view;
                    }

                    @Override
                    public View getInfoContents(Marker marker) {
                        return null;
                    }
                });

                googleMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                    @Override
                    public void onInfoWindowClick(Marker marker) {

                    }
                });


                if (getIntent().hasExtra("latitud")) {
                    String latitud = getIntent().getStringExtra("latitud");
                    String longitud = getIntent().getStringExtra("longitud");

                    LatLng sydney = new LatLng(Double.parseDouble(latitud), Double.parseDouble(longitud));
                    googleMap.addMarker(new MarkerOptions().position(sydney).snippet("descripción").title("Pin")
                            .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_default)));
                    googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(sydney, 15));
                }


                /*
                PolylineOptions linea = new PolylineOptions();
                linea.color(Color.BLUE).width(3);
                */
                for (int i = 0; i < MainActivity.lista.size(); i++) {
                    LatLng posicion = new LatLng(
                            Double.parseDouble(MainActivity.lista.get(i).getLatitud()),
                            Double.parseDouble(MainActivity.lista.get(i).getLongitud()));

                    //linea.add(posicion);
                    /*

                    LatLng posicion = new LatLng(
                            Double.parseDouble(MainActivity.lista.get(i).getLatitud()),
                            Double.parseDouble(MainActivity.lista.get(i).getLongitud()));

                    googleMap.addMarker(new MarkerOptions().position(posicion));

                     */
                }
                //googleMap.addPolyline(linea);
            }
        });
    }
}
