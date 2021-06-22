package meni;

public class Pica extends PomocnaKlasa{

    private double zapremina;

    public Pica(String naziv, double cena, double zapremina) {
        super(naziv, cena);
        this.zapremina = zapremina;
    }

    public double getZapremina() {
        return zapremina;
    }

    public void setZapremina(double zapremina) {
        this.zapremina = zapremina;
    }

    @Override
    public String toString() {
        return "enumi.Pice{" +
                "zapremina=" + zapremina +
                "} " + super.toString();
    }
}
