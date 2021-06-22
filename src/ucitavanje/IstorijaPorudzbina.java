package ucitavanje;

import enumi.*;

import java.time.LocalDateTime;

public class IstorijaPorudzbina {

    private int id;
    private String brojStola;
    private LocalDateTime datumIvremePorudzbine;
    private Pice pica;
    private Paste pasta;
    private Prilozi priloziZaPicu;
    private Prilozi priloziZaPastu;
    private GaziraniSokovi gaziraniSokovi;
    private NegaziraniSokovi negaziraniSokovi;
    private Voda voda;
    private String cena;
    private boolean platio;

    public IstorijaPorudzbina(int id, String brojStola, LocalDateTime datumIvremePorudzbine, Pice pica, Paste pasta, Prilozi priloziZaPicu, Prilozi priloziZaPastu, GaziraniSokovi gaziraniSokovi, NegaziraniSokovi negaziraniSokovi, Voda voda, String cena, boolean platio) {
        this.id = id;
        this.brojStola = brojStola;
        this.datumIvremePorudzbine = datumIvremePorudzbine;
        this.pica = pica;
        this.pasta = pasta;
        this.priloziZaPicu = priloziZaPicu;
        this.priloziZaPastu = priloziZaPastu;
        this.gaziraniSokovi = gaziraniSokovi;
        this.negaziraniSokovi = negaziraniSokovi;
        this.voda = voda;
        this.cena = cena;
        this.platio = platio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrojStola() {
        return brojStola;
    }

    public void setBrojStola(String brojStola) {
        this.brojStola = brojStola;
    }

    public LocalDateTime getDatumIvremePorudzbine() {
        return datumIvremePorudzbine;
    }

    public void setDatumIvremePorudzbine(LocalDateTime datumIvremePorudzbine) {
        this.datumIvremePorudzbine = datumIvremePorudzbine;
    }

    public Pice getPica() {
        return pica;
    }

    public void setPica(Pice pica) {
        this.pica = pica;
    }

    public Paste getPasta() {
        return pasta;
    }

    public void setPasta(Paste pasta) {
        this.pasta = pasta;
    }

    public Prilozi getPriloziZaPicu() {
        return priloziZaPicu;
    }

    public void setPriloziZaPicu(Prilozi priloziZaPicu) {
        this.priloziZaPicu = priloziZaPicu;
    }

    public Prilozi getPriloziZaPastu() {
        return priloziZaPastu;
    }

    public void setPriloziZaPastu(Prilozi priloziZaPastu) {
        this.priloziZaPastu = priloziZaPastu;
    }

    public GaziraniSokovi getGaziraniSokovi() {
        return gaziraniSokovi;
    }

    public void setGaziraniSokovi(GaziraniSokovi gaziraniSokovi) {
        this.gaziraniSokovi = gaziraniSokovi;
    }

    public NegaziraniSokovi getNegaziraniSokovi() {
        return negaziraniSokovi;
    }

    public void setNegaziraniSokovi(NegaziraniSokovi negaziraniSokovi) {
        this.negaziraniSokovi = negaziraniSokovi;
    }

    public Voda getVoda() {
        return voda;
    }

    public void setVoda(Voda voda) {
        this.voda = voda;
    }

    public String getCena() {
        return cena;
    }

    public void setCena(String cena) {
        this.cena = cena;
    }

    public boolean isPlatio() {
        return platio;
    }

    public void setPlatio(boolean platio) {
        this.platio = platio;
    }

    @Override
    public String toString() {
        return "IstorijaPorudzbina{" +
                "id=" + id +
                ", brojStola='" + brojStola + '\'' +
                ", datumIvremePorudzbine=" + datumIvremePorudzbine +
                ", pica=" + pica +
                ", pasta=" + pasta +
                ", priloziZaPicu=" + priloziZaPicu +
                ", priloziZaPastu=" + priloziZaPastu +
                ", gaziraniSokovi=" + gaziraniSokovi +
                ", negaziraniSokovi=" + negaziraniSokovi +
                ", voda=" + voda +
                ", cena=" + cena +
                ", platio=" + platio +
                '}';
    }

    public String pripremiZaSnimanje(){
        return id + "," + brojStola + "," + datumIvremePorudzbine + "," + pica + "," + pasta + "," +priloziZaPicu + "," +priloziZaPastu + "," + gaziraniSokovi + "," + negaziraniSokovi + "," + voda + "," + cena + "," + platio +  "\n";
    }
}
