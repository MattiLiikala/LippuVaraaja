package com.example.matti.lippuvaraaja;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.TextView;

import com.example.matti.lippuvaraaja.view.SlidingTabLayout;

import java.util.ArrayList;


public class AsiakasActivity2 extends ActionBarActivity {
    public final static String ELOKUVA = "com.matti.LippuVaraaja.ELOKUVA";
    public final static String AIKA = "com.matti.LippuVaraaja.AIKA";
    public final static String SALIKOKO = "com.matti.LippuVaraaja.SALIKOKO";
    public final static String TEATTERI = "com.matti.LippuVaraaja.TEATTERI";
    public final static String VARAAJA = "com.matti.LippuVaraaja.VARAAJA";
    /** Called when the activity is first created. */

    String elokuva;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        setContentView(R.layout.activity_asiakas2);
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        TextView textView = (TextView)findViewById(R.id.nimikentta2);
        textView.setTextSize(10);
        textView.setText("Kirjautunut: "+ message+"!");
/*
        if (savedInstanceState==null) {
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            transaction.replace(R.id.sample_content_fragment, fragment);
            transaction.commit();
        }
*/
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
        fragments.add(new NaytosFragment());


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
    public void varaa(View view) {
        Intent intent;
        String message = "ja eikun varaamaan";
        intent = new Intent(AsiakasActivity2.this, VarausActivity.class);
        int[] sali = {10, 10};
        intent.putExtra(SALIKOKO, sali);

        intent.putExtra(ELOKUVA, elokuva);
        startActivity(intent);
    }

}
