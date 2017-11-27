package fiuba.algo3.tp2.vista.eventos;


import fiuba.algo3.tp2.vista.JugadorVista;
import fiuba.algo3.tp2.vista.TurnoJugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.StageStyle;

public class BotonFinalizarTurnoHandler implements EventHandler<ActionEvent> {

	private JugadorVista jugador;
	private int sizeListaJugador;
	private TurnoJugador turno;
	
	
	public BotonFinalizarTurnoHandler(TurnoJugador turno, JugadorVista jugador, int sizeListaJugador)
	{
		this.turno = turno;
		this.jugador = jugador;
		this.sizeListaJugador = sizeListaJugador;
	}
	
	@Override
    public void handle(ActionEvent actionEvent) {
			sizeListaJugador += 1;
			jugador = turno.getListaJugadores().get(sizeListaJugador %3);
			turno.setJugadorGenerico(jugador);
			this.alertFinalizarTurno();
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
