package com.example.matti.lippuvaraaja;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;


public class VarausActivity extends ActionBarActivity implements Penkki.OnToggledListener{

    GridLayout napit;
    Penkki[] penkit;
    int[] salikoko;
    Naytos naytos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_varaus);

        Intent intent = getIntent();


        salikoko = new int[2];

        naytos = (Naytos)intent.getSerializableExtra(AsiakasActivity2.VALITTUNAYTOS);

        String elokuva = naytos.getElokuva();
        String teatteri = naytos.getTeatteri();
        String paiva = naytos.getPvm();
        String varaaja = intent.getStringExtra(AsiakasActivity2.VARAAJA);
        String kello = naytos.getKello();
        int sali = naytos.getSali();
        if(sali == 1){
            salikoko[0] = 9;
            salikoko[1] = 9;
        }
        else if(sali == 2){
            salikoko[0] = 7;
            salikoko[1] = 8;
        }


        TextView nimi = (TextView)findViewById(R.id.nimi);
        nimi.setTextSize(10);
        nimi.setText("Kirjautunut: "+ varaaja+"!");

        TextView textView = (TextView)findViewById(R.id.viesti);
        textView.setText("" + elokuva + " | " + paiva + "\n" + teatteri + " | kello " + kello);

        napit = (GridLayout)findViewById(R.id.napit);
        napit.setRowCount(salikoko[0]);
        napit.setColumnCount(salikoko[1]);



        int numOfCol = napit.getColumnCount();
        int numOfRow = napit.getRowCount();
        penkit = new Penkki[numOfCol*numOfRow];

        for(int yPos=0; yPos<numOfRow; yPos++){
            for(int xPos=0; xPos<numOfCol; xPos++){

                Penkki penkki = new Penkki(this, xPos, yPos);
                penkki.setOnToggledListener(this);
                penkit[yPos*numOfCol + xPos] = penkki;
                napit.addView(penkki);
            }
        }




    napit.getViewTreeObserver().addOnGlobalLayoutListener(
            new ViewTreeObserver.OnGlobalLayoutListener(){

        @Override
        public void onGlobalLayout() {

            final int MARGIN = 5;

            int pWidth = napit.getWidth();
            int pHeight = napit.getHeight();
            int numOfCol = napit.getColumnCount();
            int numOfRow = napit.getRowCount();
            int w = pWidth/numOfCol;
            int h = pHeight/numOfRow;

            for(int yPos=0; yPos<numOfRow; yPos++){
                for(int xPos=0; xPos<numOfCol; xPos++){
                    GridLayout.LayoutParams params =
                            (GridLayout.LayoutParams) penkit[yPos*numOfCol + xPos].getLayoutParams();
                    params.width = w - 2*MARGIN;
                    params.height = h - 2*MARGIN;
                    params.setMargins(MARGIN, MARGIN, MARGIN, MARGIN);
                    penkit[yPos*numOfCol + xPos].setLayoutParams(params);
                }
            }

        }});
}

    @Override
    public void OnToggled(Penkki v, boolean touchOn) {

        //get the id string

        //String idString = v.getIdY() + ":" + v.getIdX();

        //Toast.makeText(VarausActivity.this,
        //        "Toggled:\n" +
        //                idString + "\n" +
        //                touchOn,
        //        Toast.LENGTH_SHORT).show();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_varaus, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                Intent intent = NavUtils.getParentActivityIntent(this);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_SINGLE_TOP);
                NavUtils.navigateUpTo(this, intent);
                return true;
        }
        return super.onOptionsItemSelected(item);


    }

    public void tallenna(View view){
        String varatutPaikat = "";

        for(int i = 0;i<penkit.length;i++) {
            if (penkit[i].touchOn) {
                varatutPaikat = varatutPaikat + penkit[i].getIdY() + ":" + penkit[i].getIdX() + " ";
            }
        }

        Toast.makeText(VarausActivity.this,
                "Varatut paikat:\n" + varatutPaikat,
                Toast.LENGTH_SHORT).show();
    }
}
