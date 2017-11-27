
package fiuba.algo3.tp2.vista;

import fiuba.algo3.tp2.modelo.Jugador;

import javafx.scene.Parent;
import javafx.scene.image.ImageView;


public class JugadorVista extends Parent{
	
	private Jugador valorJugador;
	private int numeroCasilla;
	ImageView imageJugador;
	public static int numeroDeJugador = 0;
	private double posXEnTablero;
	
	
	public JugadorVista(Jugador valorJugador, int numeroCasilla){
		numeroDeJugador += 1;
		this.valorJugador = valorJugador;
		this.numeroCasilla = numeroCasilla;
		this.posXEnTablero= (numeroDeJugador-1)*40;
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
	
	public void asignarPosicion(double posicionX , double posicionY) {
		this.setTranslateX(posicionX + this.posXEnTablero);
		this.setTranslateY(posicionY);
	}
	public double posReferencia() {
		return this.posXEnTablero;
	}


	
	
	

}
