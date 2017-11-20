package fiuba.algo3.tp2.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class PropiedadTest {
	private static final double DELTA = 1e-15;
	
	@Test
	public void nuevaPropiedadNoNull() {
		assertNotNull(new Propiedad(0,0));
	}
	
	@Test
	public void getPrecioDevuelvePrecio() {
		Propiedad prop = new Propiedad(1000,0);
		assertEquals(1000, prop.getPrecio(), DELTA);
	}
	
	@Test
	public void getPrecioDeAlquilerDevuelvePrecioDeAlquiler() {
		Propiedad prop = new Propiedad(1000,2000);
		assertEquals(2000, prop.getPrecioAlquiler(), DELTA);
	}
	
	@Test
	public void aplicarEfectoAsignaJugadorConCapitalSuficienteComoPropietario() {
		Propiedad prop = new Propiedad(1000,0);
		Jugador jugador = new Jugador(prop);
		
		prop.aplicarEfecto(jugador);
		assertEquals(jugador, prop.getPropietario());
	}
	
	@Test
	public void aplicarEfectoNoAsignaJugadorSinCapitalSuficienteComoPropietario() {
		Propiedad prop = new Propiedad(1000000,0);
		Jugador jugador = new Jugador(prop);
		
		prop.aplicarEfecto(jugador);
		assertEquals(null, prop.getPropietario());
	}
	
	@Test
	public void aplicarEfectoNoAsignaPropietarioSiYaTieneUno() {
		Propiedad prop = new Propiedad(1000,0);
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
		Propiedad prop = new Propiedad(1000,500, 2000, 1000);
		Jugador jugador1 = new Jugador(prop);
		Jugador jugador2 = new Jugador(prop);
		
		prop.aplicarEfecto(jugador1);
		prop.aplicarEfecto(jugador2);
		
		assertEquals(99500, jugador2.getCapital(), DELTA);
	}
	
	@Test
	public void construirCasaCapitalJugadorSeReduce(){
		Propiedad prop = new Propiedad(1000,500, 2000, 1000);
		Jugador jugador1 = new Jugador(prop);
		
		prop.construirCasa(jugador1);
		
		assertEquals(98000, jugador1.getCapital(), DELTA);
	}
	
	@Test
	public void construirHotelCapitalJugadorSeReduce(){
		Propiedad prop = new Propiedad(1000,500, 2000, 3000, 500, 700, 1000);
		Jugador jugador1 = new Jugador(prop);
		
		prop.construirHotel(jugador1);
		
		assertEquals(97000, jugador1.getCapital(), DELTA);
	}
	
	@Test
	public void aplicarEfectoCobraSiYaTieneUnPropietarioConUnaCasa() {
		Propiedad prop = new Propiedad(1000,500, 2000, 4000, 1000, 3000, 4000);
		Jugador jugador1 = new Jugador(prop);
		Jugador jugador2 = new Jugador(prop);
		
		prop.aplicarEfecto(jugador1);
		prop.construirCasa(jugador1);
		prop.aplicarEfecto(jugador2);
		
		assertEquals(99000, jugador2.getCapital(), DELTA);
	}
	
	@Test
	public void aplicarEfectoCobraSiYaTieneUnPropietarioConDosCasas() {
		Propiedad prop = new Propiedad(1000,500, 2000, 4000, 1000, 3000, 4000);
		Jugador jugador1 = new Jugador(prop);
		Jugador jugador2 = new Jugador(prop);
		
		prop.aplicarEfecto(jugador1);
		prop.construirCasa(jugador1);
		prop.construirCasa(jugador1);
		
		prop.aplicarEfecto(jugador2);
		
		assertEquals(97000, jugador2.getCapital(), DELTA);
	}
	
	@Test
	public void aplicarEfectoCobraSiYaTieneUnPropietarioConUnHotel() {
		Propiedad prop = new Propiedad(1000,500, 2000, 4000, 1000, 3000, 4000);
		Jugador jugador1 = new Jugador(prop);
		Jugador jugador2 = new Jugador(prop);
		
		prop.aplicarEfecto(jugador1);
		prop.construirHotel(jugador1);
		prop.aplicarEfecto(jugador2);
		
		assertEquals(96000, jugador2.getCapital(), DELTA);
	}
}
