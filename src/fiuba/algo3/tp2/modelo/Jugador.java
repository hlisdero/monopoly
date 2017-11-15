package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;

class Jugador {	
	private double capital = 100000;
	private Casilla casillaActual;
	private ArrayList<Propiedad> listaPropiedades = new ArrayList<Propiedad>();
	private ResultadoDados ultimaTirada;
	
	Jugador(Casilla casillaInicial) {
		casillaActual = casillaInicial;
	}
	
	ArrayList<Propiedad> getListaPropiedadesJugador() {
		return listaPropiedades;
	}

	Casilla getCasilla() {
		return casillaActual;
	}

	double getCapital() {
		return capital;
	}

	void setCasilla(Casilla casilla) {
		casillaActual = casilla;
	}

	void agregarDinero(double monto) {
		capital += monto;
	}
	
	double restarDinero(double monto) throws CapitalInsuficienteException {
		if (capital < monto) {
			throw new CapitalInsuficienteException();
		}
		capital -= monto;
		return capital;
	}
	
	void addPropiedad(Propiedad propiedad){
		listaPropiedades.add(propiedad);
		this.restarDinero(propiedad.getPrecio());
	}
	
	int cantidadPropiedad(){
		return listaPropiedades.size();
	}
	
	ResultadoDados tirarDados() {
		ultimaTirada = Dados.tirarDados();
		return ultimaTirada;
	}
	
	ResultadoDados getResultadoDados() {
		return ultimaTirada;
	}
}
