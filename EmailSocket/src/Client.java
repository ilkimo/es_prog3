import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.net.*;
import java.util.*;

public class Client {
    public static void main(String[] args) {
        try {
            String nomeLocale = InetAddress.getLocalHost().getHostName();
            System.out.println(nomeLocale);
            Socket s = new Socket(nomeLocale, 8189);
            
            System.out.println("Ho aperto il socket verso il server.\n");
            
            try {
                InputStream inStream = s.getInputStream();
                Scanner in = new Scanner(inStream);
                
                ObjectOutputStream outStream = new ObjectOutputStream(s.getOutputStream());
                
                System.out.println("Sto per ricevere dati dal socket server!");
                
                String line = in.nextLine();
                System.out.println(line);
                
                boolean done = false;
                Vector<Date> leDate = new Vector<Date>();
                
                Vector<Email> emails = new Vector<>();
                populateEmails(emails);
                System.out.println("Email vector: " + emails.toString());
                
                for(int i = 0; i < 4; i++) {
                    leDate.add(new Date());
                    Thread.sleep(1000);
                }
                
                //outStream.writeObject(leDate);
                outStream.writeObject(emails);
                
                while(in.hasNextLine()) {
                    line = in.nextLine();
                    System.out.println("Ritorno: " + line);
                }
            } finally {
                s.close();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public static void populateEmails(Vector<Email> emails){
        ObservableList<String> receiverList = FXCollections.observableArrayList();
        receiverList.add("laura.ventrice@gmail.com");
        receiverList.add("kim.viberti@gmail.com");
        
        emails.add(new Email((long) 0, "livio.scarpinati@gmail.com", receiverList,
                "Esercizi LPP", "Buongiorno, ecco a voi gli esercizi di LPP. \nSaluti. \nLivio",
                new GregorianCalendar(2020, Calendar.SEPTEMBER, 22)));
        
        emails.add(new Email((long) 1, "livio.scarpinati@gmail.com", receiverList,
                "Esercizi Prog III", "Buongiorno, ecco a voi gli esercizi di Prog III. \nSaluti. " +
                "\nLivio", new GregorianCalendar(2020, Calendar.OCTOBER, 18)));
        
    }
}
