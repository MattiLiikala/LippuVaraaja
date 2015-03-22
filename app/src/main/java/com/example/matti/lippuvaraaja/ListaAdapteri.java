package com.example.matti.lippuvaraaja;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static android.app.PendingIntent.getActivity;

/**
 * Created by Sami on 21.3.2015.
 */
public class ListaAdapteri extends BaseAdapter {
    List<Naytos> naytosLista;
    List<Naytos> kaikkiNaytokset;
    Context context;


    public ListaAdapteri(Context context){
        this.context = context;
        naytosLista =  new ArrayList<>();
        kaikkiNaytokset = new ArrayList<>();
        Naytos naytos1 = new Naytos("Samin kosto", "Paimio International", 1, "27/3/2015", "16:00");
        Naytos naytos2 = new Naytos("Samin kosto", "Paimio International", 1, "27/3/2015", "20:00");
        Naytos naytos3 = new Naytos("Samin kosto", "Paimio International", 2, "27/3/2015", "18:00");
        Naytos naytos4 = new Naytos("Samin kosto", "Paimio International", 2, "28/3/2015", "18:00");
        Naytos naytos5 = new Naytos("Samin kosto", "Kaarina RockCity", 2, "28/3/2015", "18:00");

        kaikkiNaytokset.add(naytos1);
        kaikkiNaytokset.add(naytos2);
        kaikkiNaytokset.add(naytos3);
        kaikkiNaytokset.add(naytos4);
        kaikkiNaytokset.add(naytos5);

    }


    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return naytosLista.size();
    }

    @Override
    public Object getItem(int arg0) {
        // TODO Auto-generated method stub
        return naytosLista.get(arg0);
    }

    @Override
    public long getItemId(int arg0) {
        // TODO Auto-generated method stub
        return arg0;
    }

    @Override
    public View getView( int arg0, View arg1, ViewGroup arg2) {

        if(arg1==null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            arg1 = inflater.inflate(R.layout.list_item_naytos, arg2,false);
        }

        TextView pvm = (TextView)arg1.findViewById(R.id.pvm);
        TextView kello = (TextView)arg1.findViewById(R.id.kello);
        TextView sali = (TextView)arg1.findViewById(R.id.sali);

        Naytos naytos = naytosLista.get(arg0);

        pvm.setText(naytos.getPvm());
        kello.setText(naytos.getKello());
        sali.setText("Sali "+Integer.toString(naytos.getSali()));

        return arg1;
    }
    public void tyhjennaLista(){
        naytosLista.clear();
    }
    public void lisaaNaytosListaan(Naytos lisattava){
        naytosLista.add(lisattava);
        /*
        for( Naytos k : kaikkiNaytokset){
            if(k.getElokuva().equals(((AsiakasActivity2)getActivity()).getElokuva())
                    && k.getTeatteri().equals(((AsiakasActivity2)getActivity()).getTeatteri())){
                naytosLista.add(k);
            }
        }
        */
    }

    public List<Naytos> getKaikkiNaytokset() {
        return kaikkiNaytokset;
    }
}
