public class ArrayOrdinabile <T extends Comparable>{
    private SortableList obj;
    
    public void addModule(SortableList m){
        obj = m;
    }
    
    public void add(T o){
        obj.add(o);
    }
    
    public void remove(T o){
        obj.remove(o);
    }
    
    public void sort(){
        obj.sort();
    }
    
    public void print(){
        obj.print();
    }
}
