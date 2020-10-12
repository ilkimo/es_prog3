import java.util.List;

public class Coda<T>{
    private List<T> coda;

    public Coda(List<T> coda) {
        this.coda = coda;
    }

    public T get(){
        if(coda.size()>0) {
            return coda.remove(0);  //Rimuovo il primo elemento, ovvero il primo inserito (politica FIFO)
        } else{
            return null;
        }
    }

    public void put(T newElem){
        coda.add(newElem);
    }

    public boolean empty() {
        return this.coda.isEmpty();
    }

    public void print(){
        System.out.println(coda);   //Sfrutto il metodo toString() di default
    }
}
