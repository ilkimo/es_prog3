import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("/Volumes/DATA/GIT/es_prog3/Esercizio_InputOutput/src/indirizziPerRubrica.txt");
        Scanner sc = null;  // è locale nel main
        Rubrica rubrica = new Rubrica();
        
        //Create Rubrica
        try {
            sc = new Scanner(inputFile);
            // we need to use \\S and ; as delimiters
            sc.useDelimiter("\\s;\\s");
            String[] tokens;
            
            while (sc.hasNextLine()) {
                String data = sc.nextLine();
                System.out.println(data);
                tokens = data.trim().split("\\s*;\\s*");
                
                int nCivico = 0;
                try {
                    nCivico = Integer.parseInt(tokens[3]);
                }
                catch (NumberFormatException e)
                {
                    System.out.println("ERROR: " + e.getMessage());
                    throw new NumberFormatException();
                }
                
                rubrica.add(new Indirizzo(tokens[0], tokens[1], tokens[2], nCivico, tokens[4]));
            }
            
            rubrica.print();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (InputMismatchException e) {
            System.out.println("ERROR: " + e.getMessage());
        } finally {
            if(sc!=null)
                sc.close();
        }
    
        //Backup
        try {
            File backup = new File("/Volumes/DATA/GIT/es_prog3/Esercizio_InputOutput/src/backup.txt");
            if (backup.createNewFile()) {
                System.out.println("File created: " + backup.getName());
            } else {
                System.out.println("File already exists.");
            }
            
            FileWriter writer = new FileWriter("/Volumes/DATA/GIT/es_prog3/Esercizio_InputOutput/src/backup.txt");
            int i = 0;
            while(i < rubrica.getSize()){
                Indirizzo addr = rubrica.getIndirizzo(i);
                writer.write(addr.getCognome() + "; " + addr.getNome() + "; " + addr.getVia() + "; " + addr.getnCivico() + "; " + addr.getCittà() + "\n");
                i++;
            }
            writer.close();
            System.out.println("Successfully wrote to the file.");
    
    
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
