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
        
        
        TableroControl t = new TableroControl();
        
        
        
        root.getChildren().addAll(t);
        
        Scene scene = new Scene(root, 1600, 800);
        
        stage.setTitle("AlgoPoly");
        stage.setScene(scene);
        stage.show();
    }

}
