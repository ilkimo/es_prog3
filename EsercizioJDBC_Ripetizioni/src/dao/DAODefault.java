package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/*gestione del popolamento del db con valori di default*/
public class DAODefault {

    private static ArrayList<Utente> getDefaultUsers(){
        ArrayList<Utente> defaultUsers = new ArrayList<>();

        defaultUsers.add(new Utente("livio.scarpinati@gmail.com", "Password", "Utente"));
        defaultUsers.add(new Utente("kim.viberti@gmail.com", "Password", "Utente"));
        defaultUsers.add(new Utente("laura.ventrice@gmail.com", "Password", "Utente"));
        defaultUsers.add(new Utente("enrico.pileggi@gmail.com", "Password", "Utente"));
        defaultUsers.add(new Utente("marco.daniello@gmail.com", "Password", "Amministratore"));
        defaultUsers.add(new Utente("fabio.mambrin@gmail.com", "Password", "Amministratore"));

        return defaultUsers;
    }

    private static ArrayList<Corso> getDefaultRipetizioni(){
        ArrayList<Corso> defaultRipetizioni = new ArrayList<>();

        defaultRipetizioni.add(new Corso("Prog III"));
        defaultRipetizioni.add(new Corso("IUM"));
        defaultRipetizioni.add(new Corso("Reti I"));
        defaultRipetizioni.add(new Corso("LPP"));

        return defaultRipetizioni;
    }

    private static ArrayList<Docente> getDefaultDocenti(){
        ArrayList<Docente> defaultDocenti = new ArrayList<>();

        defaultDocenti.add(new Docente("Liliana", "Ardissono"));
        defaultDocenti.add(new Docente("Luca", "Padovani"));
        defaultDocenti.add(new Docente("Viviana", "Patti"));
        defaultDocenti.add(new Docente("Leonardo", "Di Caprio"));

        return defaultDocenti;
    }

    private static ArrayList<DocRip> getDefaultDocentiRipetizioni(){
        ArrayList<DocRip> defaultDocentiRipetizioni = new ArrayList<>();

        defaultDocentiRipetizioni.add(new DocRip("Liliana", "Ardissono", "Programmazione III"));
        defaultDocentiRipetizioni.add(new DocRip("Viviana", "Patti", "IUM"));
        defaultDocentiRipetizioni.add(new DocRip("Luca", "Padovani", "LPP"));
        defaultDocentiRipetizioni.add(new DocRip("Leonardo", "Di Caprio", "Reti I"));

        return defaultDocentiRipetizioni;
    }

    public static void queryDropTables(Statement st) throws SQLException {
        String dropTableUtente = "DROP TABLE UTENTE;";
        String dropTableDocente = "DROP TABLE DOCENTE;";
        String dropTableRipetizione = "DROP TABLE CORSO;";
        String dropTableDocRip = "DROP TABLE DOCRIP;";

        st.executeUpdate(dropTableDocRip);
        st.executeUpdate(dropTableUtente);
        st.executeUpdate(dropTableDocente);
        st.executeUpdate(dropTableRipetizione);
    }

    public static void populateTables(Connection conn1) throws SQLException {
        ArrayList<Utente> users = getDefaultUsers();
        for(Utente u: users){
            PreparedStatement ps = conn1.prepareStatement("INSERT INTO UTENTE VALUES(?, ?, ?)");
            ps.setString(1, u.getMail());
            ps.setString(2, u.getPassword());
            ps.setString(3, u.getRuolo());
            ps.executeUpdate();
        }

        ArrayList<Corso> corsiRipetizioni = getDefaultRipetizioni();
        for(Corso r: corsiRipetizioni){
            PreparedStatement ps = conn1.prepareStatement("INSERT INTO CORSO VALUES(?)");
            ps.setString(1, r.getNomeCorso());

            ps.executeUpdate();
        }

        ArrayList<Docente> docenti = getDefaultDocenti();
        for(Docente d: docenti) {
            PreparedStatement ps = conn1.prepareStatement("INSERT INTO DOCENTE VALUES(?, ?)");
            ps.setString(1, d.getNome());
            ps.setString(2, d.getCognome());

            ps.executeUpdate();
        }

        ArrayList<DocRip> docrip = getDefaultDocentiRipetizioni();
        for(DocRip d: docrip){
            PreparedStatement ps = conn1.prepareStatement("INSERT INTO DOCRIP VALUES(?, ?, ?)");
            ps.setString(1, d.getNomeDocente());
            ps.setString(2, d.getCognomeDocente());
            ps.setString(3, d.getCorso());

            ps.executeUpdate();
        }
    }

}
