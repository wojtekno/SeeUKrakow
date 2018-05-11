package com.example.android.seeukrakow;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class NatureFragment extends Fragment {


    public NatureFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.place_list, container, false);

        final ArrayList<Place> placesList = new ArrayList<Place>();
        placesList.add(new Place(getString(R.string.wolski_forest_title), getString(R.string.wolski_forest_desc), R.drawable.las_photo_small));
        placesList.add(new Place(getString(R.string.twardowski_complex), getString(R.string.twardowski_complex_desc), R.drawable.skalki_photo_small));
        placesList.add(new Place(getString(R.string.blonia), getString(R.string.blonia_desc), R.drawable.blonia));

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
