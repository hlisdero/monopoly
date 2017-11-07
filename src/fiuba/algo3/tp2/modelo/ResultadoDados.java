package fiuba.algo3.tp2.modelo;

class ResultadoDados {
	private int primerDado;
	private int segundoDado;
	
	ResultadoDados(int primerNumero, int segundoNumero) {
		if (primerNumero > 6 || segundoNumero > 6 ||
				primerNumero < 1 || segundoNumero < 1) {
			throw new ValoresDadoInvalidosException();
		}
		primerDado = primerNumero;
		segundoDado = segundoNumero;
	}
	
	int getSuma() {
		return primerDado + segundoDado;
	}
	
	boolean esDoble() {
		return (primerDado == segundoDado);
	}
}
