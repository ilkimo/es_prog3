package sample;

import javafx.beans.Observable;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.File;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class EmailDataModel {
    
    private final ObservableList<Email> emailList = FXCollections.observableArrayList(email ->
            new Observable[]{email.objectProperty(), email.bodyProperty()});
    
    private final ObjectProperty<Email> currentEmail = new SimpleObjectProperty<>(null);
    
    public ObjectProperty<Email> currentEmailProperty() {
        return currentEmail;
    }
    
    public final Email getCurrentEmail() {
        return currentEmailProperty().get();
    }
    
    public final void setCurrentPerson(Email email) {
        currentEmailProperty().set(email);
    }
    
    public ObservableList<Email> getEmailList() {
        return emailList;
    }
    
    public void loadData(File file) {
        
        ObservableList<String> receiverList = FXCollections.observableArrayList();
        receiverList.add("laura.ventrice@gmail.com");
        receiverList.add("kim.viberti@gmail.com");
        
        ObservableList<String> receiverListDuplicate = FXCollections.observableArrayList();
        receiverListDuplicate.add("laura.ventrice@gmail.com");
        receiverListDuplicate.add("kim.viberti@gmail.com");
        receiverListDuplicate.add("enrico.pileggi@gmail.com");
        
        emailList.setAll(
                new Email((long) 0, "livio.scarpinati@gmail.com", receiverList,
                        "Esercizi LPP", "Buongiorno, ecco a voi gli esercizi di LPP. \n Saluti. \n Livio",
                        new GregorianCalendar(2020, Calendar.SEPTEMBER, 22)),
                new Email((long) 1, "livio.scarpinati@gmail.com", receiverListDuplicate,
                        "Esercizi Prog III", "Buongiorno, ecco a voi gli esercizi di Prog III. \n Saluti. " +
                        "\n Livio", new GregorianCalendar(2020, Calendar.OCTOBER, 18)),
                new Email((long) 0, "laura.ventrice@gmail.com", receiverList,
                        "Esercizi TWEB", "Buongiorno, ecco a voi gli esercizi di TWEB. \n Saluti. " +
                        "\n Laura", new GregorianCalendar(2020, Calendar.NOVEMBER, 1)),
                new Email((long) 1, "laura.ventrice@gmail.com", receiverListDuplicate,
                        "Esercizi EGI", "Buongiorno, ecco a voi gli esercizi di EGI. \n Saluti. \n Laura",
                        new GregorianCalendar(2020, Calendar.OCTOBER, 11)),
                new Email((long) 0, "enrico.pileggi@gmail.com", receiverList,
                        "Esercizi SO", "Buongiorno, ecco a voi gli esercizi di SO. \n Saluti. \n Enrico",
                        new GregorianCalendar(2019, Calendar.JANUARY, 14)),
                new Email((long) 1, "kim.viberti@gmail.com", receiverListDuplicate,
                        "Esercizi Android", "Buongiorno, ecco a voi gli esercizi di Android. \n Saluti." +
                        " \n Kim", new GregorianCalendar(2020, Calendar.DECEMBER, 18)),
                new Email((long) 1, "kim.viberti@gmail.com", receiverListDuplicate,
                        "Esercizi Prog I", "Buongiorno, ecco a voi gli esercizi di Prog I. \n Saluti." +
                        " \n Kim", new GregorianCalendar(2018, Calendar.DECEMBER, 05)));
        
        emailList.sort((o1, o2) -> -o1.getDate().compareTo(o2.getDate())); //orders emailList from most recent to less recent
        
    }
    
    public void deleteEmail(Email emailToDelete) {
        emailList.remove(emailToDelete);
        
        //TODO: la mail deve essere rimoosa anche dal serber in odo tale che all'avvio successivo del client essa
        // non venga mostrata nuovamente
    }
    
    //TODO: decidere se mantenere la possibilità di salvare il tutto
    public void saveData(File file) {
    }
    
}
