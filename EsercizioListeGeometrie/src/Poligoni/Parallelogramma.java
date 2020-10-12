package Poligoni;

import java.util.Objects;

public class Parallelogramma extends Poligono implements Comparable{

    private double base;
    private double lato;
    private double altezza;
    private double diagonale1;
    private double diagonale2;

    public Parallelogramma(int nLati, double base, double lato, double altezza) {
        super(nLati);
        this.base = base;
        this.lato = lato;
        this.altezza = altezza;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getLato() {
        return lato;
    }

    public void setLato(double lato) {
        this.lato = lato;
    }

    public double getAltezza() {
        return altezza;
    }

    public void setAltezza(double altezza) {
        this.altezza = altezza;
    }

    @Override
    public double calcolaArea() {
        return base*altezza;
    }

    @Override
    public double calcolaPerimetro() {
        return (2*base)+(2*lato);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parallelogramma that = (Parallelogramma) o;
        return Double.compare(that.base, base) == 0 &&
                Double.compare(that.lato, lato) == 0 &&
                Double.compare(that.altezza, altezza) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(base, lato, altezza, diagonale1, diagonale2);
    }

    @Override
    public String toString() {
        return "Poligoni.Parallelogramma{" +
                "base=" + base +
                ", lato=" + lato +
                ", altezza=" + altezza +
                ", diagonale1=" + diagonale1 +
                ", diagonale2=" + diagonale2 +
                '}';
    }
}
