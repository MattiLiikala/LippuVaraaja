package com.example.matti.lippuvaraaja;


import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;


public class AdminActivity extends ActionBarActivity {
    private Naytos naytos;
    private ArrayList<Fragment> fragments;
    private String elokuva;
    private String teatteri;
    private String paiva;
    private String aika;
    private int sali;
    com.example.matti.lippuvaraaja.view.SlidingTabLayout slidingTabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

    }
    @Override
    public void onStart(){
        super.onStart();
        //tiedot = (YllapidonTiedot) getIntent().getSerializableExtra(MainActivity.TIEDOT);
        TextView textView = (TextView)findViewById(R.id.otsikko);
        textView.setTextSize(40);


        slidingTabLayout = (com.example.matti.lippuvaraaja.view.SlidingTabLayout) findViewById(R.id.tab);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);


        // create a fragment list in order.
        fragments = new ArrayList<>();
        fragments.add(new ElokuvaYllapitoFragment());
        fragments.add(new TeatteriYllapitoFragment());
        fragments.add(new PaivaYllapitoFragment());
        fragments.add(new NaytosYllapitoFragment());
        //fragments.add(new KayttajaYllapitoFragment());


        // use FragmentPagerAdapter to bind the slidingTabLayout (tabs with different titles)
        // and ViewPager (different pages of fragment) together.
        FragmentManager manager = getSupportFragmentManager();
        Adapteri adapteri =new Adapteri(manager, fragments);
        viewPager.setAdapter(adapteri);
        slidingTabLayout.setDistributeEvenly(true);
        slidingTabLayout.setViewPager(viewPager);

    }

    public void tallennanaytos(View view){
        if(teatteri != null && elokuva != null && paiva != null && aika != null && sali > 0){


            naytos = new Naytos(elokuva, teatteri, sali, paiva, aika);

            Intent returnIntent = new Intent();
            returnIntent.putExtra("Valittu_naytos", naytos);
            // Activity finished ok, return the data
            setResult(RESULT_OK, returnIntent);

            finish();


        }
        else{
            Toast.makeText(AdminActivity.this,
                    "Valitse kaikki muuttujat",
                    Toast.LENGTH_SHORT).show();
        }
    }

    //Fragmenttisetti turhaa,uusi activity vaan tai dialogi
    public void muokkaanaytoksia(MenuItem item){
        Intent intent = new Intent(this, NaytosMuokkausActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_admin, menu);
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

    public void setElokuva(String elokuva){
        this.elokuva = elokuva;

    }
    public void setTeatteri(String teatteri){
        this.teatteri = teatteri;

    }
    public void setPaiva(String paiva){
        this.paiva = paiva;
    }

    public void setAika(String aika) {
        this.aika = aika;
    }

    public void setSali(int sali) {
        this.sali = sali;
    }
    public int getSali(){
        return sali;
    }

    public String getAika(){
        return aika;
    }
    public String getElokuva(){
        return elokuva;
    }
    public String getTeatteri(){
        return teatteri;
    }
    public String getPaiva(){return paiva;}
}
