package Persona;

public class Lavoratore extends Persona{

    private String azienda;
    private int annoInizio;

    public Lavoratore(String nome, String cognome, int età, char sesso, String azienda, int annoInizio) {
        super(nome, cognome, età, sesso);
        this.azienda = azienda;
        this.annoInizio = annoInizio;
    }

    public String getAzienda() {
        return azienda;
    }

    public void setAzienda(String azienda) {
        this.azienda = azienda;
    }

    public int getAnnoInizio() {
        return annoInizio;
    }

    public void setAnnoInizio(int annoInizio) {
        this.annoInizio = annoInizio;
    }

    @Override
    public String toString() {
        return "Persona.Lavoratore{" +  super.toString() +
                "azienda='" + azienda + '\'' +
                ", annoInizio=" + annoInizio +
                '}';
    }
}
