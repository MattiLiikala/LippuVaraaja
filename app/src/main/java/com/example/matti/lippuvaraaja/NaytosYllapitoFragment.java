package com.example.matti.lippuvaraaja;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.matti.lippuvaraaja.R;

/**
 * Created by Matti on 20/03/2015.
 */
public class NaytosYllapitoFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_naytosyllapito, container, false);
    }
}