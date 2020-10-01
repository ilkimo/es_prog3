package Persona;

public class Persona implements Comparable{
    private String Nome;
    private String Cognome;
    private int età;
    private char sesso;

    public Persona(String nome, String cognome, int età, char sesso) {
        Nome = nome;
        Cognome = cognome;
        this.età = età;
        this.sesso = sesso;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getCognome() {
        return Cognome;
    }

    public void setCognome(String cognome) {
        Cognome = cognome;
    }

    public int getEtà() {
        return età;
    }

    public void setEtà(int età) {
        this.età = età;
    }

    public char getSesso() {
        return sesso;
    }

    public void setSesso(char sesso) {
        this.sesso = sesso;
    }

    @Override
    public String toString() {
        return "Nome='" + Nome + '\'' +
                ", Cognome='" + Cognome + '\'' +
                ", età=" + età +
                ", sesso=" + sesso;
    }
    @Override
    public int compareTo(Object o) {
        Class this_class = this.getClass();
        Class o_class = o.getClass();
        if(o!=null && (o_class == this_class || o_class.getSuperclass() == this_class || this_class.getSuperclass() == o_class || o_class.getSuperclass() == this_class.getSuperclass())) {
            //avoid exception
            Persona p = (Persona) o;
            return this.età - ((Persona) o).getEtà();
        }else{
            System.out.println("EXCEPTION: You are trying to compare an object of class " + this.getClass() + " with an object of class " + o.getClass());
            return -1;
        }
    }
}
