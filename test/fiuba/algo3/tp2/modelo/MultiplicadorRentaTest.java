package fiuba.algo3.tp2.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class MultiplicadorRentaTest {
	private static final double DELTA = 1e-15;

	@Test
	public void nuevoMultiplicadorRentaNoNull() {
		assertNotNull(new MultiplicadorRenta(0,0));
	}

	@Test
	public void getMultiplicadorDevuelvePrimerMultiplicadorSiEmpresaHermanaNull() {
		Empresa empresa = new Empresa(0,0,0, "");
		MultiplicadorRenta multiplicador = new MultiplicadorRenta(100, 0);
		
		assertEquals(100, multiplicador.getMultiplicador(empresa, null), DELTA);
	}

	@Test
	public void getMultiplicadorDevuelveSegundoMultiplicadorSiEmpresasMismosPropietarios() {
		Empresa empresa = new Empresa(0,0,0, "");
		empresa.setPropietario(new Jugador(new Casilla()));
		
		MultiplicadorRenta multiplicador = new MultiplicadorRenta(100, 500);
		assertEquals(500, multiplicador.getMultiplicador(empresa, empresa), DELTA);
	}
	
	@Test
	public void getMultiplicadorDevuelvePrimerMultiplicadorSiEmpresasDistintosPropietarios() {
		Empresa empresa1 = new Empresa(0,0,0, "");
		Empresa empresa2 = new Empresa(0,0,0, "");
		MultiplicadorRenta multiplicador = new MultiplicadorRenta(100, 500);
		
		empresa1.setPropietario(new Jugador(new Casilla()));
		empresa2.setPropietario(new Jugador(new Casilla()));
		assertEquals(100, multiplicador.getMultiplicador(empresa1, empresa2), DELTA);
	}
}
