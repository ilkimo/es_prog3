import java.util.GregorianCalendar;
import java.util.Locale;

public class PersonaApp {
    public static void main(String[] args) {
        Persona p1, p2, p3;

        p1 = new Persona("Viberti", "Kim", 1997, 5, 24);
        p2 = new Persona("Giovinazzo", "Valentina", 1997, 12, 06);
        p3 = new Persona("Giovinazzo", "Melissa", 2002, 9, 27);

        System.out.println("oggi e': " + new GregorianCalendar(Locale.ITALIAN));
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
    }
}