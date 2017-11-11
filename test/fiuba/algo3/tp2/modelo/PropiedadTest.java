package fiuba.algo3.tp2.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class PropiedadTest {
	private static final double DELTA = 1e-15;
	
	@Test
	public void nuevaPropiedadNoNull() {
		assertNotNull(new Propiedad(0));
	}
	
	@Test
	public void getPrecioDevuelvePrecio() {
		Propiedad prop = new Propiedad(1000);
		assertEquals(1000, prop.getPrecio(), DELTA);
	}
	
	@Test
	public void setPropietarioDevuelvePropietario() {
		Propiedad prop = new Propiedad(1000);
		Jugador jugador = new Jugador(prop);
		prop.setPropietario(jugador);
		assertEquals(jugador, prop.getPropietario());
	}
	@Test
	public void jugadorAplicarEfecto() {
		Propiedad prop = new Propiedad(1000);
		Jugador jugador = new Jugador(prop);
		prop.aplicarEfecto(jugador);
		assertEquals(jugador, prop.getPropietario());
	}
	@Test
	public void jugador1YaEsPropietarioJugador2NoAplicaEfecto() {
		Propiedad prop = new Propiedad(1000);
		Jugador jugador1 = new Jugador(prop);
		Jugador jugador2 = new Jugador(prop);
		prop.aplicarEfecto(jugador1);
		prop.aplicarEfecto(jugador2);
		assertEquals(jugador1, prop.getPropietario());
	}

}
