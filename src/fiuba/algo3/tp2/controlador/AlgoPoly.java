package fiuba.algo3.tp2.controlador;

import java.util.ArrayList;

import fiuba.algo3.tp2.modelo.Casilla;
import fiuba.algo3.tp2.modelo.GestorMovimiento;
import fiuba.algo3.tp2.modelo.GestorTurnos;
import fiuba.algo3.tp2.modelo.Jugador;

public class AlgoPoly {
	private GestorMovimiento gestorMovimiento = new GestorMovimiento();
	private GestorTurnos gestorTurnos = new GestorTurnos(gestorMovimiento.getCasillaInicial());
	private Jugador jugadorActual = gestorTurnos.proximoJugador();
	
	public void mover() {
		gestorMovimiento.mover(jugadorActual);
	}

	public void mover(int espacios) {
		gestorMovimiento.mover(jugadorActual,espacios);
	}
	
	public void proximoJugador() {
		jugadorActual = gestorTurnos.proximoJugador();
		gestorMovimiento.notificarNuevoTurno(jugadorActual);
	}
	


	public Jugador getJugador() {
		return jugadorActual;
	}

	public ArrayList<Casilla> getCasillas() {
		return gestorMovimiento.getCasillas();
	}
	
	
}
