package com.example.matti.lippuvaraaja;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

public class NaytosDialogFragment extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.dialog_message)
                .setTitle(R.string.dialog_title);

        builder.setPositiveButton(R.string.valitse_naytos, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Intent intent;
                intent = new Intent(getActivity(), VarausActivity.class);
                intent.putExtra(((AsiakasActivity2)getActivity()).VARAAJA,  ((AsiakasActivity2)getActivity()).getNimi());
                intent.putExtra(((AsiakasActivity2)getActivity()).ELOKUVA, ((AsiakasActivity2)getActivity()).getElokuva());
                intent.putExtra(((AsiakasActivity2)getActivity()).TEATTERI, ((AsiakasActivity2)getActivity()).getTeatteri());
                intent.putExtra(((AsiakasActivity2)getActivity()).PAIVA, ((AsiakasActivity2)getActivity()).getPaiva());
                startActivity(intent);
            }
        })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }
}
