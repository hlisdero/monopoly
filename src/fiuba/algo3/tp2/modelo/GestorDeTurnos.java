package fiuba.algo3.tp2.modelo;
import java.util.LinkedList;

public class GestorDeTurnos {
	private LinkedList<Turno> colaDeTurnos = new LinkedList<Turno>();

	public void agregarJugador(Jugador jugador) {
		Turno turno = new Turno(jugador);
		colaDeTurnos.add(turno);
		
	}

	public int getNumeroDeJugadores() {
		return colaDeTurnos.size();
	}

	public Turno avanzarTurno() {
		Turno turno = colaDeTurnos.remove();
		colaDeTurnos.add(turno);
		return turno;
	}
	
}
