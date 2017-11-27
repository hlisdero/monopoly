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
import javafx.stage.StageStyle;

public class BotonVenderHandler implements EventHandler<ActionEvent>{
	
	
	private JugadorVista jugador;
	private TurnoJugador turno;
	private TerrenoVista terreno;
	private Button source;
	
	public BotonVenderHandler(TurnoJugador turno, TerrenoVista terreno, Button btn){
		this.turno = turno;
		this.terreno = terreno;
		this.source = btn;
	}
	
	
	@Override
	public void handle(ActionEvent actionEvent){
		
		jugador = turno.getJugadorGenerico();
		
		if(jugador.getValorJugador().equals(((Propiedad) terreno.getList().get(jugador.getNumeroCasilla()).getValorCasilla()).getPropietario()))
			{
				jugador.getValorJugador().vender((Propiedad)terreno.getList().get(jugador.getNumeroCasilla()).getValorCasilla());
				this.alertVenderPropiedad();
				source.setDisable(true);
			}
		else this.alertNoVenderPropiedad();
	}
	
	public void alertVenderPropiedad()
	{
      	Alert dialogoAlerta = new Alert(AlertType.CONFIRMATION);
      	dialogoAlerta.setTitle("Comprar propiedad");
      	dialogoAlerta.setContentText("Precio de la propiedad: "+((Propiedad) terreno.getList().get(jugador.getNumeroCasilla()).getValorCasilla()).getPrecio()+"\n\nCapital restante: " +jugador.getValorJugador().getCapital());
      	dialogoAlerta.initStyle(StageStyle.UTILITY);
      	dialogoAlerta.showAndWait();
	}
	
	public void alertNoVenderPropiedad(){
		Alert dialogoAlerta = new Alert(AlertType.ERROR);
      	dialogoAlerta.setTitle("Comprar propiedad");
      	dialogoAlerta.setContentText("No es el propietario de la propiedad !");
      	dialogoAlerta.initStyle(StageStyle.UTILITY);
      	dialogoAlerta.showAndWait();
	}
	

}
