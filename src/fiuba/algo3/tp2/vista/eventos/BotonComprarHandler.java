package fiuba.algo3.tp2.vista.eventos;

import fiuba.algo3.tp2.modelo.Propiedad;
import fiuba.algo3.tp2.vista.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.stage.StageStyle;

public class BotonComprarHandler implements EventHandler<ActionEvent> {

	private JugadorVista jugador;
	private TerrenoVista terreno;
	private Button source;
	
	public BotonComprarHandler(JugadorVista jugador, TerrenoVista terreno, Button btn){
		this.jugador = jugador;
		this.terreno = terreno;
		this.source = btn;
	}
	
	  @Override
	    public void handle(ActionEvent actionEvent) {
		    
  			
  			if(jugador.getValorJugador().equals(((Propiedad) jugador.getValorJugador().getCasilla()).getPropietario()))
  			{
  				this.alertNoComprarPropiedad();
  			}
  			else{
  				jugador.getValorJugador().comprar((Propiedad)terreno.getList().get(jugador.getNumeroCasilla()).getValorCasilla());
	  			System.out.println(jugador.getValorJugador().getCapital());
	  			this.alertComprarPropiedad();
	  			source.setDisable(true);
  			}
  			
  			
	    }
	  
		public void alertComprarPropiedad()
		{
	      	Alert dialogoAlerta = new Alert(AlertType.CONFIRMATION);
	      	dialogoAlerta.setTitle("Comprar propiedad");
	      	dialogoAlerta.setContentText("Precio de la propiedad: "+((Propiedad) terreno.getList().get(jugador.getNumeroCasilla()).getValorCasilla()).getPrecio()+"\n\nCapital restante: " +jugador.getValorJugador().getCapital());
	      	dialogoAlerta.initStyle(StageStyle.UTILITY);
	      	dialogoAlerta.showAndWait();
		}
		
		public void alertNoComprarPropiedad(){
			Alert dialogoAlerta = new Alert(AlertType.ERROR);
	      	dialogoAlerta.setTitle("Comprar propiedad");
	      	dialogoAlerta.setContentText("No se puede comprar este propiedad");
	      	dialogoAlerta.initStyle(StageStyle.UTILITY);
	      	dialogoAlerta.showAndWait();
		}
}
