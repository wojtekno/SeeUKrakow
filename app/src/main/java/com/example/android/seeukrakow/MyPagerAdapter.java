package com.example.android.seeukrakow;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class MyPagerAdapter extends FragmentPagerAdapter {
    Context mcontext;

    public MyPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        mcontext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new HistoryFragment();
        } else if (position == 1) {
            return new NatureFragment();
        } else if (position == 2) {
            return new ViewsFragment();
        } else {
            return new SongsFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return mcontext.getString(R.string.tab_history);
        } else if (position == 1) {
            return mcontext.getString(R.string.tab_nature);
        } else if (position == 2) {
            return mcontext.getString(R.string.tab_views);
        } else {
            return mcontext.getString(R.string.tab_songs);
        }
    }
}
