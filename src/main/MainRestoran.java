package main;

import ProzorZaPrikaz.PocetniProzor;
import ucitavanje.Ucitavanje;

public class MainRestoran {


    public static final String podaciIzFajla = "istorijaPorudzbina.txt";

    public static void main(String[] args) {

        Ucitavanje ucitavanje = new Ucitavanje();

        ucitavanje.ucitajPodatke(podaciIzFajla);


        PocetniProzor prozor = new PocetniProzor(ucitavanje);
        prozor.setVisible(true);


    }

}
