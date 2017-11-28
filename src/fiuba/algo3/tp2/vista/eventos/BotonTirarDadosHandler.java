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
		
		int sumaDados = terreno.getAlgo().getJugador().tirarDados().getSuma();
		int numeroCasilla  = turno.getJugadorGenerico().getNumeroCasilla();
		
		this.alertTirarDados(sumaDados);
		source.setDisable(true);
		
		
	      	numeroCasilla = this.parseNumeroCasilla(numeroCasilla + sumaDados);
	      	turno.getJugadorGenerico().setNumeroCasilla(numeroCasilla);
	      	
	      	turno.getJugadorGenerico().setTranslateX(terreno.getList().get(numeroCasilla).getPosX() + turno.getJugadorGenerico().posReferencia());
	      	turno.getJugadorGenerico().setTranslateY(terreno.getList().get(numeroCasilla).getPosY());
	      	
	      	terreno.getAlgo().mover(sumaDados);
    }
	
	public int parseNumeroCasilla(int numero)
	{
		return (numero % terreno.getList().size());
	}
	
	public void alertTirarDados(int sumaDados)
	{
      	Alert dialogoAlerta = new Alert(AlertType.INFORMATION);
      	dialogoAlerta.setTitle("Resultado dados");
      	dialogoAlerta.setContentText("Numero sacado: " + sumaDados);
      	dialogoAlerta.initStyle(StageStyle.UTILITY);
      	dialogoAlerta.showAndWait();
	}
	
	
}
