package fiuba.algo3.tp2.vista.eventos;

import fiuba.algo3.tp2.modelo.Casilla;
import fiuba.algo3.tp2.modelo.Jugador;
import fiuba.algo3.tp2.modelo.Propiedad;
import fiuba.algo3.tp2.vista.TerrenoVista;
import fiuba.algo3.tp2.vista.TurnoJugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.stage.StageStyle;

public class BotonTirarDadosHandler implements EventHandler<ActionEvent>{

	private TurnoJugador turno;
	private TerrenoVista terreno;
	Button source;
	private Button botonComprar;
	
	public BotonTirarDadosHandler(TurnoJugador turno, TerrenoVista terreno, Button btn, Button botonComprar){
		
		this.turno = turno;
		this.terreno = terreno;
		this.source = btn;
		this.botonComprar = botonComprar;
	}
	
	
	@Override
    public void handle(ActionEvent actionEvent) {
		
		
		Jugador jugador = turno.getJugadorGenerico().getValorJugador();
		terreno.getControlador().mover(jugador);
		Casilla casilla = jugador.getCasilla();
		int posicionNueva = terreno.getControlador().getCasillas().indexOf(casilla);
	
		terreno.getControlador().notificarNuevoTurno(jugador);
		
		if (!(jugador.getCasilla() instanceof Propiedad)) {
			botonComprar.setDisable(true);
		}
		source.setDisable(true);
		this.alertTirarDados();
      	turno.getJugadorGenerico().setNumeroCasilla(posicionNueva);
      	
      	turno.getJugadorGenerico().setTranslateX(terreno.getCasillaVista(posicionNueva).getPosX() + turno.getJugadorGenerico().posReferencia());
      	turno.getJugadorGenerico().setTranslateY(terreno.getCasillaVista(posicionNueva).getPosY());
      	
    }
	
	
	
	public void alertTirarDados(){	
		Jugador jugador = turno.getJugadorGenerico().getValorJugador();
      	Alert dialogoAlerta = new Alert(AlertType.INFORMATION);
      	
      	dialogoAlerta.setTitle("Resultado dados");
      	dialogoAlerta.setContentText(
      			"Numero sacado: "+jugador.getResultadoDados().getSuma()+"\nCasilla siguiente: " +jugador.getCasilla().getNombreCasilla());
      	dialogoAlerta.initStyle(StageStyle.UTILITY);
      	dialogoAlerta.showAndWait();
	}
	
	
}
