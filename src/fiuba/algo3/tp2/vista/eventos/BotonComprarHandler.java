package fiuba.algo3.tp2.vista.eventos;

import fiuba.algo3.tp2.modelo.Propiedad;
import fiuba.algo3.tp2.vista.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

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
			
	    }
}
