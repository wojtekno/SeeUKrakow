package com.example.android.seeukrakow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class PlaceActivity extends AppCompatActivity {

    ImageView placePicture;
    TextView placeNameTV;
    TextView placeDescTV;
    Place currentPlace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place);
currentPlace = getIntent().getParcelableExtra("Place");

        placeNameTV = findViewById(R.id.place_name_tv);
        placeNameTV.setText(currentPlace.getPlaceName());

        placeDescTV = findViewById(R.id.place_descritpion_tv);
        placeDescTV.setText(currentPlace.getPlaceDescription());

    }
}
