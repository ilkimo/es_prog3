import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

class Contatore extends Observable {
    private int c;
    //private Filtro filtro;
    
    public Contatore() {
        c = 0;
        //filtro = f;
    }
    
    public void start() {
        for (int i=0; i<50; i++) {
            c++;
            if (c%5==0) {
                //filtro.filtra(c);
                setChanged();
                notifyObservers(c);
            }
        }
    }
    
}