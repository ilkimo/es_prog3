
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener.Change;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class SerializedEdgeDemo extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        Pane drawingPane = new Pane() ;
        
        ObservableList<Edge> edges = FXCollections.observableArrayList() ;
        edges.addListener((Change<? extends Edge> c) -> {
            while (c.next()) {
                if (c.wasAdded()) {
                    c.getAddedSubList().stream()
                            .map(Edge::getView)
                            .forEach(drawingPane.getChildren()::add);
                }
                if (c.wasRemoved()) {
                    c.getRemoved().stream()
                            .map(Edge::getView)
                            .forEach(drawingPane.getChildren()::remove);
                }
            }
        });
        
        FileChooser chooser = new FileChooser();
        chooser.getExtensionFilters().add(new ExtensionFilter("Edge files", "*.edges"));
        
        Button load = new Button("Load");
        load.setOnAction(e -> {
            File file = chooser.showOpenDialog(primaryStage);
            if (file != null) {
                try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
                    List<Edge> loadedEdges = (List<Edge>) in.readObject() ;
                    edges.setAll(loadedEdges);
                } catch (Exception exc) {
                    exc.printStackTrace();
                }
            }
        });
        
        Button save = new Button("Save") ;
        save.setOnAction(e -> {
            File file = chooser.showSaveDialog(primaryStage);
            if (file != null) {
                try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
                    out.writeObject(new ArrayList<>(edges));
                } catch (Exception exc) {
                    exc.printStackTrace();
                }
            }
        });
        
        ColorPicker colorPicker = new ColorPicker(Color.BLACK) ;
        
        ObjectProperty<Edge> currentEdge = new SimpleObjectProperty<>();
        drawingPane.setOnDragDetected(e -> {
            currentEdge.set(new Edge(e.getX(), e.getY(), e.getX(), e.getY(), colorPicker.getValue()));
            edges.add(currentEdge.get());
        });
        drawingPane.setOnMouseReleased(e -> currentEdge.set(null));
        drawingPane.setOnMouseDragged(e -> {
            if (currentEdge.get() != null) {
                currentEdge.get().setX2(e.getX());
                currentEdge.get().setY2(e.getY());
            }
        });
        
        HBox controls = new HBox(5, colorPicker, load, save);
        controls.setAlignment(Pos.CENTER);
        controls.setPadding(new Insets(10));
        BorderPane root = new BorderPane(drawingPane, controls, null, null, null);
        Scene scene = new Scene(root, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public static class Edge implements Serializable {
        private transient DoubleProperty x1 = new SimpleDoubleProperty();
        private transient DoubleProperty y1 = new SimpleDoubleProperty();
        private transient DoubleProperty x2 = new SimpleDoubleProperty();
        private transient DoubleProperty y2 = new SimpleDoubleProperty();
        
        private transient Color color ;
        
        private transient Node view ;
        
        public Edge(double x1, double y1, double x2, double y2, Color color) {
            setX1(x1);
            setY1(y1);
            setX2(x2);
            setY2(y2);
            this.color = color ;
            
            createView();
        }
        
        private void createView() {
            Line line = new Line() ;
            line.setStroke(color);
            line.startXProperty().bind(x1);
            line.startYProperty().bind(y1);
            line.endXProperty().bind(x2);
            line.endYProperty().bind(y2);
            view = line ;
        }
        
        public Node getView() {
            return view ;
        }
        
        public final DoubleProperty x1Property() {
            return this.x1;
        }
        
        
        public final double getX1() {
            return this.x1Property().get();
        }
        
        
        public final void setX1(final double x1) {
            this.x1Property().set(x1);
        }
        
        
        public final DoubleProperty y1Property() {
            return this.y1;
        }
        
        
        public final double getY1() {
            return this.y1Property().get();
        }
        
        
        public final void setY1(final double y1) {
            this.y1Property().set(y1);
        }
        
        
        public final DoubleProperty x2Property() {
            return this.x2;
        }
        
        
        public final double getX2() {
            return this.x2Property().get();
        }
        
        
        public final void setX2(final double x2) {
            this.x2Property().set(x2);
        }
        
        
        public final DoubleProperty y2Property() {
            return this.y2;
        }
        
        
        public final double getY2() {
            return this.y2Property().get();
        }
        
        
        public final void setY2(final double y2) {
            this.y2Property().set(y2);
        }
        
        
        private void writeObject(ObjectOutputStream s) throws IOException {
            s.defaultWriteObject();
            s.writeDouble(getX1());
            s.writeDouble(getY1());
            s.writeDouble(getX2());
            s.writeDouble(getY2());
            s.writeDouble(color.getRed());
            s.writeDouble(color.getGreen());
            s.writeDouble(color.getBlue());
            s.writeDouble(color.getOpacity());
        }
        
        private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
            x1 = new SimpleDoubleProperty(s.readDouble());
            y1 = new SimpleDoubleProperty(s.readDouble());
            x2 = new SimpleDoubleProperty(s.readDouble());
            y2 = new SimpleDoubleProperty(s.readDouble());
            double red = s.readDouble() ;
            double green = s.readDouble() ;
            double blue = s.readDouble() ;
            double opacity = s.readDouble() ;
            color = Color.color(red, green, blue, opacity) ;
            createView();
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}