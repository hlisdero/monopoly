package fiuba.algo3.tp2.modelo;

class Jugador {
	private double capital = 100000;
	private Casilla casilla;
	
	Jugador(Casilla casilla) {
		this.casilla = casilla;
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
