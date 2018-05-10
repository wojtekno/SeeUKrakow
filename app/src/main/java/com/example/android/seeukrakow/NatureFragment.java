package com.example.android.seeukrakow;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class NatureFragment extends Fragment {


    public NatureFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.place_list, container, false);

        ArrayList<Place> placesList = new ArrayList<Place>();
        placesList.add(new Place(getString(R.string.wawels_dragon), getString(R.string.wawels_dragon_desc), R.drawable.smok_wawelski_photo));

//        TextView description = (TextView) container.findViewById(R.id.place_name_tv);
//        description.setText(placesList.get(0).getPlaceName());

        ListView listView = (ListView) rootView.findViewById(R.id.place_list_lv);
        PlaceAdapter placeAdapter = new PlaceAdapter(getContext(), 0, placesList, new MyOnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(getContext(), "akuku", Toast.LENGTH_LONG).show();
            }
        });
        listView.setAdapter(placeAdapter);


        return rootView;
    }

}
