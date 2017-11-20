package fiuba.algo3.tp2.modelo;

public class Empresa extends Propiedad {
	
	public Empresa(double precio, double precioDeAlquiler) {
		super(precio, precioDeAlquiler);
	}
	
	@Override
	public void aplicarEfecto(Jugador jugador) {
		if (noTienePropietario() && jugador.getCapital() >= precio) {
			propietario = jugador;
			jugador.getGestorPropiedades().agregarPropiedad(this);
			jugador.restarDinero(precio);
		}
		else if (!noTienePropietario() && jugador.getCapital() >= this.precioDeAlquiler) {
			jugador.restarDinero(precioDeAlquiler*jugador.getResultadoDados().getSuma());
		}
	}
	
	
}
