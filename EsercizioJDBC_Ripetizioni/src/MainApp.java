import java.util.ArrayList;
import java.util.Scanner;

import dao.*;


public class MainApp {

    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);    //System.in is a standard input stream

        DAO.registerDriver();
        DAO.queryDB();

        int scelta = 1;
        int numeroVolte = 1;

        while(scelta != -1){
            System.out.println("Cosa vuoi fare? ");
            stampaMenu();
            System.out.print("Scelta: ");
            scelta = Integer.valueOf(sc.nextLine());
            switch(scelta){
                case 1:
                    System.out.println("Quante modifiche di corsi vuoi fare?");
                    numeroVolte = Integer.valueOf(sc.nextLine());
                    ArrayList<Corso> corsiRipetizioni = new ArrayList<>();
                    while(numeroVolte != 0) {
                        String nomeCorso;
                        System.out.print("Inserisci il nome del corso: ");
                        nomeCorso = sc.nextLine();
                        corsiRipetizioni.add(new Corso(nomeCorso));
                        numeroVolte--;
                    }
                    System.out.println("Vuoi inserire o eliminare queste tuple? (1 inserimento: 2 eliminazione)");
                    if(Integer.valueOf(sc.nextLine()) == 1)
                        DAO.queryInsert(corsiRipetizioni);
                    else
                        DAO.queryDelete(corsiRipetizioni);
                    break;
                case 2:
                    System.out.println("Quante modifiche di docenti vuoi fare?");
                    numeroVolte = Integer.valueOf(sc.nextLine());
                    ArrayList<Docente> docenti = new ArrayList<>();
                    while(numeroVolte != 0) {
                        String nome, cognome;
                        System.out.print("Inserisci il nome: ");
                        nome = sc.nextLine();
                        System.out.print("Inserisci il cognome: ");
                        cognome = sc.nextLine();
                        docenti.add(new Docente(nome, cognome));
                        numeroVolte--;
                    }
                    System.out.println("Vuoi inserire o eliminare queste tuple? (1 inserimento: 2 eliminazione)");
                    if(Integer.valueOf(sc.nextLine()) == 1)
                        DAO.queryInsert(docenti);
                    else
                        DAO.queryDelete(docenti);
                    break;
                case 3:/*parte due dell'es*/
                    System.out.println("Quante modifiche alle lezioni vuoi fare?");
                    numeroVolte = Integer.valueOf(sc.nextLine());
                    ArrayList<Lezione> lezioni = new ArrayList<>();
                    while(numeroVolte != 0) {
                        int idCorso, idDocente, idUtente;
                        System.out.print("Inserisci l'id del corso: ");
                        idCorso = Integer.valueOf(sc.nextLine());
                        System.out.print("Inserisci l'id del docente: ");
                        idDocente = Integer.valueOf(sc.nextLine());
                        System.out.print("Inserisci l'id dell'utente: ");
                        idUtente = Integer.valueOf(sc.nextLine());
                        lezioni.add(new Lezione(idCorso, idDocente, idUtente));
                        numeroVolte--;
                    }
                    System.out.println("Vuoi inserire o eliminare queste tuple? (1 inserimento: 2 eliminazione)");
                    if(Integer.valueOf(sc.nextLine()) == 1)
                        DAO.queryInsert(lezioni);
                    else
                        DAO.queryDelete(lezioni);
                    break;
                case 4:
                    System.out.println("Quante modifiche di associazione tra docente e corso vuoi fare?");
                    numeroVolte = Integer.valueOf(sc.nextLine());
                    ArrayList<DocRip> ripetizioni = new ArrayList<>();
                    while(numeroVolte != 0) {
                        String nomeDoc, cognomeDoc, corso;
                        System.out.print("Inserisci il nome del docente: ");
                        nomeDoc = sc.nextLine();
                        System.out.print("Inserisci il cognome del docente: ");
                        cognomeDoc = sc.nextLine();
                        System.out.print("Inserisci il nome del corso che insegna: ");
                        corso = sc.nextLine();
                        ripetizioni.add(new DocRip(nomeDoc, cognomeDoc, corso));
                        numeroVolte--;
                    }
                    System.out.println("Vuoi inserire o eliminare queste tuple? (1 inserimento: 2 eliminazione)");
                    if(Integer.valueOf(sc.nextLine()) == 1)
                        DAO.queryInsert(ripetizioni);
                    else
                        DAO.queryDelete(ripetizioni);
                    break;
                case 5:
                    System.out.println("Quante modifiche di utenti vuoi fare?");
                    numeroVolte = Integer.valueOf(sc.nextLine());
                    ArrayList<Utente> utenti = new ArrayList<>();
                    while(numeroVolte != 0) {
                        String mail, password, ruolo;
                        System.out.print("Inserisci l'email dell'utente: ");
                        mail = sc.nextLine();
                        System.out.print("Inserisci la password dell'utente: ");
                        password = sc.nextLine();
                        System.out.print("Inserisci il ruolo dell'utente (Amministratore o Utente): ");
                        ruolo = sc.nextLine();
                        utenti.add(new Utente(mail, password, ruolo));
                        numeroVolte--;
                    }
                    System.out.println("Vuoi inserire o eliminare queste tuple? (1 inserimento: 2 eliminazione)");
                    if(Integer.valueOf(sc.nextLine()) == 1)
                        DAO.queryInsert(utenti);
                    else
                        DAO.queryDelete(utenti);
                    break;
                case 6:
                    DAO.queryRipCorso();
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
        System.out.println("1 - Modificare la tabella Corso");
        System.out.println("2 - Modificare la tabella Docente");
        System.out.println("3 - Modificare la tabella lezione ********** ");
        System.out.println("4 - Modificare la tabella delle ripetizioni dei corsi associate ai docenti");
        System.out.println("5 - Modificare la tabella Utente");
        System.out.println("6 - Visualizzare, per ciascun corso, la lista delle possibili ripetizioni");
        System.out.println("-1 - ESCI");
    }
}
