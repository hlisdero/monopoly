package fiuba.algo3.tp2.vista.eventos;


import java.util.ArrayList;

import fiuba.algo3.tp2.vista.JugadorVista;
import fiuba.algo3.tp2.vista.TurnoJugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.stage.StageStyle;

public class BotonFinalizarTurnoHandler implements EventHandler<ActionEvent> {

	private JugadorVista jugador;
	private TurnoJugador turno;
	private int sizeListaJugador;
	private ArrayList<Button> btns;
	
	
	public BotonFinalizarTurnoHandler(TurnoJugador turno, JugadorVista jugador, ArrayList<Button> btns)
	{
		this.turno = turno;
		this.jugador = jugador;
		this.sizeListaJugador = turno.getListaJugadores().size();
		this.btns = btns;
	}
	
	@Override
    public void handle(ActionEvent actionEvent) {
		    sizeListaJugador += 1;
			jugador = turno.getListaJugadores().get(sizeListaJugador%3);
			
	
			turno.setJugadorGenerico(jugador);
			this.alertFinalizarTurno();
			
			for(Button btn: btns){btn.setDisable(false);}
    }
	
	public void alertFinalizarTurno(){
		
	 	Alert dialogoAlerta = new Alert(AlertType.INFORMATION);
      	dialogoAlerta.setTitle("Comprar propiedad");
      	int numeroTurno = turno.getListaJugadores().indexOf(jugador) + 1;
      	dialogoAlerta.setContentText("Turno del jugador: "+numeroTurno);
      	dialogoAlerta.initStyle(StageStyle.UTILITY);
      	dialogoAlerta.showAndWait();
	}
}
