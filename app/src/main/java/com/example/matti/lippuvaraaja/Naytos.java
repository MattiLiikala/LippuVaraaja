package com.example.matti.lippuvaraaja;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Sami on 21.3.2015.
 */
public class Naytos implements Serializable{
    private String elokuva;
    private String teatteri;
    private int sali;
    private String pvm;
    private String kello;

    public Naytos(String elokuva, String teatteri, int sali, String pvm, String kello) {
        this.elokuva = elokuva;
        this.teatteri = teatteri;
        this.sali = sali;
        this.pvm = pvm;
        this.kello = kello;
    }

    public boolean equals(Naytos naytos) {
        if(this.elokuva.equals(naytos.elokuva) && this.teatteri.equals(naytos.teatteri) && this.sali == naytos.sali &&
                this.pvm.equals(naytos.pvm) && this.kello.equals(naytos.kello)){
            return true;
        }
        else{
            return false;
        }
    }

    public String getKello() {
        return kello;
    }

    public void setKello(String kello) {
        this.kello = kello;
    }

    public int getSali() {
        return sali;
    }

    public void setSali(int sali) {
        this.sali = sali;
    }

    public String getElokuva() {
        return elokuva;
    }

    public void setElokuva(String elokuva) {
        this.elokuva = elokuva;
    }

    public String getTeatteri() {
        return teatteri;
    }

    public void setTeatteri(String teatteri) {
        this.teatteri = teatteri;
    }

    public String getPvm() {
        return pvm;
    }

    public void setPvm(String pvm){
        this.pvm = pvm;
    }
}
