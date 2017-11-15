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
	
	/* Constructor de jugador con dados iniciales para pruebas */
	Jugador(Casilla casillaInicial, int primerDado, int segundoDado) {
		casillaActual = casillaInicial;
		ultimaTirada = new ResultadoDados(primerDado, segundoDado);
	}
	
	Casilla getCasilla() {
		return casillaActual;
	}
	
	void setCasilla(Casilla casilla) {
		casillaActual = casilla;
	}
	
	double getCapital() {
		return capital;
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
	
	int getCantidadPropiedades(){
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
