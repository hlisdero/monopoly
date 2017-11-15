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
	public void aplicarEfectoMeteJugadorEnCarcel() {
		Carcel carcel = new Carcel();
		Jugador jugador = new Jugador(carcel);
		
		carcel.aplicarEfecto(jugador);
		assertTrue(carcel.estaAdentro(jugador));
	}
	
	@Test
	public void aplicarEfectoDosVecesJugadorSigueEnCarcel() {
		Carcel carcel = new Carcel();
		Jugador jugador = new Jugador(carcel);
		
		carcel.aplicarEfecto(jugador);
		carcel.aplicarEfecto(jugador);
		assertTrue(carcel.estaAdentro(jugador));
	}
	
	@Test
	public void aplicarEfectoTresVecesJugadorSigueEnCarcel() {
		Carcel carcel = new Carcel();
		Jugador jugador = new Jugador(carcel);
		
		carcel.aplicarEfecto(jugador);
		carcel.aplicarEfecto(jugador);
		carcel.aplicarEfecto(jugador);
		assertTrue(carcel.estaAdentro(jugador));
	}
	
	@Test
	public void aplicarEfectoCuatroVecesJugadorAfueraCarcel() {
		Carcel carcel = new Carcel();
		Jugador jugador = new Jugador(carcel);
		
		carcel.aplicarEfecto(jugador);
		carcel.aplicarEfecto(jugador);
		carcel.aplicarEfecto(jugador);
		carcel.aplicarEfecto(jugador);
		assertFalse(carcel.estaAdentro(jugador));
	}
	
}
