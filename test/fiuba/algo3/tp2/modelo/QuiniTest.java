package fiuba.algo3.tp2.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class QuiniTest {
	private static final double DELTA = 1e-15;

	@Test
	public void nuevoQuiniNoNull() {
		assertNotNull(new Quini());
	}
	
	@Test
	public void aplicarEfecto()
	{
		Quini quini = new Quini();
		Jugador jugador = new Jugador(quini);
		
		quini.aplicarEfecto(jugador);
		assertEquals(jugador.getCapital(), 150000, DELTA);
		
		quini.aplicarEfecto(jugador);
		assertEquals(jugador.getCapital(), 180000, DELTA);
		
		quini.aplicarEfecto(jugador);
		assertEquals(jugador.getCapital(), 180000, DELTA);
	}
	
	@Test
	public void aplicarEfectoSobreJugadores()
	{
		Quini quini = new Quini();
		Jugador jugador1 = new Jugador(quini);
		Jugador jugador2 = new Jugador(quini);
		
		quini.aplicarEfecto(jugador1);
		assertEquals(jugador1.getCapital(), 150000, DELTA);
		
		quini.aplicarEfecto(jugador2);
		assertEquals(jugador2.getCapital(), 150000, DELTA);
	}
}
