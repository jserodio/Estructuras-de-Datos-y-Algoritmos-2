package packPruebas;

import static org.junit.Assert.*;

import packCodigo.Actor;
import packCodigo.SingleActores;
import packCodigo.SinglePeliculas;

public class TestSingleActores {

	@org.junit.Test
	public void testbuscarActor() {
		int obtenido;
		
		// Sin cargar lista
		obtenido = SingleActores.getSingle().buscarActor(new Actor("Actor 3"));
		// tiene que dar false si no lo encuentra
		assertFalse(obtenido >= 0);
		
		// Cargando la lista
		SinglePeliculas.getSingle().cargarDatos("ficheros/casoA.txt");
		
		obtenido = SingleActores.getSingle().buscarActor(new Actor("Actor 1"));
		// tiene que dar true si encuentra el actor
		assertTrue(obtenido >= 0);
		
		obtenido = SingleActores.getSingle().buscarActor(new Actor("Actor 2"));
		// tiene que dar true si encuentra el actor
		assertTrue(obtenido >= 0);
				
		obtenido = SingleActores.getSingle().buscarActor(new Actor("Actor 4"));
		// tiene que dar false si no lo encuentra
		assertFalse(obtenido >= 0);
	}
	
	@org.junit.Test
	public void testestaActor() {
		boolean obtenido;
		boolean esperado;
		
		SinglePeliculas.getSingle().vaciarLista();
		SingleActores.getSingle().vaciarLista();
		
		// Sin cargar lista
		esperado = false;
		obtenido = SingleActores.getSingle().estaActor(new Actor("Actor 3"));
		// tiene que dar false si no lo encuentra
		assertEquals(esperado, obtenido);
		
		// Cargando la lista
		SinglePeliculas.getSingle().cargarDatos("ficheros/casoA.txt");
		
		esperado = true;
		obtenido = SingleActores.getSingle().estaActor(new Actor("Actor 1"));
		// tiene que dar true si encuentra el actor
		assertEquals(esperado, obtenido);
		
		esperado = true;
		obtenido = SingleActores.getSingle().estaActor(new Actor("Actor 2"));
		// tiene que dar true si encuentra el actor
		assertEquals(esperado, obtenido);
				
		esperado = false;
		obtenido = SingleActores.getSingle().estaActor(new Actor("Actor 4"));
		// tiene que dar false si no lo encuentra
		assertEquals(esperado, obtenido);
	}
	
	@org.junit.Test
	public void testeliminarActor() {
		Actor obtenido;
		Actor esperado;
		
		// Sin cargar lista	
		esperado = null;
		obtenido = SingleActores.getSingle().eliminarActor(new Actor("Actor 4"));
		assertEquals(esperado, obtenido);
		
		// Cargando lista
		SinglePeliculas.getSingle().cargarDatos("ficheros/casoA.txt");
		
		esperado = new Actor("Actor 3");
		obtenido = SingleActores.getSingle().eliminarActor(new Actor("Actor 3"));
		// Tiene que devolver el Actor 3 porque lo ha eliminado
		assertEquals(esperado, obtenido);
		
		esperado = null;
		obtenido = SingleActores.getSingle().eliminarActor(new Actor("Actor 4"));
		// Tiene que devolver null porque no lo ha podido eliminar
		assertEquals(esperado, obtenido);
	}

}
