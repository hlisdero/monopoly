package fiuba.algo3.tp2.modelo;

public class Empresa extends Propiedad {
	private Empresa empresaHermana;
	private double renta;
	private double rentaGremial;
	
	public Empresa(double precio, double renta, double rentaGremial) {
		super(precio);
		this.renta = renta;
		this.rentaGremial = rentaGremial;
	}
	
	public void setEmpresaHermana(Empresa empresa) {
		empresaHermana = empresa;
	}
	
	public double getRenta() {
		if (empresaHermana != null && this.getPropietario() != null && this.getPropietario().getGestorPropiedades().contiene(empresaHermana)){ 
			return rentaGremial;
		}
		return renta;
	}
	
	public Empresa getEmpresaHermana() {
		return empresaHermana;
	}

	@Override
	public void aplicarEfecto(Jugador jugador) {
		if (tienePropietario() && jugador != this.getPropietario() ) {
			jugador.restarDinero(getRenta()*jugador.getResultadoDados().getSuma());
			getPropietario().agregarDinero(getRenta()*jugador.getResultadoDados().getSuma());
		}
	}
}
