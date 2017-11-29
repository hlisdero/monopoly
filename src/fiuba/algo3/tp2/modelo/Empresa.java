package fiuba.algo3.tp2.modelo;

public class Empresa extends Propiedad {
	private Empresa empresaHermana;
	private MultiplicadorRenta multiplicador;
	

	public Empresa(double precio, double multiplicador, double multiplicadorMejorado, String nombre) {

		super(precio);
		this.multiplicador = new MultiplicadorRenta(multiplicador, multiplicadorMejorado);
		this.nombreCasilla = nombre;

	}
	
	public void setEmpresaHermana(Empresa empresa) {
		empresaHermana = empresa;
	}
	
	@Override
	public void aplicarEfecto(Jugador jugador) {
		if (debeCobrar(jugador)) {
			int sumaDados = jugador.getResultadoDados().getSuma();
			double montoACobrar = multiplicador.getMultiplicador(this, empresaHermana) * sumaDados;
			
			jugador.restarDinero(montoACobrar);
			this.getPropietario().agregarDinero(montoACobrar);
		}
	}
}
