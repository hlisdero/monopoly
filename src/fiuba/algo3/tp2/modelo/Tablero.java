package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;

public class Tablero {
	private static final int CANTIDAD_CASILLAS = 20;
	private ArrayList<Casilla> casillas = new ArrayList<Casilla>();
	
	public Tablero(GestorMovimiento gestor) {
		Carcel carcel = new Carcel();

		Empresa edesur = new Empresa(35000, 500,1000,"EDESUR");
		Empresa subte = new Empresa(40000, 600,1100, "SUBTE");
		Empresa aysa = new Empresa(30000, 300,500,"AYSA");
		Empresa trenes = new Empresa(38000, 450,800,"TRENES");
		
		/* Agrego las casillas en orden */
		casillas.add(new Casilla());											// Salida
		casillas.add(new Quini());												// Quini 6

		casillas.add(new Provincia(20000, 2000, 5000, 8000, 3000, 3500, 5000,"BA ZONA SUR"));	// Buenos Aires Zona Sur
		casillas.add(edesur);
		casillas.add(new Provincia(25000, 2500, 5500, 9000, 3500, 4000, 6000,"BA ZONA NORTE"));	// Buenos Aires Zona Norte	
		casillas.add(carcel);
		casillas.add(new Provincia(18000, 1000, 2000, 3000, 1500, 2500, 3000,"CORDOBA ZONA SUR"));	// Córdoba Zona Sur
		casillas.add(new CasillaMovimientoDinamico(new Avance(), gestor,"AVANCE"));		// Avance Dinámico		
		casillas.add(subte);
		casillas.add(new Provincia(20000, 1300, 2200, 3500, 1800, 2900, 3500,"CORDOBA ZONA NORTE"));	// Córdoba Zona Norte
		casillas.add(new Impuesto());											// Impuesto al Lujo

		casillas.add(new Provincia(15000, 1500, 4000, 3500, "SANTA FE"));					// Santa Fe
		casillas.add(aysa);
		casillas.add(new Provincia(23000, 2000, 4500, 7500, 3250, 3850, 5500,"SALTA ZONA NORTE"));	// Salta Zona Norte
		casillas.add(new Provincia(23000, 2000, 4500, 7500, 3250, 3850, 5500,"SALTA ZONA SUR"));	// Salta Zona Sur
		casillas.add(new Policia(carcel, gestor, "POLICIA"));									// Policia
		casillas.add(trenes);
		casillas.add(new Provincia(17000, 1800, 4800, 3800,"NEUQUEN"));					// Neuquén
		casillas.add(new CasillaMovimientoDinamico(new Retroceso(), gestor,"RETROCESO"));	// Retroceso Dinámico
		casillas.add(new Provincia(25000, 2500, 7000, 2500,"TUCUMAN"));					// Tucumán

		
		/* Configuración extra de las casillas especiales */
		gestor.agregarContadorTurnos(carcel);
		edesur.setEmpresaHermana(aysa);
		aysa.setEmpresaHermana(edesur);
		subte.setEmpresaHermana(trenes);
		trenes.setEmpresaHermana(subte);
	}

	public Casilla getCasillaInicial() {
		return casillas.get(0);
	}
	
	public Casilla getCasillaSiguiente(Casilla casillaActual, int posiciones) {		
		int posicionCasillaSiguiente = (casillas.indexOf(casillaActual) + posiciones) % CANTIDAD_CASILLAS;
		return casillas.get(posicionCasillaSiguiente);
	}

	public ArrayList<Casilla> getCasillas() {
		return casillas;
	}
	
	
}
