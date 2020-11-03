package sample;

import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;

public class ListController {
    @FXML
    private ListView<Email> listView;
    
    private EmailDataModel model;
    
    public void initModel(EmailDataModel model) {
        // ensure model is only set once:
        if(this.model != null) {
            throw new IllegalStateException("Model can only be initialized once");
        }
        
        this.model = model;
        listView.setItems(model.getEmailList());
        
        listView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) ->
                model.setCurrentPerson(newSelection));
        
        model.currentEmailProperty().addListener((obs, oldEmail, newEmail) -> {
            if(newEmail == null) {
                listView.getSelectionModel().clearSelection();
            } else {
                listView.getSelectionModel().select(newEmail);
            }
        });
        
        listView.setCellFactory(lv -> new ListCell<Email>() {
            @Override
            public void updateItem(Email email, boolean empty) {
                super.updateItem(email, empty);
                if(empty) {
                    setText(null);
                } else {
                    setText(email.getObject() + " - " + email.getBody());
                }
            }
        });
    }
}
