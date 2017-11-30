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
	private String listaPropiedad;
	
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
		
		listaPropiedad = "";
		
		JugadorVista jugadorVista = turno.getJugadorGenerico();
		Jugador jugador = turno.getJugadorGenerico().getValorJugador();
      	Alert dialogoAlerta = new Alert(AlertType.INFORMATION);
      	
      	
      	for(Propiedad p: jugador.getGestorPropiedades().getPropiedades())
      	{
      		listaPropiedad += p.getNombreCasilla() + "\n";
      	}
      	
      	dialogoAlerta.setTitle("Informaciones jugador numero: "+jugadorVista.getNumeroJugador());
      	
      	dialogoAlerta.setContentText(
      			"Capital del Jugador: "+jugador.getCapital()+
      			"\n\nCantidad de propiedad: "+jugador.getCantidadPropiedades()+
      			"\n\nPosicion en el terreno: "+jugador.getCasilla().getNombreCasilla()+
      			"\n\nLista de propiedad: \n"+listaPropiedad
      			);
      	dialogoAlerta.initStyle(StageStyle.UTILITY);
      	dialogoAlerta.showAndWait();
	}
	
}
