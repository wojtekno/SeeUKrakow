package com.example.android.seeukrakow;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Wojtek on 5/8/2018.
 */

public class Place implements Parcelable {

    private String placeName;
    private String placeDescription;
    private int imageResId;
    private LatLng coordinates;
    private String videoId;

    public Place(String placeName, String placeDescription, int imageResId) {
        this.placeDescription = placeDescription;
        this.placeName = placeName;
        this.imageResId = imageResId;
    }

    public Place(String placeName, String placeDescription, int imageResId, String videoId) {
        this.placeDescription = placeDescription;
        this.placeName = placeName;
        this.imageResId = imageResId;
        this.videoId = videoId;
    }

    public Place(String placeName, String placeDescription, int imageResId, LatLng coordinates) {
        this.placeDescription = placeDescription;
        this.placeName = placeName;
        this.imageResId = imageResId;
        this.coordinates = coordinates;
    }

    public Place(String placeName, String placeDescription, int imageResId, String videoId, LatLng coordinates) {
        this.placeDescription = placeDescription;
        this.placeName = placeName;
        this.imageResId = imageResId;
        this.coordinates = coordinates;
        this.videoId = videoId;
    }

    protected Place(Parcel in) {
        placeName = in.readString();
        placeDescription = in.readString();
        imageResId = in.readInt();
        coordinates = in.readParcelable(LatLng.class.getClassLoader());
        videoId = in.readString();
    }

    public static final Creator<Place> CREATOR = new Creator<Place>() {
        @Override
        public Place createFromParcel(Parcel in) {
            return new Place(in);
        }

        @Override
        public Place[] newArray(int size) {
            return new Place[size];
        }
    };

    public String getPlaceName() {
        return placeName;
    }

    public String getPlaceDescription() {
        return placeDescription;
    }

    public int getImageResId() {
        return imageResId;
    }

    public LatLng getCoordinates() {
        return coordinates;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public String getVideoId() {
        return videoId;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(placeName);
        parcel.writeString(placeDescription);
        parcel.writeInt(imageResId);
        parcel.writeParcelable(coordinates, i);
        parcel.writeString(videoId);
    }
}
