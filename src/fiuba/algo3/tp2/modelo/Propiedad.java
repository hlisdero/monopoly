package fiuba.algo3.tp2.modelo;

public class Propiedad implements Casilla {
	private double precio;
	private	Jugador propietario;
	
	public Propiedad(double precio) {
		this.precio = precio;
	}

	public double getPrecio() {
		return precio;
	}

	public Jugador getPropietario() {
		return this.propietario;
	}
	
	public void setPropietario(Jugador propietario) {
		this.propietario = propietario;
	}

	public void construirCasa() {
		
	}
	public void construirHotel() {
		
	}
	private boolean noTienePropietario() {
		return propietario == null;
	}

	@Override
	public void aplicarEfecto(Jugador jugador) {
		if(this.noTienePropietario()) {
			this.propietario = jugador;
			jugador.addPropiedad(this);
				
		}
	}
	
}
