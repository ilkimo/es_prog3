package dao;

import java.sql.*;
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

    private static ArrayList<Corso> getDefaultCorsi(){
        ArrayList<Corso> defaultCorsi = new ArrayList<>();

        defaultCorsi.add(new Corso("Prog III"));
        defaultCorsi.add(new Corso("IUM"));
        defaultCorsi.add(new Corso("Reti I"));
        defaultCorsi.add(new Corso("LPP"));

        return defaultCorsi;
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

        defaultDocentiRipetizioni.add(new DocRip("Liliana", "Ardissono", "Prog III"));
        defaultDocentiRipetizioni.add(new DocRip("Viviana", "Patti", "IUM"));
        defaultDocentiRipetizioni.add(new DocRip("Luca", "Padovani", "LPP"));
        defaultDocentiRipetizioni.add(new DocRip("Leonardo", "Di Caprio", "Reti I"));

        return defaultDocentiRipetizioni;
    }

    private static ArrayList<Lezione> getDefaultLezioni(){
        ArrayList<Lezione> defaultLezioni = new ArrayList<>();

        defaultLezioni.add(new Lezione(2, 1, 1));
        defaultLezioni.add(new Lezione(4, 2,1));
        defaultLezioni.add(new Lezione(3, 4, 2));

        return defaultLezioni;
    }



    public static void queryDropTables(Statement st) throws SQLException {
        String dropTableUtente = "DROP TABLE UTENTE;";
        String dropTableDocente = "DROP TABLE DOCENTE;";
        String dropTableRipetizione = "DROP TABLE CORSO;";
        String dropTableDocRip = "DROP TABLE DOCRIP;";
        String dropTableLezione = "DROP TABLE LEZIONE;";

        //Dropping Table
        try {
            st.executeUpdate(dropTableLezione);
            System.out.println("Table Lezione has been deleted.");
        } catch (SQLException e) {
            System.out.println("Table Lezione doesn't exist.");
        }

        try {
            st.executeUpdate(dropTableDocRip);
            System.out.println("Table DOCRIP has been deleted.");
        } catch (SQLException e) {
            System.out.println("Table DOCRIP doesn't exist.");
        }

        try {
            st.executeUpdate(dropTableUtente);
            System.out.println("Table UTENTE has been deleted.");
        } catch (SQLException e) {
            System.out.println("Table UTENTE doesn't exist.");
        }

        try {
            st.executeUpdate(dropTableDocente);
            System.out.println("Table DOCENTE has been deleted.");
        } catch (SQLException e) {
            System.out.println("Table DOCENTE doesn't exist.");
        }

        try {
            st.executeUpdate(dropTableRipetizione);
            System.out.println("Table CORSO has been deleted.");
        } catch (SQLException e) {
            System.out.println("Table CORSO doesn't exist.");
        }

    }

    public static void populateTables(Connection conn1) throws SQLException {
        ArrayList<Utente> users = getDefaultUsers();
        PreparedStatement ps;
        for(Utente u: users){
            ps = conn1.prepareStatement("INSERT INTO UTENTE VALUES(?, ?, ?, ?)");
            ps.setObject(1, null);
            ps.setString(2, u.getMail());
            ps.setString(3, u.getPassword());
            ps.setString(4, u.getRuolo());
            ps.executeUpdate();
        }

        ArrayList<Corso> corsiRipetizioni = getDefaultCorsi();
        for(Corso r: corsiRipetizioni){
            ps = conn1.prepareStatement("INSERT INTO CORSO VALUES(?, ?)");
            ps.setObject(1, null);
            ps.setString(2, r.getNomeCorso());

            ps.executeUpdate();
        }

        ArrayList<Docente> docenti = getDefaultDocenti();
        for(Docente d: docenti) {
            ps = conn1.prepareStatement("INSERT INTO DOCENTE VALUES(?, ?, ?)");
            ps.setObject(1, null);
            ps.setString(2, d.getNome());
            ps.setString(3, d.getCognome());

            ps.executeUpdate();
        }

        ArrayList<DocRip> docrip = getDefaultDocentiRipetizioni();
        for(DocRip d: docrip){
            ps = conn1.prepareStatement("INSERT INTO DOCRIP VALUES(?, ?, ?)");
            ps.setString(1, d.getNomeDoc());
            ps.setString(2, d.getCognomeDoc());
            ps.setString(3, d.getCorso());

            ps.executeUpdate();
        }

        ArrayList<Lezione> lezioni = getDefaultLezioni();
        for(Lezione l: lezioni){
            ps = conn1.prepareStatement("INSERT INTO LEZIONE VALUES(?, ?, ?)");
            ps.setInt(1, l.getIdCorso());
            ps.setInt(2, l.getIdDocente());
            ps.setInt(3, l.getIdUtente());

            ps.executeUpdate();
        }
    }

}
