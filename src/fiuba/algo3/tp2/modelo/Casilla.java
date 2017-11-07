package fiuba.algo3.tp2.modelo;

class Casilla {
	int numeroCasilla;
	
	Casilla(int numeroCasilla) {
		this.numeroCasilla = numeroCasilla;
	}
	
	int siguiente(int posiciones) {
		return (numeroCasilla + posiciones) % 20;
	}
}
