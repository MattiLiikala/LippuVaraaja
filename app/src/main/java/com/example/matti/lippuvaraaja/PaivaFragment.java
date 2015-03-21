package com.example.matti.lippuvaraaja;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.Toast;

/**
 * Created by Sami on 21.3.2015.
 */
public class PaivaFragment extends Fragment {

    CalendarView calView;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View paivaFragmentView = inflater.inflate(R.layout.fragment_paiva, container, false);

        calView = (CalendarView) paivaFragmentView.findViewById(R.id.calendarView);


        if(((AsiakasActivity2) getActivity()).getPaiva() != null) {
            calView.setDate(((AsiakasActivity2) getActivity()).getPaiva());
        }

        calView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView arg0, int year, int month, int date) {
                Toast.makeText(getActivity().getApplicationContext(), date + "/" + month + "/" + year, Toast.LENGTH_SHORT).show();
                ((AsiakasActivity2)getActivity()).setPaiva(arg0.getDate());
            }
        });

        return paivaFragmentView;
    }
}
