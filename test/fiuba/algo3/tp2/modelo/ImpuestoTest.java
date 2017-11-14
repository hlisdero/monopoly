package fiuba.algo3.tp2.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class ImpuestoTest {
	private static final double DELTA = 1e-15;

	@Test
	public void nuevoImpuestoNoEsNull() {
		assertNotNull(new Impuesto());
	}
	
	@Test
	public void aplicarEfectoRestaDiezPorCientoCapital() {
		Impuesto impuesto = new Impuesto();
		Jugador jugador = new Jugador(impuesto);
		impuesto.aplicarEfecto(jugador);
		assertEquals(90000, jugador.getCapital(), DELTA);
	}

}
