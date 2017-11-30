package fiuba.algo3.tp2.modelo;

import java.util.HashMap;

public class Carcel extends Casilla implements ContadorTurnos {
	private static final int TURNOS_NECESARIOS_PARA_SALIR = 3;
	private static final int TURNOS_NECESARIO_PARA_PAGAR_FIANZA = 2;
	private static final double PRECIO_FIANZA = 45000;
	private HashMap<Jugador, Integer> contadorTurnos = new HashMap<Jugador, Integer>();

	public Carcel() {
		setNombreCasilla("CARCEL");
	}
	
	@Override
	public void aplicarEfecto(Jugador jugador) {
		contadorTurnos.put(jugador, 0);
		jugador.prohibirMovimiento();
	}
	
	public void contarTurno(Jugador jugador) {
		if (!estaAdentro(jugador)) {
			return;
		}
		if (puedeSalir(jugador)) {
			contadorTurnos.remove(jugador);
			jugador.permitirMovimiento();
		} else {
			contadorTurnos.put(jugador, getCantidadTurnos(jugador) + 1);
		}
	}
	
	public boolean puedeSalir(Jugador jugador) {
		return (getCantidadTurnos(jugador) == TURNOS_NECESARIOS_PARA_SALIR);
	}
	
	public boolean estaAdentro(Jugador jugador) {
		return (contadorTurnos.containsKey(jugador));
	}
	
	public void pagarFianza(Jugador jugador) {
		if (contadorTurnos.get(jugador) >= TURNOS_NECESARIO_PARA_PAGAR_FIANZA && jugador.getCapital() >= PRECIO_FIANZA) {
			contadorTurnos.remove(jugador);
			jugador.permitirMovimiento();
			jugador.restarDinero(PRECIO_FIANZA);
		}
	}
	
	public int getCantidadTurnos(Jugador jugador) {
		return contadorTurnos.get(jugador);
	}
}
