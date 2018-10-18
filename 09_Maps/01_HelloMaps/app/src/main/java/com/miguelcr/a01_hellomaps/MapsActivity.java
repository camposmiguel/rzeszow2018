package com.miguelcr.a01_hellomaps;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerDragListener, GoogleMap.OnMapClickListener {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera

        // Define a location
        LatLng schoolZst = new LatLng(50.015320,21.978180);
        LatLng schoolSev = new LatLng(50.015320,21.978180);

        List<LatLng> locationList = new ArrayList<>();
        locationList.add(new LatLng(50.015320,21.978180));
        locationList.add(new LatLng(60.015320,21.978180));
        locationList.add(new LatLng(70.015320,21.978180));

        for(int i=0; i<locationList.size(); i++) {
            // Add a marker to the map
            mMap.addMarker(new MarkerOptions()
                    .position(locationList.get(i))
                    .title("Marker in Rzeszów")
            );
        }



        // Move the map center to the school location
        mMap.moveCamera(CameraUpdateFactory.newLatLng(schoolZst));

        mMap.setOnMarkerDragListener(this);
        mMap.setOnMapClickListener(this);
    }

    @Override
    public void onMarkerDragStart(Marker marker) {
        marker.hideInfoWindow();
    }

    @Override
    public void onMarkerDrag(Marker marker) {
        LatLng position = marker.getPosition();
        Log.i("MAPS","Location: " + position.latitude + ", " + position.longitude);
    }

    @Override
    public void onMarkerDragEnd(Marker marker) {
        marker.showInfoWindow();
    }

    @Override
    public void onMapClick(LatLng latLng) {
        mMap.addMarker(new MarkerOptions()
                .position(latLng)
                .title("New Marker")
        );

        mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));

    }
}
