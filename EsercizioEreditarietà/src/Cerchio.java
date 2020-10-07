public class Cerchio extends NonPoligono{
    private double raggio;
    private double diametro;

    public Cerchio(double raggio) {
        super();
        this.raggio = raggio;
        this.diametro = raggio*2;
    }

    public double getRaggio() {
        return raggio;
    }

    public void setRaggio(double raggio) {
        this.raggio = raggio;
    }

    public double getDiametro() {
        return diametro;
    }

    public void setDiametro(double diametro) {
        this.diametro = diametro;
    }

    @Override
    public double calcolaArea() {
        return Math.PI*Math.pow(raggio,2);
    }

    @Override
    public double calcolaPerimetro() {
        return 2*raggio*Math.PI;
    }

    @Override
    public String toString() {
        return "Cerchio{" +
                "raggio=" + raggio +
                ", diametro=" + diametro +
                '}';
    }
}
