package fiuba.algo3.tp2.modelo;

public class Terreno extends Casilla {
	
	public int precioDelTerreno;
	
	public Terreno()
	{
		super();
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
	
	
	
}
