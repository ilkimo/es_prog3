package sample;

import javafx.fxml.FXML;
import javafx.scene.control.MenuBar;
import javafx.stage.FileChooser;

import java.io.File;

public class MenuController {
    private EmailDataModel model ;
    
    /*
    @FXML
    private MenuBar menuBarButtons ;
    */
    
    public void initModel(EmailDataModel model) {
        if (this.model != null) {
            throw new IllegalStateException("Model can only be initialized once");
        }
        this.model = model ;
    }
    
    
    @FXML
    public void load() {
        /*FileChooser chooser = new FileChooser();
        File file = chooser.showOpenDialog(menuBarButtons.getScene().getWindow());
        if (file != null) {
            try {
                model.loadData(file);
            } catch (Exception exc) {
                // handle exception...
            }
        }*/
    }
    
    /*
    @FXML
    public void save() {
        
        // similar to load...
        
    }
    
    @FXML
    public void exit() {
        menuBarButtons.getScene().getWindow().hide();
    }*/
}
