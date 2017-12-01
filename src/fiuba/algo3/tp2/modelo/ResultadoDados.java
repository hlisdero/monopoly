package fiuba.algo3.tp2.modelo;

public class ResultadoDados {
	private int primerDado;
	private int segundoDado;
	
	public ResultadoDados(int primerNumero, int segundoNumero) {
		if (primerNumero > 6 || segundoNumero > 6 ||
				primerNumero < 1 || segundoNumero < 1) {
			throw new ValoresDadoInvalidosException();
		}
		primerDado = primerNumero;
		segundoDado = segundoNumero;
	}
	
	public int getSuma() {
		return primerDado + segundoDado;
	}
	
	public boolean esDoble() {
		return (primerDado == segundoDado);
	}	
}
