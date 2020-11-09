package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class NewEmailController {
    
    private EmailDataModel model;
    
    @FXML
    private TextField receivers;
    @FXML
    private TextField subjectEmail;
    @FXML
    private TextArea bodyEmail;
    
    public void initModel(EmailDataModel model) {
        if(this.model != null) {
            throw new IllegalStateException("Model can only be initialized once");
        }
        this.model = model;
    }
    
    @FXML
    private void handleSendButton(ActionEvent event) {
        //TODO: Handle Click Here
        System.out.println("Send Button Clicked");
        System.out.println("receivers: " + receivers.getText());
        System.out.println("subjectEmail: " + subjectEmail.getText());
        System.out.println("bodyEmail: " + bodyEmail.getText());
        
        //TODO: gestire l'inserimento di più destinatari e controllare che i dati iinseriti siano delle email
    }
    
    
}
