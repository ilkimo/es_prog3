import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Persona {
    private String surname, name, mestiere, sesso;
    private GregorianCalendar birthday; //month expressed as [0-11]

    /**
     * Creates a new Persona with given parameters
     * @param birthMonth is a number in range [1-12] where January is 1, February is 2...*/
    public Persona(String surname, String name, int birthyear, int birthMonth, int birthDayOfMonth) {
        this.surname = surname;
        this.name = name;
        birthday = new GregorianCalendar(birthyear, birthMonth-1, birthDayOfMonth);
        mestiere = "nessun mestiere";
        sesso = "non definito";
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getMestiere() {
        return mestiere;
    }

    public String getSesso() {
        return sesso;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMestiere(String mestiere) {
        this.mestiere = mestiere;
    }

    public void setSesso(String sesso) {
        this.sesso = sesso;
    }

    public int getAge() {
        int age;
        GregorianCalendar today = new GregorianCalendar((Locale.ITALIAN));

        age = today.get(Calendar.YEAR) - birthday.get(Calendar.YEAR);

        if(birthday.get(Calendar.MONTH) > today.get(Calendar.MONTH)) {
            age--;
        } else if(birthday.get(Calendar.MONTH) == today.get(Calendar.MONTH)){
            if(birthday.get(Calendar.DAY_OF_MONTH) > today.get(Calendar.DAY_OF_MONTH)) {
                age--;
            }
        }


        return age;
    }

    @Override
    public String toString() {
        return "<" + surname + " " + name + ", age: " + getAge() + ">";
    }
}