import Animale.*;
import Persona.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] ergs){
        ArrayList<Persona> persone = new ArrayList<Persona>();
        Ordinamento ordinatore = new Ordinamento();

        Studente p = new Studente("Livio", "Scarpinati", 20, 'M', "Università", "Informatica", 2018, 2023);
        persone.add(p);
        persone.add(new Lavoratore("Marco", "D'Aniello", 21, 'M', "Accenture", 2018));
        persone.add(new Lavoratore("Alessio", "Garrone", 21, 'M', "Accenture", 2019));
        persone.add(new Studente("Fabio", "Mambrin", 20, 'M', "Università", "Scienze della terra", 2020, 2025));
        persone.add(new Persona("Giusy", "Scarpinati", 25, 'F'));
        persone.add(new Studente("Roberta", "Ramundo", 20, 'F',"Università", "Medicina", 2019, 2025));

        for(int i=0; i< persone.size(); i++){
            System.out.println(persone.get(i));
        }


        for(int i=0; i< persone.size(); i++){
            System.out.println(persone.get(i));
        }

        ordinatore.ordina(persone);

        for(int i=0; i< persone.size(); i++){
            System.out.println(persone.get(i));
        }

        Mammifero a = new Mammifero("Mammifero", 7, "Cane", "Carnivoro",  4, "Bassotto");

        //Prova: confronto di una persona con un animale
        p.compareTo(a);

        //Prova: confronto di un animale con una persona
        a.compareTo(p);
    }
}
