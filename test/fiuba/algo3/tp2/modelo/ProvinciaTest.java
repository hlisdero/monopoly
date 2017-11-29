package fiuba.algo3.tp2.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class ProvinciaTest {
	private static final double DELTA = 1e-15;
	
	@Test
	public void nuevaProvinciaNoNull() {
		assertNotNull(new Provincia(0,0,0,0, null));
	}
	
	@Test
	public void getPrecioDevuelvePrecio() {
		Provincia prop = new Provincia(1000,0,0,0, null);
		assertEquals(1000, prop.getPrecio(), DELTA);
	}
		
	@Test
	public void aplicarEfectoCobraSiYaTieneUnPropietario() {
		Provincia prop = new Provincia(1000, 500, 2000, 1000, null);
		Jugador jugador1 = new Jugador(prop);
		Jugador jugador2 = new Jugador(prop);
		
		prop.setPropietario(jugador1);
		prop.aplicarEfecto(jugador2);
		
		assertEquals(99500, jugador2.getCapital(), DELTA);
	}
	
	@Test
	public void construirCasaCapitalJugadorSeReduce() {

		Provincia prop = new Provincia(20000, 2000, 5000, 8000, 3000, 3500, 5000, null);
		Jugador jugador1 = new Jugador(prop);
		
		prop.setPropietario(jugador1);
		try {
			prop.construirCasa();
		} catch (ConstruirCasaInvalidoException e) {
			e.printStackTrace();
		}
		
		assertEquals(95000, jugador1.getCapital(), DELTA);
	}
	
	@Test
	public void construirHotelCapitalJugadorSeReduce() {
		Provincia prop = new Provincia(20000, 2000, 5000, 8000, 3000, 3500, 5000, null);
		Jugador jugador1 = new Jugador(prop);
		
		prop.setPropietario(jugador1);
		try {
			prop.construirCasa();
			prop.construirCasa();
		} catch (ConstruirCasaInvalidoException e) {
			e.printStackTrace();
		}
		
		try {
			prop.construirHotel();
		} catch (ConstruirHotelInvalidoException e) {
			e.printStackTrace();
		}
		assertEquals(82000, jugador1.getCapital(), DELTA);
	}
	
	@Test
	public void jugadorQuiereVenderPropiedadPropietarioNull() {
		Provincia prop = new Provincia(1000,500,0,0, null);
		Jugador jugador1 = new Jugador(prop);
		
		prop.aplicarEfecto(jugador1);
		prop.comprar(jugador1);
		prop.vender(jugador1);
		
		assertNull(prop.getPropietario());
	}	
}
