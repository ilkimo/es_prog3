import java.io.*;
import java.net.*;
import java.util.*;

/**
 * This program implements a simple server that listens to port 8189 and echoes back all
 * client input.
 */
public class Server {
    public static void main(String[] args) {
        System.out.println("Finestra del server: ");
        try {
            int i = 1;
            ServerSocket s = new ServerSocket(8189);
            
            while(true) {
                Socket incoming = s.accept(); // si mette in attesa di richiesta di connessione e la apre
                System.out.println("Spawning " + i);
                Runnable r = new ThreadedEchoHandler(incoming, i);
                new Thread(r).start();
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
    
    /*
    public static void main(String[] args) {
        System.out.println("Finestra del socket server");
        try {
            ServerSocket s = new ServerSocket(8189);
            Socket incoming = s.accept();
            try {
            
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    */

/**
 * This class handles the client input for one server socket connection.
 */
class ThreadedEchoHandler implements Runnable {
    
    private Socket incoming;
    private int counter;
    
    /**
     * Constructs a handler.
     *
     * @param in the incoming socket
     * @param c the counter for the handlers (used in prompts)
     */
    public ThreadedEchoHandler(Socket in, int c) {
        incoming = in;
        counter = c;
    }
    
    public void run() {
        try {
            try {
                ObjectInputStream inStream = new ObjectInputStream(incoming.getInputStream());
                OutputStream outStream = incoming.getOutputStream();
                
                PrintWriter out = new PrintWriter(outStream, true);
                
                out.println("Hello! Waiting for data.");
                
                // echo client input
                Vector<Date> v = null;
                Vector<Email> vEmails = null;
                try {
                    //v = ((Vector<Date>) inStream.readObject());
                    vEmails = ((Vector<Email>) inStream.readObject());
                } catch (ClassNotFoundException e) {
                    System.out.println(e.getMessage());
                }

                /*
                if(v != null)
                    for(int i = 0; i < v.size(); i++) {
                        Date date = v.get(i);
                        System.out.println("Echo: " + date);
                        out.println("Echo: " + date);
                    }
                    
                 */
    
                if(vEmails != null) {
                    for(int i = 0; i < vEmails.size(); i++) {
                        Email e = vEmails.get(i);
                        System.out.println("Echo: " + e);
                        out.println("Echo: " + e);
                    }
                }
            } finally {
                incoming.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



