package fiuba.algo3.tp2.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class ProvinciaTest {
	private static final double DELTA = 1e-15;
	
	@Test
	public void nuevaProvinciaSimpleNoNull() {
		assertNotNull(new Provincia(0, 0, 0, 0, ""));
	}
	
	@Test
	public void nuevaProvinciaDobleNoNull() {
		assertNotNull(new Provincia(0, 0, 0, 0, 0, 0, 0, ""));
	}
	
	@Test
	public void existeProvinciaHermanaInicialDevuelveFalse() {
		Provincia provincia = new Provincia(0, 0, 0, 0, "");
		assertFalse(provincia.existeProvinciaHermana());
	}
	
	@Test
	public void existeProvinciaHermanaInicialDevuelveTrueSiSetProvinciaHermana() {
		Provincia provincia = new Provincia(0, 0, 0, 0, "");
		Provincia provinciaHermana = new Provincia(0, 0, 0, 0, "");
		
		provincia.setProvinciaHermana(provinciaHermana);
		assertTrue(provincia.existeProvinciaHermana());
	}
	
	@Test
	public void sePuedeConstruirHotelInicialDevuelveFalse() {
		Provincia provincia = new Provincia(0, 0, 0, 0, "");
		assertFalse(provincia.sePuedeConstruirHotel());
	}
	
	@Test
	public void getPrecioDevuelvePrecio() {
		Provincia provincia = new Provincia(1000, 0, 0, 0, "");
		assertEquals(1000, provincia.getPrecio(), DELTA);
	}
	
	@Test
	public void aplicarEfectoNoCobraSiNoHayPropietario() {
		Provincia provincia = new Provincia(1000, 500, 0, 0, "");
		Jugador jugador = new Jugador(provincia);		
		
		provincia.aplicarEfecto(jugador);
		assertEquals(100000, jugador.getCapital(), DELTA);
	}
	
	@Test
	public void aplicarEfectoNoCobraSiCaePropietario() {
		Provincia provincia = new Provincia(0, 500, 0, 0, "");
		Jugador jugador = new Jugador(provincia);
		
		provincia.comprar(jugador);
		provincia.aplicarEfecto(jugador);
		assertEquals(100000, jugador.getCapital(), DELTA);
	}
		
	@Test
	public void aplicarEfectoCobraSiYaTieneUnPropietario() {
		Provincia provincia = new Provincia(1000, 500, 2000, 1000, "");
		Jugador jugador1 = new Jugador(provincia);
		Jugador jugador2 = new Jugador(provincia);
		
		provincia.comprar(jugador1);
		provincia.aplicarEfecto(jugador2);
		assertEquals(99500, jugador2.getCapital(), DELTA);
	}
	
	@Test
	public void aplicarEfectoCobraPrecioAlquilerCasa() throws ConstruirCasaInvalidoException {
		Provincia provincia = new Provincia(1000, 500, 2000, 1000, "");
		Jugador jugador1 = new Jugador(provincia);
		Jugador jugador2 = new Jugador(provincia);
		
		provincia.comprar(jugador1);
		provincia.construirCasa();
		provincia.aplicarEfecto(jugador2);
		assertEquals(99000, jugador2.getCapital(), DELTA);
	}
	
	@Test
	public void aplicarEfectoCobraPrecioAlquilerHotel() throws ConstruirCasaInvalidoException, ConstruirHotelInvalidoException {
		Provincia provincia = new Provincia(0, 0, 0, 0, 0, 0, 10000, "");
		Jugador jugador1 = new Jugador(provincia);
		Jugador jugador2 = new Jugador(provincia);
		
		provincia.comprar(jugador1);
		provincia.construirCasa();
		provincia.construirCasa();
		provincia.construirHotel();
		provincia.aplicarEfecto(jugador2);
		assertEquals(90000, jugador2.getCapital(), DELTA);
	}
	
	@Test
	public void construirCasaCapitalJugadorSeReduce() throws ConstruirCasaInvalidoException {
		Provincia provincia = new Provincia(0, 0, 2000, 0, 0, 0, 0, "");
		Jugador jugador = new Jugador(provincia);
		
		provincia.comprar(jugador);
		provincia.construirCasa();	
		assertEquals(98000, jugador.getCapital(), DELTA);
	}
	
	@Test
	public void construirCasaSegundaVezCapitalJugadorSeReduce() throws ConstruirCasaInvalidoException {
		Provincia provincia = new Provincia(0, 0, 2000, 0, 0, 0, 0, "");
		Jugador jugador = new Jugador(provincia);
		
		provincia.comprar(jugador);
		provincia.construirCasa();
		provincia.construirCasa();
		assertEquals(96000, jugador.getCapital(), DELTA);
	}
	
	@Test
	public void construirHotelCapitalJugadorSeReduce() throws ConstruirCasaInvalidoException, ConstruirHotelInvalidoException {
		Provincia provincia = new Provincia(0, 0, 0, 8000, 0, 0, 0, "");
		Jugador jugador = new Jugador(provincia);
		
		provincia.comprar(jugador);
		provincia.construirCasa();
		provincia.construirCasa();
		provincia.construirHotel();
		assertEquals(92000, jugador.getCapital(), DELTA);
	}
	
}
