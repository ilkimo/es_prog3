package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class EditorController {
    @FXML
    private Label emailObjectLabel;
    @FXML
    private TextField emailBodyField ;
    
    private EmailDataModel model ;
    
    public void initModel(EmailDataModel model) {
        if (this.model != null) {
            throw new IllegalStateException("Model can only be initialized once");
        }
        this.model = model ;
        model.loadData(null);//  aggiunto per far caricare i dati delle person
        model.currentEmailProperty().addListener((obs, oldEmail, newEmail) -> {
            if (oldEmail != null) {
                emailObjectLabel.textProperty().unbindBidirectional(oldEmail.objectProperty());
                emailBodyField.textProperty().unbindBidirectional(oldEmail.bodyProperty());
            }
            if (newEmail == null) {
                emailBodyField.setText("");
                emailBodyField.setText("");
            } else {
                emailObjectLabel.textProperty().bindBidirectional(newEmail.objectProperty());
                emailBodyField.textProperty().bindBidirectional(newEmail.bodyProperty());
            }
        });
    }
}
