package fiuba.algo3.tp2.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class GestorMovimientoTest {

	@Test
	public void nuevoGestorNoEsNull() {
		assertNotNull(new GestorMovimiento());
	}

	@Test
	public void getCasillaInicialDevuelveCasillaInicial() {
		GestorMovimiento gestor = new GestorMovimiento();
		assertNotNull(gestor.getCasillaInicial());
	}
}
