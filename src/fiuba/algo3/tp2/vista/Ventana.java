package fiuba.algo3.tp2.vista;

import javafx.application.Application;

import javafx.scene.Scene;
import javafx.scene.layout.StackPane;

import javafx.stage.Stage;

public class Ventana extends Application {
	 
    public static void main(String[] args) {
        Application.launch(Ventana.class, args);
    }
    
    public void start(Stage stage) {
  
        StackPane root = new StackPane();
        
        TableroDeJuego t = new TableroDeJuego();
        
        root.getChildren().addAll(t);
        
        Scene scene = new Scene(root, 1200, 600);
        scene.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
        stage.setTitle("AlgoPoly");
        stage.setScene(scene);
        stage.show();
    }

}
