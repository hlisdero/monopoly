package fiuba.algo3.tp2.vista.eventos;

import fiuba.algo3.tp2.modelo.Propiedad;
import fiuba.algo3.tp2.vista.JugadorVista;
import fiuba.algo3.tp2.vista.TerrenoVista;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.StageStyle;

public class BotonVenderHandler implements EventHandler<ActionEvent>{
	
	
	private JugadorVista jugador;
	private TerrenoVista terreno;
	
	public BotonVenderHandler(JugadorVista jugador, TerrenoVista terreno){
		this.jugador = jugador;
		this.terreno = terreno;
	}
	
	
	@Override
	public void handle(ActionEvent actionEvent){
		
		if(jugador.getValorJugador().equals(((Propiedad) terreno.getList().get(jugador.getNumeroCasilla()).getValorCasilla()).getPropietario()))
			{jugador.getValorJugador().vender((Propiedad)terreno.getList().get(jugador.getNumeroCasilla()).getValorCasilla());
			this.alertVenderPropiedad();}
		else this.alertNoVenderPropiedad();
	}
	
	public void alertVenderPropiedad()
	{
      	Alert dialogoAlerta = new Alert(AlertType.INFORMATION);
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
