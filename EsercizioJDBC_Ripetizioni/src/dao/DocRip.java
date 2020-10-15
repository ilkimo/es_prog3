package dao;

public class DocRip {
    private String nomeDocente;
    private String cognomeDocente;
    private String corso;

    public DocRip(String nomeDocente, String cognomeDocente, String corso) {
        this.nomeDocente = nomeDocente;
        this.cognomeDocente = cognomeDocente;
        this.corso = corso;
    }

    public String getNomeDocente() {
        return nomeDocente;
    }

    public String getCognomeDocente() {
        return cognomeDocente;
    }

    public String getCorso() {
        return corso;
    }
}
