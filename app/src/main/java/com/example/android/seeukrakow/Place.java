package com.example.android.seeukrakow;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Wojtek on 5/8/2018.
 */

public class Place implements Parcelable {

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


    protected Place(Parcel in) {
        placeName = in.readString();
        placeDescription = in.readString();
        imageResId = in.readInt();
        audioResId = in.readInt();
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

    public int getAudioResId() {
        return audioResId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(placeName);
        parcel.writeString(placeDescription);
        parcel.writeInt(imageResId);
        parcel.writeInt(audioResId);
    }
}
