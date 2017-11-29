package fiuba.algo3.tp2.vista.eventos;

import fiuba.algo3.tp2.modelo.Casilla;
import fiuba.algo3.tp2.modelo.Propiedad;
import fiuba.algo3.tp2.vista.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.stage.StageStyle;

public class BotonComprarHandler implements EventHandler<ActionEvent> {

	private TurnoJugador turno;
	private TerrenoVista terreno;
	private Button source;
	private JugadorVista jugador;
	
	public BotonComprarHandler(TurnoJugador turno, TerrenoVista terreno, Button btn){
		this.turno = turno;
		this.terreno = terreno;
		this.source = btn;
	}
	
	  @Override
	    public void handle(ActionEvent actionEvent) {
		    
		  	jugador = turno.getJugadorGenerico();
		  	Casilla casilla = jugador.getValorJugador().getCasilla();
  			
  			if(((Propiedad) casilla).tienePropietario())
  			{
  				this.alertComprarPropiedad(false);
  			}
  			else{
  				jugador.getValorJugador().comprar((Propiedad)terreno.getList().get(jugador.getNumeroCasilla()).getValorCasilla());
  				System.out.println(jugador.getValorJugador().getCapital());
	  			this.alertComprarPropiedad(true);
	  			source.setDisable(true);
  			}
	    }
	  
		public void alertComprarPropiedad(boolean valido)
		{
			Alert dialogoAlerta = new Alert(null);
			dialogoAlerta.setTitle("Comprar propiedad");
			dialogoAlerta.initStyle(StageStyle.UTILITY);
			if(valido){
				dialogoAlerta.setAlertType(AlertType.CONFIRMATION);

				dialogoAlerta.setContentText("Precio de la propiedad: "+((Propiedad) terreno.getList().get(jugador.getNumeroCasilla()).getValorCasilla()).getPrecio()+"\n\nCapital restante: " +jugador.getValorJugador().getCapital());
			}
			else{
				dialogoAlerta.setAlertType(AlertType.ERROR);
				dialogoAlerta.setContentText("No se puede comprar este propiedad");
			}
	    
	      	
	      	dialogoAlerta.showAndWait();
		}
		
}
