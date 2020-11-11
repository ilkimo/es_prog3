package sample;

import javafx.beans.property.ObjectProperty;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class MenuController {
    private EmailDataModel model;
    
    private final String lightTheme = getClass().getResource("lightTheme.css").toExternalForm();
    private final String darkTheme = getClass().getResource("darkTheme.css").toExternalForm();
    
    private String theme = getClass().getResource("lightTheme.css").toExternalForm();   //current theme choosen
    
    @FXML
    private Button newMailButton;
    @FXML
    private MenuItem setDarkThemeButton;
    @FXML
    private MenuItem setLightThemeButton;
    
    public void initModel(EmailDataModel model) {
        if(this.model != null) {
            throw new IllegalStateException("Model can only be initialized once");
        }
        this.model = model;
    }
    
    @FXML
    private void handleNewMailButton(ActionEvent event) throws IOException {
        //TODO: Handle Click Here
        System.out.println("New Mail Button Clicked");
        
        BorderPane root = new BorderPane();
        
        Scene thisScene = newMailButton.getScene();
        System.out.println("scene stylesheets on button 2 click: " + thisScene.getStylesheets());
    
        //TODO: load new mail GUI
        FXMLLoader newMailLoader = new FXMLLoader(getClass().getResource("newMail.fxml"));
        root.setCenter(newMailLoader.load());
        NewEmailController newEmailController = newMailLoader.getController();
        newEmailController.initModel(model, "", "", "");
        
        theme = thisScene.getStylesheets().get(0);
        
        Stage newMailStage = new Stage();
        Scene scene = new Scene(root, 900, 550);
        scene.getStylesheets().add(theme);
        newMailStage.setScene(scene);
        newMailStage.show();
    }
    
    @FXML
    private void handleRefreshMailboxButton(ActionEvent event) {
        //TODO: Handle Click Here
        System.out.println("Refresh MailBox Button Clicked");
    }
    
    @FXML
    private void handleReplyButton(ActionEvent event) throws IOException {
        //TODO: Handle Click Here
        System.out.println("Reply Button Clicked");
    
        BorderPane root = new BorderPane();
    
        Scene thisScene = newMailButton.getScene();
        System.out.println("scene stylesheets on button 2 click: " + thisScene.getStylesheets());
    
        ObjectProperty<Email> email = model.currentEmailProperty();
    
        String subject = "";
        String sender = "";
        
        System.out.println(email.toString());
    
        //TODO: gestire il caso in cui non seleziono nessuna mail -> va bene gestito così?
        if(email.getValue()!=null) {
            sender = email.get().getSenderAddress();
            subject = email.get().getObject();
    
            //TODO: load new mail GUI
            FXMLLoader newMailLoader = new FXMLLoader(getClass().getResource("newMail.fxml"));
            root.setCenter(newMailLoader.load());
            NewEmailController newEmailController = newMailLoader.getController();
            newEmailController.initModel(model, sender, "Re: " + subject, "");
    
            theme = thisScene.getStylesheets().get(0);
    
            Stage newMailStage = new Stage();
            Scene scene = new Scene(root, 900, 550);
            scene.getStylesheets().add(theme);
            newMailStage.setScene(scene);
            newMailStage.show();
        }else{
            //TODO: dire all'utente di selezionare una mail
        }
    }
    
    @FXML
    private void handleReplyAllButton(ActionEvent event) throws IOException {
        //TODO: Handle Click Here
        System.out.println("Reply All Button Clicked");
    
        BorderPane root = new BorderPane();
    
        Scene thisScene = newMailButton.getScene();
        System.out.println("scene stylesheets on button 2 click: " + thisScene.getStylesheets());
    
        ObjectProperty<Email> email = model.currentEmailProperty();
    
        String subject = "";
        String newReceivers = "";
    
        //TODO: gestire il caso in cui non seleziono nessuna mail -> va bene gestito così?
        if(email.getValue()!=null) {
            subject = email.get().getObject();
    
            ObservableList<String> receivers = email.get().getReceiverAddress();
            newReceivers += email.get().getSenderAddress();
    
            //TODO: capire come rappresentare i singoli destinatari -> Stringa unica con , come sepparatore? ArrayList?
            for(String r : receivers) {
                if(!newReceivers.contains(r))
                    newReceivers += ", " + r;
            }
    
            //TODO: load new mail GUI
            FXMLLoader newMailLoader = new FXMLLoader(getClass().getResource("newMail.fxml"));
            root.setCenter(newMailLoader.load());
            NewEmailController newEmailController = newMailLoader.getController();
            newEmailController.initModel(model, newReceivers, "Re: " + subject, "");
    
            theme = thisScene.getStylesheets().get(0);
    
            Stage newMailStage = new Stage();
            Scene scene = new Scene(root, 900, 550);
            scene.getStylesheets().add(theme);
            newMailStage.setScene(scene);
            newMailStage.show();
        }else{
            //TODO: dire all'utente di selezionare una mail
        }
    }
    
    @FXML
    private void handleForwardButton(ActionEvent event) throws IOException {
        //TODO: Handle Click Here
        System.out.println("Forward Button Clicked");
    
        BorderPane root = new BorderPane();
    
        Scene thisScene = newMailButton.getScene();
        System.out.println("scene stylesheets on button 2 click: " + thisScene.getStylesheets());
    
        ObjectProperty<Email> email = model.currentEmailProperty();
    
        String subject = "";
        String body = "";
    
        if(email.getValue()!=null) {
            subject = email.get().getObject();
            body = email.get().getBody();
            //TODO: load new mail GUI
            FXMLLoader newMailLoader = new FXMLLoader(getClass().getResource("newMail.fxml"));
            root.setCenter(newMailLoader.load());
            NewEmailController newEmailController = newMailLoader.getController();
            newEmailController.initModel(model, "", "Fwd: " + subject, body);
    
            theme = thisScene.getStylesheets().get(0);
    
            Stage newMailStage = new Stage();
            Scene scene = new Scene(root, 900, 550);
            scene.getStylesheets().add(theme);
            newMailStage.setScene(scene);
            newMailStage.show();
        }else{
            //TODO: dire all'utente di selezionare una mail
        }
    }
    
    @FXML
    private void handleDeleteButton(ActionEvent event) {
        //TODO: Handle Click Here
        System.out.println("Delete Button Clicked");
        
        ObjectProperty<Email> email = model.currentEmailProperty();
    
        //TODO: gestire il caso in cui non seleziono nessuna mail -> va bene gestito così?
        if(email.getValue()!=null) {
            model.deleteEmail(model.getCurrentEmail());
        } else{
            //TODO: dire all'utente di selezionare una mail
        }
    }
    
    //TODO: non dovrebbe servire un metodo per caricare un file -> in caso rimuoverlo
    @FXML
    public void load() {
        FileChooser chooser = new FileChooser();
        File file = chooser.showOpenDialog(newMailButton.getScene().getWindow());
        if(file != null) {
            try {
                model.loadData(file);
            } catch (Exception exc) {
                // handle exception...
            }
        }
    }
    
    @FXML
    public void setDarkTheme() {
        Scene scene = newMailButton.getScene();
        scene.getStylesheets().remove(theme);
        System.out.println("scene stylesheets on button 2 click: " + scene.getStylesheets());
        if(!scene.getStylesheets().contains(darkTheme)) scene.getStylesheets().add(darkTheme);
        System.out.println("scene stylesheets on button 2 click: " + scene.getStylesheets());
        
        setDarkThemeButton.setVisible(false);
        setLightThemeButton.setVisible(true);
    }
    
    @FXML
    public void setLightTheme() {
        Scene scene = newMailButton.getScene();
        scene.getStylesheets().remove(darkTheme);
        System.out.println("scene stylesheets on button 2 click: " + scene.getStylesheets());
        if(!scene.getStylesheets().contains(lightTheme)) scene.getStylesheets().add(lightTheme);
        System.out.println("scene stylesheets on button 2 click: " + scene.getStylesheets());
        
        setLightThemeButton.setVisible(false);
        setDarkThemeButton.setVisible(true);
    }
    
    @FXML
    public void exit() {
        newMailButton.getScene().getWindow().hide();
    }
}
