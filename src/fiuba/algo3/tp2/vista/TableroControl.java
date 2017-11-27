package fiuba.algo3.tp2.vista;



import java.util.ArrayList;

import fiuba.algo3.tp2.vista.eventos.*;

import javafx.scene.Parent;
import javafx.scene.control.Button;

public class TableroControl extends Parent{
	
	TerrenoVista terreno = new TerrenoVista();
	DatosJugador datos = new DatosJugador();
	Button tirarDados= new Button("Tirar dados");
	Button finalizarTurno= new Button("Finalizar turno");
	Button comprarPropiedad = new Button("Comprar propiedad");
	Button venderPropiedad = new Button("Vender propiedad");
	Button construirCasa = new Button("Construir casa");
	
	ArrayList<Button> listBotones = new ArrayList<Button>();
	
	private TurnoJugador turnoJugador = new TurnoJugador();


	public TableroControl(){

		this.setLayoutComponents();

		listBotones.add(tirarDados);
		listBotones.add(comprarPropiedad);
		listBotones.add(venderPropiedad);
		listBotones.add(finalizarTurno);
		listBotones.add(construirCasa);
		
		BotonTirarDadosHandler tirarDadosHandler = new BotonTirarDadosHandler(turnoJugador, terreno, tirarDados);
       	tirarDados.setOnAction(tirarDadosHandler);
       	
       	BotonComprarHandler comprarHandler = new BotonComprarHandler(turnoJugador, terreno, comprarPropiedad);
    	comprarPropiedad.setOnAction(comprarHandler);
    	
    	BotonVenderHandler venderHandler = new BotonVenderHandler(turnoJugador, terreno, venderPropiedad);
    	venderPropiedad.setOnAction(venderHandler);

    	BotonConstruirCasaHandler casaHandler = new BotonConstruirCasaHandler(turnoJugador, terreno);
    	construirCasa.setOnAction(casaHandler);
    	
       	BotonFinalizarTurnoHandler finalizarHandler = new BotonFinalizarTurnoHandler(turnoJugador, turnoJugador.getJugadorGenerico(), listBotones );
       	finalizarTurno.setOnAction(finalizarHandler);
       	
       	
       	
       	this.getChildren().addAll(listBotones);
       	this.getChildren().add(datos);
       	this.getChildren().add(terreno);
		this.getChildren().add(turnoJugador);
	}
	

	public void setLayoutComponents()
	{
		tirarDados.setLayoutX(570);
		tirarDados.setLayoutY(850);

		finalizarTurno.setLayoutX(670);
		finalizarTurno.setLayoutY(850);

		comprarPropiedad.setLayoutX(900);
		comprarPropiedad.setLayoutY(850);
		
		venderPropiedad.setLayoutX(1100);
		venderPropiedad.setLayoutY(850);
		
		construirCasa.setLayoutX(1110);
		construirCasa.setLayoutY(900);
	}

}
