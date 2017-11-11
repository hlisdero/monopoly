package fiuba.algo3.tp2.modelo;
import java.util.LinkedList;
import java.util.Queue;

class GestorTurnos {
	private Queue<Jugador> colaTurnos = new LinkedList<Jugador>();
	private final int cantidadJugadoresInicial = 3;

	GestorTurnos(Casilla casillaInicial) {
		int i;
		for (i = 0; i < cantidadJugadoresInicial; i++) {
			colaTurnos.add(new Jugador(casillaInicial));
		}
	}
	
	int getCantidadJugadores() {
		return colaTurnos.size();
	}

	Jugador proximoJugador() {
		Jugador jugador = colaTurnos.remove();
		colaTurnos.add(jugador);
		return jugador;
	}
	
}
