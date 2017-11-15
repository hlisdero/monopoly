package fiuba.algo3.tp2.modelo;

class MovimientoDinamico extends Casilla {
	private TipoMovimiento tipoMovimiento;
	private int indiceMovimiento = 0;
	
	MovimientoDinamico(TipoMovimiento nuevoTipo) {
		tipoMovimiento = nuevoTipo;	
	}
	
	@Override
	public int getIndiceCasillaSiguiente(int posicionCasillaActual, ResultadoDados dados) {
		return posicionCasillaActual + indiceMovimiento;
	}
	
	@Override
	public void aplicarEfecto(Jugador jugador) {
		indiceMovimiento = tipoMovimiento.getIndiceMovimiento(jugador);
	}
	
}
