package com.example.matti.lippuvaraaja;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.matti.lippuvaraaja.view.SlidingTabLayout;

import java.util.ArrayList;
import java.util.Calendar;


public class AsiakasActivity2 extends ActionBarActivity {
    /*
    public final static String ELOKUVA = "com.matti.LippuVaraaja.ELOKUVA";
    public final static String PAIVA = "com.matti.LippuVaraaja.PAIVA";
    public final static String TEATTERI = "com.matti.LippuVaraaja.TEATTERI";

    public final static String KELLO = "com.matti.LippuVaraaja.KELLO";
    public final static String SALI = "com.matti.Lippuvaraaja.SALI";
*/
    public final static String VALITTUNAYTOS = "com.matti.Lippuvaraaja.VALITTUNAYTOS";
    public final static String VARAAJA = "com.matti.LippuVaraaja.VARAAJA";

   private String elokuva;
   private String teatteri;
   private String paiva;
   private String nimi;
   private Calendar c;

    private YllapidonTiedot tiedot;


        @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asiakas2);

    }

    @Override
    public void onStart(){
        super.onStart();
        c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int date = c.get(Calendar.DAY_OF_MONTH);
        paiva = date + "/" + (month + 1) + "/" + year;
        Intent intent = getIntent();

        nimi = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        tiedot = (YllapidonTiedot) intent.getSerializableExtra(MainActivity.TIEDOT);
        TextView textView = (TextView)findViewById(R.id.nimikentta2);
        textView.setTextSize(10);
        textView.setText("Kirjautunut: "+ nimi);

        Toast.makeText(this, "Tervetuloa " + nimi + "!", Toast.LENGTH_SHORT)
                .show();



        // Define SlidingTabLayout (shown at top)
        // and ViewPager (shown at bottom) in the layout.
        // Get their instances.
        SlidingTabLayout slidingTabLayout = (SlidingTabLayout) findViewById(R.id.tab);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        // create a fragment list in order.
        ArrayList<android.support.v4.app.Fragment> fragments = new ArrayList<>();
        fragments.add(new ElokuvaFragment());
        fragments.add(new TeatteriFragment());
        fragments.add(new PaivaFragment());
        //fragments.add(new NaytosFragment());


        // use FragmentPagerAdapter to bind the slidingTabLayout (tabs with different titles)
        // and ViewPager (different pages of fragment) together.
        FragmentManager manager = getSupportFragmentManager();
        Adapteri adapteri =new Adapteri(manager, fragments);
        viewPager.setAdapter(adapteri);
        slidingTabLayout.setDistributeEvenly(true);
        slidingTabLayout.setViewPager(viewPager);

    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_asiakas2, menu);
        return super.onCreateOptionsMenu(menu);
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
    public void varaa(View view) {
        NaytosDialogFragment dialogFragment = new NaytosDialogFragment();
        dialogFragment.show(getSupportFragmentManager(), "naytokset");

    }

    public void setElokuva(String elokuva){
        this.elokuva = elokuva;

    }
    public void setTeatteri(String teatteri){
        this.teatteri = teatteri;

    }
    public void setPaiva(String paiva){
        this.paiva = paiva;
    }
    public String getElokuva(){
        return elokuva;
    }
    public String getTeatteri(){
        return teatteri;
    }
    public String getPaiva(){return paiva;}

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public YllapidonTiedot getTiedot() {
        return tiedot;
    }

    public void setTiedot(YllapidonTiedot tiedot) {
        this.tiedot = tiedot;
    }
}
