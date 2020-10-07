public abstract class NonPoligono extends FigureGeometriche{
    private double area;
    private double perimetro;

    public NonPoligono(double area, double perimetro) {
        this.area = area;
        this.perimetro = perimetro;
    }

    public NonPoligono() {

    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPerimetro() {
        return perimetro;
    }

    public void setPerimetro(double perimetro) {
        this.perimetro = perimetro;
    }

    abstract public double calcolaArea();

    abstract public double calcolaPerimetro();
}
