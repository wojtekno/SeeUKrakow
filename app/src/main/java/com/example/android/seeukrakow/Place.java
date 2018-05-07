package com.example.android.seeukrakow;

/**
 * Created by Wojtek on 5/8/2018.
 */

public class Place {

    private String placeName;
    private String placeDescription;
    private int imageResId;
    private int audioResId;

    public Place (String placeName, String placeDescription) {
        this.placeDescription = placeDescription;
        this.placeName = placeName;
    }

    public Place (String placeName, String placeDescription, int imageResId) {
        this.placeDescription = placeDescription;
        this.placeName = placeName;
        this.imageResId = imageResId;
    }

    public Place (String placeName, String placeDescription, int imageResId, int audioResId) {
        this.placeDescription = placeDescription;
        this.placeName = placeName;
        this.imageResId = imageResId;
        this.audioResId = audioResId;
    }


    public String getPlaceName() {
        return placeName;
    }

    public String getPlaceDescription() {
        return placeDescription;
    }

    public int getImageResId() {
        return imageResId;
    }

    public int getAudioResId() {
        return audioResId;
    }
}
