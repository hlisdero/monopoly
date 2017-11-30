package fiuba.algo3.tp2.vista;



import java.util.ArrayList;

import fiuba.algo3.tp2.vista.eventos.*;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class TableroControl extends Parent{
	
	TerrenoVista terreno = new TerrenoVista();
	
	BarraDeMenu barra = new BarraDeMenu();
	
	Button tirarDados= new Button("Tirar dados");
	Button finalizarTurno= new Button("Finalizar turno");
	Button comprarPropiedad = new Button("Comprar propiedad");
	Button venderPropiedad = new Button("Vender propiedad");
	Button construirCasa = new Button("Construir casa");
	Button construirHotel = new Button("Construir hotel");
	Button pagarFianza = new Button("Pagar fianza");
	Button datosJugador = new Button("Datos jugador");
	
	ArrayList<Button> listBotones = new ArrayList<Button>();
	
	private TurnoJugador turnoJugador = new TurnoJugador();
	
	Label titulo = new Label("Entrar el numero de casilla");
	TextField text = new TextField();
	

	public TableroControl(){

		this.setLayoutComponents();

		
		listBotones.add(tirarDados);
		listBotones.add(comprarPropiedad);
		listBotones.add(venderPropiedad);
		listBotones.add(finalizarTurno);
		listBotones.add(construirCasa);
		listBotones.add(construirHotel);
		listBotones.add(pagarFianza);
		listBotones.add(datosJugador);
	
       	
       	
       	BotonComprarHandler comprarHandler = new BotonComprarHandler(turnoJugador, terreno, comprarPropiedad);
       	comprarPropiedad.setOnAction(comprarHandler);
       	
      
 		BotonVenderHandler venderHandler = new BotonVenderHandler(turnoJugador, terreno, venderPropiedad, text);
		venderPropiedad.setOnAction(venderHandler);
	

		BotonConstruirCasaHandler casaHandler = new BotonConstruirCasaHandler(turnoJugador, terreno);
		construirCasa.setOnAction(casaHandler);
    	
		BotonConstruirHotelHandler hotelHandler = new BotonConstruirHotelHandler(turnoJugador, terreno);
		construirHotel.setOnAction(hotelHandler);
    	
		BotonPagarFianzaHandler fianzaHandler = new BotonPagarFianzaHandler(turnoJugador);
		pagarFianza.setOnAction(fianzaHandler);
		
		BotonDatosJugadorHandler datosHandler = new BotonDatosJugadorHandler(turnoJugador);
		datosJugador.setOnAction(datosHandler);
		
       	BotonFinalizarTurnoHandler finalizarHandler = new BotonFinalizarTurnoHandler(turnoJugador, turnoJugador.getJugadorGenerico(), listBotones );
       	finalizarTurno.setOnAction(finalizarHandler);
       	
       	BotonTirarDadosHandler tirarDadosHandler = new BotonTirarDadosHandler(turnoJugador, terreno, tirarDados, comprarPropiedad);
       	tirarDados.setOnAction(tirarDadosHandler);
       	
       	
       	
       	this.getChildren().addAll(listBotones);
       	this.getChildren().add(terreno);
		this.getChildren().add(turnoJugador);
		this.getChildren().add(barra);
		this.getChildren().add(titulo);
		this.getChildren().add(text);
	}
	

	public void setLayoutComponents()
	{
		tirarDados.setLayoutX(500);
		tirarDados.setLayoutY(850);
		tirarDados.setStyle("-fx-padding: 50;");

		finalizarTurno.setLayoutX(700);
		finalizarTurno.setLayoutY(850);
		finalizarTurno.setStyle("-fx-padding: 50;");

		comprarPropiedad.setLayoutX(950);
		comprarPropiedad.setLayoutY(850);
		comprarPropiedad.setStyle("-fx-padding: 20;");
		
		venderPropiedad.setLayoutX(1150);
		venderPropiedad.setLayoutY(850);
		venderPropiedad.setStyle("-fx-padding: 20;");
		
		construirCasa.setLayoutX(970);
		construirCasa.setLayoutY(920);
		construirCasa.setStyle("-fx-padding: 15;");
		
		construirHotel.setLayoutX(1170);
		construirHotel.setLayoutY(920);
		construirHotel.setStyle("-fx-padding: 15;");
		
		pagarFianza.setLayoutX(390);
		pagarFianza.setLayoutY(740);
		pagarFianza.setStyle("-fx-padding: 15;");
		
		datosJugador.setLayoutX(350);
		datosJugador.setLayoutY(500);
		datosJugador.setStyle("-fx-padding: 15;");
		
		
		barra.setTranslateX(430);
		barra.setTranslateY(350);
		
		titulo.setLayoutX(1140);
		titulo.setLayoutY(805);
		
		text.setLayoutX(1140);
		text.setLayoutY(820);
	}
	
	

}
