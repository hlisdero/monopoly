package fiuba.algo3.tp2.modelo;

public class CasasInsuficienteException extends Exception {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CasasInsuficienteException(){
		System.out.println("Debe construir 2 casas antes de construir un hotel !");
	}
}
