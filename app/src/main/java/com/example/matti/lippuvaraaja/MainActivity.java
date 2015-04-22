package com.example.matti.lippuvaraaja;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {


    public final static String EXTRA_MESSAGE = "com.matti.LippuVaraaja.MESSAGE";
    public final static String TIEDOT = "com.matti.Lippuvaraaja.TIEDOT";
    private static final int NAYTOS_TALLENNUS = 1;
    private YllapidonTiedot tiedot;

    ImageButton helpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();

        tiedot = new YllapidonTiedot();
        tiedot.getKaikkiNaytokset().add(new Naytos("Samin kosto", "Paimio International", 1, "22/4/2015", "16:00"));
        tiedot.getKaikkiNaytokset().add(new Naytos("Samin kosto", "Paimio International", 1, "22/4/2015", "20:00"));
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        switch (requestCode) {
            case NAYTOS_TALLENNUS:
                if (resultCode == RESULT_OK) {
                    Naytos naytos = (Naytos)data.getSerializableExtra("Valittu_naytos");
                    tiedot.getKaikkiNaytokset().add(naytos);
                    Toast.makeText(this, "Näytös lisätty:\n" + naytos.getElokuva() + " | " + naytos.getTeatteri() + " " + naytos.getSali()
                            + " " + naytos.getPvm() + " | " + naytos.getKello(), Toast.LENGTH_LONG).show();
                    break;
                }
        }
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
            intent.setClass(MainActivity.this,AdminActivity.class);
            startActivityForResult(intent, NAYTOS_TALLENNUS);
            //intent.putExtra(TIEDOT, tiedot);
        }
        else if(message.equals(null) || message.equals("")){
            Toast.makeText(MainActivity.this, "Kirjoita käyttäjänimesi", Toast.LENGTH_SHORT).show();
        }
        else {
            intent = new Intent(this, AsiakasActivity2.class);
            intent.putExtra(EXTRA_MESSAGE, message);
            tiedot.getKayttajat().add(message);
            intent.putExtra(TIEDOT, tiedot);
            startActivity(intent);
        }

    }

    public void naytaOhjeDialogi(MenuItem item){
        AlertDialog ohjeDialogi = new AlertDialog.Builder(this).create();
        ohjeDialogi.setTitle("Näin käytät LippuVaraajaa:");
        ohjeDialogi.setMessage(this.getString(R.string.ohje_message));
        ohjeDialogi.setCanceledOnTouchOutside(true);
        ohjeDialogi.show();
    }

    public void naytaOhjeDialogi(){
        AlertDialog ohjeDialogi = new AlertDialog.Builder(this).create();
        ohjeDialogi.setTitle("Näin käytät LippuVaraajaa:");
        ohjeDialogi.setMessage(this.getString(R.string.ohje_message));
        ohjeDialogi.setCanceledOnTouchOutside(true);
        ohjeDialogi.show();
    }

    public void addListenerOnButton() {

        helpButton = (ImageButton) findViewById(R.id.helpButton);

        helpButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

              naytaOhjeDialogi();

            }

        });

    }
}
