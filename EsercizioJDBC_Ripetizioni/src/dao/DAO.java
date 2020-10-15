package dao;

import java.sql.*;
import java.util.ArrayList;

public class DAO extends DAODefault{

    /*
    private static final String dbName="ripetizioni";
    private static final String url1 = "jdbc:mysql://localhost:8889/"+dbName+"?useSSL=false";
    private static final String user = "Livio";
    private static final String password = "PasswordMySQL99";
    */

    private static final String url1 = "jdbc:mysql://localhost:3306/ripetizioni";
    private static final String user = "root";
    private static final String password = "";


    public static void registerDriver() {
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            System.out.println("Driver correttamente registrato");
        } catch (SQLException e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }

    public static void queryDB() {
        Connection conn1 = null;

        try {
            conn1 = DriverManager.getConnection(url1, user, password);
            if (conn1 != null) {
                System.out.println("Connected to the database ");
            }

            assert conn1 != null;   //per sicurezza
            Statement st = conn1.createStatement();

            queryDropTables(st);
            queryCreateTables(st);
            populateTables(conn1); /*con valori di default*/

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

    public static void queryCreateTables(Statement st) throws SQLException {
        String createTableUtente = "CREATE TABLE UTENTE (id int auto_increment primary key, mail varchar(30) unique, password varchar(50), ruolo varchar(15));";
        String createTableCorso = "CREATE TABLE CORSO (id int auto_increment primary key, nomecorso varchar(30) unique);";
        String createTableDocente = "CREATE TABLE DOCENTE (id int auto_increment primary key, nome varchar(30), cognome varchar(30), unique(nome, cognome));";
        String createTableDocRip = "CREATE TABLE DOCRIP (nomedoc varchar(30), cognomedoc varchar(30), corso varchar(30)," +
                                   "constraint fk_doc foreign key(nomedoc, cognomedoc) references DOCENTE(nome, cognome) on delete cascade on update cascade, " +
                                   "constraint fk_rip foreign key(corso) references CORSO(nomecorso) on delete cascade on update cascade, " +
                                   "constraint pl_docrip primary key (nomedoc, cognomedoc, corso));";
        String createTableLezione = "CREATE TABLE LEZIONE (IDCorso int, IDUtente int,  IDDocente int,"+
                "constraint fk_lezione primary key (IDCorso, IDUtente, IDDocente)," +
                "constraint fk_cor foreign key(IDCorso) references CORSO(id) on delete cascade on update cascade," +
                "constraint fk_utente foreign key(IDUtente) references UTENTE(id) on delete cascade on update cascade," +
                "constraint fk_ledocente foreign key(IDDocente) references DOCENTE(id) on delete cascade on update cascade);";

        st.executeUpdate(createTableUtente);
        st.executeUpdate(createTableCorso);
        st.executeUpdate(createTableDocente);
        st.executeUpdate(createTableDocRip);
        st.executeUpdate(createTableLezione);
    }

    public static void queryRipCorso() {

        Connection conn1 = null;

        try {
            conn1 = DriverManager.getConnection(url1, user, password);
            if (conn1 != null) {
                System.out.println("Connected to the database utente");
            }

            assert conn1 != null;

            Statement ps = conn1.createStatement();

            ResultSet rs = ps.executeQuery("SELECT* FROM CORSO C LEFT JOIN DOCRIP D ON C.NOMECORSO=CORSO");
            System.out.println("\t Corso" + " \t\t Nome Docente" + "\t Cognome Docente");
            while (rs.next()) {
                System.out.println("\t" + rs.getString("NOMECORSO") + "\t\t\t"
                        + rs.getString("NOME") + "\t\t\t"
                        + rs.getString("COGNOME"));
            }

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

    public static void queryInsert(ArrayList<?> valori) {
        Connection conn1 = null;

        try {
            conn1 = DriverManager.getConnection(url1, user, password);
            if (conn1 != null) {
                System.out.println("Connected to the database");
            }

            assert conn1 != null;

            if(valori != null && valori.size() > 0) {
                Class c = (valori.get(0)).getClass();
                PreparedStatement ps;
                switch (c.getName()) {
                    case "dao.Corso":
                        for (Object obj: valori) {
                            ps = conn1.prepareStatement("INSERT INTO CORSO VALUES(?, ?)");
                            ps.setObject(1, null);
                            ps.setString(2, ((Corso) obj).getNomeCorso());
                            ps.executeUpdate();
                        }
                        break;
                    case "dao.Docente":
                        for (Object obj: valori) {
                            ps = conn1.prepareStatement("INSERT INTO DOCENTE VALUES(?, ?, ?)");
                            ps.setObject(1, null);
                            ps.setString(2, ((Docente) obj).getNome());
                            ps.setString(3, ((Docente) obj).getCognome());
                            ps.executeUpdate();
                        }
                        break;
                    case "dao.Utente":
                        for (Object obj: valori) {
                            ps = conn1.prepareStatement("INSERT INTO UTENTE VALUES(?, ?, ?, ?)");
                            ps.setObject(1, null);
                            ps.setString(2, ((Utente) obj).getMail());
                            ps.setString(3, ((Utente) obj).getPassword());
                            ps.setString(4, ((Utente) obj).getRuolo());
                            ps.executeUpdate();
                        }
                        break;
                    case "dao.DocRip":
                        for (Object obj: valori) {
                            ps = conn1.prepareStatement("INSERT INTO DOCRIP VALUES(?, ?, ?)");
                            ps.setString(1, ((DocRip) obj).getNomeDoc());
                            ps.setString(2, ((DocRip) obj).getCognomeDoc());
                            ps.setString(3, ((DocRip) obj).getCorso());
                            ps.executeUpdate();
                        }
                        break;
                    case "dao.Lezione":
                        for (Object obj: valori) {
                            ps = conn1.prepareStatement("INSERT INTO LEZIONE VALUES(?, ?, ?)");
                            ps.setInt(1, ((Lezione) obj).getIdCorso());
                            ps.setInt(2, ((Lezione) obj).getIdDocente());
                            ps.setInt(3, ((Lezione) obj).getIdUtente());

                            ps.executeUpdate();
                        }
                    default:
                        break;
                }
                System.out.println("Inserimento avvenuto correttamente");
            }else{
                System.out.println("Non ci sono valori da inserire");
            }

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

    public static void queryDelete(ArrayList<?> valori) {
        Connection conn1 = null;

        try {
            conn1 = DriverManager.getConnection(url1, user, password);
            if (conn1 != null) {
                System.out.println("Connected to the database");
            }

            assert conn1 != null;

            if(valori != null && valori.size() > 0) {
                Class c = (valori.get(0)).getClass();
                PreparedStatement ps;
                switch (c.getName()) {
                    case "dao.Corso":
                        for (Object obj: valori) {
                            ps = conn1.prepareStatement("DELETE FROM CORSO WHERE NOMECORSO =?");
                            ps.setString(1, ((Corso) obj).getNomeCorso());

                            ps.executeUpdate();
                        }
                        break;
                    case "dao.Docente":
                        for (Object obj: valori) {
                            ps = conn1.prepareStatement("DELETE FROM DOCENTE WHERE NOME = ? AND COGNOME = ?");
                            ps.setString(1, ((Docente) obj).getNome());
                            ps.setString(2, ((Docente) obj).getCognome());

                            ps.executeUpdate();
                        }
                        break;
                    case "dao.Utente":
                        for (Object obj: valori) {
                            ps = conn1.prepareStatement("DELETE FROM UTENTE WHERE MAIL = ? AND PASSWORD = ? AND RUOLO = ?");
                            ps.setString(1, ((Utente) obj).getMail());
                            ps.setString(2, ((Utente) obj).getPassword());
                            ps.setString(3, ((Utente) obj).getRuolo());

                            ps.executeUpdate();
                        }
                        break;
                    case "dao.DocRip":
                        for (Object obj: valori) {
                            ps = conn1.prepareStatement("DELETE FROM DOCRIP WHERE NOMEDOC = ? AND COGNOMEDOC = ? AND CORSO = ?");
                            ps.setString(1, ((DocRip) obj).getNomeDoc());
                            ps.setString(2, ((DocRip) obj).getCognomeDoc());
                            ps.setString(3, ((DocRip) obj).getCorso());
                            ps.executeUpdate();
                        }
                        break;
                    case "dao.Lezione":
                        for (Object obj: valori) {
                            ps = conn1.prepareStatement("DELETE FROM LEZIONE WHERE IDCORSO = ? AND IDDOCENTE = ? AND IDUTENTE = ?");
                            ps.setInt(1, ((Lezione) obj).getIdCorso());
                            ps.setInt(2, ((Lezione) obj).getIdDocente());
                            ps.setInt(3, ((Lezione) obj).getIdUtente());

                            ps.executeUpdate();
                        }
                    default:
                        break;
                }
                System.out.println("Eliminazione avvenuta correttamente");
            }else{
                System.out.println("Non ci sono valori da eliminare");
            }

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

}
