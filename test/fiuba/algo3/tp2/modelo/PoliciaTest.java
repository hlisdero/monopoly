package fiuba.algo3.tp2.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class PoliciaTest {

	@Test
	public void nuevaPoliciaNoEsNull() {
		assertNotNull(new Policia(1));
	}
	
	@Test
	public void getIndiceDevuelveElIndiceConElCualFueCreado() {
		Policia pol = new Policia(1);
		assertEquals(1,pol.getIndiceCasillaSiguiente(2, Dados.tirarDados()));
	}
}
