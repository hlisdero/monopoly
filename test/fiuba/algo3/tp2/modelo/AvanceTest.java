package fiuba.algo3.tp2.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class AvanceTest {

	@Test
	public void nuevoAvanceNoNull() {
		assertNotNull(new Avance());
	}
	
	@Test
	public void getIndiceMovimientoSumaDadosSeis() {
		Jugador jugador = new Jugador(new Casilla(), 3, 3);
		Avance avance = new Avance();
		assertEquals(4, avance.getIndiceMovimiento(jugador));
	}
	
	@Test
	public void getIndiceMovimientoSumaDadosDiez() {
		Jugador jugador = new Jugador(new Casilla(), 5, 5);
		Avance avance = new Avance();
		assertEquals(0, avance.getIndiceMovimiento(jugador));
	}
	
	@Test
	public void getIndiceMovimientoSumaDadosDoce() {
		Jugador jugador = new Jugador(new Casilla(), 6, 6);
		Avance avance = new Avance();
		assertEquals(12, avance.getIndiceMovimiento(jugador));
	}


}
