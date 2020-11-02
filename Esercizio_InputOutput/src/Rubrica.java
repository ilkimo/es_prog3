import java.util.ArrayList;
import java.util.List;

public class Rubrica {
    private List<Indirizzo> indirizzi;
    
    public Rubrica() {
        this.indirizzi = new ArrayList<>();
    }
    
    public void add(Indirizzo i){
        indirizzi.add(i);
    }
    
    public void print(){
        System.out.println(indirizzi);
    }
    
    public Indirizzo getIndirizzo(int index){
        return indirizzi.get(index);
    }
    
    public int getSize(){
        return indirizzi.size();
    }
}
