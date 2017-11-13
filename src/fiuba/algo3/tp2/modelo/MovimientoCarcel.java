package fiuba.algo3.tp2.modelo;

public class MovimientoCarcel implements Movimiento{

	private int tiempoDeCarcel = 3;
	
	@Override
	public int getMultiplicadorDeMovimiento() {
		if (tiempoDeCarcel == 0) {
			/*hay que hacer algo aca, basicamente funciona como un MovimientoNormal, 
			buscar forma de cambiar este objeto por otro o repensar la estructura (me inclino por el ultimo)
			pero sirve como base creo yo
			*/
			return 1;
		}
		if (tiempoDeCarcel <= 2) {
			//fianza
		}
		tiempoDeCarcel -= 1;
		return 0;
	}

	
}
