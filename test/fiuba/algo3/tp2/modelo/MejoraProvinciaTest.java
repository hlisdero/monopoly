package fiuba.algo3.tp2.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class MejoraProvinciaTest {
	private static final double DELTA = 1e-15;
	
	@Test
	public void nuevaMejoraProvinciaNoNull() {
		assertNotNull(new MejoraProvincia(0));
	}

	@Test
	public void nuevaMejoraProvinciaConPrecioConstruccionNoNull() {
		assertNotNull(new MejoraProvincia(0,0));
	}
	
	@Test
	public void getPrecioAlquilerDevuelvePrecioAlquiler() {
		MejoraProvincia mejora = new MejoraProvincia(1000, 0);
		assertEquals(1000, mejora.getPrecioAlquiler(), DELTA);
	}
	
	@Test
	public void getPrecioConstruccionDevuelvePrecioConstruccion() {
		MejoraProvincia mejora = new MejoraProvincia(2500, 5000);
		assertEquals(5000, mejora.getPrecioConstruccion(), DELTA);
	}

}
