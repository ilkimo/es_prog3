package dao;

public class Utente {
    private String mail;
    private String password;
    private String ruolo;

    public Utente(String mail, String password, String ruolo) {
        this.mail = mail;
        this.password = password;
        this.ruolo = ruolo;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

    public String getRuolo() {
        return ruolo;
    }

    @Override
    public String toString() {
        return "Utente{" +
                "mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                ", ruolo='" + ruolo + '\'' +
                '}';
    }
}
