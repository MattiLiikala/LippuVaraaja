package com.example.matti.lippuvaraaja;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Sami on 21.3.2015.
 */
public class NaytosFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View paivaFragmentView = inflater.inflate(R.layout.fragment_naytos, container, false);
        return paivaFragmentView;
    }
}
