package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
    
    private String theme1Url = getClass().getResource("lightTheme.css").toExternalForm();
    
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        BorderPane root = new BorderPane();
        FXMLLoader listLoader = new FXMLLoader(getClass().getResource("list.fxml"));
        root.setLeft(listLoader.load());  //mette al sinistra la vista
        ListController listController = listLoader.getController();
    
        FXMLLoader editorLoader = new FXMLLoader(getClass().getResource("editor.fxml"));
        root.setCenter(editorLoader.load()); //mette al centro la vista
        EditorController editorController = editorLoader.getController();
    
        FXMLLoader menuLoader = new FXMLLoader(getClass().getResource("menuNew.fxml"));
        root.setTop(menuLoader.load()); //mette in alto la vista
        MenuController menuController = menuLoader.getController();
        
        EmailDataModel model = new EmailDataModel();
        listController.initModel(model);
        editorController.initModel(model);
        menuController.initModel(model);
        
        Scene scene = new Scene(root, 1000, 600);
    
        System.out.println("scene stylesheets: " + scene.getStylesheets());
       // scene.getStylesheets().add(theme1Url);
        System.out.println("scene stylesheets: " + scene.getStylesheets());
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
