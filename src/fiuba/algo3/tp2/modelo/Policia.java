package fiuba.algo3.tp2.modelo;

public class Policia extends Casilla {
	private Carcel carcel;
	private GestorMovimiento gestorMovimiento;
	
	public Policia(Carcel carcel, GestorMovimiento gestorMovimiento, String nombreCasilla) {
		this.carcel = carcel;
		this.gestorMovimiento = gestorMovimiento;
		this.nombreCasilla = nombreCasilla;
	}
	
	@Override
	public void aplicarEfecto(Jugador jugador) {
		gestorMovimiento.mover(jugador, carcel);
		System.out.println("Aplicar efecto POLICIA");
	}

}
