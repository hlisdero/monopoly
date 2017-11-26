package fiuba.algo3.tp2.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class EmpresaTest {
	private static final double DELTA = 1e-15;
	
	@Test
	public void nuevaEmpresaNoNull() {
		assertNotNull(new Empresa(100, 100, 100, null));
	}
	
	@Test
	public void aplicarEfectoNoCobraPropietario() {
		Empresa empresa = new Empresa(0, 500, 0, null);
		Jugador propietario = new Jugador(new Casilla(), 5, 5);
		
		propietario.comprar(empresa);
		empresa.aplicarEfecto(propietario);
		assertEquals(100000, propietario.getCapital(), DELTA);
	}
	
	@Test
	public void aplicarEfectoCobraSumaDadosPorMultiplicador() {
		Empresa empresa = new Empresa(0, 500, 0, null);
		Jugador propietario = new Jugador(new Casilla());
		Jugador pagador = new Jugador(empresa, 5, 5); // Jugador con suma 10 en los dados
		
		propietario.comprar(empresa);
		empresa.aplicarEfecto(pagador);
		assertEquals(100000 - 500*10, pagador.getCapital(), DELTA);
	}
	
	@Test
	public void aplicarEfectoAcreditaPropietarioSumaDadosPorMultiplicador() {
		Empresa empresa = new Empresa(0, 500, 0, null);
		Jugador propietario = new Jugador(new Casilla());
		Jugador pagador = new Jugador(empresa, 5, 5); // Jugador con suma 10 en los dados
		
		propietario.comprar(empresa);
		empresa.aplicarEfecto(pagador);
		assertEquals(100000 + 500*10, propietario.getCapital(), DELTA);
	}
	
	@Test
	public void aplicarEfectoCobraSumaDadosPorMultiplicadorMejorado() {
		Empresa empresa1 = new Empresa(0, 500, 1000, null);
		Empresa empresa2 = new Empresa(0, 0, 0, null);
		Jugador propietario = new Jugador(new Casilla());
		Jugador pagador = new Jugador(empresa1, 5, 5); // Jugador con suma 10 en los dados
		
		empresa1.setEmpresaHermana(empresa2);
		propietario.comprar(empresa1);
		propietario.comprar(empresa2);
		empresa1.aplicarEfecto(pagador);
		assertEquals(100000 - 1000*10, pagador.getCapital(), DELTA);
	}
	
	@Test
	public void aplicarEfectoAcreditaPropietarioSumaDadosPorMultiplicadorMejorado() {
		Empresa empresa1 = new Empresa(0, 500, 1000, null);
		Empresa empresa2 = new Empresa(0, 0, 0, null);
		Jugador propietario = new Jugador(new Casilla());
		Jugador pagador = new Jugador(empresa1, 5, 5); // Jugador con suma 10 en los dados
		
		empresa1.setEmpresaHermana(empresa2);
		propietario.comprar(empresa1);
		propietario.comprar(empresa2);
		empresa1.aplicarEfecto(pagador);
		assertEquals(100000 + 1000*10, propietario.getCapital(), DELTA);
	}
	
}
