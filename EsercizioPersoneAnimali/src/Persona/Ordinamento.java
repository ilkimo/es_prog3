package Persona;

import Persona.Persona;

import java.util.ArrayList;
import java.util.Collections;

public class Ordinamento{

    public void ordina(ArrayList<Persona> array){
        for(int i=0; i<array.size(); i++){
            for(int j=i; j<array.size(); j++){
                if(array.get(i).compareTo(array.get(j))>0){
                    Collections.swap(array, i, j);
                }
            }
        }
        System.out.println("Fine ordinamento");
    }

}
