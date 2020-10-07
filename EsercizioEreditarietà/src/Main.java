import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Geometrie g = new Geometrie();
        Scanner sc= new Scanner(System.in);    //System.in is a standard input stream

        g.aggiungiPoligono(new Rettangolo(4,6,7));
        g.aggiungiPoligono(new Rettangolo(4,8,7));
        g.aggiungiPoligono(new Rettangolo(4,6,7));  //Non lo aggiunge perchè già esiste
        g.aggiungiPoligono(new Triangolo(3,8,7, 15));
        g.aggiungiPoligono(new Triangolo(3,24,26, 10));

        System.out.println("Area poligono: " + ((Poligono)(g.getPoligono(3))).calcolaArea());

        g.aggiungiPoligono(new Cerchio(2));

        g.stampaPoligoni();
        int scelta = 0;

        while(scelta!=-1){
            stampaMenu();

            System.out.print("Scelta: ");
            scelta = sc.nextInt();

            switch(scelta){
                case 1: {
                    int base, altezza;
                    System.out.print("Inserisci il valore della base: ");
                    base = sc.nextInt();
                    System.out.print("Inserisci il valore dell'altezza: ");
                    altezza = sc.nextInt();
                    g.aggiungiPoligono(new Rettangolo(4, altezza, base));
                    break;
                }
                case 2: {
                    int base, altezza, lato;
                    System.out.print("Inserisci il valore della base: ");
                    base = sc.nextInt();
                    System.out.print("Inserisci il valore dell'altezza: ");
                    altezza = sc.nextInt();
                    System.out.print("Inserisci il valore del lato: ");
                    lato = sc.nextInt();
                    g.aggiungiPoligono(new Parallelogramma(4, base, lato, altezza));
                    break;
                }
                case 3: {
                    int latoA, latoB, latoC;
                    System.out.print("Inserisci il valore del lato A: ");
                    latoA = sc.nextInt();
                    System.out.print("Inserisci il valore del lato B: ");
                    latoB = sc.nextInt();
                    System.out.print("Inserisci il valore del lato C: ");
                    latoC = sc.nextInt();
                    g.aggiungiPoligono(new Triangolo(4, latoA, latoB, latoC));
                    break;
                }
                case 4: {
                    int raggio;
                    System.out.print("Inserisci il valore del raggio: ");
                    raggio = sc.nextInt();
                    g.aggiungiPoligono(new Cerchio(raggio));
                    break;
                }
                case 5: {
                    g.stampaPoligoni();
                }
                default:
                    break;
            }
        }
    }

    public static void stampaMenu(){
        System.out.println("MENU");
        System.out.println("Scegli cosa vuoi fare:");
        System.out.println("1 - Inserisci un Rettangolo");
        System.out.println("2 - Inserisci un Parallelogramma");
        System.out.println("3 - Inserisci un Triangolo");
        System.out.println("4 - Inserisci un Cerchio");
        System.out.println("5 - Stampa poligoni");
        System.out.println("-1 - ESCI");
    }
}
