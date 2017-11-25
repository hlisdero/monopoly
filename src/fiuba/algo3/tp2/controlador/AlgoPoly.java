package fiuba.algo3.tp2.controlador;

import fiuba.algo3.tp2.modelo.GestorMovimiento;
import fiuba.algo3.tp2.modelo.GestorTurnos;
import fiuba.algo3.tp2.modelo.Jugador;

public class AlgoPoly {
	private GestorMovimiento gestorMovimiento = new GestorMovimiento();
	private GestorTurnos gestorTurnos = new GestorTurnos(gestorMovimiento.getCasillaInicial());
	
	public void mover() {
		Jugador jugador = gestorTurnos.proximoJugador();
		gestorMovimiento.notificarNuevoTurno(jugador);
		gestorMovimiento.mover(jugador);
	}

	public GestorMovimiento getGestorMovimiento() {
		return gestorMovimiento;
	}

	public GestorTurnos getGestorTurnos() {
		return gestorTurnos;
	}
	
	
}
