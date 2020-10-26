import java.util.*;

public class Esercizio1 {
    
    public static void main(String[] args) {
        Visualizzatore v = new Visualizzatore();
        Filtro f = new Filtro();
        Contatore c = new Contatore();
        
        c.addObserver(f);
        f.addObserver(v);
        
        c.start();
    }
}

class Contatore extends Observable {
    private int c;
    
    public Contatore() {
        c = 0;
    }
    
    public void start() {
        for (int i=0; i<50; i++) {
            c++;
            if (c%5==0) {
                setChanged();
                notifyObservers(c);
            }
        }
    }
    
}

class Filtro extends Observable implements Observer {
    private List<Integer> lista;

    public List<Integer> getLista() {
        return lista;
    }
    
    public void setLista(List<Integer> lista) {
        this.lista = lista;
    }
    
    public Filtro() {
        lista = new ArrayList<Integer>();
    }
    
    @Override
    public void update(Observable ob, Object arg) {
        if (ob!=null && ob instanceof Contatore) {
            lista.add((Integer)arg);
            if (lista.size()%2==0) {
                System.out.println("lista size: " + lista.size());
                setChanged();
                notifyObservers();
            }
        }
    }
}

class Visualizzatore implements Observer {
    
    @Override
    public void update(Observable ob, Object arg) {
        if (ob!=null && ob instanceof Filtro) {
            List<Integer> lista = ((Filtro) ob).getLista();
            
            for (Integer i : lista) {
                System.out.println(i.intValue());
            }
            System.out.println();
        }
    }
}