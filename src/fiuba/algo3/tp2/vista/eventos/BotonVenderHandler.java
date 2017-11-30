package fiuba.algo3.tp2.vista.eventos;

import fiuba.algo3.tp2.modelo.Propiedad;
import fiuba.algo3.tp2.vista.JugadorVista;
import fiuba.algo3.tp2.vista.TerrenoVista;
import fiuba.algo3.tp2.vista.TurnoJugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.StageStyle;

public class BotonVenderHandler implements EventHandler<ActionEvent>{
	
	
	private JugadorVista jugador;
	private TurnoJugador turno;
	private TerrenoVista terreno;
	private Button source;
	private TextField text;
	Integer numero;
	
	public BotonVenderHandler(TurnoJugador turno, TerrenoVista terreno, Button btn, TextField text){
		this.turno = turno;
		this.terreno = terreno;
		this.source = btn;
		this.text = text;
	}
	
	
	@Override
	public void handle(ActionEvent actionEvent){
		
		this.numero = Integer.valueOf(text.getText());
		
		System.out.println("Numero casilla: "+numero);
		jugador = turno.getJugadorGenerico();
		try{
			if(jugador.getValorJugador().getGestorPropiedades().getPropiedades().contains(terreno.getCasillasVista().get(numero).getValorCasilla()))
			{
				jugador.getValorJugador().vender((Propiedad)terreno.getCasillasVista().get(numero).getValorCasilla());
				terreno.venderCasa(terreno.getCasillaVista(numero));
				this.alertVenderPropiedad(true);
				source.setDisable(true);
			}
		
			else{ this.alertVenderPropiedad(false);
		}
		}catch(ClassCastException e){
			this.alertVenderPropiedad(false);
		}
	}
	
	public void alertVenderPropiedad(boolean valido)
	{
		Alert dialogoAlerta = new Alert(null);
      	dialogoAlerta.setTitle("Vender propiedad");
      	dialogoAlerta.initStyle(StageStyle.UTILITY);
		
		if(valido){
			dialogoAlerta.setAlertType(AlertType.CONFIRMATION);
			dialogoAlerta.setContentText("Precio de la propiedad: "+((Propiedad) terreno.getCasillasVista().get(numero).getValorCasilla()).getPrecio()+"\n\nCapital restante: " +jugador.getValorJugador().getCapital());
		}
		else{
			dialogoAlerta.setAlertType(AlertType.ERROR);
			dialogoAlerta.setContentText("No se puede vender la propiedad !");
		}
      	dialogoAlerta.showAndWait();
	}

	

}
