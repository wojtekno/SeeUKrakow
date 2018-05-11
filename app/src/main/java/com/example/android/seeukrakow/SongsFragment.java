package com.example.android.seeukrakow;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SongsFragment extends Fragment {

    public SongsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.place_list, container, false);

        final ArrayList<Place> placesList = new ArrayList<Place>();
        placesList.add(new Place(getString(R.string.krakow_myslovitz), getString(R.string.krakow_mysovitz_desc), R.drawable.golebia_photo_small, "https://www.youtube.com/watch?v=VhqN-S8mIjM"));
        placesList.add(new Place(getString(R.string.bracka_turnau), getString(R.string.bracka_turnau_desc), R.drawable.bracka_photo_small, "https://www.youtube.com/watch?v=vhuW6Pvwj4I", new LatLng(50.060162, 19.936267)));
        placesList.add(new Place(getString(R.string.cracovia_anthem), getString(R.string.cracovia_anthem_desc), R.drawable.cracovia_photo, "https://www.youtube.com/watch?v=m7r9sywQJ1g&t=61s"));
        placesList.add(new Place(getString(R.string.wisla_anthem), getString(R.string.wisla_anthem_desc), R.drawable.wisla_stadion_photo, "https://www.youtube.com/watch?v=4M0ClspalU8&t=10s"));

        ListView listView = (ListView) rootView.findViewById(R.id.place_list_lv);
        PlaceAdapter placeAdapter = new PlaceAdapter(getContext(), 0, placesList, new MyOnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent i = new Intent(getContext(), PlaceActivity.class);
                i.putExtra("Place", placesList.get(position));
                startActivity(i);
            }
        });
        listView.setAdapter(placeAdapter);

        return rootView;
    }

}
