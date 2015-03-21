package com.example.matti.lippuvaraaja;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.matti.lippuvaraaja.view.*;

import java.util.ArrayList;


public class AdminActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        TextView textView = (TextView)findViewById(R.id.otsikko);
        textView.setTextSize(40);

        com.example.matti.lippuvaraaja.view.SlidingTabLayout slidingTabLayout = (com.example.matti.lippuvaraaja.view.SlidingTabLayout) findViewById(R.id.tab);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);

        // create a fragment list in order.
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new ElokuvaYllapitoFragment());
        fragments.add(new NaytosYllapitoFragment());
        fragments.add(new KayttajaYllapitoFragment());


        // use FragmentPagerAdapter to bind the slidingTabLayout (tabs with different titles)
        // and ViewPager (different pages of fragment) together.
        FragmentManager manager = getSupportFragmentManager();
        Adapteri adapteri =new Adapteri(manager, fragments);
        viewPager.setAdapter(adapteri);
        // slidingTabLayout.setDistributeEvenly(true);
        slidingTabLayout.setViewPager(viewPager);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_admin, menu);
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
