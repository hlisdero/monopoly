package fiuba.algo3.tp2.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class ResultadoDadosTest {
	
	@Test
	public void nuevoResultadoDadosNoNull() {
		assertNotNull(new ResultadoDados(1,2));
	}
	
	@Test
	public void getSumaDevuelveSuma() {
		ResultadoDados resultado = new ResultadoDados(1,5);
		assertEquals(resultado.getSuma(), 6);
	}
	
	@Test
	public void esDobleDevuelveTrueSiDadosIguales() {
		ResultadoDados resultado = new ResultadoDados(5,5);
		assertTrue(resultado.esDoble());
	}

	@Test
	public void esDobleDevuelveFalseSiDadosDistintos() {
		ResultadoDados resultado = new ResultadoDados(3,5);
		assertFalse(resultado.esDoble());
	}
	
	@Test(expected = ValoresDadoInvalidosException.class)
	public void nuevoDadoLanzaExcepcionPrimerDatoInvalido() {
		new ResultadoDados(0,1);
	}
	
	@Test(expected = ValoresDadoInvalidosException.class)
	public void nuevoDadoLanzaExcepcionSegundoDatoInvalido() {
		new ResultadoDados(2,7);
	}
	
	@Test(expected = ValoresDadoInvalidosException.class)
	public void nuevoDadoLanzaExcepcionDosDatosInvalidos() {
		new ResultadoDados(8,0);
	}
}
