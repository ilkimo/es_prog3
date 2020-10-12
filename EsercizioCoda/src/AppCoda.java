import java.util.ArrayList;

public class AppCoda {

    public static void main(String[] args) {

        testCodaInteger();
        System.out.println();
        testCodaString();
        System.out.println();
        testCodaDouble();
        System.out.println();
    }

    public static void testCodaInteger(){
        ArrayList<Integer> lista1 = new ArrayList<>();
        Coda<Integer> coda1 = new Coda(lista1);

        System.out.println("Coda1 è vuota: " + coda1.empty());

        System.out.println("Elemento estratto: " + coda1.get());

        coda1.put(2);
        coda1.put(6);
        coda1.put(10);
        coda1.put(1);
        // coda1.put("ciao"); -> Errore, non posson inserire una stringa in una coda di Integer

        System.out.println("Coda1 iniziale: ");
        coda1.print();
        System.out.println("Coda1 è vuota: " + coda1.empty());

        Integer element = (Integer)coda1.get();
        System.out.println("Elemento estratto: " + element);

        System.out.println("Coda1 dopo get(): ");
        coda1.print();
    }

    public static void testCodaDouble(){
        ArrayList<Double> lista3 = new ArrayList<>();
        Coda<Double> coda3 = new Coda(lista3);
        System.out.println("Coda3 è vuota: " + coda3.empty());

        coda3.put(2.45);
        coda3.put(6.29);
        coda3.put(7.35);
        coda3.put(10.3714);

        System.out.println("Coda3 iniziale: ");
        coda3.print();

        Double element3 = (Double)coda3.get();
        System.out.println("Elemento estratto: " + element3);

        System.out.println("Coda3 dopo get(): ");
        coda3.print();

        coda3.put(245882.23);
        System.out.println("Coda3 dopo put(): ");
        coda3.print();

        System.out.println("Coda3 è vuota: " + coda3.empty());
    }

    public static void testCodaString(){
        ArrayList<String> lista2 = new ArrayList<>();
        Coda<String> coda2 = new Coda(lista2);
        System.out.println("Coda2 è vuota: " + coda2.empty());

        coda2.put("Livio");
        coda2.put("Kim");
        coda2.put("Laura");
        coda2.put("Enrico");

        System.out.println("Coda2 iniziale: ");
        coda2.print();

        String element2 = (String)coda2.get();
        System.out.println("Elemento estratto: " + element2);

        System.out.println("Coda2 dopo get(): ");
        coda2.print();

        coda2.put("Fabio");
        System.out.println("Coda2 dopo put(): ");
        coda2.print();

        System.out.println("Coda2 è vuota: " + coda2.empty());
    }

}
