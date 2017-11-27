package fiuba.algo3.tp2.vista.eventos;

import fiuba.algo3.tp2.modelo.Propiedad;
import fiuba.algo3.tp2.vista.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.StageStyle;

public class BotonComprarHandler implements EventHandler<ActionEvent> {

	private JugadorVista jugador;
	private TerrenoVista terreno;
	
	public BotonComprarHandler(JugadorVista jugador, TerrenoVista terreno){
		this.jugador = jugador;
		this.terreno = terreno;
	}
	
	  @Override
	    public void handle(ActionEvent actionEvent) {
		    jugador.getValorJugador().comprar((Propiedad)terreno.getList().get(jugador.getNumeroCasilla()).getValorCasilla());
  			System.out.println(jugador.getValorJugador().getCapital());
  			this.alertComprarPropiedad();
	    }
	  
		public void alertComprarPropiedad()
		{
	      	Alert dialogoAlerta = new Alert(AlertType.CONFIRMATION);
	      	dialogoAlerta.setTitle("Comprar propiedad");
	      	dialogoAlerta.setContentText("Precio de la propiedad: "+((Propiedad) terreno.getList().get(jugador.getNumeroCasilla()).getValorCasilla()).getPrecio()+"\n\nCapital restante: " +jugador.getValorJugador().getCapital());
	      	dialogoAlerta.initStyle(StageStyle.UTILITY);
	      	dialogoAlerta.showAndWait();
		}
}
