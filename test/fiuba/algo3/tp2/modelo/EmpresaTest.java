package fiuba.algo3.tp2.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class EmpresaTest {

	private static final double DELTA = 1e-15;
	
	@Test
	public void nuevaEmpresaNoNull() {
		assertNotNull(new Empresa(100, 100,100));
	}
	
	@Test
	public void getRentaSinEmpresaHermanaDevuelveElValorCorrecto() {
		Empresa unaEmpresa = new Empresa(1000,500,100);
		assertEquals(unaEmpresa.getRenta(), 500, DELTA);
	}
	
	@Test
	public void setEmpresaHermanaAsociaLaEmpresa() {
		Empresa unaEmpresa = new Empresa(10,500,1000);
		Empresa otraEmpresa = new Empresa(10,200,600);
		unaEmpresa.setEmpresaHermana(otraEmpresa);
		assertEquals(unaEmpresa.getEmpresaHermana(),otraEmpresa);
	}
	
	@Test
	public void jugadorQuiereVenderPropiedadPropietarioNull() {
		Empresa empresa = new Empresa(1000,500,700);
		Jugador jugador1 = new Jugador(empresa);
		
		empresa.aplicarEfecto(jugador1);
		empresa.jugadorVendePropiedad(jugador1);
		
		assertNull(empresa.getPropietario());
	}
	

}
