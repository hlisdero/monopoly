package fiuba.algo3.tp2.vista;

import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class DatosJugador extends Parent{

	private TableView<String> table = new TableView<String>();
	
	public DatosJugador(){
		TableColumn colJugador1 = new TableColumn("Jugador 1");
		//firstNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
		colJugador1.setMinWidth(100);
		TableColumn colJugador2 = new TableColumn("Jugador 2");
	//	lastNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
		colJugador2.setMinWidth(100);
		TableColumn colJugador3 = new TableColumn("Jugador 3");
	//	phoneCol.setCellValueFactory(new PropertyValueFactory<Person, String>("phone"));
		colJugador3.setMinWidth(100);

		//table.setItems(data);
		table.getColumns().addAll(colJugador1, colJugador2, colJugador3);

		
		table.setLayoutX(180);
		table.setLayoutY(400);
		
		
		this.getChildren().add(table);
	}
}
