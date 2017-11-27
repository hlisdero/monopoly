package fiuba.algo3.tp2.vista.eventos;

import fiuba.algo3.tp2.vista.TerrenoVista;
import fiuba.algo3.tp2.vista.TurnoJugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.StageStyle;

public class BotonTirarDadosHandler implements EventHandler<ActionEvent>{

	private TurnoJugador turno;
	private TerrenoVista terreno;
	private int sumaDados;
	private int numeroCasilla;
	
	public BotonTirarDadosHandler(TurnoJugador turno, TerrenoVista terreno){
		
		this.turno = turno;
		this.terreno = terreno;
	}
	
	
	@Override
    public void handle(ActionEvent actionEvent) {
		
		
		numeroCasilla = turno.getJugadorGenerico().getNumeroCasilla();
  
		sumaDados = terreno.getAlgo().getGestorTurnos().proximoJugador().tirarDados().getSuma();
		this.alertTirarDados();
      	System.out.println(sumaDados);
      	numeroCasilla += sumaDados;

      	if(numeroCasilla > terreno.getList().size()){numeroCasilla -= terreno.getList().size() + 1;}
      	
      	turno.getJugadorGenerico().setNumeroCasilla(numeroCasilla);
      	
      	turno.getJugadorGenerico().setTranslateX(terreno.getList().get(numeroCasilla).getPosX() + turno.getJugadorGenerico().posReferencia());
      	turno.getJugadorGenerico().setTranslateY(terreno.getList().get(numeroCasilla).getPosY());
      	
      	terreno.getAlgo().getGestorMovimiento().mover(turno.getJugadorGenerico().getValorJugador(), terreno.getList().get(turno.getJugadorGenerico().getNumeroCasilla()).getValorCasilla());
      	
      	
    }
	
	public void alertTirarDados()
	{
      	Alert dialogoAlerta = new Alert(AlertType.INFORMATION);
      	dialogoAlerta.setTitle("Resultado dados");
      	dialogoAlerta.setContentText("Numero sacado: " + sumaDados);
      	dialogoAlerta.initStyle(StageStyle.UTILITY);
      	dialogoAlerta.showAndWait();
	}
	
	
}
