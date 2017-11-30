package fiuba.algo3.tp2.vista.eventos;

import fiuba.algo3.tp2.modelo.ConstruirCasaInvalidoException;
import fiuba.algo3.tp2.modelo.Provincia;
import fiuba.algo3.tp2.vista.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.StageStyle;

public class BotonConstruirCasaHandler implements EventHandler<ActionEvent>{

	private TurnoJugador jugador;
	private TerrenoVista terreno;
	
	public BotonConstruirCasaHandler(TurnoJugador jugador, TerrenoVista terreno)
	{
		this.jugador = jugador;
		this.terreno = terreno;
	}
	
	
	@Override
    public void handle(ActionEvent actionEvent) {
		JugadorVista jugadorVista = jugador.getJugadorGenerico();
		CasillaVista casillaVista = terreno.getCasillasVista().get(jugadorVista.getNumeroCasilla());
		
		 try {
			 	((Provincia)casillaVista.getValorCasilla()).construirCasa();
				terreno.crearCasaVista(casillaVista.getPosX(), casillaVista.getPosY(),jugadorVista, casillaVista);
				this.alertConstruirCasa(true);
				
		 	}catch (ConstruirCasaInvalidoException e) {
		 		this.alertConstruirCasa(false);
		}	catch(NullPointerException e) {
			this.alertConstruirCasa(false);
		}	
		 	catch(ClassCastException e)	{
		 		this.alertConstruirCasa(false);
		}
	}
	
	public void alertConstruirCasa(boolean valido){
		Alert dialogoAlerta = new Alert(null);
		dialogoAlerta.setTitle("Construir casa");
		
		if(valido){
			dialogoAlerta.setAlertType(AlertType.CONFIRMATION);
			dialogoAlerta.setContentText("Casa construida !");
		}
		else {
			dialogoAlerta.setAlertType(AlertType.ERROR);
			dialogoAlerta.setContentText("No se puede construir una casa");
		}
	   	dialogoAlerta.initStyle(StageStyle.UTILITY);
      	dialogoAlerta.showAndWait();
	}
}
