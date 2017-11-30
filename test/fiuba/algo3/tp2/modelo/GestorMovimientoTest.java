package fiuba.algo3.tp2.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class GestorMovimientoTest {
	private static final double DELTA = 1e-15;
	
	@Test
	public void nuevoGestorNoEsNull() {
		assertNotNull(new GestorMovimiento());
	}

	@Test
	public void getCasillaInicialDevuelveCasillaInicial() {
		GestorMovimiento gestor = new GestorMovimiento();
		assertNotNull(gestor.getCasillaInicial());
	}
	
	@Test
	public void moverJugadorCasillaCambiaCasillaJugador() {
		GestorMovimiento gestor = new GestorMovimiento();
		Casilla casilla = new Casilla();
		Jugador jugador = new Jugador(gestor.getCasillaInicial());
		
		gestor.mover(jugador, casilla);
		assertEquals(casilla, jugador.getCasilla());
	}
	
	@Test
	public void moverJugadorCasillaAplicaEfecto() {
		GestorMovimiento gestor = new GestorMovimiento();
		Jugador jugador = new Jugador(gestor.getCasillaInicial());
		CasillaPrueba casilla = new CasillaPrueba();
		
		gestor.mover(jugador, casilla);
		assertTrue(casilla.llamoAplicarEfecto());
	}
	
	@Test
	public void moverJugadorNoHaceNadaSiJugadorNoPuedeMoverse() {
		GestorMovimiento gestor = new GestorMovimiento();
		Jugador jugador = new Jugador(gestor.getCasillaInicial());
		
		jugador.prohibirMovimiento();
		gestor.mover(jugador);
		assertEquals(gestor.getCasillaInicial(), jugador.getCasilla());
	}

	@Test
	public void moverJugadorPosicionesNoHaceNadaSiJugadorNoPuedeMoverse() {
		GestorMovimiento gestor = new GestorMovimiento();
		Jugador jugador = new Jugador(gestor.getCasillaInicial());
		
		jugador.prohibirMovimiento();
		gestor.mover(jugador, 5);
		assertEquals(gestor.getCasillaInicial(), jugador.getCasilla());
	}
	
	/***********************************************************************
	 * Las pruebas siguientes asumen la configuración correcta del Tablero
	 ***********************************************************************/
	
	@Test
	public void moverJugadorPosicionesVeinteDejaMismoLugar() {
		GestorMovimiento gestor = new GestorMovimiento();
		Jugador jugador = new Jugador(gestor.getCasillaInicial());
		
		gestor.mover(jugador, 20);
		assertEquals(gestor.getCasillaInicial(), jugador.getCasilla());
	}
	
	
	@Test
	public void moverJugadorPosicionesCaeEnCarcel() {
		GestorMovimiento gestor = new GestorMovimiento();
		Jugador jugador = new Jugador(gestor.getCasillaInicial());
		
		gestor.mover(jugador, 5);
		assertFalse(jugador.sePuedeMover());
	}
	
	@Test
	public void moverJugadorPosicionesCaeEnImpuesto() {
		GestorMovimiento gestor = new GestorMovimiento();
		Jugador jugador = new Jugador(gestor.getCasillaInicial());
		
		gestor.mover(jugador, 10);
		assertEquals(90000, jugador.getCapital(), DELTA);
	}
	
	@Test
	public void moverJugadorPosicionesCaeEnPolicia() {
		GestorMovimiento gestor = new GestorMovimiento();
		Jugador jugador = new Jugador(gestor.getCasillaInicial());
		
		gestor.mover(jugador, 15);
		assertFalse(jugador.sePuedeMover());
	}
	
	@Test
	public void moverJugadorPosicionesDosJugadoresLleganMismoLugar() {
		GestorMovimiento gestor = new GestorMovimiento();
		Jugador jugador1 = new Jugador(gestor.getCasillaInicial());
		Jugador jugador2 = new Jugador(gestor.getCasillaInicial());
		
		gestor.mover(jugador1, 10);
		gestor.mover(jugador2, 4);
		gestor.mover(jugador2, 6);
		assertEquals(jugador1.getCasilla(), jugador2.getCasilla());
	}
	
	@Test
	public void moverJugadorPosicionesDosJugadoresTerminanCarcel() {
		GestorMovimiento gestor = new GestorMovimiento();
		Jugador jugador1 = new Jugador(gestor.getCasillaInicial());
		Jugador jugador2 = new Jugador(gestor.getCasillaInicial());
		
		gestor.mover(jugador1, 5);
		gestor.mover(jugador2, 15);
		assertEquals(jugador1.getCasilla(), jugador2.getCasilla());
	}
	
}
