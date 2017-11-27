package fiuba.algo3.tp2.vista.eventos;

import fiuba.algo3.tp2.modelo.ConstruirCasaInvalidoException;
import fiuba.algo3.tp2.modelo.Provincia;
import fiuba.algo3.tp2.vista.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

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
		 try {
			((Provincia)terreno.getList().get(jugador.getJugadorGenerico().getNumeroCasilla()).getValorCasilla()).construirCasa();
		} catch (ConstruirCasaInvalidoException e) {
			e.printStackTrace();
		}
		 
		 terreno.crearCasaVista(terreno.getList().get(jugador.getJugadorGenerico().getNumeroCasilla()).getPosX(), terreno.getList().get(jugador.getJugadorGenerico().getNumeroCasilla()).getPosY());
	}
}
