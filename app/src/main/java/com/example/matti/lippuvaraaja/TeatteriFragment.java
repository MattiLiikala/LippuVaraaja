package com.example.matti.lippuvaraaja;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by Sami on 19.3.2015.
 */
public class TeatteriFragment extends Fragment {
    ListView listView2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View teatteriFragmentView = inflater.inflate(R.layout.fragment_teatteri, container, false);
        listView2 = (ListView) teatteriFragmentView.findViewById(android.R.id.list);


        // Defined Array values to show in ListView
        String[] values = new String[] { "Paimio International",
                "Kaarina RockCity",
                "East side best side"

        };

        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data

        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(getActivity(), R.layout.list_item_elokuva_teatteri, R.id.firstLine, values);


        // Assign adapter to ListView
        listView2.setAdapter(adapter2);

        // ListView Item Click Listener
        listView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition     = position;

                // ListView Clicked item value
                String  itemValue    = (String) listView2.getItemAtPosition(position);

                ((AsiakasActivity2)getActivity()).setTeatteri(itemValue);

                // Show Alert
                Toast.makeText(getActivity().getApplicationContext(),
                        "Position :" + itemPosition + "  ListItem : " + itemValue, Toast.LENGTH_SHORT)
                        .show();

            }

        });
        return teatteriFragmentView;

    }


}
