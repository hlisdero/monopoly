package fiuba.algo3.tp2.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class EmpresasIntegracionTest {
	private static final double DELTA = 1e-15;
	@Test
	public void JugadorCaeEnTrenesAdquiridaPorOtroJugadorQueNoTieneSubtes() {
		
		Jugador j1 = new Jugador(new Casilla());
		Jugador j2 = new Jugador(new Casilla());
		Empresa subte = new Empresa(1, 600,1100);
		Empresa trenes = new Empresa(1, 450,800);
		
		subte.setEmpresaHermana(trenes);
		trenes.setEmpresaHermana(subte);
		
		trenes.aplicarEfecto(j1);
		ResultadoDados dados = j2.tirarDados();
		double capitalInicial = j2.getCapital();
		trenes.aplicarEfecto(j2);
		
		assertEquals(capitalInicial - dados.getSuma()*450,j2.getCapital(),DELTA);
	}
	
	@Test
	public void JugadorCaeEnTrenesAdquiridaPorOtroJugadorQueTieneSubtes() {
		
		Jugador j1 = new Jugador(new Casilla());
		Jugador j2 = new Jugador(new Casilla());
		Empresa subte = new Empresa(1, 600,1100);
		Empresa trenes = new Empresa(1, 450,800);
		
		subte.setEmpresaHermana(trenes);
		trenes.setEmpresaHermana(subte);
		
		trenes.aplicarEfecto(j1);
		subte.aplicarEfecto(j1);
		ResultadoDados dados = j2.tirarDados();
		double capitalInicial = j2.getCapital();
		trenes.aplicarEfecto(j2);
		
		assertEquals(capitalInicial - dados.getSuma()*800,j2.getCapital(),DELTA);
	}
	
	@Test
	public void JugadorCaeEnEDESURAdquiridaPorOtroJugadorQueNoTieneAYSA() {
		
		Jugador j1 = new Jugador(new Casilla());
		Jugador j2 = new Jugador(new Casilla());
		Empresa edesur = new Empresa(1, 500,1000);
		Empresa aysa = new Empresa(1, 300,500);
		
		edesur.setEmpresaHermana(aysa);
		aysa.setEmpresaHermana(edesur);
		
		edesur.aplicarEfecto(j1);
		ResultadoDados dados = j2.tirarDados();
		double capitalInicial = j2.getCapital();
		edesur.aplicarEfecto(j2);
		
		assertEquals(capitalInicial - dados.getSuma()*500,j2.getCapital(),DELTA);
	}
	
	@Test
	public void JugadorCaeEnEDESURAdquiridaPorOtroJugadorQueTieneAYSA() {
		
		Jugador j1 = new Jugador(new Casilla());
		Jugador j2 = new Jugador(new Casilla());
		Empresa edesur = new Empresa(1, 500,1000);
		Empresa aysa = new Empresa(1, 300,500);
		
		edesur.setEmpresaHermana(aysa);
		aysa.setEmpresaHermana(edesur);

		edesur.aplicarEfecto(j1);
		aysa.aplicarEfecto(j1);
		ResultadoDados dados = j2.tirarDados();
		double capitalInicial = j2.getCapital();
		edesur.aplicarEfecto(j2);
		
		assertEquals(capitalInicial - dados.getSuma()*1000,j2.getCapital(),DELTA);
	}
	
	@Test 
	public void aplicarEfectoAcreditarJugadorPropietarioHermanasCuandoOtroCae() {
		Jugador j1 = new Jugador(new Casilla());
		Jugador j2 = new Jugador(new Casilla());
		Empresa edesur = new Empresa(1000, 500,1000);
		Empresa aysa = new Empresa(1000, 300,500);
		
		edesur.setEmpresaHermana(aysa);
		aysa.setEmpresaHermana(edesur);

		edesur.aplicarEfecto(j1);
		aysa.aplicarEfecto(j1);
		
		j2.tirarDados();
		int suma = j2.getResultadoDados().getSuma();
		
		edesur.aplicarEfecto(j2);
		
		assertEquals(100000-2000+(1000*suma), j1.getCapital(),DELTA);
		
		
	}

}
