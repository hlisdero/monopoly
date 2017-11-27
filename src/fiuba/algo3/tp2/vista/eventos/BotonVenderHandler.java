package fiuba.algo3.tp2.vista.eventos;

import fiuba.algo3.tp2.vista.JugadorVista;
import fiuba.algo3.tp2.vista.TerrenoVista;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BotonVenderHandler implements EventHandler<ActionEvent>{
	
	
	private JugadorVista jugador;
	private TerrenoVista terreno;
	
	public BotonVenderHandler(JugadorVista jugador, TerrenoVista terreno){
		this.jugador = jugador;
		this.terreno = terreno;
	}
	
	
	@Override
	public void handle(ActionEvent actionEvent){
		
	}

}
