package fiuba.algo3.tp2.modelo;

public class AlgoPoly {
	private GestorDeMovimiento gestorDeMovimiento = new GestorDeMovimiento();
	private GestorDeTurnos colaDeTurnos = new GestorDeTurnos();

	
	public Jugador crearJugador() {
		Casilla casillaInicial = gestorDeMovimiento.getCasillaInicial();
		Jugador jugador = new Jugador(casillaInicial);
		colaDeTurnos.agregarJugador(jugador);
		return jugador;
	}
	
	 
	//a modo de ejemplo preliminar
	public void empezarJuego(){
		//agregarJugadoresALaCola()
		  while (colaDeTurnos.getNumeroDeJugadores() > 1){
			  Jugador jugador = colaDeTurnos.proximoTurno();
			  //gestorDeMovimientos.mover(jugador);
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
