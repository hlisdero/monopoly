package fiuba.algo3.tp2.vista.eventos;

import fiuba.algo3.tp2.modelo.ConstruirHotelInvalidoException;
import fiuba.algo3.tp2.modelo.Provincia;
import fiuba.algo3.tp2.vista.TerrenoVista;
import fiuba.algo3.tp2.vista.TurnoJugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.StageStyle;

public class BotonConstruirHotelHandler implements EventHandler<ActionEvent>{

	private TurnoJugador jugador;
	private TerrenoVista terreno;
	
	public BotonConstruirHotelHandler(TurnoJugador jugador, TerrenoVista terreno)
	{
		this.jugador = jugador;
		this.terreno = terreno;
	}
	
	
	@Override
    public void handle(ActionEvent actionEvent) {
		 try {
			 ((Provincia)terreno.getList()
						.get(jugador.getJugadorGenerico().getNumeroCasilla())
						.getValorCasilla())
						.construirHotel();
				terreno.crearHotelVista(terreno.getList()
						.get(jugador.getJugadorGenerico().getNumeroCasilla())
						.getPosX(), terreno.getList()
						.get(jugador.getJugadorGenerico().getNumeroCasilla())
						.getPosY());
				this.alertConstruirHotel(true);
				
		} catch (ConstruirHotelInvalidoException e) {
			e.printStackTrace();
			this.alertConstruirHotel(false);
		}
	}
	
	public void alertConstruirHotel(boolean valido)
	{
		Alert dialogoAlerta = new Alert(null);
		dialogoAlerta.setTitle("Construir hotel");
		dialogoAlerta.initStyle(StageStyle.UTILITY);
		
		if(valido){
			dialogoAlerta.setAlertType(AlertType.CONFIRMATION);
			dialogoAlerta.setContentText("Hotel construido !");
		}
		else {
			dialogoAlerta.setAlertType(AlertType.ERROR);
			dialogoAlerta.setContentText("No se puede construir un hotel");
		}
	   	
      	dialogoAlerta.showAndWait();
  
	}
}
