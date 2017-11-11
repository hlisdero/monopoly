package fiuba.algo3.tp2.modelo;
import java.util.LinkedList;

public class GestorTurnos {
	private LinkedList<Jugador> colaDeTurnos = new LinkedList<Jugador>();

	public void agregarJugador(Jugador jugador) {
		colaDeTurnos.add(jugador);
		
	}

	public int getNumeroDeJugadores() {
		return colaDeTurnos.size();
	}

	public Jugador proximoTurno() {
		Jugador jugador = colaDeTurnos.remove();
		colaDeTurnos.add(jugador);
		return jugador;
	}
	
}
