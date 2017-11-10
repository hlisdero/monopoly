package fiuba.algo3.tp2.modelo;

import java.util.ArrayList;

class Jugador {
	
	private int capital = 100000;
	private Casilla casilla;
	private ArrayList<Propiedad> listaDePropiedadesDelJugador = new ArrayList<Propiedad>();
	private ResultadoDados ultimaTirada;
	
	public Jugador(Casilla casillaInicial) {
		casilla = casillaInicial;
	}
	
	
	public ArrayList<Propiedad> getListaPropiedadesJugador() {
		return listaDePropiedadesDelJugador;
	}

	public void setListaDeCasillasDelJugador(ArrayList<Propiedad> listaDeCasillasDelJugador) {
		this.listaDePropiedadesDelJugador = listaDeCasillasDelJugador;
	}

	Casilla getCasilla() {
		return casilla;
	}

	public int getCapital() {
		return capital;
	}

	public void setCasilla(Casilla unaCasilla) {
		this.casilla = unaCasilla;
	}

	public void agregarDinero(double monto) {
		this.capital += monto;
	}
	
	public int restarDinero(int monto) throws CapitalInsuficienteException {
		if (this.capital < monto) {
			throw new CapitalInsuficienteException();
		}
		 this.capital -= monto;
		 return this.capital;
	}
	
	public int addTerrenoALaLista(Propiedad unaPropiedad)
	{
		this.listaDePropiedadesDelJugador.add(unaPropiedad);
		return this.listaDePropiedadesDelJugador.size();
	}
	
	public ResultadoDados tirarDados() {
		ultimaTirada = Dados.tirarDados();
		return ultimaTirada;
	}
	public ResultadoDados  getResultadoDados() {
		return ultimaTirada;
	}
}
