package fiuba.algo3.tp2.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class EmpresaTest {

	private static final double DELTA = 1e-15;
	
	@Test
	public void nuevaEmpresaNoNull() {
		assertNotNull(new Empresa(100, 100,100));
	}
	
	/*@Test
	public void aplicarEfectoCobraSiYaTieneUnPropietario() {
		Propiedad unaEmpresa = new Empresa(1000,500);
		Jugador jugador1 = new Jugador(unaEmpresa);
		Jugador jugador2 = new Jugador(unaEmpresa);
		
		jugador2.tirarDados();
		
		unaEmpresa.aplicarEfecto(jugador1);
		unaEmpresa.aplicarEfecto(jugador2);
		
		int resultadoDados = jugador2.getResultadoDados().getSuma();
		int precioDeAlquiler = (int) (unaEmpresa.getPrecioAlquiler()*resultadoDados);
		
		assertEquals(100000-precioDeAlquiler, jugador2.getCapital(), DELTA);
	}
	*/
	
	

}
