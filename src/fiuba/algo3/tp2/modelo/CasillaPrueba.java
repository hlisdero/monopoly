package fiuba.algo3.tp2.modelo;

/**
 * Mock para Casilla para hacer pruebas
 */
public class CasillaPrueba extends Casilla {
	private boolean llamoAplicarEfecto = false;
	
	@Override
	public void aplicarEfecto(Jugador jugador) {
		llamoAplicarEfecto = true;
	}
	
	public boolean llamoAplicarEfecto() {
		return llamoAplicarEfecto;
	}
}
