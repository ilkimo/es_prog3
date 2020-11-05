package sample;

import javafx.beans.property.*;
import javafx.collections.ObservableList;
import java.util.GregorianCalendar;

public class Email {
    private final LongProperty id = new SimpleLongProperty();
    private final StringProperty senderAddress = new SimpleStringProperty();
    private final ListProperty<String> receiverAddress = new SimpleListProperty<>();
    private final StringProperty object  = new SimpleStringProperty();
    private final StringProperty body  = new SimpleStringProperty();
    private final ObjectProperty<GregorianCalendar> date = new SimpleObjectProperty<>();
    
    public Email(Long id, String senderAddress, ObservableList<String> receiverAddress, String object, String body, GregorianCalendar date) {
        setId(id);
        setSenderAddress(senderAddress);
        setReceiverAddress(receiverAddress);
        setObject(object);
        setBody(body);
        setDate(date);
    }
    
    public long getId() {
        return id.get();
    }
    
    public LongProperty idProperty() {
        return id;
    }
    
    public void setId(long id) {
        this.id.set(id);
    }
    
    public String getSenderAddress() {
        return senderAddress.get();
    }
    
    public StringProperty senderAddressProperty() {
        return senderAddress;
    }
    
    public void setSenderAddress(String senderAddress) {
        this.senderAddress.set(senderAddress);
    }
    
    public ObservableList<String> getReceiverAddress() {
        return receiverAddress.get();
    }
    
    public ListProperty<String> receiverAddressProperty() {
        return receiverAddress;
    }
    
    public void setReceiverAddress(ObservableList<String> receiverAddress) {
        this.receiverAddress.set(receiverAddress);
    }
    
    public String getObject() {
        return object.get();
    }
    
    public StringProperty objectProperty() {
        return object;
    }
    
    public void setObject(String object) {
        this.object.set(object);
    }
    
    public String getBody() {
        return body.get();
    }
    
    public StringProperty bodyProperty() {
        return body;
    }
    
    public void setBody(String body) {
        this.body.set(body);
    }
    
    public GregorianCalendar getDate() {
        return date.get();
    }
    
    public ObjectProperty<GregorianCalendar> dateProperty() {
        return date;
    }
    
    public void setDate(GregorianCalendar date) {
        this.date.set(date);
    }
}
