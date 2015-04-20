package com.example.matti.lippuvaraaja;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

/**
 * Created by Sami on 3.4.2015.
 */
public class NaytosMuokkausActivity extends ActionBarActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_naytosmuokkaus);

        final ListView listView = (ListView) findViewById(android.R.id.list);


        // Defined Array values to show in ListView
        String[] values = new String[] { "Samin kosto",
                "Samin kosto ja paluu",
                "Sami V: MuumioSami"
        };

        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the TextView to which the data is written
        // Forth - the Array of data

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_item_elokuva_teatteri, R.id.firstLine, values);




        // Assign adapter to ListView
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item value
                String  itemValue    = (String) listView.getItemAtPosition(position);
                switch (position){
                    case 0:
                }

            }

        });
    }
}
