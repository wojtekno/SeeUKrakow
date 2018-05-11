package com.example.android.seeukrakow;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class PlaceActivity extends AppCompatActivity implements OnMapReadyCallback {

    ImageView placePicture;
    TextView placeNameTV;
    TextView placeDescTV;
    Place currentPlace;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);
        currentPlace = getIntent().getParcelableExtra("Place");

        if (currentPlace.getImageResId() != 0) {
            placePicture = (ImageView) findViewById(R.id.place_picure);
            placePicture.setImageResource(currentPlace.getImageResId());
        }


        placeNameTV = findViewById(R.id.place_name_tv);
        placeNameTV.setText(currentPlace.getPlaceName());

        placeDescTV = findViewById(R.id.place_descritpion_tv);
        placeDescTV.setText(currentPlace.getPlaceDescription());

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.googlemap);

        Log.v("PlaceAct", "currentPlace.getCoordinates: " + currentPlace.getCoordinates());
        if (currentPlace.getCoordinates() != null) {
            mapFragment.getView().setVisibility(View.VISIBLE);
            mapFragment.getMapAsync(this);
        } else {
            mapFragment.getView().setVisibility(View.GONE);
        }
        ImageView ytImageV = (ImageView) findViewById(R.id.yt_button);
        if (currentPlace.getVideoId() != null) {
            ytImageV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    watchYoutubeVideo(currentPlace.getVideoId());
                }
            });
            ytImageV.setVisibility(View.VISIBLE);
        } else {
            ytImageV.setVisibility(View.GONE);
        }

    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng point = currentPlace.getCoordinates();
        googleMap.addMarker(new MarkerOptions().position(point).title("here we are"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(point, 14));
    }


    public void watchYoutubeVideo(String id) {
//        Intent appIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(id));
        Intent webIntent = new Intent(Intent.ACTION_VIEW,
                Uri.parse(id));
        try {
//            startActivity(appIntent);
        } catch (ActivityNotFoundException ex) {
            startActivity(webIntent);
        }
    }
}
