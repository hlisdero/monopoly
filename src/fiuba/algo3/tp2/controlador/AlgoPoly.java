package fiuba.algo3.tp2.controlador;

import java.util.ArrayList;

import fiuba.algo3.tp2.modelo.Casilla;
import fiuba.algo3.tp2.modelo.GestorMovimiento;
import fiuba.algo3.tp2.modelo.GestorTurnos;
import fiuba.algo3.tp2.modelo.Jugador;
import fiuba.algo3.tp2.modelo.Propiedad;
import fiuba.algo3.tp2.modelo.Carcel;

public class AlgoPoly {
	private GestorMovimiento gestorMovimiento = new GestorMovimiento();
	private GestorTurnos gestorTurnos = new GestorTurnos(gestorMovimiento.getCasillaInicial());
	private Jugador jugadorActual;
	
	public void mover(Jugador jugador) {
		gestorMovimiento.mover(jugador);
	}

	public void mover(Jugador jugador, int posiciones) {
		gestorMovimiento.mover(jugador, posiciones);
	}
	
	public Jugador proximoJugador() {
		jugadorActual = gestorTurnos.proximoJugador();
		gestorMovimiento.notificarNuevoTurno(jugadorActual);
		return jugadorActual;
	}
	
	public boolean sePuedeComprar(Casilla casilla) {
		return casilla.sePuedeComprar();
	}
	
	public void comprar(Jugador jugador, Propiedad propiedad) {
		jugador.comprar(propiedad);
	}
	
	public void vender(Jugador jugador, Propiedad propiedad) {
		jugador.vender(propiedad);
	}
	
	public void pagarFianza(Jugador jugador, Carcel carcel) {
		carcel.pagarFianza(jugador);
	}

	public Jugador getJugador() {
		return gestorTurnos.proximoJugador();
	}

	public ArrayList<Casilla> getCasillas() {
		return gestorMovimiento.getCasillas();
	}

	public void notificarNuevoTurno(Jugador jugador) {
		gestorMovimiento.notificarNuevoTurno(jugador);	
	}
}
