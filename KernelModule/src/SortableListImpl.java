import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortableListImpl <T extends Comparable> implements SortableList<T> {
    
    private List<T> lista;
    
    public SortableListImpl() {
        this.lista = new ArrayList<>();
    }
    
    @Override
    public void add(T o) {
        lista.add(o);
    }
    
    @Override
    public void remove(T o) {
        lista.remove(o);
    }
    
    /*
    @Override
    public void sort() {
        Collections.sort(lista);
    }
     */
    
    @Override
    public void sort() {
        //sorting algorithm
        System.out.println("Ordino lista - lista.size() = " + lista.size());
        
        for(int i = 0; i < lista.size(); i++){
            for(int j = i; j < lista.size(); j++){
                if(lista.get(i).compareTo(lista.get(j))>0){
                    Collections.swap(lista, i, j);
                }
            }
        }
        System.out.println("Fine ordinamento");
    }
    
    @Override
    public void print() {
        System.out.println(lista);
    }
}
