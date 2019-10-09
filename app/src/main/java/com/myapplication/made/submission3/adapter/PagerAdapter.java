package com.myapplication.made.submission3.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.myapplication.made.submission3.fragment.MovieFragment;
import com.myapplication.made.submission3.fragment.TvShowFragment;

public class PagerAdapter extends FragmentStatePagerAdapter {
    private int numberTabs;

    public PagerAdapter(FragmentManager fm, int numberTabs) {
        super(fm);
        this.numberTabs = numberTabs;
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
//                return new FilmFragment();
                return new MovieFragment();
            case 1:
//                return new TvFragment();
                return new TvShowFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numberTabs;
    }
}
