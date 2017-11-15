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
	public void primeraVezAgregaCincuentaMilAlCapital() {
		Quini quini = new Quini();
		Jugador jugador = new Jugador(quini);
		
		quini.aplicarEfecto(jugador);
		assertEquals(150000, jugador.getCapital(), DELTA);
	}
	
	@Test
	public void segundaVezAgregaTreintaMilAlCapital() {
		Quini quini = new Quini();
		Jugador jugador = new Jugador(quini);
		
		quini.aplicarEfecto(jugador);
		quini.aplicarEfecto(jugador);
		assertEquals(180000, jugador.getCapital(), DELTA);
	}
	
	@Test
	public void terceraVezNoAgregaNadaAlCapital() {
		Quini quini = new Quini();
		Jugador jugador = new Jugador(quini);
		
		quini.aplicarEfecto(jugador);
		quini.aplicarEfecto(jugador);
		quini.aplicarEfecto(jugador);
		assertEquals(180000, jugador.getCapital(), DELTA);
	}
	
	@Test
	public void segundoJugadorPrimeraVezCaeAgregaCincuentaMilAlCapital() {
		Quini quini = new Quini();
		Jugador jugador1 = new Jugador(quini);
		Jugador jugador2 = new Jugador(quini);
		
		quini.aplicarEfecto(jugador1);		
		quini.aplicarEfecto(jugador2);
		assertEquals(150000, jugador2.getCapital(), DELTA);
	}
	
	@Test
	public void segundoJugadorSegundaVezCaeAgregaTreintaMilAlCapital() {
		Quini quini = new Quini();
		Jugador jugador1 = new Jugador(quini);
		Jugador jugador2 = new Jugador(quini);
		
		quini.aplicarEfecto(jugador1);
		quini.aplicarEfecto(jugador2);
		quini.aplicarEfecto(jugador2);
		assertEquals(180000, jugador2.getCapital(), DELTA);
	}
	
	@Test
	public void segundoJugadorTerceraVezCaeNoAgregaNadaAlCapital() {
		Quini quini = new Quini();
		Jugador jugador1 = new Jugador(quini);
		Jugador jugador2 = new Jugador(quini);
		
		quini.aplicarEfecto(jugador1);
		quini.aplicarEfecto(jugador2);
		quini.aplicarEfecto(jugador2);
		quini.aplicarEfecto(jugador2);
		assertEquals(180000, jugador2.getCapital(), DELTA);
	}

}
