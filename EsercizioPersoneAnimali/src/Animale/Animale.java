package Animale;

public class Animale  implements Comparable{
    private String tipo;
    private int età;
    private String genere;

    public Animale(String tipo, int età, String genere) {
        this.tipo = tipo;
        this.età = età;
        this.genere = genere;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getEtà() {
        return età;
    }

    public void setEtà(int età) {
        this.età = età;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return "Tipo='" + tipo + '\'' +
                ", età=" + età +
                ", genere='" + genere;
    }

    @Override
    public int compareTo(Object o) {
        Class this_class = this.getClass();
        Class o_class = o.getClass();
        if(o!=null && (o_class == this_class || o_class.getSuperclass() == this_class || this_class.getSuperclass() == o_class || o_class.getSuperclass() == this_class.getSuperclass())) {
            //avoid exception
            Animale a = (Animale) o;
            return this.età - ((Animale) o).getEtà();
        }else{
            System.out.println("EXCEPTION: You are trying to compare an object of class " + this.getClass() + " with an object of class " + o.getClass());
            return -1;
        }
    }
}
