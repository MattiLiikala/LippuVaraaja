package com.example.matti.lippuvaraaja;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class NaytosDialogFragment extends DialogFragment {
    private CharSequence[] items;
    private ArrayList<Naytos> naytosLista;
    private String valittuKello = "";
    private int valittuSali;
    private Boolean onNaytoksia = false;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());


        naytosLista = new ArrayList<>();
        for(Naytos n : ((AsiakasActivity2)getActivity()).getTiedot().getKaikkiNaytokset()){
            if (n.getElokuva().equals(((AsiakasActivity2)getActivity()).getElokuva())&&
                    n.getTeatteri().equals(((AsiakasActivity2)getActivity()).getTeatteri())&&
                    n.getPvm().equals(((AsiakasActivity2)getActivity()).getPaiva())){
                naytosLista.add(n);
                onNaytoksia=true;
            }
        }
        items = new CharSequence[naytosLista.size()];
        for (int i=0; i<items.length; i++){
            items[i] = naytosLista.get(i).getPvm()+"  kello "+ naytosLista.get(i).getKello()+ "  Sali "+naytosLista.get(i).getSali();
        }

        builder.setTitle(R.string.dialog_title).setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                valittuKello = naytosLista.get(which).getKello();
                valittuSali = naytosLista.get(which).getSali();
            }
        });





        builder.setPositiveButton(R.string.valitse_naytos, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {


            }
        })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        // Create the AlertDialog object and return it
       final AlertDialog dialog = builder.create();
        dialog.show();

        //Overriding the handler immediately after show is probably a better approach than OnShowListener as described below
        dialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {

                //Do stuff, possibly set wantToCloseDialog to true then...
                if(!onNaytoksia)
                    dialog.getButton(AlertDialog.BUTTON_POSITIVE).setClickable(false);
                    dialog.getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.LTGRAY);

                if(onNaytoksia){
                    Intent intent;
                    intent = new Intent(getActivity(), VarausActivity.class);
                    intent.putExtra(((AsiakasActivity2)getActivity()).VARAAJA,  ((AsiakasActivity2)getActivity()).getNimi());
                    intent.putExtra(((AsiakasActivity2)getActivity()).ELOKUVA, ((AsiakasActivity2)getActivity()).getElokuva());
                    intent.putExtra(((AsiakasActivity2)getActivity()).TEATTERI, ((AsiakasActivity2)getActivity()).getTeatteri());
                    intent.putExtra(((AsiakasActivity2)getActivity()).PAIVA, ((AsiakasActivity2)getActivity()).getPaiva());
                    intent.putExtra(((AsiakasActivity2)getActivity()).KELLO, valittuKello);
                    intent.putExtra(((AsiakasActivity2)getActivity()).SALI, valittuSali);
                    startActivity(intent);
                }
                //else dialog stays open. Make sure you have an obvious way to close the dialog especially if you set cancellable to false.
            }
        });
/*
        dialog.getButton(AlertDialog.BUTTON_NEGATIVE).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Boolean wantToCloseDialog = true;
                //Do stuff, possibly set wantToCloseDialog to true then...
                if(wantToCloseDialog)
                    dialog.dismiss();
                //else dialog stays open. Make sure you have an obvious way to close the dialog especially if you set cancellable to false.
            }
        });
        */
        return dialog;
    }
}
