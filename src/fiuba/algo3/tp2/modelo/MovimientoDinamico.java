package fiuba.algo3.tp2.modelo;

public class MovimientoDinamico extends Casilla{
	private TipoMovimiento tipoMovimiento;
	private int indice = 0;
	
	MovimientoDinamico(TipoMovimiento nuevoTipo){
		tipoMovimiento = nuevoTipo;	
	}
	public int getIndiceCasillaSiguiente(int posicionCasillaActual, ResultadoDados dados) {
		return posicionCasillaActual + this.indice;
	}
	
	
	public void aplicarEfecto(Jugador jugador) {
			if(jugador.getResultadoDados().getSuma() <= 6) {
				this.indice = tipoMovimiento.efectoPrimero(jugador);
			}else if(jugador.getResultadoDados().getSuma() <= 10) {
				this.indice = tipoMovimiento.efectoPrimero(jugador);
			}else if(jugador.getResultadoDados().getSuma() <= 12) {
				this.indice = tipoMovimiento.efectoTercero(jugador); 
			}
			
	}
	
	
}
