package dao;

import java.sql.*;
import java.util.ArrayList;

public class DAO extends DAODefault{


    private static final String dbName="ripetizioni";
    private static final String url1 = "jdbc:mysql://localhost:8889/"+dbName+"?useSSL=false";
    private static final String user = "Livio";
    private static final String password = "PasswordMySQL99";

    /*
    private static final String url1 = "jdbc:mysql://localhost:3306/ripetizioni";
    private static final String user = "root";
    private static final String password = "";
     */

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
        String createTableRipetizione = "CREATE TABLE CORSO (id int auto_increment primary key, nomecorso varchar(30) unique);";
        String createTableDocente = "CREATE TABLE DOCENTE (id int auto_increment primary key, nome varchar(30), cognome varchar(30), unique(nome, cognome));";
        String createTableDocRip = "CREATE TABLE DOCRIP (nome varchar(30), cognome varchar(30), corso varchar(30)," +
                                   "constraint fk_doc foreign key(nome, cognome) references DOCENTE(nome, cognome) on delete cascade on update cascade, " +
                                   "constraint fk_rip foreign key(corso) references CORSO(nomecorso) on delete cascade on update cascade, " +
                                   "constraint pl_docrip primary key (nome, cognome, corso));";

        st.executeUpdate(createTableUtente);
        st.executeUpdate(createTableRipetizione);
        st.executeUpdate(createTableDocente);
        st.executeUpdate(createTableDocRip);
    }

    public static void queryInsertDocente(ArrayList<Docente> docenti) {
        Connection conn1 = null;

        try {
            conn1 = DriverManager.getConnection(url1, user, password);
            if (conn1 != null) {
                System.out.println("Connected to the database docente");
            }

            assert conn1 != null;

            for (Docente doc: docenti) {
                PreparedStatement ps = conn1.prepareStatement("INSERT INTO DOCENTE VALUES(?, ?)");
                ps.setString(1, doc.getNome());
                ps.setString(2, doc.getCognome());

                ps.executeUpdate();
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

    public static void queryInsertCorso(ArrayList<Corso> nomeCorsi) {
        Connection conn1 = null;

        try {
            conn1 = DriverManager.getConnection(url1, user, password);
            if (conn1 != null) {
                System.out.println("Connected to the database corso");
            }

            assert conn1 != null;

            for (Corso rip: nomeCorsi) {
                PreparedStatement ps = conn1.prepareStatement("INSERT INTO CORSO VALUES(?)");
                ps.setString(1, rip.getNomeCorso());

                ps.executeUpdate();
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

    public static void queryInsertUtente(ArrayList<Utente> utenti) {
        Connection conn1 = null;

        try {
            conn1 = DriverManager.getConnection(url1, user, password);
            if (conn1 != null) {
                System.out.println("Connected to the database utente");
            }

            assert conn1 != null;

            for (Utente u: utenti) {
                PreparedStatement ps = conn1.prepareStatement("INSERT INTO UTENTE VALUES(?, ?, ?)");
                ps.setString(1, u.getMail());
                ps.setString(2, u.getPassword());
                ps.setString(3, u.getRuolo());

                ps.executeUpdate();
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

    public static void queryInsertDocRip(ArrayList<DocRip> docrip) {
        Connection conn1 = null;

        try {
            conn1 = DriverManager.getConnection(url1, user, password);
            if (conn1 != null) {
                System.out.println("Connected to the database utente");
            }

            assert conn1 != null;

            for (DocRip dr: docrip) {
                PreparedStatement ps = conn1.prepareStatement("INSERT INTO DOCRIP VALUES(?, ?, ?)");
                ps.setString(1, dr.getNomeDocente());
                ps.setString(2, dr.getCognomeDocente());
                ps.setString(3, dr.getCorso());

                ps.executeUpdate();
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
                System.out.println("\t" + rs.getString("NOMECORSO") + "\t\t\t" + rs.getString("NOME") + "\t\t\t"
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

    public static void queryDeleteUtente(ArrayList<Utente> utenti) {
        Connection conn1 = null;

        try {
            conn1 = DriverManager.getConnection(url1, user, password);
            if (conn1 != null) {
                System.out.println("Connected to the database utente");
            }

            assert conn1 != null;

            for (Utente u: utenti) {
                PreparedStatement ps = conn1.prepareStatement("DELETE FROM UTENTE WHERE MAIL ='" + u.getMail()
                        + "' AND PASSWORD = '" + u.getPassword()+"' AND RUOLO = '" + u.getRuolo() + "'");

                ps.executeUpdate();
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

    public static void queryDeleteDocente(ArrayList<Docente> docenti) {
        Connection conn1 = null;

        try {
            conn1 = DriverManager.getConnection(url1, user, password);
            if (conn1 != null) {
                System.out.println("Connected to the database docente");
            }

            assert conn1 != null;

            for (Docente d: docenti) {
                PreparedStatement ps = conn1.prepareStatement("DELETE FROM DOCENTE WHERE NOME ='" + d.getNome()
                        + "' AND COGNOME = '" + d.getCognome()+"'");

                ps.executeUpdate();
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

    public static void queryDeleteDocRip(ArrayList<DocRip> docrip) {
        Connection conn1 = null;

        try {
            conn1 = DriverManager.getConnection(url1, user, password);
            if (conn1 != null) {
                System.out.println("Connected to the database docrip");
            }

            assert conn1 != null;

            for (DocRip dr: docrip) {
                PreparedStatement ps = conn1.prepareStatement("DELETE FROM DOCRIP WHERE NOMEDOCENTE ='"
                        + dr.getNomeDocente() + "' AND COGNOMEDOCENTE = '" + dr.getCognomeDocente()
                        + "' AND CORSO = '" + dr.getCorso() + "'");

                ps.executeUpdate();
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

    public static void queryDeleteCorso(ArrayList<Corso> corsi){
        Connection conn1 = null;

        try {
            conn1 = DriverManager.getConnection(url1, user, password);
            if (conn1 != null) {
                System.out.println("Connected to the database corsi");
            }

            assert conn1 != null;

            for (Corso c: corsi) {
                PreparedStatement ps = conn1.prepareStatement("DELETE FROM CORSO WHERE NOMECORSO ='"
                        + c.getNomeCorso() + "'");

                ps.executeUpdate();
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
