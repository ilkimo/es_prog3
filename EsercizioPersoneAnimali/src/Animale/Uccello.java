package Animale;

public class Uccello {
    private String alimentazione;
    private String razza;
    private String piume;

    public Uccello(String alimentazione, String razza, String piume) {
        this.alimentazione = alimentazione;
        this.razza = razza;
        this.piume = piume;
    }

    public String getAlimentazione() {
        return alimentazione;
    }

    public void setAlimentazione(String alimentazione) {
        this.alimentazione = alimentazione;
    }

    public String getRazza() {
        return razza;
    }

    public void setRazza(String razza) {
        this.razza = razza;
    }

    public String getPiume() {
        return piume;
    }

    public void setPiume(String piume) {
        this.piume = piume;
    }

    @Override
    public String toString() {
        return "Uccelli{" + super.toString() +
                ", alimentazione='" + alimentazione + '\'' +
                ", piume=" + piume +
                ", razza='" + razza + '\'' +
                '}';
    }
}
