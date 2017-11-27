package fiuba.algo3.tp2.vista;



import fiuba.algo3.tp2.vista.eventos.BotonComprarHandler;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.StageStyle;





public class TableroDeControl extends Parent{
	
	
	TerrenoVista terreno = new TerrenoVista();
	
	Button tirarDados= new Button("Tirar dados");
	Button finalizarTurno= new Button("Finalizar turno");
	Button comprarPropiedad = new Button("Comprar propiedad");
	
	private int sumaDados;
	
	private TurnoJugador turnoJugador = new TurnoJugador();
	
	private JugadorVista jugadorGenerico;
	private int sizeListaJugador = turnoJugador.getListaJugadores().size();
	
	private TableView<String> table = new TableView<String>();
	
	public TableroDeControl(){
		
		
		jugadorGenerico= turnoJugador.getListaJugadores().get(0);
		
		table.setLayoutX(50);
		table.setLayoutY(400);

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
		table.getColumns().addAll(colJugador1, colJugador2, colJugador3);
		
		this.getChildren().add(table);

		tirarDados.setLayoutX(370);
		tirarDados.setLayoutY(400);
		this.getChildren().add(tirarDados);
		
		finalizarTurno.setLayoutX(370);
		finalizarTurno.setLayoutY(450);
		this.getChildren().add(finalizarTurno);

		
		comprarPropiedad.setLayoutX(350);
		comprarPropiedad.setLayoutY(500);
		this.getChildren().add(comprarPropiedad);
		
		
       	tirarDados.setOnMouseClicked(e ->{
	      
	          	int numeroDeCasilla = jugadorGenerico.getNumeroCasilla();
	          	
	          	sumaDados = terreno.getAlgo().getGestorTurnos().proximoJugador().tirarDados().getSuma();
	          	System.out.println(sumaDados);
	          	numeroDeCasilla += sumaDados;
	          	Alert dialogoAlerta = new Alert(AlertType.INFORMATION);
	          	dialogoAlerta.setTitle("Resultado dados");
	          	dialogoAlerta.setContentText("DADOS:" + sumaDados);
	          	dialogoAlerta.initStyle(StageStyle.UTILITY);
	          	dialogoAlerta.showAndWait();
	          	
	          	if(numeroDeCasilla > terreno.getList().size()){numeroDeCasilla -= terreno.getList().size() + 1;}
	          	
	          	jugadorGenerico.setNumeroCasilla(numeroDeCasilla);

	          	
	          	terreno.getAlgo().getGestorMovimiento().mover(jugadorGenerico.getValorJugador());
	          	

	          	jugadorGenerico.setTranslateX(terreno.getList().get(numeroDeCasilla).getPosX() + jugadorGenerico.posReferencia());

	          	jugadorGenerico.setTranslateY(terreno.getList().get(numeroDeCasilla).getPosY());
	           	
	          	terreno.getAlgo().getGestorMovimiento().mover(jugadorGenerico.getValorJugador(), terreno.getList().get(jugadorGenerico.getNumeroCasilla()).getValorCasilla());
	          	
	          	tirarDados.setDisable(true);
	            });
       	
       	
       	BotonComprarHandler comprarHandler = new BotonComprarHandler(jugadorGenerico, terreno);
    	comprarPropiedad.setOnAction(comprarHandler);
    	//comprarPropiedad.setDisable(true);
    		

       	
       	finalizarTurno.setOnMouseClicked(e-> {sizeListaJugador += 1;
       			jugadorGenerico = turnoJugador.getListaJugadores().get(sizeListaJugador %3);
       			tirarDados.setDisable(false);
       			comprarPropiedad.setDisable(false);
       			
       	
       	});
       	
       	this.getChildren().add(terreno);
		this.getChildren().add(turnoJugador);
	}

}
