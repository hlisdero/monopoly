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
		Jugador jugador = new Jugador("Pepito");
		GestorDeTurnos turnos = new GestorDeTurnos();
		turnos.agregarJugador(jugador);
		assertEquals(turnos.getNumeroDeJugadores(),1);
	}
	
	@Test
	public void agregarJugadoRespetaElOrdenEnElQueFueronAgregados() {
		Jugador jugador = new Jugador("Pepito");
		Jugador jugador2 = new Jugador("Jorgito");
		GestorDeTurnos turnos = new GestorDeTurnos();
		turnos.agregarJugador(jugador);
		turnos.agregarJugador(jugador2);
		Turno turno = turnos.avanzarTurno();
		assertEquals(turno.getJugador(),jugador);
	}
	
	@Test
	public void avanzarTurnoDevuelveElTurno() {
		Jugador jugador = new Jugador("Pepito");
		GestorDeTurnos turnos = new GestorDeTurnos();
		turnos.agregarJugador(jugador);
		assertNotNull(turnos.avanzarTurno());
	}
	@Test
	public void avanzarTurnoLoMandaAlFinalDeLaCola() {
		Jugador jugador = new Jugador("Pepito");
		Jugador jugador2 = new Jugador("Jorgito");
		GestorDeTurnos turnos = new GestorDeTurnos();
		turnos.agregarJugador(jugador);
		turnos.agregarJugador(jugador2);
		turnos.avanzarTurno();
		Turno turno = turnos.avanzarTurno();
		assertEquals(turno.getJugador(),jugador2);
	}
}
