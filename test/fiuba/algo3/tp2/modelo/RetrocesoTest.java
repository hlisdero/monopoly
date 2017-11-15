package fiuba.algo3.tp2.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class RetrocesoTest {

	@Test
	public void nuevoRetrocesoNoNull() {
		assertNotNull(new Retroceso());
	}
	
	@Test
	public void getIndiceMovimientoSumaDadosSeis() {
		Jugador jugador = new Jugador(new Casilla(), 3, 3);
		Retroceso avance = new Retroceso();
		assertEquals(-6, avance.getIndiceMovimiento(jugador));
	}
	
	@Test
	public void getIndiceMovimientoSumaDadosDiez() {
		Jugador jugador = new Jugador(new Casilla(), 5, 5);
		Retroceso avance = new Retroceso();
		assertEquals(0, avance.getIndiceMovimiento(jugador));
	}
	
	@Test
	public void getIndiceMovimientoSumaDadosDoce() {
		Jugador jugador = new Jugador(new Casilla(), 6, 6);
		Retroceso avance = new Retroceso();
		assertEquals(-10, avance.getIndiceMovimiento(jugador));
	}

}
