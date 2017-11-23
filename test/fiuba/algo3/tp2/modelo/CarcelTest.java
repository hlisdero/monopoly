package fiuba.algo3.tp2.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class CarcelTest {
	private static final double DELTA = 1e-15;
	
	@Test
	public void nuevaCarcelNoNull() {
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
	public void despuesPrimerTurnoJugadorSigueEnCarcel() {
		Carcel carcel = new Carcel();
		Jugador jugador = new Jugador(carcel);
		
		carcel.aplicarEfecto(jugador);
		carcel.contarTurno(jugador);
		assertTrue(carcel.estaAdentro(jugador));
	}
	
	@Test
	public void despuesSegundoTurnoJugadorSigueEnCarcel() {
		Carcel carcel = new Carcel();
		Jugador jugador = new Jugador(carcel);
		
		carcel.aplicarEfecto(jugador);
		carcel.contarTurno(jugador);
		carcel.contarTurno(jugador);
		assertTrue(carcel.estaAdentro(jugador));
	}
	
	@Test
	public void despuesTercerTurnoJugadorAfueraCarcel() {
		Carcel carcel = new Carcel();
		Jugador jugador = new Jugador(carcel);
		
		carcel.aplicarEfecto(jugador);
		carcel.contarTurno(jugador);
		carcel.contarTurno(jugador);
		carcel.contarTurno(jugador);
		carcel.contarTurno(jugador);
		assertFalse(carcel.estaAdentro(jugador));
	}
	
	@Test
	public void pagarFianzaLiberaJugador() {
		Carcel carcel = new Carcel();
		Jugador jugador = new Jugador(carcel);
		
		carcel.aplicarEfecto(jugador);
		carcel.contarTurno(jugador);
		carcel.contarTurno(jugador);
		carcel.pagarFianza(jugador);
		assertFalse(carcel.estaAdentro(jugador));
	}
	
	@Test
	public void pagarFianzaRestaCuarentaYCincoMilAlCapitalJugador() {
		Carcel carcel = new Carcel();
		Jugador jugador = new Jugador(carcel);
		
		carcel.aplicarEfecto(jugador);
		carcel.contarTurno(jugador);
		carcel.contarTurno(jugador);
		carcel.pagarFianza(jugador);
		assertEquals(55000, jugador.getCapital(), DELTA);
	}
	
	@Test
	public void jugadorConCapitalInsuficienteNoPuedePagarFianza() {
		Carcel carcel = new Carcel();
		Jugador jugador = new Jugador(carcel);
		
		jugador.restarDinero(60000);
		carcel.aplicarEfecto(jugador);
		carcel.contarTurno(jugador);
		carcel.pagarFianza(jugador);
		assertTrue(carcel.estaAdentro(jugador));
	}
	
	@Test
	public void jugadorPrimerTurnoCarcelNoPuedePagarFianza() {
		Carcel carcel = new Carcel();
		Jugador jugador = new Jugador(carcel);
		
		carcel.aplicarEfecto(jugador);
		carcel.contarTurno(jugador);
		carcel.pagarFianza(jugador);
		assertTrue(carcel.estaAdentro(jugador));
	}
}
