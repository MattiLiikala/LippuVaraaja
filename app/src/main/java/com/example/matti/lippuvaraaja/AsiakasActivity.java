package com.example.matti.lippuvaraaja;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class AsiakasActivity extends FragmentActivity {

    public final static String ELOKUVA = "com.matti.LippuVaraaja.ELOKUVA";
    public final static String AIKA = "com.matti.LippuVaraaja.AIKA";
    public final static String SALIKOKO = "com.matti.LippuVaraaja.SALIKOKO";
    public final static String TEATTERI = "com.matti.LippuVaraaja.TEATTERI";
    public final static String VARAAJA = "com.matti.LippuVaraaja.VARAAJA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        setContentView(R.layout.activity_asiakas);
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = (TextView)findViewById(R.id.nimikentta);
        textView.setTextSize(40);
        textView.setText("Tervetuloa "+ message+"!");





        if (savedInstanceState==null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            SlidingTabsColorFragment fragment = new SlidingTabsColorFragment();
            transaction.replace(R.id.sample_content_fragment, fragment);
            transaction.commit();
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_asiakas, menu);
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

    //public void varaa(View view) {
      //  Intent intent;
        //String message = "ja eikun varaamaan";
        //intent = new Intent(this, VarausActivity.class);
        //int[] sali = {10, 10};
        //intent.putExtra(SALIKOKO, sali);
        //startActivity(intent);
    //}
}
