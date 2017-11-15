package fiuba.algo3.tp2.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class CarcelTest {

	@Test
	public void nuevaCarcelNoEsNull() {
		assertNotNull(new Carcel());
	}
	
	@Test
	public void estaAdentroDevuelveFalseSiNoEstaEnCarcel() {
		Jugador jugador = new Jugador(new Casilla());
		Carcel carcel = new Carcel();
		assertFalse(carcel.estaAdentro(jugador));
	}
	
	@Test
	public void aplicarEfectoMeteAlJugadorEnLaCarcel() {
		Jugador jugador = new Jugador(new Casilla());
		Carcel carcel = new Carcel();
		carcel.aplicarEfecto(jugador);
		assertTrue(carcel.estaAdentro(jugador));
	}
	
	@Test
	public void aplicarEfecto3VecesLoSacaDeLaCarcel() {
		Jugador jugador = new Jugador(new Casilla());
		Carcel carcel = new Carcel();
		carcel.aplicarEfecto(jugador);
		carcel.aplicarEfecto(jugador);
		carcel.aplicarEfecto(jugador);
		assertTrue(carcel.estaAdentro(jugador));
	}
	
}
