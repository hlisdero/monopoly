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
	
	
	@Test(expected = ConstruirCasaInvalidoException.class)
	public void construirCasaLanzaExcepcionSiPropietariosDiferentes() throws ConstruirCasaInvalidoException {
		Provincia provincia1 = new Provincia(0, 0, 0, 0, 0, 0, 0, "");
		Provincia provincia2 = new Provincia(0, 0, 0, 0, 0, 0, 0, "");
		Jugador jugador1 = new Jugador(provincia1);
		Jugador jugador2 = new Jugador(provincia2);
		
		provincia1.setProvinciaHermana(provincia2);
		provincia1.comprar(jugador1);
		provincia2.comprar(jugador2);
		provincia1.construirCasa();
	}
	
	@Test
	public void sePuedeConstruirHotelDevuelveFalseSiProvinciaActualNoTieneCantidadMaximaCasas() throws ConstruirCasaInvalidoException {
		Provincia provincia1 = new Provincia(0, 0, 0, 0, 0, 0, 0, "");
		Provincia provincia2 = new Provincia(0, 0, 0, 0, 0, 0, 0, "");
		Jugador jugador = new Jugador(provincia1);
		
		provincia1.setProvinciaHermana(provincia2);
		provincia1.comprar(jugador);
		provincia2.comprar(jugador);
		provincia1.construirCasa();
		provincia2.construirCasa();
		provincia2.construirCasa();
		assertFalse(provincia1.sePuedeConstruirHotel());
	}
	
	@Test
	public void sePuedeConstruirHotelDevuelveFalseSiProvinciaHermanaNoTieneCantidadMaximaCasas() throws ConstruirCasaInvalidoException {
		Provincia provincia1 = new Provincia(0, 0, 0, 0, 0, 0, 0, "");
		Provincia provincia2 = new Provincia(0, 0, 0, 0, 0, 0, 0, "");
		Jugador jugador = new Jugador(provincia1);
		
		provincia1.setProvinciaHermana(provincia2);
		provincia1.comprar(jugador);
		provincia2.comprar(jugador);
		provincia1.construirCasa();
		provincia1.construirCasa();
		provincia2.construirCasa();
		assertFalse(provincia1.sePuedeConstruirHotel());
	}
	
	@Test
	public void sePuedeConstruirHotelDevuelveTrueSiProvinciaActualYHermanaCantidadMaximaCasas() throws ConstruirCasaInvalidoException {
		Provincia provincia1 = new Provincia(0, 0, 0, 0, 0, 0, 0, "");
		Provincia provincia2 = new Provincia(0, 0, 0, 0, 0, 0, 0, "");
		Jugador jugador = new Jugador(provincia1);
		
		provincia1.comprar(jugador);
		provincia2.comprar(jugador);
		provincia1.setProvinciaHermana(provincia2);
		provincia1.construirCasa();
		provincia1.construirCasa();
		provincia2.construirCasa();
		provincia2.construirCasa();
		assertTrue(provincia1.sePuedeConstruirHotel());
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
	
	@Test
	public void tieneHotelDevuelveTrueSiTieneHotel() throws ConstruirCasaInvalidoException, ConstruirHotelInvalidoException {
		Provincia provincia = new Provincia(0, 0, 0, 0, 0, 0, 0, "");
		Jugador jugador = new Jugador(provincia);
		
		provincia.comprar(jugador);
		provincia.construirCasa();
		provincia.construirCasa();
		provincia.construirHotel();
		assertTrue(provincia.tieneHotel());
	}
	
	@Test
	public void venderNoHaceNadaSiNoEsPropietario() {
		Provincia provincia = new Provincia(0, 0, 0, 0, "");
		Jugador jugador = new Jugador(provincia);
		provincia.vender(jugador);
	}

	@Test
	public void venderCambiaPropietario() {
		Provincia provincia = new Provincia(0, 0, 0, 0, "");
		Jugador jugador = new Jugador(provincia);
		
		provincia.comprar(jugador);
		provincia.vender(jugador);
		assertFalse(provincia.tienePropietario());
	}
	
	@Test
	public void venderConConstruccionesAgregaPrecioVentaCapitalPropietario() throws ConstruirCasaInvalidoException, ConstruirHotelInvalidoException {
		Provincia provincia = new Provincia(0, 0, 2500, 5000, 0, 0, 0, "");
		Jugador jugador = new Jugador(provincia);
		
		provincia.comprar(jugador);
		provincia.construirCasa();
		provincia.construirCasa();
		provincia.construirHotel();
		provincia.vender(jugador);
		assertEquals(90000 + 5000*0.85, jugador.getCapital(), DELTA);
	}

	@Test
	public void venderReseteaMejoras() throws ConstruirCasaInvalidoException, ConstruirHotelInvalidoException {
		Provincia provincia = new Provincia(0, 0, 0, 0, 0, 0, 0, "");
		Jugador jugador = new Jugador(provincia);
		
		provincia.comprar(jugador);
		provincia.construirCasa();
		provincia.construirCasa();
		provincia.construirHotel();
		provincia.vender(jugador);
		assertEquals(0, provincia.getCantidadCasas());
	}
	
}
