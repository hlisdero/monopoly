package fiuba.algo3.tp2.modelo;

import java.util.HashMap;

class Quini implements Casilla {

	private HashMap<Jugador, Integer> map = new HashMap<Jugador, Integer>();
	private int numeroDeTurno = 1;
	private int montoDePrimeraVez = 50000;
	private int montoDeSegundaVez = 30000;

	
	@Override
	public void aplicarEfecto(Jugador jugador) {
		// TODO Auto-generated method stub
		
		if(map.get(jugador) == null)
		{
			jugador.agregarDinero(montoDePrimeraVez);
			map.put(jugador, this.numeroDeTurno + 1);
		}
		else if(map.get(jugador).intValue() == 2)
		{
			jugador.agregarDinero(montoDeSegundaVez);
			map.put(jugador, map.get(jugador).intValue() + 1);
		}
		
	}
	
}
