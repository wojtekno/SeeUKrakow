package com.example.android.seeukrakow;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Wojtek on 5/8/2018.
 */

public class PlaceAdapter extends ArrayAdapter<Place> {

    public PlaceAdapter(@NonNull Context context, int resource, @NonNull List<Place> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.object_list_item, parent, false);
        }

        Place currentPlace = getItem(position);

        TextView descriptionTV = (TextView) convertView.findViewById(R.id.place_name_tv);
        descriptionTV.setText(currentPlace.getPlaceName());

        if (currentPlace.getImageResId() != 0) {
            ImageView placeIcon = (ImageView) convertView.findViewById(R.id.photo_image);
            placeIcon.setImageResource(currentPlace.getImageResId());
        }
        return convertView;
    }

}
