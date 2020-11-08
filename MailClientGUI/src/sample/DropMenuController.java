package sample;

import java.io.File;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.stage.FileChooser;

/**
 *
 * @author liliana
 */
public class DropMenuController {
    
    private EmailDataModel model ;
    
    private String lightTheme = getClass().getResource("lightTheme.css").toExternalForm();
    private String darkTheme = getClass().getResource("darkTheme.css").toExternalForm();
    
    @FXML
    private MenuBar menuBar ;
    
    public void initModel(EmailDataModel model) {
        if (this.model != null) {
            throw new IllegalStateException("Model can only be initialized once");
        }
        this.model = model ;
    }
    
    @FXML
    public void load() {
        /*
        FileChooser chooser = new FileChooser();
        File file = chooser.showOpenDialog(menuBar.getScene().getWindow());
        if (file != null) {
            try {
                model.loadData(file);
            } catch (Exception exc) {
                // handle exception...
            }
        }*/
        Scene scene = menuBar.getScene();
        scene.getStylesheets().remove(lightTheme);
        System.out.println("scene stylesheets on button 2 click: " + scene.getStylesheets());
        if(!scene.getStylesheets().contains(darkTheme)) scene.getStylesheets().add(darkTheme);
        System.out.println("scene stylesheets on button 2 click: " + scene.getStylesheets());
        // similar to load...
    }
    
    @FXML
    public void save() {
        
        // similar to load...
        
    }
    
    @FXML
    public void exit() {
        menuBar.getScene().getWindow().hide();
    }
}
