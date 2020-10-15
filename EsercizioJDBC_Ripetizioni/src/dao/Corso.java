package dao;

public class Corso {
    private String nomecorso;

    public Corso(String nomecorso) {
        this.nomecorso = nomecorso;
    }

    public String getNomeCorso() {
        return nomecorso;
    }

    @Override
    public String toString() {
        return "Ripetizione{" +
                "nomecorso='" + nomecorso + '\'' +
                '}';
    }
}
