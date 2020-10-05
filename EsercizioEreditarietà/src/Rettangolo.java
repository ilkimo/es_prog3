import java.util.Objects;

public class Rettangolo extends Poligono implements Comparable{

    private double altezza;
    private double base;

    public Rettangolo(int nLati, double altezza, double base) {
        super(nLati);
        this.altezza = altezza;
        this.base = base;
    }

    public double getAltezza() {
        return altezza;
    }

    public void setAltezza(double altezza) {
        this.altezza = altezza;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    @Override
    public double calcolaArea() {
        return base*altezza;
    }

    @Override
    public double calcolaPerimetro() {
        return (2*base)+(2*altezza);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rettangolo that = (Rettangolo) o;
        return Double.compare(that.altezza, altezza) == 0 &&
                Double.compare(that.base, base) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(altezza, base);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public String toString() {
        return "Rettangolo{" +
                "altezza=" + altezza +
                ", base=" + base +
                '}';
    }
}
