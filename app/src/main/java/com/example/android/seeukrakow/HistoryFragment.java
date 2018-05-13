package com.example.android.seeukrakow;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class HistoryFragment extends Fragment {

    public HistoryFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.place_list, container, false);

        final ArrayList<Place> placesList = new ArrayList<Place>();
        placesList.add(new Place(getString(R.string.wawel_castle), getString(R.string.wawel_castle_desc), R.drawable.wawel_photo));
        placesList.add(new Place(getString(R.string.mariacki_church), getString(R.string.mariacki_church_decs), R.drawable.mariacki_photo_small));
        placesList.add(new Place(getString(R.string.wieliczka_salt_mine), getString(R.string.wieliczka_desc), R.drawable.wieliczka_photo));
        placesList.add(new Place(getString(R.string.main_square), getString(R.string.main_square_desc), R.drawable.rynek_photo_small));
        placesList.add(new Place(getString(R.string.wawels_dragon), getString(R.string.wawels_dragon_desc), R.drawable.smok_wawelski_photo));

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
