package fiuba.algo3.tp2.modelo;

class Policia extends Casilla {
	private int posicionRelativaCarcel;
	private GestorMovimiento gestorMovimiento;
	
	Policia(int posicionRelativaCarcel, GestorMovimiento gestorMovimiento) {
		this.posicionRelativaCarcel = posicionRelativaCarcel;
		this.gestorMovimiento = gestorMovimiento;
	}
	
	@Override
	public void aplicarEfecto(Jugador jugador) {
		gestorMovimiento.mover(jugador, posicionRelativaCarcel);
	}

}
