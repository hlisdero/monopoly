package fiuba.algo3.tp2.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class PoliciaTest {

	@Test
	public void nuevaPoliciaNoEsNull() {
		assertNotNull(new Policia(1, new GestorMovimiento()));
	}
	
}
