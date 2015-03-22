package com.example.matti.lippuvaraaja;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.matti.lippuvaraaja.R;

/**
 * Created by Matti on 20/03/2015.
 */
public class NaytosYllapitoFragment extends Fragment {
    TimePicker picker;
    ListView listView;
    String hours;
    String minutes;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View naytosYllapitoFragmentView = inflater.inflate(R.layout.fragment_naytosyllapito, container, false);

        picker = (TimePicker)naytosYllapitoFragmentView.findViewById(R.id.timepicker);

        picker.setIs24HourView(DateFormat.is24HourFormat(getActivity()));

        picker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener(){
            @Override
            public void onTimeChanged(TimePicker timePicker, int hour, int minute){

                if(hour < 10){
                    hours = "0" + hour;
                }
                else{
                    hours = "" + hour;
                }
                if(minute < 10){
                    minutes = "0" + minute;
                }
                else{
                    minutes = "" + minute;
                }

                ((AdminActivity)getActivity()).setAika(hours + ":" + minutes);

/*
                // Show Alert
                Toast.makeText(getActivity().getApplicationContext(),
                        "aika: " + hour + ":" + minute, Toast.LENGTH_SHORT)
                        .show();
                        */
            }
        });

        listView = (ListView) naytosYllapitoFragmentView.findViewById(android.R.id.list);


        // Defined Array values to show in ListView
        String[] values = new String[] { "Sali 1: 10x10 paikkaa", "Sali 2: 8x7 paikkaa"
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



                ((AdminActivity)getActivity()).setSali(position + 1);

                // Show Alert
                Toast.makeText(getActivity().getApplicationContext(),
                        "Sali: " + (position + 1), Toast.LENGTH_SHORT)
                        .show();

            }

        });

        return naytosYllapitoFragmentView;
    }


}