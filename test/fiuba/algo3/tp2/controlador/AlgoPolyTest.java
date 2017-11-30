package fiuba.algo3.tp2.controlador;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.tp2.modelo.Jugador;

public class AlgoPolyTest {

	@Test
	public void nuevoAlgoPolyNoEsNull() {
		assertNotNull(new AlgoPoly());
	}

	@Test
	public void proximoJugadorDevuelveElJugador() {
		AlgoPoly poly = new AlgoPoly();
		assertNotNull(poly.proximoJugador());
	}
	
	@Test
	public void proximoJugadorAvanzaElJugador() {
		AlgoPoly poly = new AlgoPoly();
		Jugador jugador = poly.proximoJugador();
		assertNotEquals(jugador,poly.proximoJugador());
	}
	
	@Test
	public void getJugadorNoDevuelveNull() {
		AlgoPoly poly = new AlgoPoly();
		poly.proximoJugador();
		assertNotNull(poly.getJugador());
	}
	
	@Test
	public void getCasillasNoDevuelveNull() {
		AlgoPoly poly = new AlgoPoly();
		assertNotNull(poly.getCasillas());
	}
}
