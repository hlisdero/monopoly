package fiuba.algo3.tp2.modelo;

class CasillaMovimientoDinamico extends Casilla {
	private TipoMovimiento tipoMovimiento;
	private GestorMovimiento gestorMovimiento;
	
	CasillaMovimientoDinamico(TipoMovimiento nuevoTipo, GestorMovimiento gestorMovimiento) {
		tipoMovimiento = nuevoTipo;	
		this.gestorMovimiento = gestorMovimiento;
	}
		
	@Override
	public void aplicarEfecto(Jugador jugador) {
		gestorMovimiento.mover(jugador, tipoMovimiento.getIndiceMovimiento(jugador));
	}
	
}
