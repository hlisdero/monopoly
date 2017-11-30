package fiuba.algo3.tp2.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class AlquilerTest {
	private static final double DELTA = 1e-15;
	
	@Test
	public void nuevoAlquilerNoNull() {
		assertNotNull(new Alquiler(0));
	}
	
	@Test
	public void nuevoAlquilerConPrecioConstruccionNoNull() {
		assertNotNull(new Alquiler(0, 0));
	}
	
	@Test
	public void getPrecioAlquilerDevuelvePrecioAlquilerInicial() {
		Alquiler alquiler = new Alquiler(1000);
		assertEquals(1000, alquiler.getPrecioAlquiler(), DELTA);
	}
	
	@Test
	public void getPrecioVentaConstruccionInicialDevuelveCero() {
		Alquiler alquiler = new Alquiler(1000);
		assertEquals(0, alquiler.getPrecioVentaConstruccion(), DELTA);
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
	public void getPrecioAlquilerDevuelvePrecioAlquilerMejora() throws ConstruirCasaInvalidoException {
		Alquiler alquiler = new Alquiler(100);
		
		alquiler.setCantidadCasasMaxima(1);
		alquiler.agregarMejora(500, 500);
		alquiler.construirCasa();
		assertEquals(500, alquiler.getPrecioAlquiler(), DELTA);
	}
	
	@Test
	public void getPrecioConstruccionDevuelvePrecioConstruccionMejora() throws ConstruirCasaInvalidoException {
		Alquiler alquiler = new Alquiler(100);
		
		alquiler.setCantidadCasasMaxima(1);
		alquiler.agregarMejora(500, 700);
		alquiler.construirCasa();
		assertEquals(700, alquiler.getPrecioConstruccion(), DELTA);
	}
	
	@Test
	public void getPrecioVentaConstruccionDevuelvePrecioConstruccionMenosComision() throws ConstruirCasaInvalidoException {
		Alquiler alquiler = new Alquiler(1000);
		
		alquiler.setCantidadCasasMaxima(1);
		alquiler.agregarMejora(500, 1000);
		alquiler.construirCasa();
		assertEquals(850, alquiler.getPrecioVentaConstruccion(), DELTA);
	}
	
	@Test
	public void getPrecioAlquilerDevuelvePrecioAlquilerInicialSiResetearMejoras() throws ConstruirCasaInvalidoException {
		Alquiler alquiler = new Alquiler(100);
		
		alquiler.setCantidadCasasMaxima(2);
		alquiler.agregarMejora(500, 700);
		alquiler.construirCasa();
		alquiler.resetearMejoras();
		assertEquals(100, alquiler.getPrecioAlquiler(), DELTA);
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
	
	@Test
	public void getCantidadCasasDevuelveCeroSiConstruyoHotel() throws ConstruirCasaInvalidoException, ConstruirHotelInvalidoException {
		Alquiler alquiler = new Alquiler(0);
		
		alquiler.setCantidadCasasMaxima(2);
		alquiler.agregarMejora(100, 100);
		alquiler.agregarMejora(200, 100);
		alquiler.agregarMejora(400, 250);
		alquiler.construirCasa();
		alquiler.construirCasa();
		alquiler.construirHotel();
		assertEquals(0, alquiler.getCantidadCasas());
	}
	
	@Test
	public void getPrecioAlquilerDevuelvePrecioAlquilerHotel() throws ConstruirCasaInvalidoException, ConstruirHotelInvalidoException {
		Alquiler alquiler = new Alquiler(50);
		
		alquiler.setCantidadCasasMaxima(2);
		alquiler.agregarMejora(100, 100);
		alquiler.agregarMejora(200, 100);
		alquiler.agregarMejora(400, 700);
		alquiler.construirCasa();
		alquiler.construirCasa();
		alquiler.construirHotel();
		assertEquals(400, alquiler.getPrecioAlquiler(), DELTA);
	}
	
	@Test
	public void getPrecioConstruccionDevuelvePrecioConstruccionHotel() throws ConstruirCasaInvalidoException, ConstruirHotelInvalidoException {
		Alquiler alquiler = new Alquiler(50);
		
		alquiler.setCantidadCasasMaxima(2);
		alquiler.agregarMejora(100, 100);
		alquiler.agregarMejora(200, 100);
		alquiler.agregarMejora(400, 700);
		alquiler.construirCasa();
		alquiler.construirCasa();
		alquiler.construirHotel();
		assertEquals(700, alquiler.getPrecioConstruccion(), DELTA);
	}

}
