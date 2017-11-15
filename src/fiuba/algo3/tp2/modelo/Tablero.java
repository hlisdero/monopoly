package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;

class Tablero {
	private ArrayList<Casilla> casillas = new ArrayList<Casilla>();
	private ArrayList<Casilla> casillasProhibidas = new ArrayList<Casilla>();
	private int cantidadCasillas = 20;
	private Carcel carcel;
	
	Tablero() {
		MovimientoDinamico avance = new MovimientoDinamico(new Avance());
		MovimientoDinamico retroceso = new MovimientoDinamico(new Retroceso());
		carcel = new Carcel();
		
		casillas.add(new Casilla());		// Salida
		casillas.add(new Quini());			// Quini 6
		casillas.add(new Propiedad(20000));	// Buenos Aires Zona Sur
		casillas.add(new Empresa(35000));	// EDESUR
		casillas.add(new Propiedad(25000));	// Buenos Aires Zona Norte
		casillas.add(carcel);				// Carcel
		casillas.add(new Propiedad(18000));	// Córdoba Zona Sur
		casillas.add(avance);				// Avance Dinámico
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
		casillas.add(retroceso);			// Retroceso Dinámico
		casillas.add(new Propiedad(25000));	// Tucumán
		
		casillasProhibidas.add(avance);
		casillasProhibidas.add(retroceso);
	}
	
	void insertarCasilla(int posicion, Casilla casilla) {
		casillas.add(posicion, casilla);
	}
	
	Casilla getCasillaInicial() {
		return casillas.get(0);
	}
	
	Carcel getCarcel() {
		return carcel;
	}
	
	Casilla getCasillaSiguiente(Casilla casillaActual, ResultadoDados dados) {		
		int posicionCasillaActual = casillas.indexOf(casillaActual);
		return casillas.get(casillaActual.getIndiceCasillaSiguiente(posicionCasillaActual, dados) % cantidadCasillas);
	}
	
	boolean esCasillaProhibida(Casilla casilla) {
		return casillasProhibidas.contains(casilla);
	}
}
