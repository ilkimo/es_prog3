import java.util.ArrayList;

public class Geometrie{

    private ArrayList<FigureGeometriche> poligoni = new ArrayList<FigureGeometriche>();

    public void aggiungiPoligono(FigureGeometriche p){
        //Information Leak
        //CLONARE p e aggiungere il clone
        //chi chiama il metodo si ritrova un oggetto che non è effettivamente quello della lista


        boolean ok = true;

        for(int i = 0; i < poligoni.size() && ok == true; i++){
            if(p.equals(poligoni.get(i))){
                ok = false;
            }
        }
        if(ok){
            poligoni.add(p);
        }
    }

    public int getNumPoligoni(){
        return poligoni.size();
    }

    public void stampaPoligoni(){
        System.out.println(poligoni);
    }

    public FigureGeometriche getPoligono(int index){
        return poligoni.get(index);
    }

}
