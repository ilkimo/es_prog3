import Poligoni.Parallelogramma;
import Poligoni.Poligono;
import Poligoni.Rettangolo;
import Poligoni.Triangolo;

import java.util.List;

public class Geometrie<T extends Poligono> {
    List<T> listaPoligoni;

    public Geometrie(List<T> listaPoligoni) {
        this.listaPoligoni = listaPoligoni;
    }

    public int getNumElementi() {
        return this.listaPoligoni.size();
    }

    public boolean add(T poligono) {
        Class poligono_class = poligono.getClass();
        //System.out.println(poligono_class);
        //System.out.println(poligono_class.getName());

        //To avoid the information leak
        switch(poligono_class.getName()){
            case "Poligoni.Rettangolo":
                Rettangolo r = new Rettangolo(4, ((Rettangolo)poligono).getAltezza(), ((Rettangolo)poligono).getBase());
                listaPoligoni.add((T) r);
                break;
            case "Poligoni.Triangolo":
                Triangolo t = new Triangolo(3, ((Triangolo)poligono).getLatoA(),((Triangolo)poligono).getLatoB(),((Triangolo)poligono).getLatoC());
                listaPoligoni.add((T) t);
                break;
            case "Poligoni.Parallelogramma":
                Parallelogramma p = new Parallelogramma(4, ((Parallelogramma)poligono).getBase(),((Parallelogramma)poligono).getLato(),((Parallelogramma)poligono).getAltezza());
                listaPoligoni.add((T) p);
                break;
            default:
                break;
        }

        return true;
    }

    public void printAree(){
        System.out.println("AREE POLIGONI: ");
        for(T poligono: listaPoligoni){
            System.out.println("Area: " + poligono.getArea());
        }
    }

}
