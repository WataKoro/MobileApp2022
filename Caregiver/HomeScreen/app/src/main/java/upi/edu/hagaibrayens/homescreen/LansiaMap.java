package upi.edu.hagaibrayens.homescreen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class LansiaMap extends AppCompatActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lansia_map);

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
}