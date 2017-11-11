package fiuba.algo3.tp2.modelo;

public class GestorMovimiento {
	private Tablero tablero = new Tablero();
	
	public Casilla getCasillaInicial() {
		return tablero.getCasillaInicial();
	}
	
	public void mover(Jugador jugador) {
		Casilla casillaSiguiente = tablero.getCasillaSiguiente(jugador.getCasilla(), jugador.tirarDados());
		casillaSiguiente.aplicarEfecto(jugador);
		jugador.setCasilla(casillaSiguiente);
	}
	
}
