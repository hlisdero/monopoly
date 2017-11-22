package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GestorTurnos {
	private Queue<Jugador> colaTurnos = new LinkedList<Jugador>();
	private final int cantidadJugadoresInicial = 3;
	
	public GestorTurnos(Casilla casillaInicial) {
		int i;
		for (i = 0; i < cantidadJugadoresInicial; i++) {
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
