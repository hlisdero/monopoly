package fiuba.algo3.tp2.modelo;

public class Compania extends Casilla {

	private int precioDeLaCompania;
	
	public Compania()
	{
		this.precioDeLaCompania = 0;
	}
	
	public Compania(int precio)
	{
		this.precioDeLaCompania = precio;
	}

	public int getPrecioDeLaCompania() {
		return precioDeLaCompania;
	}

	public void setPrecioDeLaCompania(int precioDeLaCompania) {
		this.precioDeLaCompania = precioDeLaCompania;
	}
	
	
	
	
}
