package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;

class Jugador {
	private double capital = 100000;
	private Casilla casilla;
	private ArrayList<Casilla> listaDeCasillasDelJugador;
	
	
	public Jugador(){
		this.listaDeCasillasDelJugador = new ArrayList<Casilla>();
	}
	
	public Jugador(Casilla casilla) {
		this.casilla = casilla;
	}
	
	public ArrayList<Casilla> getListaDeCasillasDelJugador() {
		return listaDeCasillasDelJugador;
	}

	public void setListaDeCasillasDelJugador(ArrayList<Casilla> listaDeCasillasDelJugador) {
		this.listaDeCasillasDelJugador = listaDeCasillasDelJugador;
	}

	Casilla getCasilla() {
		return casilla;
	}

	void setCasilla(Casilla casilla) {
		this.casilla = casilla;
	}

	void agregarDinero(double monto) {
		capital += monto;
	}
	
	void restarDinero(double monto) throws CapitalInsuficienteException {
		if (capital < monto) {
			throw new CapitalInsuficienteException();
		}
		capital -= monto;
	}
}
