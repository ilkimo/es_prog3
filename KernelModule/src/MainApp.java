public class MainApp {
    public static void main(String[] args) {
        ArrayOrdinabile<Integer> array = new ArrayOrdinabile();
        array.addModule(new SortableListImpl<>());
        
        array.add(2);
        array.add(1);
        array.add(4);
        array.add(5);
        array.add(0);
        array.print();
        
        array.sort();
        array.print();
    
        ArrayOrdinabile<String> animali = new ArrayOrdinabile();
        animali.addModule(new SortableListImpl<>());
    
        animali.add("Cane");
        animali.add("Gatto");
        animali.add("Zebra");
        animali.add("Farfalla");
        animali.add("Ippopotamo");
        animali.add("Cavallo");
    
        animali.print();
    
        animali.sort();
    
        animali.print();
    }
}
