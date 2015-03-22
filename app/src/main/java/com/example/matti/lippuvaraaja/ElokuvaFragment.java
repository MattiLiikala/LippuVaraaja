package com.example.matti.lippuvaraaja;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import static android.widget.Toast.makeText;

/**
 * Created by Sami on 19.3.2015.
 */
public class ElokuvaFragment extends Fragment {
    ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View elokuvaFragmentView = inflater.inflate(R.layout.fragment_elokuva_teatteri, container, false);

        /* Get ListView object from xml */
        listView = (ListView) elokuvaFragmentView.findViewById(android.R.id.list);


        // Defined Array values to show in ListView
        String[] values = new String[] { "Samin kosto",
                "Samin kosto ja paluu",
                "Matin uhka",
                "Annan kirous",
                "Santerin liekehtivä sikari",
                "Digitin kilta",
                "Sami V: MuumioSami",
                "Santerin Päiväkirjat"
        };

        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), R.layout.list_item_elokuva_teatteri, R.id.firstLine, values);




        // Assign adapter to ListView
        listView.setAdapter(adapter);

        // ListView Item Click Listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {



                // ListView Clicked item value
                String  itemValue    = (String) listView.getItemAtPosition(position);


                ((AsiakasActivity2)getActivity()).setElokuva(itemValue);

                // Show Alert
                Toast.makeText(getActivity().getApplicationContext(),
                        "Elokuva: " + itemValue, Toast.LENGTH_SHORT)
                        .show();

            }

        });
        return elokuvaFragmentView;
    }

}

