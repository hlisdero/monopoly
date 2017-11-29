package fiuba.algo3.tp2.vista.eventos;

import fiuba.algo3.tp2.modelo.Carcel;
import fiuba.algo3.tp2.modelo.Jugador;
import fiuba.algo3.tp2.vista.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.StageStyle;

public class BotonPagarFianzaHandler  implements EventHandler<ActionEvent>{

	private TurnoJugador turno;
	private TerrenoVista terreno;
	
	public BotonPagarFianzaHandler(TurnoJugador turno, TerrenoVista terreno)
	{
		this.turno = turno;
		this.terreno = terreno;
	}
	
	
	@Override
    public void handle(ActionEvent actionEvent) {
		Jugador jugador = turno.getJugadorGenerico().getValorJugador();
		
		
		
		if(((Carcel) jugador.getCasilla()).estaAdentro(jugador) && ((Carcel) jugador.getCasilla()).puedeSalir(jugador))
		{
			((Carcel) jugador.getCasilla()).pagarFianza(jugador);
			this.alertPagarFianza(true);
		}
		else this.alertPagarFianza(false);
		
		
    }
	
	public void alertPagarFianza(boolean valido){
		
	 	Alert dialogoAlerta = new Alert(AlertType.INFORMATION);
      	dialogoAlerta.setTitle("Pagar fianza carcel");
      	dialogoAlerta.initStyle(StageStyle.UTILITY);
      	
      	if(valido) {
      		dialogoAlerta.setContentText("Eres libre de la carcel ! ");
      	}
      	else dialogoAlerta.setContentText("No se puede pagar fianza ahora !");
      	dialogoAlerta.showAndWait();
	}
	
	
}
