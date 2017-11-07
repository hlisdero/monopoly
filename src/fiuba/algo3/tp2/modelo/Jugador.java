package fiuba.algo3.tp2.modelo;

class Jugador {
	private double capital = 100000;
	
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
