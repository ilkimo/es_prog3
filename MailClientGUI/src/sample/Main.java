package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        BorderPane root = new BorderPane();
        FXMLLoader listLoader = new FXMLLoader(getClass().getResource("list.fxml"));
        root.setLeft(listLoader.load());  //mette al sinistra la vista
        ListController listController = listLoader.getController();
    
        FXMLLoader editorLoader = new FXMLLoader(getClass().getResource("editor.fxml"));
        root.setCenter(editorLoader.load()); //mette al centro la vista
        EditorController editorController = editorLoader.getController();
    
        FXMLLoader menuLoader = new FXMLLoader(getClass().getResource("menuButtons.fxml"));
        root.setTop(menuLoader.load()); //mette in alto la vista
        MenuController menuController = menuLoader.getController();
        
        EmailDataModel model = new EmailDataModel();
        listController.initModel(model);
        editorController.initModel(model);
        menuController.initModel(model);
        
        Scene scene = new Scene(root, 1000, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
