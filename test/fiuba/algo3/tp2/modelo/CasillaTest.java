package fiuba.algo3.tp2.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class CasillaTest {
	@Test
	public void nuevoCasillaNoEsNull() {
		assertNotNull(new Casilla());
	}
	
	@Test
	public void getIndiceSiguienteDevuelveElNumeroCorrecto() {
		Casilla c = new Casilla();
		ResultadoDados dados = Dados.tirarDados();
		assertEquals(dados.getSuma() + 1, c.getIndiceCasillaSiguiente(1, dados));
	}

}
