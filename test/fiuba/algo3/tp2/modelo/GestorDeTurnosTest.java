package fiuba.algo3.tp2.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class GestorDeTurnosTest {

	@Test
	public void nuevoGestorNoEsNull() {
		assertNotNull(new GestorDeTurnos());
	}
	
	@Test
	public void agregarJugadorLoAgregaALaCola() {
		Jugador jugador = new Jugador(new CasillaPrueba());
		GestorDeTurnos turnos = new GestorDeTurnos();
		turnos.agregarJugador(jugador);
		assertEquals(turnos.getNumeroDeJugadores(),1);
	}
	
	@Test
	public void agregarJugadoRespetaElOrdenEnElQueFueronAgregados() {
		
		Jugador jugador = new Jugador(new CasillaPrueba());
		Jugador jugador2 = new Jugador(new CasillaPrueba());
		GestorDeTurnos turnos = new GestorDeTurnos();
		turnos.agregarJugador(jugador);
		turnos.agregarJugador(jugador2);
		Jugador jugadorTurno = turnos.proximoTurno();
		assertEquals(jugadorTurno,jugador);
	}
	
	@Test
	public void proximoTurnoDevuelveElTurno() {
		Jugador jugador = new Jugador(new CasillaPrueba());
		GestorDeTurnos turnos = new GestorDeTurnos();
		turnos.agregarJugador(jugador);
		assertNotNull(turnos.proximoTurno());
	}
	@Test
	public void proximoTurnoLoMandaAlFinalDeLaCola() {
		Jugador jugador = new Jugador(new CasillaPrueba());
		Jugador jugador2 = new Jugador(new CasillaPrueba());
		GestorDeTurnos turnos = new GestorDeTurnos();
		turnos.agregarJugador(jugador);
		turnos.agregarJugador(jugador2);
		turnos.proximoTurno();
		Jugador jugadorTurno = turnos.proximoTurno();
		assertEquals(jugadorTurno,jugador2);
	}
}
