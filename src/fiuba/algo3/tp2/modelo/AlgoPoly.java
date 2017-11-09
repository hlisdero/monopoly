package fiuba.algo3.tp2.modelo;

public class AlgoPoly {
	private Tablero tablero = new Tablero();
	
	public Jugador crearJugador() {
		return new Jugador(tablero.getCasillaInicial());
	}
	
	public void mover(Jugador jugador, int posiciones) {
		Casilla siguiente = tablero.getCasillaSiguiente(jugador.getCasilla(), posiciones);
		jugador.setCasilla(siguiente);
	}
	
	public int jugadorCompraTerreno(Jugador unJugador, Terreno unTerreno) throws CapitalInsuficienteException
	{
		unJugador.addTerrenoALaLista(unTerreno);
		return unJugador.restarDinero(unTerreno.getPrecioDelTerreno());
	}
	
	public int jugadorCompraCompania(Jugador unJugador, Compania unaCompania) throws CapitalInsuficienteException
	{
		unJugador.addTerrenoALaLista(unaCompania);
		return unJugador.restarDinero(unaCompania.getPrecioDeLaCompania());
	}
}
