import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

class Filtro extends Observable implements Observer {
    private List<Integer> lista;
    //Visualizzatore visualizzatore;
    
    
    public List<Integer> getLista() {
        return lista;
    }
    
    public void setLista(List<Integer> lista) {
        this.lista = lista;
    }
    
    public Filtro() {
        //visualizzatore = v;
        lista = new ArrayList<Integer>();
    }
    
    public void filtra(int c) {
        lista.add(c);
        if (lista.size()%2==0) {
            System.out.println("lista size: " + lista.size());
            //visualizzatore.visualizza(lista);
        }
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
            //visualizzatore.visualizza(lista);
        }
    }
}