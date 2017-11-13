package fiuba.algo3.tp2.modelo;

import java.util.HashMap;

public class Quini extends Casilla {
	private HashMap<Jugador, Integer> vecesQueCayeron = new HashMap<Jugador, Integer>();
	private PremioQuini premio = new PremioQuini();
	
	@Override
	public void aplicarEfecto(Jugador jugador) {
		if (!vecesQueCayeron.containsKey(jugador)) {
			vecesQueCayeron.put(jugador, 1);
		} else {
			int cantidadVeces = vecesQueCayeron.get(jugador);
			vecesQueCayeron.put(jugador, cantidadVeces + 1);
		}
		premio.darPremio(jugador, vecesQueCayeron.get(jugador));
	}
	
}
