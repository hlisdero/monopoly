package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;

class Tablero {
	private ArrayList<Casilla> casillas = new ArrayList<Casilla>();
	private int cantidadCasillas = 20;
	
	Tablero() {
		casillas.add(new Casilla());		// Salida
		casillas.add(new Quini());			// Quini 6
		casillas.add(new Propiedad(20000));	// Buenos Aires Zona Sur
		casillas.add(new Empresa(35000));	// EDESUR
		casillas.add(new Propiedad(25000));	// Buenos Aires Zona Norte
		// Cárcel
		casillas.add(new Propiedad(18000));	// Córdoba Zona Sur
		casillas.add(new Casilla()); 		// TODO Avance dinámico
		casillas.add(new Empresa(40000));	// SUBTE		
		casillas.add(new Propiedad(20000));	// Córdoba Zona Norte
		casillas.add(new Impuesto());		// Impuesto al Lujo
		casillas.add(new Propiedad(15000));	// Santa Fe
		casillas.add(new Empresa(30000));	// AYSA
		casillas.add(new Propiedad(23000));	// Salta Zona Norte
		casillas.add(new Propiedad(23000));	// Salta Zona Sur
		casillas.add(new Policia(5));		// Policia
		casillas.add(new Empresa(38000));	// Trenes
		casillas.add(new Propiedad(17000));	// Neuquén
		casillas.add(new Casilla());		// TODO Retroceso dinámico
		casillas.add(new Propiedad(25000));	// Tucumán		
	}
	
	void insertarCasilla(int posicion, Casilla casilla) {
		casillas.add(5, casilla);
	}
	
	Casilla getCasillaInicial() {
		return casillas.get(0);
	}
	
	Casilla getCasillaSiguiente(Casilla casillaActual, ResultadoDados dados) {
		int posicionCasillaActual = casillas.indexOf(casillaActual);
		return casillas.get(casillaActual.getIndiceCasillaSiguiente(posicionCasillaActual, dados) % cantidadCasillas);
	}
}
