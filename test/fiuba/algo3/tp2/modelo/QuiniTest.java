package fiuba.algo3.tp2.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class QuiniTest {

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
		assertEquals(jugador.getCapital(), 150000);
		
		quini.aplicarEfecto(jugador);
		assertEquals(jugador.getCapital(), 180000);
		
		quini.aplicarEfecto(jugador);
		assertEquals(jugador.getCapital(), 180000);
	}
	

}
