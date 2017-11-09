package fiuba.algo3.tp2.modelo;

public class Terreno extends Casilla {
	
	private  
		int precioDelTerreno;
		Jugador dueno;
	public Terreno()
	{
		super();
		this.dueno=new Jugador();
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
	public Jugador  duenoDelTerreno() {
		return this.dueno;
	}
	public void asignarDueno(Jugador nuevoDueno) {
		this.dueno= nuevoDueno;
	}
	
	
	
}
