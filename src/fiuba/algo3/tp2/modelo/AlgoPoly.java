package fiuba.algo3.tp2.modelo;

public class AlgoPoly {
	Tablero tablero = new Tablero();
	
	public Jugador crearJugador() {
		return new Jugador(tablero.getCasillaInicial());
	}
	
	public void mover(Jugador jugador, int posiciones) {
		Casilla siguiente = tablero.getCasillaSiguiente(jugador.getCasilla(), posiciones);
		jugador.setCasilla(siguiente);
	}
}
