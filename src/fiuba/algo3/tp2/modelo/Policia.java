package fiuba.algo3.tp2.modelo;

public class Policia extends Casilla {
	private int posicionRelativaCarcel;
	private GestorMovimiento gestorMovimiento;
	
	public Policia(int posicionRelativaCarcel, GestorMovimiento gestorMovimiento) {
		this.posicionRelativaCarcel = posicionRelativaCarcel;
		this.gestorMovimiento = gestorMovimiento;
	}
	
	@Override
	public void aplicarEfecto(Jugador jugador) {
		gestorMovimiento.mover(jugador, posicionRelativaCarcel);
	}
}
