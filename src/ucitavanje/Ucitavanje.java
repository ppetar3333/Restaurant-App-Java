package ucitavanje;

import enumi.*;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Ucitavanje {

    private ArrayList<IstorijaPorudzbina> istorijaPorudzbina;

    public Ucitavanje() {
        this.istorijaPorudzbina = new ArrayList<>();
    }

    public ArrayList<IstorijaPorudzbina> getIstorijaPorudzbina() {
        return istorijaPorudzbina;
    }

    public void ucitajPodatke(String imeFajla){
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File("src/fajlovi/" + imeFajla)));
            String line;
            while ((line = br.readLine()) != null) {
                String[] podaci = line.trim().split(",");
                int id = Integer.parseInt(podaci[0]);
                String brStola = podaci[1];
                String datumString = podaci[2];
                LocalDateTime datumIvremePorudzbine = LocalDateTime.parse(datumString);
                Pice pice = Pice.valueOf(podaci[3]);
                Paste pasta = Paste.valueOf(podaci[4]);
                Prilozi priloziPica = Prilozi.valueOf(podaci[5]);
                Prilozi priloziPasta = Prilozi.valueOf(podaci[6]);
                GaziraniSokovi gaziraniSokovi = GaziraniSokovi.valueOf(podaci[7]);
                NegaziraniSokovi negaziraniSokovi = NegaziraniSokovi.valueOf(podaci[8]);
                Voda voda = Voda.valueOf(podaci[9]);
                String cena = podaci[10];
                boolean platio = Boolean.parseBoolean(podaci[11]);
                IstorijaPorudzbina istorijaPorudzbina1 = new IstorijaPorudzbina(id,brStola,datumIvremePorudzbine,pice,pasta,priloziPica,priloziPasta,gaziraniSokovi,negaziraniSokovi,voda,cena,platio);
                istorijaPorudzbina.add(istorijaPorudzbina1);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Greska prilikom citanja fajla");
        }
    }

    public void snimiPorudzbine(String imeFajla){
        try{
            BufferedWriter br = new BufferedWriter(new FileWriter(new File("src/fajlovi/" + imeFajla)));
            for (IstorijaPorudzbina istorijaPorudzbina : istorijaPorudzbina){
                br.write(istorijaPorudzbina.pripremiZaSnimanje());
            }
            br.close();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Greska prilikom snimanja fajla");
        }
    }
    public int generisiNoviID() {
        int maks = -1;
        for (IstorijaPorudzbina istorijaPorudzbina1 : istorijaPorudzbina) {
            if (istorijaPorudzbina1.getId() > maks) {
                maks = istorijaPorudzbina1.getId();
            }
        }
        return maks + 1;
    }

    public ArrayList<IstorijaPorudzbina> nadjiPorudzbine(String brojStola) {
        ArrayList<IstorijaPorudzbina> istorijaPorudzbinaArrayList = new ArrayList<>();
        for(IstorijaPorudzbina istorijaPorudzbina : istorijaPorudzbina){
            if(istorijaPorudzbina.getBrojStola().equals(brojStola) && !istorijaPorudzbina.isPlatio()){
                istorijaPorudzbinaArrayList.add(istorijaPorudzbina);
            }
        }
        return istorijaPorudzbinaArrayList;
    }

    public int randomBroj(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public IstorijaPorudzbina neplaceniSto(String brojStola) {
        for(IstorijaPorudzbina istorijaPorudzbina : istorijaPorudzbina){
            if(!istorijaPorudzbina.isPlatio() && istorijaPorudzbina.getBrojStola().equals(brojStola)){
                return istorijaPorudzbina;
            }
        }
        return null;
    }
}
