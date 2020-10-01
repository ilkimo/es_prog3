package Animale;

public class Mammifero extends Animale{
    private String alimentazione;
    private int numero_arti;
    private String razza;

    public Mammifero(String tipo, int età, String genere, String alimentazione, int numero_arti, String razza) {
        super(tipo, età, genere);
        this.alimentazione = alimentazione;
        this.numero_arti = numero_arti;
        this.razza = razza;
    }

    public String getAlimentazione() {
        return alimentazione;
    }

    public void setAlimentazione(String alimentazione) {
        this.alimentazione = alimentazione;
    }

    public int getNumero_arti() {
        return numero_arti;
    }

    public void setNumero_arti(int numero_arti) {
        this.numero_arti = numero_arti;
    }

    public String getRazza() {
        return razza;
    }

    public void setRazza(String razza) {
        this.razza = razza;
    }

    @Override
    public String toString() {
        return "Mammiferi{" + super.toString() +
                ", alimentazione='" + alimentazione + '\'' +
                ", numero_arti=" + numero_arti +
                ", razza='" + razza + '\'' +
                '}';
    }
}
