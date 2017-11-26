
package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.modelo.Jugador;

import javafx.scene.Parent;
import javafx.scene.image.ImageView;


public class JugadorVista extends Parent{
	
	private Jugador valorJugador;
	private int numeroCasilla;
	ImageView imageJugador;
	public static int numeroDeJugador = 0;
	
	
	public JugadorVista(Jugador valorJugador, int numeroCasilla){
		numeroDeJugador += 1;
		
		this.valorJugador = valorJugador;
		this.numeroCasilla = numeroCasilla;
		
		imageJugador =  new ImageView("File:images/j"+numeroDeJugador+".png");
		
		imageJugador.setFitWidth(50);
		imageJugador.setFitHeight(50);
		
		this.getChildren().add(imageJugador);
	}

	public int getNumeroCasilla() {
		return numeroCasilla;
	}

	public void setNumeroCasilla(int numeroCasilla) {
		this.numeroCasilla = numeroCasilla;
	}

	public Jugador getValorJugador() {
		return valorJugador;
	}

	public void setValorJugador(Jugador valorJugador) {
		this.valorJugador = valorJugador;
	}

	
	
	

}
