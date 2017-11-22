package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;

public class Tablero {
	private static final int CANTIDAD_CASILLAS = 20;
	private ArrayList<Casilla> casillas = new ArrayList<Casilla>();
		
	private void agregarEmpresas() {
		Empresa edesur = new Empresa(35000, 500,1000);
		Empresa subte = new Empresa(40000, 600,1100);
		Empresa aysa = new Empresa(30000, 300,500);
		Empresa trenes = new Empresa(38000, 450,800);
		
		edesur.setEmpresaHermana(aysa);
		aysa.setEmpresaHermana(edesur);
		subte.setEmpresaHermana(trenes);
		trenes.setEmpresaHermana(subte);
		
		casillas.add(edesur);
		casillas.add(subte);
		casillas.add(aysa);
		casillas.add(trenes);
	}
	
	private void agregarContadoresTurnos(GestorMovimiento gestor) {
		Carcel carcel = new Carcel();
		gestor.agregarContadorTurnos(carcel);
		casillas.add(carcel);
	}
	
	public Tablero(GestorMovimiento gestor) {
		casillas.add(new Casilla());									// Salida
		casillas.add(new Quini());										// Quini 6
		casillas.add(new Propiedad(20000, 2000, 5000, 8000, 3000, 3500, 5000));								// Buenos Aires Zona Sur
		casillas.add(new Propiedad(25000, 2500, 5500, 9000, 3500, 4000, 6000));								// Buenos Aires Zona Norte	
		casillas.add(new Propiedad(18000, 1000, 2000, 3000, 1500, 2500, 3000));								// Córdoba Zona Sur
		casillas.add(new CasillaMovimientoDinamico(new Avance(), gestor));		// Avance Dinámico		
		casillas.add(new Propiedad(20000, 1300, 2200, 3500, 1800, 2900, 3500));								// Córdoba Zona Norte
		casillas.add(new Impuesto());									// Impuesto al Lujo
		casillas.add(new Propiedad(15000, 1500, 4000, 3500));								// Santa Fe
		casillas.add(new Propiedad(23000, 2000, 4500, 7500, 3250, 3850, 5500));								// Salta Zona Norte
		casillas.add(new Propiedad(23000, 2000, 4500, 7500, 3250, 3850, 5500));								// Salta Zona Sur
		casillas.add(new Policia(-10, gestor));							// Policia
		casillas.add(new Propiedad(17000, 1800, 4800, 3800));								// Neuquén
		casillas.add(new CasillaMovimientoDinamico(new Retroceso(), gestor));	// Retroceso Dinámico
		casillas.add(new Propiedad(25000, 2500, 7000, 2500));								// Tucumán
		agregarContadoresTurnos(gestor);
		agregarEmpresas();
	}

	public Casilla getCasillaInicial() {
		return casillas.get(0);
	}
	
	public Casilla getCasillaSiguiente(Casilla casillaActual, int posiciones) {		
		int posicionCasillaSiguiente = (casillas.indexOf(casillaActual) + posiciones) % CANTIDAD_CASILLAS;
		return casillas.get(posicionCasillaSiguiente);
	}
}
