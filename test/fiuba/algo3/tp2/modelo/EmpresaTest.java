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
	public void getRentaConEmpresaHermanaDevuelveElValorCorrecto() {
		Empresa unaEmpresa = new Empresa(10,500,1000);
		Empresa otraEmpresa = new Empresa(10,200,600);
		unaEmpresa.setEmpresaHermana(otraEmpresa);
		Jugador jugador1 = new Jugador(unaEmpresa);
		
		unaEmpresa.aplicarEfecto(jugador1);
		otraEmpresa.aplicarEfecto(jugador1);
		
		assertEquals(unaEmpresa.getRenta(), 1000, DELTA);
	}
	
	@Test
	public void aplicarEfectoCobraSiYaTieneUnPropietario() {
		Empresa unaEmpresa = new Empresa(1000,500,100);
		Jugador jugador1 = new Jugador(unaEmpresa);
		Jugador jugador2 = new Jugador(unaEmpresa);
		double capitalInicial = jugador2.getCapital();
		
		jugador2.tirarDados();
		
		unaEmpresa.aplicarEfecto(jugador1);
		unaEmpresa.aplicarEfecto(jugador2);
		
		int resultadoDados = jugador2.getResultadoDados().getSuma();
		double precioDeAlquiler = (unaEmpresa.getRenta()*resultadoDados);
		
		assertEquals(capitalInicial - precioDeAlquiler, jugador2.getCapital(), DELTA);
	}
	
	@Test
	public void aplicarEfectoAcreditarJugadorPropietarioCuandoOtroCae() {
		Empresa unaEmpresa = new Empresa(1000,500,100);
		Jugador jugador1 = new Jugador(unaEmpresa);
		Jugador jugador2 = new Jugador(unaEmpresa);
		
		jugador2.tirarDados();
		int suma = jugador2.getResultadoDados().getSuma();
		unaEmpresa.aplicarEfecto(jugador1);
		unaEmpresa.aplicarEfecto(jugador2);
		
		assertEquals(100000-1000+(500*suma), jugador1.getCapital(), DELTA);
	}
	
	@Test
	public void jugadorQuiereVenderPropiedadSeAcreditaMontoMenos15Porciento() {
		
		Empresa empresa = new Empresa(1000,500,700);
		Jugador jugador1 = new Jugador(empresa);
		
		empresa.aplicarEfecto(jugador1);
		empresa.jugadorVendePropiedad(jugador1);
		
		assertEquals(100000-1000+empresa.getPrecioDeVenta(), jugador1.getCapital(), DELTA);
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
