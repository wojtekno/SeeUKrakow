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
public class ViewsFragment extends Fragment {


    public ViewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.place_list, container, false);

        final ArrayList<Place> placesList = new ArrayList<Place>();
        placesList.add(new Place(getString(R.string.wawels_dragon), getString(R.string.wawels_dragon_desc), R.drawable.smok_photo, new LatLng(50.053078, 19.933596)));
        placesList.add(new Place(getString(R.string.pilsudski_mound), getString(R.string.pilsudski_mound_desc), R.drawable.kopiec_pilsudskiego_photo));
        placesList.add(new Place(getString(R.string.kraka_mound), getString(R.string.kraka_mound_desc), R.drawable.kopiec_kraka_photo_small));
        placesList.add(new Place(getString(R.string.tyniec), getString(R.string.tyniec_desc), R.drawable.tyniec_photo));

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
