package fiuba.algo3.tp2.vista;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;

import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Ventana extends Application {
	 
    public static void main(String[] args) {
        Application.launch(Ventana.class, args);
    }
    
    public void start(Stage stage) {
        Circle circ = new Circle(40, 40, 30);
        Group root = new Group(circ);
        Scene scene = new Scene(root, 400, 300);

        stage.setTitle("My JavaFX Application");
        stage.setScene(scene);
        stage.show();
    }

}
