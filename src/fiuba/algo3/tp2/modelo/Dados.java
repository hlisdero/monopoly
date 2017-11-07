package fiuba.algo3.tp2.modelo;

import java.util.Random;

class Dados {
	private static Random rand = new Random();
	
	ResultadoDados tirarDados() {
		return new ResultadoDados(rand.nextInt(6) + 1 , rand.nextInt(6) + 1);
	}
}
