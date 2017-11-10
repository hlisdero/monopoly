package fiuba.algo3.tp2.modelo;

public class Propiedad implements Casilla {
	
	private int precio;
	private	Jugador propietario;
	
	public Propiedad(int precio){
		this.precio = precio;
	}

	public int getPrecioDelTerreno() {
		return precio;
	}

	public void setPrecioDelTerreno(int precioDelTerreno) {
		this.precio = precioDelTerreno;
	}
	public Jugador duenioDelTerreno() {
		return this.propietario;
	}
	public void asignarDuenio(Jugador nuevoDueno) {
		this.propietario= nuevoDueno;
	}

	public void construirCasa() {
		
	}
	public void construirHotel() {
		
	}

	@Override
	public void aplicarEfecto(Jugador jugador) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
