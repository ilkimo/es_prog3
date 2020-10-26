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