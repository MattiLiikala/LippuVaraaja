package com.example.matti.lippuvaraaja;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Button;


public class VarausActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        setContentView(R.layout.activity_varaus);
        TextView textView = (TextView)findViewById(R.id.viesti);
        textView.setTextSize(40);
        textView.setText("Paikanvaraus");
        int[] salikoko = intent.getIntArrayExtra(AsiakasActivity.SALIKOKO);

        LinearLayout napit = (LinearLayout)findViewById(R.id.napit);
        for (int i = 0; i<salikoko[0]; i++){
            for(int j = 0; j<salikoko[1];j++){
                Button penkki = new Button(this);
                penkki.setText("Rivi" + i + ", Penkki" + j);
                LinearLayout.LayoutParams layoutParams = new  LinearLayout.LayoutParams(70, 70);
                layoutParams.setMargins(5, 3, 0, 0); // left, top, right, bottom
                penkki.setLayoutParams(layoutParams);
            }

        }
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
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
