import java.util.List;
import java.util.Observable;
import java.util.Observer;

class Visualizzatore implements Observer {
    
    public void visualizza(List<Integer> lista) {
        for (Integer i : lista) {
            System.out.println(i.intValue());
        }
        System.out.println();
    }
    
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