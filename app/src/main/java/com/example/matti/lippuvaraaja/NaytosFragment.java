package com.example.matti.lippuvaraaja;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * Created by Sami on 21.3.2015.
 */
public class NaytosFragment extends Fragment {
    ListView listView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){


        View naytosFragmentView = inflater.inflate(R.layout.fragment_naytos, container, false);
        ListaAdapteri listaAdapteri = new ListaAdapteri(getActivity());
        listView = (ListView) naytosFragmentView.findViewById(android.R.id.list);
        listView.setAdapter(listaAdapteri);

        for( Naytos k : listaAdapteri.getKaikkiNaytokset()){
            if(k.getElokuva().equals(((AsiakasActivity2)getActivity()).getElokuva())
                    && k.getTeatteri().equals(((AsiakasActivity2)getActivity()).getTeatteri())){
                listaAdapteri.lisaaNaytosListaan(k);
            }
        }
        return naytosFragmentView;
    }
}
