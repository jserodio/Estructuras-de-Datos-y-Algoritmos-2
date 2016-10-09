package packPruebas;

import static org.junit.Assert.*;

import packCodigo.Actor;
import packCodigo.SingleActores;
import packCodigo.SinglePeliculas;

public class TestSingleActores {

	@org.junit.Test
	public void testbuscarActor() {
		SinglePeliculas.getSingle().cargarDatos("ficheros/casoA.txt");
		int obtenido;
		
		obtenido = SingleActores.getSingle().buscarActor(new Actor("Actor 1"));
		// tiene que dar true si encuentra el actor
		assertTrue(obtenido >= 0);
		
		obtenido = SingleActores.getSingle().buscarActor(new Actor("Actor 2"));
		// tiene que dar true si encuentra el actor
		assertTrue(obtenido >= 0);
		
		obtenido = SingleActores.getSingle().buscarActor(new Actor("Actor 3"));
		// tiene que dar true si encuentra el actor
		assertTrue(obtenido >= 0);
		
		obtenido = SingleActores.getSingle().buscarActor(new Actor("Actor 4"));
		// tiene que dar false si no lo encuentra
		assertFalse(obtenido >= 0);
	}

}
