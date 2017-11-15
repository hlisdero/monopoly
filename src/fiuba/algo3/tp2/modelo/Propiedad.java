package fiuba.algo3.tp2.modelo;

public class Propiedad extends Casilla {
	private double precio;
	private	Jugador propietario;
	
	Propiedad(double precio) {
		this.precio = precio;
	}

	double getPrecio() {
		return precio;
	}

	Jugador getPropietario() {
		return this.propietario;
	}

	boolean noTienePropietario() {
		return (propietario == null);
	}

	@Override
	public void aplicarEfecto(Jugador jugador) {
		if (noTienePropietario() && jugador.getCapital() >= precio) {
			propietario = jugador;
			jugador.agregarPropiedad(this);
			jugador.restarDinero(precio);
		}
	}
	
}
