package upi.edu.hagaibrayens.homescreen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import kotlin.contracts.Returns;


public class LansiaMap extends AppCompatActivity implements OnMapReadyCallback {

    private FusedLocationProviderClient fusedLocationProviderClient;
    private GoogleMap mMap;
    private static final int Request_code = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lansia_map);

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this.getApplicationContext());

        // Get a handle to the fragment and register the callback.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        mapFragment.getMapAsync(this);

    }



    public void home(View v){
        Intent switchActivityIntent = new Intent(this, Home.class);
        startActivity(switchActivityIntent);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        //add marker
        LatLng bandung = new LatLng(-6.914744, 107.609810);
        MarkerOptions markerOptions = new MarkerOptions()
                .position(bandung)
                .title("Bandung")
                .snippet("A city in West Java, Indonesia");
        googleMap.addMarker(markerOptions);

        //pan dan zoom ke Bandung
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(bandung, 10);
        googleMap.animateCamera(cameraUpdate);

    }

    private void getCurrentLocation(){
        if(ActivityCompat.checkSelfPermission(
                this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){

            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, Request_code);
            return;
        }
    }

//    @SuppressLint("MissingSiperCall")
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull @org.jetbrains.annotations.NotNull) {
//
//    }
}