public class Studente extends Persona{

    String gradoStudi;
    String indirizzoStudi;
    int annoInizio;
    int annoFinePrevisto;

    public Studente(String nome, String cognome, int età, char sesso, String gradoStudi, String indirizzoStudi, int annoInizio, int annoFinePrevisto) {
        super(nome, cognome, età, sesso);
        this.gradoStudi = gradoStudi;
        this.indirizzoStudi = indirizzoStudi;
        this.annoInizio = annoInizio;
        this.annoFinePrevisto = annoFinePrevisto;
    }

    public String getGradoStudi() {
        return gradoStudi;
    }

    public void setGradoStudi(String gradoStudi) {
        this.gradoStudi = gradoStudi;
    }

    public String getIndirizzoStudi() {
        return indirizzoStudi;
    }

    public void setIndirizzoStudi(String indirizzoStudi) {
        this.indirizzoStudi = indirizzoStudi;
    }

    public int getAnnoInizio() {
        return annoInizio;
    }

    public void setAnnoInizio(int annoInizio) {
        this.annoInizio = annoInizio;
    }

    public int getAnnoFinePrevisto() {
        return annoFinePrevisto;
    }

    public void setAnnoFinePrevisto(int annoFinePrevisto) {
        this.annoFinePrevisto = annoFinePrevisto;
    }

    @Override
    public String toString() {
        return "Studente{" + super.toString() +
                "gradoStudi='" + gradoStudi + '\'' +
                ", indirizzoStudi='" + indirizzoStudi + '\'' +
                ", annoInizio=" + annoInizio +
                ", annoFinePrevisto=" + annoFinePrevisto +
                '}';
    }
}
