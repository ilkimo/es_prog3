package dao;

public class Lezione {
    private final int idCorso;
    private final int idDocente;
    private final int idUtente;

    public Lezione (int idCorso, int idDocente, int idUtente) {
        this.idCorso = idCorso;
        this.idDocente = idDocente;
        this.idUtente = idUtente;
    }

    public int getIdCorso() {
        return idCorso;
    }

    public int getIdDocente() {
        return idDocente;
    }

    public int getIdUtente() {
        return idUtente;
    }
}
