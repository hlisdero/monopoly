package fiuba.algo3.tp2.modelo;

public class Terreno extends Casilla {
	
	private  
		int precioDelTerreno;
		Jugador duenio;
	public Terreno()
	{
		super();
		this.duenio=new Jugador();
	}
	
	public Terreno(int precio)
	{
		this.precioDelTerreno = precio;
	}

	public int getPrecioDelTerreno() {
		return precioDelTerreno;
	}

	public void setPrecioDelTerreno(int precioDelTerreno) {
		this.precioDelTerreno = precioDelTerreno;
	}
	public Jugador duenioDelTerreno() {
		return this.duenio;
	}
	public void asignarDuenio(Jugador nuevoDueno) {
		this.duenio= nuevoDueno;
	}

	
	
	
	
}
