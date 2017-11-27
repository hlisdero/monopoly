package fiuba.algo3.tp2.vista;



import fiuba.algo3.tp2.vista.eventos.BotonComprarHandler;
import fiuba.algo3.tp2.vista.eventos.BotonFinalizarTurnoHandler;
import fiuba.algo3.tp2.vista.eventos.BotonTirarDadosHandler;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


public class TableroControl extends Parent{
	
	TerrenoVista terreno = new TerrenoVista();
	
	Button tirarDados= new Button("Tirar dados");
	Button finalizarTurno= new Button("Finalizar turno");
	Button comprarPropiedad = new Button("Comprar propiedad");
	
	private TurnoJugador turnoJugador = new TurnoJugador();
	
	private int sizeListaJugador = turnoJugador.getListaJugadores().size();
	
	private TableView<String> table = new TableView<String>();
	
	public TableroControl(){

		this.setLayoutComponents();

		TableColumn<String, String> colJugador1 = new TableColumn<String, String>("Jugador 1");
		//firstNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
		colJugador1.setMinWidth(100);
		TableColumn<String, String> colJugador2 = new TableColumn<String, String>("Jugador 2");
	//	lastNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
		colJugador2.setMinWidth(100);
		TableColumn<String, String> colJugador3 = new TableColumn<String, String>("Jugador 3");
	//	phoneCol.setCellValueFactory(new PropertyValueFactory<Person, String>("phone"));
		colJugador3.setMinWidth(100);

		//table.setItems(data);
		//table.getColumns().addAll(colJugador1, colJugador2, colJugador3);

		BotonTirarDadosHandler tirarDadosHandler = new BotonTirarDadosHandler(turnoJugador, terreno);
       	tirarDados.setOnAction(tirarDadosHandler);
	    //tirarDados.setDisable(true););
       	
       	BotonComprarHandler comprarHandler = new BotonComprarHandler(turnoJugador.getJugadorGenerico(), terreno);
    	comprarPropiedad.setOnAction(comprarHandler);
    	//comprarPropiedad.setDisable(true);	

       	BotonFinalizarTurnoHandler finalizarHandler = new BotonFinalizarTurnoHandler(turnoJugador, turnoJugador.getJugadorGenerico(), sizeListaJugador);
       	finalizarTurno.setOnAction(finalizarHandler);
		//tirarDados.setDisable(false);
		//comprarPropiedad.setDisable(false);
       	
       	this.getChildren().addAll(tirarDados,finalizarTurno,comprarPropiedad);
       	this.getChildren().add(table);
       	this.getChildren().add(terreno);
		this.getChildren().add(turnoJugador);
	}
	
	
	public void setLayoutComponents()
	{
		table.setLayoutX(180);
		table.setLayoutY(400);
		
		tirarDados.setLayoutX(570);
		tirarDados.setLayoutY(850);

		finalizarTurno.setLayoutX(670);
		finalizarTurno.setLayoutY(850);

		comprarPropiedad.setLayoutX(900);
		comprarPropiedad.setLayoutY(850);
	}

}
