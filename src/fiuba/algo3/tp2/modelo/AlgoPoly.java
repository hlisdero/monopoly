package fiuba.algo3.tp2.modelo;

public class AlgoPoly {
	private GestorMovimiento gestorMovimiento = new GestorMovimiento();
	private GestorTurnos gestorTurnos = new GestorTurnos();

	
	public Jugador crearJugador() {
		Casilla casillaInicial = gestorMovimiento.getCasillaInicial();
		Jugador jugador = new Jugador(casillaInicial);
		gestorTurnos.agregarJugador(jugador);
		return jugador;
	}
	
	 
	//a modo de ejemplo preliminar
	public void empezarJuego(){
		//agregarJugadoresALaCola()
		  while (gestorTurnos.getNumeroDeJugadores() > 1){
			  Jugador jugador = gestorTurnos.proximoTurno();
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
