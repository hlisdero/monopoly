package fiuba.algo3.tp2.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class PropiedadTest {
	private static final double DELTA = 1e-15;
	
	@Test
	public void nuevaPropiedadNoNull() {
		assertNotNull(new Propiedad(0,0,0,0));
	}
	
	@Test
	public void getPrecioDevuelvePrecio() {
		Propiedad prop = new Propiedad(1000,0,0,0);
		assertEquals(1000, prop.getPrecio(), DELTA);
	}
	
	@Test
	public void aplicarEfectoAsignaJugadorConCapitalSuficienteComoPropietario() {
		Propiedad prop = new Propiedad(1000,0,0,0);
		Jugador jugador = new Jugador(prop);
		
		prop.aplicarEfecto(jugador);
		assertEquals(jugador, prop.getPropietario());
	}
	
	@Test
	public void aplicarEfectoNoAsignaJugadorSinCapitalSuficienteComoPropietario() {
		Propiedad prop = new Propiedad(1000000,0,0,0);
		Jugador jugador = new Jugador(prop);
		
		prop.aplicarEfecto(jugador);
		assertEquals(null, prop.getPropietario());
	}
	
	@Test
	public void aplicarEfectoNoAsignaPropietarioSiYaTieneUno() {
		Propiedad prop = new Propiedad(1000,0,0,0);
		Jugador jugador1 = new Jugador(prop);
		Jugador jugador2 = new Jugador(prop);
		
		prop.aplicarEfecto(jugador1);
		prop.aplicarEfecto(jugador2);
		assertEquals(jugador1, prop.getPropietario());
	}
	
	@Test
	public void aplicarEfectoAsignaPropietarioYReduceSuCapital() {
		Propiedad prop = new Propiedad(1000,500, 2000, 1000);
		Jugador jugador1 = new Jugador(prop);
		
		prop.aplicarEfecto(jugador1);
		
		assertEquals(99000, jugador1.getCapital(), DELTA);
	}
	
	@Test
	public void aplicarEfectoCobraSiYaTieneUnPropietario() {
		Propiedad prop = new Propiedad(1000, 500, 2000, 1000);
		Jugador jugador1 = new Jugador(prop);
		Jugador jugador2 = new Jugador(prop);
		
		prop.aplicarEfecto(jugador1);
		prop.aplicarEfecto(jugador2);
		
		assertEquals(99500, jugador2.getCapital(), DELTA);
	}
	
	@Test
	public void construirCasaCapitalJugadorSeReduce() {

		Propiedad prop = new Propiedad(20000, 2000, 5000, 8000, 3000, 3500, 5000);
		Jugador jugador1 = new Jugador(prop);
		
		try {
			prop.construirCasa(jugador1);
		} catch (ConstruirCasaInvalidoException e) {
			e.printStackTrace();
		}
		
		assertEquals(95000, jugador1.getCapital(), DELTA);
	}
	
	@Test
	public void construirHotelCapitalJugadorSeReduce() {
		Propiedad prop = new Propiedad(20000, 2000, 5000, 8000, 3000, 3500, 5000);
		Jugador jugador1 = new Jugador(prop);
		
		try {
			prop.construirCasa(jugador1);
			prop.construirCasa(jugador1);
		} catch (ConstruirCasaInvalidoException e) {
			e.printStackTrace();
		}
		
		try {
			prop.construirHotel(jugador1);
		} catch (ConstruirHotelInvalidoException e) {
			e.printStackTrace();
		}
		assertEquals(82000, jugador1.getCapital(), DELTA);
	}
	
	@Test
	public void aplicarEfectoCobraSiYaTieneUnPropietarioConUnaCasa() {
		Propiedad prop = new Propiedad(20000, 2000, 5000, 8000, 3000, 3500, 5000);
		Jugador jugador1 = new Jugador(prop);
		Jugador jugador2 = new Jugador(prop);
		
		prop.aplicarEfecto(jugador1);
		try {
			prop.construirCasa(jugador1);
		} catch (ConstruirCasaInvalidoException e) {
			e.printStackTrace();
		}
		prop.aplicarEfecto(jugador2);
		
		assertEquals(97000, jugador2.getCapital(), DELTA);
	}
	
	@Test
	public void aplicarEfectoCobraSiYaTieneUnPropietarioConDosCasas() {
		Propiedad prop = new Propiedad(20000, 2000, 5000, 8000, 3000, 3500, 5000);
		Jugador jugador1 = new Jugador(prop);
		Jugador jugador2 = new Jugador(prop);
		
		prop.aplicarEfecto(jugador1);
		try {
			prop.construirCasa(jugador1);
			prop.construirCasa(jugador1);
		} catch (ConstruirCasaInvalidoException e) {
			e.printStackTrace();
		}	
		prop.aplicarEfecto(jugador2);
		
		assertEquals(96500, jugador2.getCapital(), DELTA);
	}
	
	@Test
	public void aplicarEfectoCobraSiYaTieneUnPropietarioConUnHotel() {
		Propiedad prop = new Propiedad(1000,500, 2000, 4000, 1000, 3000, 4000);
		Jugador jugador1 = new Jugador(prop);
		Jugador jugador2 = new Jugador(prop);
		
		prop.aplicarEfecto(jugador1);
		try {
			prop.construirCasa(jugador1);
			prop.construirCasa(jugador1);
		} catch (ConstruirCasaInvalidoException e) {
			e.printStackTrace();
		}
		
		try {
			prop.construirHotel(jugador1);
		} catch (ConstruirHotelInvalidoException e) {
			e.printStackTrace();
		}
		prop.aplicarEfecto(jugador2);
		
		assertEquals(96000, jugador2.getCapital(), DELTA);
	}
	
	@Test
	public void aplicarEfectoAlquilerPropiedadCapitalJugadorSeAcredita() {
		Propiedad prop = new Propiedad(1000,500, 2000, 4000, 1000, 3000, 4000);
		Jugador jugador1 = new Jugador(prop);
		Jugador jugador2 = new Jugador(prop);
		
		prop.aplicarEfecto(jugador1);
		prop.aplicarEfecto(jugador2);
		
		assertEquals(100000-1000+500, jugador1.getCapital(),DELTA);
	}
	
	@Test
	public void jugadorQuiereVenderPropiedadSeAcreditaMontoMenos15Porciento() {
		
		Propiedad prop = new Propiedad(1000,500,0,0);
		Jugador jugador1 = new Jugador(prop);
		
		prop.aplicarEfecto(jugador1);
		prop.jugadorVendePropiedad(jugador1);
		
		assertEquals(100000-1000+prop.getPrecioDeVenta(), jugador1.getCapital(), DELTA);
	}
	
	@Test
	public void jugadorQuiereVenderPropiedadPropietarioNull() {
		Propiedad prop = new Propiedad(1000,500,0,0);
		Jugador jugador1 = new Jugador(prop);
		
		prop.aplicarEfecto(jugador1);
		prop.jugadorVendePropiedad(jugador1);
		
		assertNull(prop.getPropietario());
	}
	
}
