package com.example.matti.lippuvaraaja;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {


    public final static String EXTRA_MESSAGE = "com.matti.LippuVaraaja.MESSAGE";
    public final static String TIEDOT = "Tiedot";
    private YllapidonTiedot tiedot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tiedot = new YllapidonTiedot();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void login(View view) {
        Intent intent;
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        if(message.equals("admin")) {
            intent = new Intent(this, AdminActivity.class);
            intent.putExtra(TIEDOT, tiedot);
        }
        else {
            intent = new Intent(this, AsiakasActivity2.class);
            intent.putExtra(EXTRA_MESSAGE, message);
            tiedot.getKayttajat().add(message);
            intent.putExtra(TIEDOT, tiedot);
        }
        startActivity(intent);
    }
}
