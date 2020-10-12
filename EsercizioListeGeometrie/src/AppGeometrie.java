import Poligoni.Parallelogramma;
import Poligoni.Rettangolo;
import Poligoni.Triangolo;

import java.util.ArrayList;

public class AppGeometrie {
    public static void main(String[] args) {

        ArrayList<Rettangolo> rettangoli = new ArrayList<>();
        Geometrie<Rettangolo> listaRettangoli = new Geometrie<>(rettangoli);

        listaRettangoli.add(new Rettangolo(4,6,7));
        listaRettangoli.add(new Rettangolo(4,3,9));
        listaRettangoli.add(new Rettangolo(4,8,10));
        //listaRettangoli.add(new Parallelogramma(4, 4,6,7)); //ERRORE

        System.out.println("Numero elementi in listaRettangoli: " + listaRettangoli.getNumElementi());

        listaRettangoli.printAree();

        ArrayList<Triangolo> triangoli = new ArrayList<>();
        Geometrie<Triangolo> listaTriangoli = new Geometrie<>(triangoli);

        listaTriangoli.add(new Triangolo(3, 4,6,7));
        listaTriangoli.add(new Triangolo(3, 4,3,9));
        listaTriangoli.add(new Triangolo(3, 4,8,10));
        //listaRettangoli.add(new Parallelogramma(4, 4,6,7)); //ERRORE

        System.out.println("\nNumero elementi in listaTriangoli: " + listaTriangoli.getNumElementi());

        listaTriangoli.printAree();

        ArrayList<Parallelogramma> parallelogrammi = new ArrayList<>();
        Geometrie<Parallelogramma> listaParallelogrammi = new Geometrie<>(parallelogrammi);

        listaParallelogrammi.add(new Parallelogramma(4, 4,6,7));
        listaParallelogrammi.add(new Parallelogramma(4, 4,3,9));
        listaParallelogrammi.add(new Parallelogramma(4, 4,8,10));
        //listaRettangoli.add(new Rettangolo(4, 4,6,7)); //ERRORE

        System.out.println("\nNumero elementi in listaParallelogrammi: " + listaParallelogrammi.getNumElementi());

        listaParallelogrammi.printAree();
    }
}
