package com.example.matti.lippuvaraaja;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class NaytosDialogFragment extends DialogFragment {
    private CharSequence[] items;
    private ArrayList<Naytos> naytosLista;
    private String valittuKello = "";
    private int valittuSali;
    private int listanNaytos;
    private Boolean onNaytoksia = false;
    private Boolean naytosValittu = false;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());


        naytosLista = new ArrayList<>();
        for (Naytos n : ((AsiakasActivity2) getActivity()).getTiedot().getKaikkiNaytokset()) {
            if (n.getElokuva().equals(((AsiakasActivity2) getActivity()).getElokuva()) &&
                    n.getTeatteri().equals(((AsiakasActivity2) getActivity()).getTeatteri()) &&
                    n.getPvm().equals(((AsiakasActivity2) getActivity()).getPaiva())) {
                naytosLista.add(n);
                onNaytoksia = true;
            }
        }
        if (!onNaytoksia) {
            builder.setTitle(R.string.dialog_title).setMessage("Ei näytöksiä");
            builder.setNeutralButton("Takaisin", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
        }
        items = new CharSequence[naytosLista.size()];
        for (int i = 0; i < items.length; i++) {
            items[i] = naytosLista.get(i).getPvm() + "  kello " + naytosLista.get(i).getKello() + "  Sali " + naytosLista.get(i).getSali();
        }

        builder.setTitle(R.string.dialog_title).setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                //valittuKello = naytosLista.get(which).getKello();
                naytosValittu = true;
                listanNaytos = which;
                //valittuSali = naytosLista.get(which).getSali();
            }
        });


        if (onNaytoksia) {
            builder.setPositiveButton(R.string.valitse_naytos, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    if (!onNaytoksia) {
                        Toast.makeText(getActivity().getApplicationContext(),
                                "Ei näytöstä täällä tänään!", Toast.LENGTH_SHORT)
                                .show();
                    }
                    if (!naytosValittu) {
                        Toast.makeText(getActivity().getApplicationContext(),
                                "Valitse näytös", Toast.LENGTH_SHORT)
                                .show();
                    }


                    if (onNaytoksia && naytosValittu) {

                        Intent intent;
                        intent = new Intent(getActivity(), VarausActivity.class);
                        intent.putExtra(((AsiakasActivity2) getActivity()).VARAAJA, ((AsiakasActivity2) getActivity()).getNimi());
                        intent.putExtra(((AsiakasActivity2) getActivity()).VALITTUNAYTOS, naytosLista.get(listanNaytos));
                        startActivity(intent);
                    }

                }
            })

                    .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.cancel();
                        }
                    });
        }
        // Create the AlertDialog object and return it
        final AlertDialog dialog = builder.create();
        dialog.show();


        return dialog;
    }
}
