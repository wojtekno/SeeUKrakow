package com.example.android.seeukrakow;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Wojtek on 5/8/2018.
 */

public class MyPagerAdapter extends FragmentPagerAdapter {
    Context mcontext;
    public MyPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        mcontext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if(position ==0){
            return  new HistoryFragment();
        } else {
            return new NatureFragment();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    //TODO make it to the StringRes
    @Override
    public CharSequence getPageTitle(int position) {
        if(position ==0){
            return  mcontext.getString(R.string.tab_history);
        } else {
            return mcontext.getString(R.string.tab_nature);
        }    }
}
