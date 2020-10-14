package dao;

public class DocRip {
    private String nomeDocente;
    private String cognomeDocente;
    private String nomeCorso;

    public DocRip(String nomeDocente, String cognomeDocente, String nomeCorso) {
        this.nomeDocente = nomeDocente;
        this.cognomeDocente = cognomeDocente;
        this.nomeCorso = nomeCorso;
    }

    public String getNomeDocente() {
        return nomeDocente;
    }

    public String getCognomeDocente() {
        return cognomeDocente;
    }

    public String getNomeCorso() {
        return nomeCorso;
    }
}
