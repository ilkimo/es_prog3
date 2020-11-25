import javafx.beans.property.*;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.GregorianCalendar;

public class Email implements Serializable {
    private LongProperty id = new SimpleLongProperty();
    private StringProperty senderAddress = new SimpleStringProperty();
    private final ListProperty<String> receiverAddress = new SimpleListProperty<>();
    private StringProperty receiverAddressString = new SimpleStringProperty();
    private StringProperty subject  = new SimpleStringProperty();
    private StringProperty body  = new SimpleStringProperty();
    private ObjectProperty<GregorianCalendar> date = new SimpleObjectProperty<>();
    
    public Email(Long id, String senderAddress, ObservableList<String> receiverAddress, String subject, String body,
                 GregorianCalendar date) {
        setId(id);
        setSenderAddress(senderAddress);
        setReceiverAddress(receiverAddress);
        setSubject(subject);
        setBody(body);
        setDate(date);
    }
    
    public StringProperty bodyProperty() { return body; }
    
    public ObjectProperty<GregorianCalendar> dateProperty() { return date;}
    
    public String getBody() { return body.get(); }
    
    public GregorianCalendar getDate() { return date.get(); }
    
    public long getId() {
        return id.get();
    }
    
    public ObservableList<String> getReceiverAddress() {
        return receiverAddress.get();
    }
    
    public String getSenderAddress() {
        return senderAddress.get();
    }
    
    public String getSubject() { return subject.get(); }
    
    public LongProperty idProperty() {
        return id;
    }
    
    public ListProperty<String> receiverAddressProperty() { return receiverAddress; }
    
    public StringProperty receiverAddressPropertyString() { return receiverAddressString; }
    
    /**
     * @return StringProperty used for field "receivers" in ReplyAll new Email
     */
    
    //TODO: MODIFY ME WHEN WE HAVE LOGIN!
    public StringProperty receiverAddressPropertyReplyAll() {
        return new SimpleStringProperty(getSenderAddress() + " " + toStringReceiverAddress());
    }
    
    public StringProperty senderAddressProperty() {
        return senderAddress;
    }
    
    public void setBody(String body) { this.body.set(body); }
    
    public void setDate(GregorianCalendar date) { this.date.set(date); }
    
    public void setId(long id) {
        this.id.set(id);
    }
    
    public void setSenderAddress(String senderAddress) { this.senderAddress.set(senderAddress); }
    
    public void setSubject(String subject) { this.subject.set(subject); }
    
    public void setReceiverAddress(ObservableList<String> receiverAddress) {
        this.receiverAddress.set(receiverAddress);
        setReceiverAddressString();
    }
    
    private void setReceiverAddressString() { receiverAddressString.setValue(toStringReceiverAddress()); }
    
    /**
     * @return StringProperty used for field "subject" in Forward new Email
     */
    public StringProperty subjectForward() { return new SimpleStringProperty("Fwd: " + getSubject()); }
    
    public StringProperty subjectProperty() { return subject; }
    
    /**
     * @return StringProperty used for field "subject" in Reply/ReplyAll new Email
     */
    
    public StringProperty subjectReply() { return new SimpleStringProperty("Re: " + getSubject()); }
    
    public String toStringReceiverAddress() {
        String receiver = "";
        for (String address : receiverAddress) {
            receiver = receiver.concat(address).concat(" ");
        }
        return receiver;
    }
    
    @Override
    public String toString() {
        return "Email{" +
                "id=" + id.getValue() +
                ", subject=" + subject.getValue() +
                ", body=" + body.getValue() +
                '}';
    }
    
    private void writeObject(ObjectOutputStream s) throws IOException {
        //s.defaultWriteObject();   // always call this first -> dà errore
    
        s.writeLong(getId());
        s.writeObject(getSenderAddress());
        s.writeObject(receiverAddressString.getValue());
        s.writeObject(getSubject());
        s.writeObject(getBody());
        s.writeObject(getDate());
    }
    
    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        //s.defaultReadObject();    // always call this first -> dà errore
    
        id = new SimpleLongProperty(s.readLong());
        senderAddress = new SimpleStringProperty((String)s.readObject());
        receiverAddressString = new SimpleStringProperty((String)s.readObject());
        subject = new SimpleStringProperty((String)s.readObject());
        body = new SimpleStringProperty((String)s.readObject());
        date = new SimpleObjectProperty<>((GregorianCalendar)s.readObject());

    }
}
