package fiuba.algo3.tp2.modelo;

public class Impuesto extends Casilla {
	private static final double PORCENTAJE_IMPUESTO = 0.10;
	
	@Override
	public void aplicarEfecto(Jugador jugador) {
		jugador.restarDinero(jugador.getCapital() * PORCENTAJE_IMPUESTO);
	}
}
