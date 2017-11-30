package fiuba.algo3.tp2.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class AlquilerTest {

	@Test
	public void nuevoAlquilerNoNull() {
		assertNotNull(new Alquiler(0));
	}
	
	@Test
	public void nuevoAlquilerConPrecioConstruccionNoNull() {
		assertNotNull(new Alquiler(0, 0));
	}
	
	@Test
	public void getCantidadCasasInicialDevuelveCero() {
		Alquiler alquiler = new Alquiler(0);
		assertEquals(0, alquiler.getCantidadCasas());
	}
	
	@Test
	public void tieneHotelInicialDevuelveFalse() {
		Alquiler alquiler = new Alquiler(0);
		assertFalse(alquiler.tieneHotel());
	}
	
	@Test
	public void hayCantidadCasasMaximaDevuelveFalseSiSeteaCantidadCasasMaxima() {
		Alquiler alquiler = new Alquiler(0);
		
		alquiler.setCantidadCasasMaxima(2);
		assertFalse(alquiler.hayCantidadCasasMaxima());
	}
	
	@Test
	public void construirCasaAumentaCantidadCasas() throws ConstruirCasaInvalidoException {
		Alquiler alquiler = new Alquiler(0);
		
		alquiler.setCantidadCasasMaxima(2);
		alquiler.agregarMejora(100, 100);
		alquiler.construirCasa();
		assertEquals(1, alquiler.getCantidadCasas());
	}
	
	@Test
	public void construirCasaDosVecesAumentaCantidadCasas() throws ConstruirCasaInvalidoException {
		Alquiler alquiler = new Alquiler(0);
		
		alquiler.setCantidadCasasMaxima(2);
		alquiler.agregarMejora(100, 100);
		alquiler.agregarMejora(200, 100);
		alquiler.construirCasa();
		alquiler.construirCasa();
		assertEquals(2, alquiler.getCantidadCasas());
	}
	
	@Test
	public void hayCantidadCasasMaximaDevuelveTrueSiCantidadCasasMaxima() throws ConstruirCasaInvalidoException {
		Alquiler alquiler = new Alquiler(50);
		
		alquiler.setCantidadCasasMaxima(2);
		alquiler.agregarMejora(100, 100);
		alquiler.agregarMejora(200, 100);
		alquiler.construirCasa();
		alquiler.construirCasa();
		assertTrue(alquiler.hayCantidadCasasMaxima());
	}
	
	@Test(expected = ConstruirCasaInvalidoException.class)
	public void construirMasCasasQueLaCantidadMaximaLanzaExcepcion() throws ConstruirCasaInvalidoException {
		Alquiler alquiler = new Alquiler(50);
		
		alquiler.setCantidadCasasMaxima(2);
		alquiler.agregarMejora(100, 100);
		alquiler.agregarMejora(200, 100);
		alquiler.construirCasa();
		alquiler.construirCasa();
		alquiler.construirCasa();
	}
	
	@Test(expected = ConstruirHotelInvalidoException.class)
	public void construirHotelLanzaExcepcionSiNoConstruyoCasas() throws ConstruirHotelInvalidoException {
		Alquiler alquiler = new Alquiler(50);
		
		alquiler.setCantidadCasasMaxima(2);
		alquiler.agregarMejora(100, 100);
		alquiler.agregarMejora(200, 100);
		alquiler.construirHotel();
	}
	
	@Test(expected = ConstruirHotelInvalidoException.class)
	public void construirHotelLanzaExcepcionSiConstruyoMenosCasasQueCantidadMaxima() throws ConstruirCasaInvalidoException, ConstruirHotelInvalidoException {
		Alquiler alquiler = new Alquiler(50);
		
		alquiler.setCantidadCasasMaxima(2);
		alquiler.agregarMejora(100, 100);
		alquiler.agregarMejora(200, 100);
		alquiler.construirCasa();
		alquiler.construirHotel();
	}
	
	@Test
	public void tieneHotelDevuelveTrueSiConstruyoHotel() throws ConstruirCasaInvalidoException, ConstruirHotelInvalidoException {
		Alquiler alquiler = new Alquiler(0);
		
		alquiler.setCantidadCasasMaxima(2);
		alquiler.agregarMejora(100, 100);
		alquiler.agregarMejora(200, 100);
		alquiler.agregarMejora(400, 250);
		alquiler.construirCasa();
		alquiler.construirCasa();
		alquiler.construirHotel();
		assertTrue(alquiler.tieneHotel());
	}

}
