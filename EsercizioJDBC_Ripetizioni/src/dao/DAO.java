package dao;

import java.sql.*;
import java.util.ArrayList;

public class DAO {

    private static final String dbName="ripetizioni";
    private static final String url1 = "jdbc:mysql://localhost:8889/"+dbName+"?useSSL=false";
    private static final String user = "Livio";
    private static final String password = "PasswordMySQL99";

    public static void registerDriver() {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            System.out.println("Driver correttamente registrato");
        } catch (SQLException e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }

    public static ArrayList<Utente> getDefaultUsers(){
        ArrayList<Utente> defaultUsers = new ArrayList<>();

        defaultUsers.add(new Utente("livio.scarpinati@gmail.com", "Password", "Utente"));
        defaultUsers.add(new Utente("kim.viberti@gmail.com", "Password", "Utente"));
        defaultUsers.add(new Utente("laura.ventrice@gmail.com", "Password", "Utente"));
        defaultUsers.add(new Utente("enrico.pileggi@gmail.com", "Password", "Utente"));
        defaultUsers.add(new Utente("marco.daniello@gmail.com", "Password", "Amministratore"));
        defaultUsers.add(new Utente("fabio.mambrin@gmail.com", "Password", "Amministratore"));

        return defaultUsers;
    }

    public static ArrayList<Ripetizione> getDefaultRipetizioni(){
        ArrayList<Ripetizione> defaultRipetizioni = new ArrayList<>();

        defaultRipetizioni.add(new Ripetizione("Programmazione III"));
        defaultRipetizioni.add(new Ripetizione("IUM"));
        defaultRipetizioni.add(new Ripetizione("Reti I"));
        defaultRipetizioni.add(new Ripetizione("LPP"));

        return defaultRipetizioni;
    }

    public static ArrayList<Docente> getDefaultDocenti(){
        ArrayList<Docente> defaultDocenti = new ArrayList<>();

        defaultDocenti.add(new Docente("Liliana", "Ardissono"));
        defaultDocenti.add(new Docente("Luca", "Padovani"));
        defaultDocenti.add(new Docente("Viviana", "Patti"));
        defaultDocenti.add(new Docente("Leonardo", "Di Caprio"));

        return defaultDocenti;
    }

    public static ArrayList<DocRip> getDefaultDocentiRipetizioni(){
        ArrayList<DocRip> defaultDocentiRipetizioni = new ArrayList<>();

        defaultDocentiRipetizioni.add(new DocRip("Liliana", "Ardissono", "Programmazione III"));
        defaultDocentiRipetizioni.add(new DocRip("Viviana", "Patti", "IUM"));
        defaultDocentiRipetizioni.add(new DocRip("Luca", "Padovani", "LPP"));
        defaultDocentiRipetizioni.add(new DocRip("Leonardo", "Di Caprio", "Reti I"));

        return defaultDocentiRipetizioni;
    }

    public static void queryDropTables(Statement st, Connection conn1) throws SQLException {
        String dropTableUtente = "DROP TABLE UTENTE;";
        String dropTableDocente = "DROP TABLE DOCENTE;";
        String dropTableRipetizione = "DROP TABLE RIPETIZIONE;";
        String dropTableDocRip = "DROP TABLE DOCRIP;";

        st.executeUpdate(dropTableDocRip);
        st.executeUpdate(dropTableUtente);
        st.executeUpdate(dropTableDocente);
        st.executeUpdate(dropTableRipetizione);
    }

    public static void queryCreateTables(Statement st, Connection conn1) throws SQLException {
        String createTableUtente = "CREATE TABLE UTENTE (mail varchar(30) primary key, password varchar(50), ruolo varchar(15));";
        String createTableRipetizione = "CREATE TABLE RIPETIZIONE (nomecorso varchar(30), primary key(nomecorso));";
        String createTableDocente = "CREATE TABLE DOCENTE (nome varchar(30), cognome varchar(30), primary key(nome, cognome));";
        String createTableDocRip = "CREATE TABLE DOCRIP (nome varchar(30), cognome varchar(30), nomecorso varchar(30)," +
                                   "constraint fk_doc foreign key(nome, cognome) references DOCENTE(nome, cognome) on delete cascade on update cascade, " +
                                   "constraint fk_rip foreign key(nomecorso) references RIPETIZIONE(nomecorso) on delete cascade on update cascade, " +
                                   "constraint pl_docrip primary key (nome, cognome, nomecorso));";

        st.executeUpdate(createTableUtente);
        st.executeUpdate(createTableRipetizione);
        st.executeUpdate(createTableDocente);
        st.executeUpdate(createTableDocRip);
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

        ArrayList<Ripetizione> ripetizioni = getDefaultRipetizioni();
        for(Ripetizione r: ripetizioni){
            PreparedStatement ps = conn1.prepareStatement("INSERT INTO RIPETIZIONE VALUES(?)");
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
            ps.setString(3, d.getNomeCorso());

            ps.executeUpdate();
        }
    }

    public static void queryDB() {
        Connection conn1 = null;
        ArrayList<Utente> out = new ArrayList<>();

        try {
            conn1 = DriverManager.getConnection(url1, user, password);
            if (conn1 != null) {
                System.out.println("Connected to the database " + dbName);
            }

            assert conn1 != null;   //per sicurezza
            Statement st = conn1.createStatement();

            //queryDropTables(st, conn1);
            queryCreateTables(st, conn1);
            populateTables(conn1);

            /*
            String allQuery = "SELECT * FROM UTENTE";
            String whereQuery = "SELECT * FROM STUDENTE WHERE NOME='Livio'";
            ResultSet rs = st.executeQuery(allQuery);
            while (rs.next()) {
                Utente p = new Utente(rs.getString("MAIL"),rs.getString("PASSWORD"), rs.getString("RUOLO"));
                out.add(p);
            }

            for (Utente p: out)
                System.out.println(p);

             */

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally {
            if (conn1 != null) {
                try {
                    conn1.close();
                } catch (SQLException e2) {
                    System.out.println(e2.getMessage());
                }
            }
        }
    }

    public static void queryInsertDocente(String nome, String cognome) {
        Connection conn1 = null;

        try {
            conn1 = DriverManager.getConnection(url1, user, password);
            if (conn1 != null) {
                System.out.println("Connected to the database " + dbName);
            }

            assert conn1 != null;   //per sicurezza

            PreparedStatement ps = conn1.prepareStatement("INSERT INTO DOCENTE VALUES(?, ?)");
            ps.setString(1, nome);
            ps.setString(2, cognome);

            ps.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        finally {
            if (conn1 != null) {
                try {
                    conn1.close();
                } catch (SQLException e2) {
                    System.out.println(e2.getMessage());
                }
            }
        }
    }

    public static void queryInsertCorso(String nomeCorso) {

    }

    public static void queryInsertDocRic(String nomeDocente, String  cognomeDocente, String nomeCorso) {

    }

}
