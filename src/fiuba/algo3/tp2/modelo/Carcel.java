package fiuba.algo3.tp2.modelo;

import java.util.HashMap;

class Carcel extends Casilla {
	private static final int TURNOS_NECESARIOS_PARA_SALIR = 3;
	private static final int TURNOS_NECESARIO_PARA_PAGAR_FIANZA = 2;
	private static final double PRECIO_FIANZA = 45000;
	private HashMap<Jugador, Integer> contadorTurnos = new HashMap<Jugador, Integer>();
	
	@Override
	public void aplicarEfecto(Jugador jugador) {
		contadorTurnos.put(jugador, 0);
		jugador.prohibirMovimiento();
	}
	
	void contarTurno(Jugador jugador) {
		int cantidadTurnos = contadorTurnos.get(jugador);
		if (cantidadTurnos == TURNOS_NECESARIOS_PARA_SALIR) {
			contadorTurnos.remove(jugador);
			jugador.permitirMovimiento();
		} else {
			contadorTurnos.put(jugador, cantidadTurnos + 1);
		}
	}
	
	boolean estaAdentro(Jugador jugador) {
		return (contadorTurnos.containsKey(jugador));
	}
	
	void pagarFianza(Jugador jugador) {
		if (contadorTurnos.get(jugador) >= TURNOS_NECESARIO_PARA_PAGAR_FIANZA && jugador.getCapital() >= PRECIO_FIANZA) {
			contadorTurnos.remove(jugador);
			jugador.restarDinero(PRECIO_FIANZA);
		}
	}
	
}
