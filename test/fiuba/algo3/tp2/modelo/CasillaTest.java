package fiuba.algo3.tp2.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class CasillaTest {

	@Test
	public void nuevoCasillaNoEsNull() {
		assertNotNull(new Casilla());
	}
	
	@Test
	public void aplicarEfectoNoHaceNada() {
		Casilla casilla = new Casilla();
		casilla.aplicarEfecto(null);
	}

}
