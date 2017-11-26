package fiuba.algo3.tp2.modelo;

public class CasillaMovimientoDinamico extends Casilla {
	private TipoMovimiento tipoMovimiento;
	private GestorMovimiento gestorMovimiento;
	
	public CasillaMovimientoDinamico(TipoMovimiento nuevoTipo, GestorMovimiento gestorMovimiento, String nombre) {
		tipoMovimiento = nuevoTipo;	
		this.gestorMovimiento = gestorMovimiento;
		this.nombreCasilla = nombre;
	}
		
	@Override
	public void aplicarEfecto(Jugador jugador) {
		gestorMovimiento.mover(jugador, tipoMovimiento.getIndiceMovimiento(jugador));
	}	
}
