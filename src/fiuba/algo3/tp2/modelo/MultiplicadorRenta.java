package fiuba.algo3.tp2.modelo;

public class MultiplicadorRenta {
	private double multiplicador;
	private double multiplicadorMejorado;
	
	public MultiplicadorRenta(double multiplicador, double multiplicadorMejorado) {
		this.multiplicador = multiplicador;
		this.multiplicadorMejorado = multiplicadorMejorado;
	}
	
	public double getMultiplicador(Empresa empresaActual, Empresa empresaHermana) {
		if (empresaHermana == null) {
			return multiplicador;
		} else if (empresaActual.getPropietario() == empresaHermana.getPropietario()) {
			return multiplicadorMejorado;
		} else {
			return multiplicador;
		}
	}
}
