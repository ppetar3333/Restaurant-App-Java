package meni;

public abstract class PomocnaKlasa {

    protected String naziv;
    protected double cena;

    public PomocnaKlasa(){}
    public PomocnaKlasa(String naziv, double cena) {
        this.naziv = naziv;
        this.cena = cena;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }

    @Override
    public String toString() {
        return "pomocnaKlasa{" +
                "naziv='" + naziv + '\'' +
                ", cena=" + cena +
                '}';
    }
}
