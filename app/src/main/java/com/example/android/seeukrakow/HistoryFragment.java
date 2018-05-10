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
public class HistoryFragment extends Fragment {


    public HistoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.place_list, container, false);

        final ArrayList<Place> placesList = new ArrayList<Place>();
        placesList.add(new Place(getString(R.string.wawel_castle), getString(R.string.wawel_castle_desc), R.drawable.krakow_herb));

//        TextView description = (TextView) container.findViewById(R.id.place_name_tv);
//        description.setText(placesList.get(0).getPlaceName());

        ListView listView = (ListView) rootView.findViewById(R.id.place_list_lv);
        PlaceAdapter placeAdapter = new PlaceAdapter(getContext(), 0, placesList, new MyOnItemClickListener() {
            @Override
            public void onItemClick(int position) {
//                Toast.makeText(getContext(), "KLikam :)", Toast.LENGTH_LONG).show();
                Intent i = new Intent(getContext(), PlaceActivity.class);
                i.putExtra("Place", placesList.get(position));
                startActivity(i);
            }
        });
        listView.setAdapter(placeAdapter);



        return rootView;
    }

}
