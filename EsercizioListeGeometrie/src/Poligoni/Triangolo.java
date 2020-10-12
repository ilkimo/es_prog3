package Poligoni;

import java.util.Objects;

public class Triangolo extends Poligono implements Comparable{

    private double latoA;   //base
    private double latoB;   //B
    private double latoC;   //C

    public Triangolo(int nLati, double latoA, double latoB, double latoC) {
        super(nLati);
        this.latoA = latoA;
        this.latoB = latoB;
        this.latoC = latoC;
    }

    public double getLatoA() {
        return latoA;
    }

    public void setLatoA(double latoA) {
        this.latoA = latoA;
    }

    public double getLatoB() {
        return latoB;
    }

    public void setLatoB(double latoB) {
        this.latoB = latoB;
    }

    public double getLatoC() {
        return latoC;
    }

    public void setLatoC(double latoC) {
        this.latoC = latoC;
    }

    @Override
    public double calcolaArea() {
        double ipotenusa = getLatoMaggiore();
        //System.out.println("ipotenusa: " + ipotenusa);
        double[] pitagora = getPitagora(ipotenusa);
        //System.out.println("lato1: " + pitagora[0] + ", lato2: " + pitagora[1]);

        double sommaCateti = Math.sqrt(Math.pow(pitagora[0],2)+Math.pow(pitagora[1],2));
        //System.out.println("somma cateti: " + sommaCateti);

        if(ipotenusa == sommaCateti){
            return (pitagora[0]*pitagora[1])/2;
        }else{
            return ((2*calcolaPerimetro())/2*Math.sqrt(3));
        }
    }

    @Override
    public double calcolaPerimetro() {
        return latoA+latoB+latoC;
    }

    private double getLatoMaggiore(){
        if(latoA > latoB && latoA > latoC)
        {
            return latoA;
        }
        else if(latoB > latoC)
        {
            return latoB;
        }
        else
        {
            return latoC;
        }
    }

    private double[] getPitagora(double ipotenusa){
        double lati[] = new double[2];
        if(latoA==ipotenusa){
            lati[0]=latoB;
            lati[1]=latoC;
        }else if(latoB==ipotenusa){
            lati[0]=latoA;
            lati[1]=latoC;
        }else if(latoC==ipotenusa){
            lati[0]=latoA;
            lati[1]=latoB;
        }

        return lati;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangolo triangolo = (Triangolo) o;
        return Double.compare(triangolo.latoA, latoA) == 0 &&
                Double.compare(triangolo.latoB, latoB) == 0 &&
                Double.compare(triangolo.latoC, latoC) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(latoA, latoB, latoC);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public String toString() {
        return "Poligoni.Triangolo{" +
                "latoA=" + latoA +
                ", latoB=" + latoB +
                ", latoC=" + latoC +
                '}';
    }
}
