package fiuba.algo3.tp2.vista.eventos;

import fiuba.algo3.tp2.modelo.Jugador;
import fiuba.algo3.tp2.modelo.Propiedad;
import fiuba.algo3.tp2.vista.JugadorVista;
import fiuba.algo3.tp2.vista.TurnoJugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.StageStyle;

public class BotonDatosJugadorHandler implements EventHandler<ActionEvent>{

	
	private TurnoJugador turno;
	private String listaPropiedad = null;
	
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
		JugadorVista jugadorVista = turno.getJugadorGenerico();
		Jugador jugador = turno.getJugadorGenerico().getValorJugador();
      	Alert dialogoAlerta = new Alert(AlertType.INFORMATION);
      	
      	
      	for(Propiedad p: jugador.getGestorPropiedades().getPropiedades())
      	{
      		listaPropiedad.concat(p.getNombreCasilla());
      		listaPropiedad.concat("\n");
      	}
      	
      	dialogoAlerta.setTitle("Informaciones jugador numero: "+jugadorVista.getNumeroJugador());
      	
      	dialogoAlerta.setContentText(
      			"Capital del Jugador: "+jugador.getCapital()+
      			"\nCantidad de propiedad: "+jugador.getCantidadPropiedades()+
      			"\nPosicion en el terreno: "+jugador.getCasilla().getNombreCasilla()+
      			"\nLista de propiedad: "+listaPropiedad
      			

      			);
      	dialogoAlerta.initStyle(StageStyle.UTILITY);
      	dialogoAlerta.showAndWait();
	}
	
}
