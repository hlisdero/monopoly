package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;

class Jugador {	
	private double capital = 100000;
	private Casilla casillaActual;
	private ArrayList<Propiedad> listaPropiedades = new ArrayList<Propiedad>();
	private ResultadoDados ultimaTirada;
	private boolean sePuedeMover = true;
	
	Jugador(Casilla casillaInicial) {
		casillaActual = casillaInicial;
	}
	
	/* Constructor de Jugador con dados iniciales para pruebas */
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
	
	void agregarPropiedad(Propiedad propiedad){
		listaPropiedades.add(propiedad);
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
	
	boolean noSePuedeMover() {
		return !sePuedeMover;
	}
	
	void prohibirMovimiento() {
		sePuedeMover = false;
	}
	
	void permitirMovimiento() {
		sePuedeMover = true;
	}
	
}
