package dao;

public class DocRip {
    private String nomeDoc;
    private String cognomeDoc;
    private String corso;

    public DocRip(String nomeDoc, String cognomeDoc, String corso) {
        this.nomeDoc = nomeDoc;
        this.cognomeDoc = cognomeDoc;
        this.corso = corso;
    }

    public String getNomeDoc() {
        return nomeDoc;
    }

    public String getCognomeDoc() {
        return cognomeDoc;
    }

    public String getCorso() {
        return corso;
    }
}
