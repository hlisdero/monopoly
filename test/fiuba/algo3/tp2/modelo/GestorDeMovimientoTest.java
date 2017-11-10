package fiuba.algo3.tp2.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class GestorDeMovimientoTest {

	@Test
	public void nuevoGestorNoEsNull() {
		assertNotNull(new GestorDeMovimiento());
	}

	@Test
	public void getCasillaInicialNoDevuelveNull() {
		GestorDeMovimiento gestor = new GestorDeMovimiento();
		assertNotNull(gestor.getCasillaInicial());
	}
}
