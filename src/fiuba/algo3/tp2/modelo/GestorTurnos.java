package fiuba.algo3.tp2.modelo;

import java.util.LinkedList;
import java.util.Queue;

public class GestorTurnos {
	private static final int CANTIDAD_JUGADORES_INICIAL = 3;
	private Queue<Jugador> colaTurnos = new LinkedList<Jugador>();
	
	public GestorTurnos(Casilla casillaInicial) {
		for (int i = 0; i < CANTIDAD_JUGADORES_INICIAL; i++) {
			colaTurnos.add(new Jugador(casillaInicial));
		}
	}
	
	public int getCantidadJugadores() {
		return colaTurnos.size();
	}

	public Jugador proximoJugador() {
		Jugador jugador = colaTurnos.remove();
		colaTurnos.add(jugador);
		return jugador;
	}
}
