package fiuba.algo3.tp2.modelo;

public class MejoraPropiedad {
	private double precioAlquiler;
	private double precioConstruccion;

	public MejoraPropiedad(double precioAlquiler, double precioConstruccion) {
		this.precioAlquiler = precioAlquiler;
		this.precioConstruccion = precioConstruccion;
	}
	
	public double getPrecioAlquiler() {
		return precioAlquiler;
	}
	
	public double getPrecioConstruccion() {
		return precioConstruccion;
	}
}
