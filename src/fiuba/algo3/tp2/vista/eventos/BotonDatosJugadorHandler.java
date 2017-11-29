package fiuba.algo3.tp2.vista.eventos;

import fiuba.algo3.tp2.vista.TurnoJugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.StageStyle;

public class BotonDatosJugadorHandler implements EventHandler<ActionEvent>{

	
	private TurnoJugador turno;
	
	
	public BotonDatosJugadorHandler(TurnoJugador turno)
	{
		this.turno = turno;
	}
	
	
	@Override
    public void handle(ActionEvent actionEvent) {
		this.alertDatosJugador(turno);
	}
	
	
	public void alertDatosJugador(TurnoJugador turno)
	{	
      	Alert dialogoAlerta = new Alert(AlertType.INFORMATION);
      	dialogoAlerta.setTitle("Informaciones jugador numero: "+turno.getJugadorGenerico().getNumeroJugador());
      	
      	dialogoAlerta.setContentText(
      			"Capital del Jugador: "+turno.getJugadorGenerico().getValorJugador().getCapital()+
      			"\nCantidad de propiedad: "+turno.getJugadorGenerico().getValorJugador().getCantidadPropiedades()+
      			"\nPosicion en el terreno: "+turno.getJugadorGenerico().getValorJugador().getCasilla().nombreCasilla()
      			
      			);
      	dialogoAlerta.initStyle(StageStyle.UTILITY);
      	dialogoAlerta.showAndWait();
	}
	
}
