public class Indirizzo {
    private String nome;
    private String cognome;
    private String via;
    private int nCivico;
    private String città;
    
    public Indirizzo(String cognome, String nome, String via, int nCivico, String città) {
        this.cognome = cognome;
        this.nome = nome;
        this.via = via;
        this.nCivico = nCivico;
        this.città = città;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getCognome() {
        return cognome;
    }
    
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    
    public String getVia() {
        return via;
    }
    
    public void setVia(String via) {
        this.via = via;
    }
    
    public int getnCivico() {
        return nCivico;
    }
    
    public void setnCivico(int nCivico) {
        this.nCivico = nCivico;
    }
    
    public String getCittà() {
        return città;
    }
    
    public void setCittà(String città) {
        this.città = città;
    }
    
    @Override
    public String toString() {
        return "Indirizzo{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", via='" + via + '\'' +
                ", nCivico=" + nCivico +
                ", città='" + città + '\'' +
                '}';
    }
}
