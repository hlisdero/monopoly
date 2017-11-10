package fiuba.algo3.tp2.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class TurnoTest {

	@Test
	public void nuevoTurnoNoEsNull() {
		Jugador jugador = new Jugador("Pepe");
		assertNotNull(new Turno(jugador));
	}

	@Test
	public void nuevoTurnoContieneAlJugador() {
		Jugador jugador = new Jugador("Pepe");
		Turno turno = new Turno(jugador);
		assertEquals(turno.getJugador(),jugador);
	}
}
