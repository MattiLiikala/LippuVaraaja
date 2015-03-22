package com.example.matti.lippuvaraaja;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sami on 22.3.2015.
 */
public class YllapidonTiedot implements Serializable{
    private ArrayList<Naytos> kaikkiNaytokset;
    private ArrayList<String> kayttajat;

    public YllapidonTiedot(){
        kaikkiNaytokset = new ArrayList<>();
        kayttajat = new ArrayList<>();

    }
    public YllapidonTiedot(ArrayList<Naytos> kaikkiNaytokset, ArrayList<String> kayttajat) {
        this.kaikkiNaytokset = kaikkiNaytokset;
        this.kayttajat = kayttajat;
    }

    public ArrayList<Naytos> getKaikkiNaytokset() {
        return kaikkiNaytokset;
    }

    public void setKaikkiNaytokset(ArrayList<Naytos> kaikkiNaytokset) {
        this.kaikkiNaytokset = kaikkiNaytokset;
    }

    public ArrayList<String> getKayttajat() {
        return kayttajat;
    }

    public void setKayttajat(ArrayList<String> kayttajat) {
        this.kayttajat = kayttajat;
    }
}
