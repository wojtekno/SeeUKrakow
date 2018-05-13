package com.example.android.seeukrakow;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ViewsFragment extends Fragment {

    public ViewsFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.place_list, container, false);

        final ArrayList<Place> placesList = new ArrayList<Place>();
        placesList.add(new Place(getString(R.string.wawels_dragon), getString(R.string.wawels_dragon_desc), R.drawable.smok_photo, new LatLng(50.053078, 19.933596)));
        placesList.add(new Place(getString(R.string.pilsudski_mound), getString(R.string.pilsudski_mound_desc), R.drawable.kopiec_pilsudskiego_photo, new LatLng(50.059975, 19.847176)));
        placesList.add(new Place(getString(R.string.kraka_mound), getString(R.string.kraka_mound_desc), R.drawable.kopiec_kraka_photo_small, new LatLng(50.038068, 19.958397)));
        placesList.add(new Place(getString(R.string.tyniec), getString(R.string.tyniec_desc), R.drawable.tyniec_photo, new LatLng(50.018998, 19.802248)));

        ListView listView = (ListView) rootView.findViewById(R.id.place_list_lv);
        PlaceAdapter placeAdapter = new PlaceAdapter(getContext(), 0, placesList);
        listView.setAdapter(placeAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getContext(), PlaceActivity.class);
                intent.putExtra("Place", placesList.get(i));
                startActivity(intent);
            }
        });

        return rootView;
    }

}
