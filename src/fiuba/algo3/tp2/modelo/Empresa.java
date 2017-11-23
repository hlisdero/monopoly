package fiuba.algo3.tp2.modelo;

public class Empresa extends Propiedad {
	protected Empresa empresaHermana;
	protected double renta;
	protected double rentaGremial;
	
	public Empresa(double precio, double renta, double rentaGremial) { //si tiene empresa hermana el gremio te cobra carito
		super(precio);
		this.renta = renta;
		this.rentaGremial = rentaGremial;
	}
	
	public void setEmpresaHermana(Empresa empresa) {
		empresaHermana = empresa;
	}
	
	public double getRenta() {
			if (empresaHermana != null && propietario != null && propietario.getGestorPropiedades().contiene(empresaHermana)){
				return rentaGremial;
			}
			return renta;
		};
	
	public Empresa getEmpresaHermana() {
		return empresaHermana;
	}
	
	@Override
	public void aplicarEfecto(Jugador jugador) {
		if (noTienePropietario() && jugador.getCapital() >= this.getPrecio()) {
			propietario = jugador;
			jugador.getGestorPropiedades().agregarPropiedad(this);
			jugador.restarDinero(this.getPrecio());
		}
		else if (!noTienePropietario() && jugador != propietario ) {
			jugador.restarDinero(getRenta()*jugador.getResultadoDados().getSuma());
			getPropietario().agregarDinero(getRenta()*jugador.getResultadoDados().getSuma());
		}
	}
	

	
	
}
