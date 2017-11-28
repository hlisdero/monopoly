package fiuba.algo3.tp2.vista.eventos;

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
	
	public BotonTirarDadosHandler(TurnoJugador turno, TerrenoVista terreno, Button btn){
		
		this.turno = turno;
		this.terreno = terreno;
		this.source = btn;
	}
	
	
	@Override
    public void handle(ActionEvent actionEvent) {
		
		
		
		terreno.getAlgo().getGestorMovimiento()
		.mover(turno.getJugadorGenerico().getValorJugador());
		
		int posicionNueva = terreno.getAlgo()
				.getGestorMovimiento()
				.getCasillas()
				.indexOf(turno.getJugadorGenerico().getValorJugador().getCasilla());
	
		
		
		terreno
		.getAlgo().getGestorMovimiento()
		.notificarNuevoTurno(turno.getJugadorGenerico().getValorJugador());
		
		
		this.alertTirarDados(posicionNueva);
		source.setDisable(true);
		
		

      	turno.getJugadorGenerico().setNumeroCasilla(posicionNueva);
      	
      	turno.getJugadorGenerico().setTranslateX(terreno.getList().get(posicionNueva).getPosX() + turno.getJugadorGenerico().posReferencia());
      	turno.getJugadorGenerico().setTranslateY(terreno.getList().get(posicionNueva).getPosY());
      	
      	
      	System.out.println("Capital: "+turno.getJugadorGenerico().getValorJugador().getCapital());
    }
	
	
	public void alertTirarDados(int sumaDados)
	{	
      	Alert dialogoAlerta = new Alert(AlertType.INFORMATION);
      	dialogoAlerta.setTitle("Resultado dados");
      	dialogoAlerta.setContentText("Casilla siguiente: " +turno.getJugadorGenerico().getValorJugador().getCasilla().nombreCasilla());
      	dialogoAlerta.initStyle(StageStyle.UTILITY);
      	dialogoAlerta.showAndWait();
	}
	
	
}
