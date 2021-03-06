package fiuba.algo3.tp2.modelo;

public class Jugador {	
	private double capital = 100000;
	private Casilla casillaActual;
	private ResultadoDados ultimaTirada;
	private GestorPropiedades gestorPropiedades = new GestorPropiedades(this);
	private boolean sePuedeMover = true;
	
	public Jugador(Casilla casillaInicial) {
		casillaActual = casillaInicial;
	}
	
	/* Constructor de Jugador con dados iniciales para pruebas */
	public Jugador(Casilla casillaInicial, int primerDado, int segundoDado) {
		casillaActual = casillaInicial;
		ultimaTirada = new ResultadoDados(primerDado, segundoDado);
	}
	
	public Casilla getCasilla() {
		return casillaActual;
	}
	
	void setCasilla(Casilla casilla) {
		casillaActual = casilla;
	}
	
	public double getCapital() {
		return capital;
	}

	public void agregarDinero(double monto) {
		capital += monto;
	}
	
	public double restarDinero(double monto) throws CapitalInsuficienteException {
		if (capital < monto) {
			throw new CapitalInsuficienteException();
		}
		capital -= monto;
		return capital;
	}
	
	public ResultadoDados tirarDados() {
		ultimaTirada = Dados.tirarDados();
		return ultimaTirada;
	}
	
	public ResultadoDados getResultadoDados() {
		return ultimaTirada;
	}
	
	public boolean sePuedeMover() {
		return sePuedeMover;
	}
	
	public void prohibirMovimiento() {
		sePuedeMover = false;
	}
	
	public void permitirMovimiento() {
		sePuedeMover = true;
	}
	
	public void comprar(Propiedad propiedad) {
		gestorPropiedades.comprar(propiedad);
	}
	
	public void vender(Propiedad propiedad) {
		gestorPropiedades.vender(propiedad);
	}
	
	public int getCantidadPropiedades() {
		return gestorPropiedades.getCantidadPropiedades();
	}

	public GestorPropiedades getGestorPropiedades() {
		return gestorPropiedades;
	}
	
	
}
