package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GestorTurnos {
	private Queue<Jugador> colaTurnos = new LinkedList<Jugador>();
	private final int cantidadJugadoresInicial = 3;
	private ArrayList<ContadorTurnos> contadoresTurnos = new  ArrayList<ContadorTurnos>();

	public GestorTurnos(Casilla casillaInicial) {
		int i;
		for (i = 0; i < cantidadJugadoresInicial; i++) {
			colaTurnos.add(new Jugador(casillaInicial));
		}
	}
	
	public int getCantidadJugadores() {
		return colaTurnos.size();
	}

	public void agregarContadorTurnos(ContadorTurnos contador) {
		contadoresTurnos.add(contador);
	}
	
	public Jugador proximoJugador() {
		Jugador jugador = colaTurnos.remove();
		for(int i = 0; i < contadoresTurnos.size(); i++){
			contadoresTurnos.get(i).contarTurno(jugador);;
        }
		colaTurnos.add(jugador);
		return jugador;
	}
}
