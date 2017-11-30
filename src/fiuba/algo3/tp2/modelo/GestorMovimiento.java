package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;

public class GestorMovimiento {
	private static final int CANTIDAD_DADOS_DOBLE_MAXIMA = 1;
	private ArrayList<ContadorTurnos> contadoresTurnos = new ArrayList<ContadorTurnos>();
	private Tablero tablero = new Tablero(this);
	
	public Casilla getCasillaInicial() {
		return tablero.getCasillaInicial();
	}

	public void agregarContadorTurnos(ContadorTurnos contador) {
		contadoresTurnos.add(contador);
	}
	
	public void notificarNuevoTurno(Jugador jugador) {
		for (ContadorTurnos elementoANotificar : contadoresTurnos) {
			elementoANotificar.contarTurno(jugador);
        }
	}

	public void mover(Jugador jugador) {
		int cantidadDadosDoble = 0;
		
		if (!jugador.sePuedeMover()) {
			return;
		}
		do {
			this.mover(jugador, jugador.tirarDados().getSuma());
			if (jugador.getResultadoDados().esDoble()) {
				cantidadDadosDoble++;
			}
		} while (cantidadDadosDoble <= CANTIDAD_DADOS_DOBLE_MAXIMA);
	}
	
	public void mover(Jugador jugador, int posiciones) {
		if (!jugador.sePuedeMover() && posiciones == 0) {
			return;
		} 
		Casilla casillaSiguiente = tablero.getCasillaSiguiente(jugador.getCasilla(), posiciones);
		mover(jugador, casillaSiguiente);
	}
	
	public void mover(Jugador jugador, Casilla casilla) {
		jugador.setCasilla(casilla);
		casilla.aplicarEfecto(jugador);
	}
	
	public Tablero getTablero() {
		return tablero;
	}

	public ArrayList<Casilla> getCasillas() {
		return tablero.getCasillas();
	}
}
