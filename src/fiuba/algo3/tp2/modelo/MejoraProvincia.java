package fiuba.algo3.tp2.modelo;

public class MejoraProvincia {
	private double precioAlquiler;
	private double precioConstruccion;

	public MejoraProvincia(double precioAlquiler, double precioConstruccion) {
		this.precioAlquiler = precioAlquiler;
		this.precioConstruccion = precioConstruccion;
	}
	
	public MejoraProvincia(double precioAlquiler) {
		this(precioAlquiler, 0);
	}
	
	public double getPrecioAlquiler() {
		return precioAlquiler;
	}
	
	public double getPrecioConstruccion() {
		return precioConstruccion;
	}
}
