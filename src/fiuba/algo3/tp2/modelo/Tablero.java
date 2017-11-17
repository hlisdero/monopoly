package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;

public class Tablero {
	private static final int CANTIDAD_CASILLAS = 20;
	private ArrayList<Casilla> casillas = new ArrayList<Casilla>();
		
	public Tablero(GestorMovimiento gestor) {		
		casillas.add(new Casilla());									// Salida
		casillas.add(new Quini());										// Quini 6
		casillas.add(new Propiedad(20000));								// Buenos Aires Zona Sur
		casillas.add(new Empresa(35000));								// EDESUR
		casillas.add(new Propiedad(25000));								// Buenos Aires Zona Norte
		// casillas.add(new Carcel());										// Carcel
		casillas.add(new Propiedad(18000));								// Córdoba Zona Sur
		casillas.add(new CasillaMovimientoDinamico(new Avance(), gestor));		// Avance Dinámico
		casillas.add(new Empresa(40000));								// SUBTE		
		casillas.add(new Propiedad(20000));								// Córdoba Zona Norte
		casillas.add(new Impuesto());									// Impuesto al Lujo
		casillas.add(new Propiedad(15000));								// Santa Fe
		casillas.add(new Empresa(30000));								// AYSA
		casillas.add(new Propiedad(23000));								// Salta Zona Norte
		casillas.add(new Propiedad(23000));								// Salta Zona Sur
		casillas.add(new Policia(-10, gestor));							// Policia
		casillas.add(new Empresa(38000));								// Trenes
		casillas.add(new Propiedad(17000));								// Neuquén
		casillas.add(new CasillaMovimientoDinamico(new Retroceso(), gestor));	// Retroceso Dinámico
		casillas.add(new Propiedad(25000));								// Tucumán
	}
	
	public Casilla getCasillaInicial() {
		return casillas.get(0);
	}
	
	public Casilla getCasillaSiguiente(Casilla casillaActual, int posiciones) {		
		int posicionCasillaSiguiente = (casillas.indexOf(casillaActual) + posiciones) % CANTIDAD_CASILLAS;
		return casillas.get(posicionCasillaSiguiente);
	}
}
