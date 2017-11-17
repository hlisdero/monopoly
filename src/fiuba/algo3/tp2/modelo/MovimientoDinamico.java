package fiuba.algo3.tp2.modelo;

class MovimientoDinamico extends Casilla {
	private TipoMovimiento tipoMovimiento;
	private GestorMovimiento gestorMovimiento;
	
	MovimientoDinamico(TipoMovimiento nuevoTipo, GestorMovimiento gestorMovimiento) {
		tipoMovimiento = nuevoTipo;	
		this.gestorMovimiento = gestorMovimiento;
	}
		
	@Override
	public void aplicarEfecto(Jugador jugador) {
		gestorMovimiento.mover(jugador, tipoMovimiento.getIndiceMovimiento(jugador));
	}
	
}
