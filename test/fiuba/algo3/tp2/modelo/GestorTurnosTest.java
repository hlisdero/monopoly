package fiuba.algo3.tp2.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class GestorTurnosTest {

	@Test
	public void nuevoGestorTurnosNoEsNull() {
		assertNotNull(new GestorTurnos(new CasillaPrueba()));
	}
	
	@Test
	public void nuevoGestorTurnosGetCantidadJugadoresDevuelveTres() {
		GestorTurnos gestorTurnos = new GestorTurnos(new CasillaPrueba());
		assertEquals(3, gestorTurnos.getCantidadJugadores());
	}
	
	@Test
	public void proximoJugadorNoNull() {
		GestorTurnos gestorTurnos = new GestorTurnos(new CasillaPrueba());
		assertNotNull(gestorTurnos.proximoJugador());
	}

}
