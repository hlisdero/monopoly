package fiuba.algo3.tp2.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class PoliciaTest {

	@Test
	public void nuevaPoliciaNoEsNull() {
		assertNotNull(new Policia(new Carcel(), new GestorMovimiento()));
	}
	
	@Test
	public void aplicarEfectoMueveJugadorACarcel() {
		Carcel carcel = new Carcel();
		Policia policia = new Policia(carcel, new GestorMovimiento());
		Jugador jugador = new Jugador(policia);
		
		policia.aplicarEfecto(jugador);
		assertEquals(carcel, jugador.getCasilla());
	}

	@Test
	public void aplicarEfectoProhibeMovimientoJugador() {
		Carcel carcel = new Carcel();
		Policia policia = new Policia(carcel, new GestorMovimiento());
		Jugador jugador = new Jugador(policia);
		
		policia.aplicarEfecto(jugador);
		assertFalse(jugador.sePuedeMover());
	}

}
