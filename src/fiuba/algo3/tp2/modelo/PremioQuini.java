package fiuba.algo3.tp2.modelo;

class PremioQuini {
	private static final double MONTO_PRIMERA_VEZ = 50000;
	private static final double MONTO_SEGUNDA_VEZ = 30000;

	void darPremio(Jugador jugador, int cantidadVeces) {
		if (cantidadVeces == 1) {
			jugador.agregarDinero(MONTO_PRIMERA_VEZ);
		} else if (cantidadVeces == 2)	{
			jugador.agregarDinero(MONTO_SEGUNDA_VEZ);
		}
	}
}
