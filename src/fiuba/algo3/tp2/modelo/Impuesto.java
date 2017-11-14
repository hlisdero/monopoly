package fiuba.algo3.tp2.modelo;

class Impuesto extends Casilla {
	private double porcentajeImpuesto = 0.10;
	
	@Override
	public void aplicarEfecto(Jugador jugador) {
		jugador.restarDinero(jugador.getCapital() * porcentajeImpuesto);
	}

}
