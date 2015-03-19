package com.example.matti.lippuvaraaja;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class Adapteri extends FragmentPagerAdapter {
   private ArrayList<Fragment> fragments;

    public Adapteri(FragmentManager fm, ArrayList<Fragment> fragments) {
        super(fm);
        this.fragments=fragments;
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }
/*
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case CHAT:
                return UI_TAB_CHAT;
            case FIND:
                return UI_TAB_FIND;
            case MEET:
                return UI_TAB_MEET;
            case PARTY:
                return UI_TAB_PARTY;
            default:
                break;
        }
        return null;
    }
    */
}
