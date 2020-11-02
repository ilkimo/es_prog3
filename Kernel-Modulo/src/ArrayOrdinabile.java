public class ArrayOrdinabile <T extends Comparable>{
    private SortableList obj;
    
    public void addModulo(SortableList<T> m) {
        obj = m;
    }
    
    public void add(T o){
        obj.add(o);
    }
    
    public void remove(T o){
        obj.remove(o);
    }
    
    public void sort(){
        //è offerto dalla classe Arrays
        //prende l'oggetto e riordina gli elementi al suo interno in base al metodo di ordinamento offerto dentro al modulo
        //guarda gli oggetti del modulo che fanno il compare to
        obj.sort();
    }
    
    public void print(){
        obj.print();
    }
}
