package dao;

public class Ripetizione {
    private String nomecorso;

    public Ripetizione(String nomecorso) {
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
