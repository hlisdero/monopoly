package fiuba.algo3.tp2.modelo;

public class AlgoPoly {
	private Tablero tablero = new Tablero();
	private GestorDeTurnos colaDeTurnos = new GestorDeTurnos();
	
	public Jugador crearJugador(String NombreDelJugador) {
		Jugador jugador = new Jugador(NombreDelJugador);
		jugador.setCasilla(tablero.getCasillaInicial());
		colaDeTurnos.agregarJugador(jugador);
		return jugador;
	}
	
	public void mover(Jugador jugador) {
		Casilla casillaSiguiente = tablero.getCasillaSiguiente(jugador.getCasilla(), jugador.tirarDados());
		casillaSiguiente.aplicarEfecto(jugador);
		jugador.setCasilla(casillaSiguiente);
	}
	 
	//a modo de ejemplo preliminar
	public void empezarJuego(){
		  while (colaDeTurnos.getNumeroDeJugadores() > 1){
			  Turno turno = colaDeTurnos.avanzarTurno();
			  this.mover(turno.getJugador());
		  }
		  // finalizarJuego()
	  }
	
	/*public int jugadorCompraTerreno(Jugador unJugador, Terreno unTerreno) throws CapitalInsuficienteException
	{
		unJugador.addTerrenoALaLista(unTerreno);
		return unJugador.restarDinero(unTerreno.getPrecioDelTerreno());
	}*/
	
	/*public int jugadorCompraCompania(Jugador unJugador, Compania unaCompania) throws CapitalInsuficienteException
	{
		unJugador.addTerrenoALaLista(unaCompania);
		return unJugador.restarDinero(unaCompania.getPrecioDeLaCompania());
	}*/
}
