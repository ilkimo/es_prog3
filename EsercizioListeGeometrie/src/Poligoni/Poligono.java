package Poligoni;

public abstract class Poligono {

    private int nLati;
    private double area;
    private double perimetro;

    public Poligono(int nLati) {
        this.nLati = nLati;
    }

    public int getnLati() {
        return nLati;
    }

    public void setnLati(int nLati) {
        this.nLati = nLati;
    }

    public double getArea() {
        return calcolaArea();
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPerimetro() {
        return calcolaPerimetro();
    }

    public void setPerimetro(double perimetro) {
        this.perimetro = perimetro;
    }

    abstract public double calcolaArea();

    abstract public double calcolaPerimetro();
}
