package com.example.matti.lippuvaraaja;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class Adapteri extends FragmentPagerAdapter {
   private ArrayList<android.support.v4.app.Fragment> fragments;
    private static final int ELOKUVA = 0;
    private static final int TEATTERI = 1;
    private static final String ELOKUVA_OTSIKKO = "ELOKUVA";
    private static final String TEATTERI_OTSIKKO = "TEATTERI";

    public Adapteri(FragmentManager fm, ArrayList<Fragment> fragments) {
        super(fm);
        this.fragments=fragments;
    }



    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public android.support.v4.app.Fragment getItem(int position) {
        return fragments.get(position);
    }

    public CharSequence getPageTitle(int position) {
        switch (position) {
            case ELOKUVA:
                return ELOKUVA_OTSIKKO;
            case TEATTERI:
                return TEATTERI_OTSIKKO;
            /*
            case MEET:
                return UI_TAB_MEET;
            case PARTY:
                return UI_TAB_PARTY;
                */
            default:
                break;
        }
        return null;
    }

}
