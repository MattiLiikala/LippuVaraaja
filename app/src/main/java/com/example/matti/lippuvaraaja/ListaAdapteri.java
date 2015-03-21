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
    Context context;

    public ListaAdapteri(Context context){
        this.context = context;
        naytosLista = getDataForListView();
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

    public List<Naytos> getDataForListView()
    {
        List<Naytos> naytokset = new ArrayList<>();

        naytokset.add(new Naytos("Matti iskee takaisin", "Toijalan Kino", 1, "20.5.2015", "20:15"));
        naytokset.add(new Naytos("Joelin paluu", "Kinopalatsi", 3, "13.5.2015", "19:00"));

        return naytokset;

    }


}
