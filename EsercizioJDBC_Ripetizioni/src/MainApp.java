import java.util.ArrayList;
import java.util.Scanner;

import dao.*;

/* Questo esempio dimostra come connettersi a un DB MySQL
   e recuperare dati da tabella. Per un completo, che
   mostra vari tipi di connessione, vedere:
   http://www.codejava.net/java-se/jdbc/connect-to-mysql-database-via-jdbc#CodeExample
 */
public class MainApp {

    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);    //System.in is a standard input stream

        DAO.registerDriver();
        DAO.queryDB();

        int scelta = 1;

        while(scelta!=-1){
            System.out.println("Cosa vuoi fare? ");
            stampaMenu();
            System.out.print("Scelta: ");
            scelta = Integer.valueOf(sc.nextLine());
            switch(scelta){
                case 1:
                    break;
                case 2:
                    String nome, cognome;
                    System.out.print("Inserisci il nome: ");
                    nome = sc.nextLine();
                    System.out.print("Inserisci il cognome: ");
                    cognome = sc.nextLine();
                    DAO.queryInsertDocente(nome, cognome);
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    break;
            }
        }

        System.out.println("FINE");
    }

    public static void stampaMenu(){
        System.out.println("MENU");
        System.out.println("Scegli cosa vuoi fare:");
        System.out.println("1 - Inserisci un Corso");
        System.out.println("2 - Inserisci un Docente");
        System.out.println("3 - Inserisci una Materia per le Ripetizioni");
        System.out.println("4 - Inserisci un'associazione tra Docente e Corso");
        System.out.println("-1 - ESCI");
    }
}
