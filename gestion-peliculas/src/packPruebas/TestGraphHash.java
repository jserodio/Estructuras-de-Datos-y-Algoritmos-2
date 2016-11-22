package packPruebas;

import static org.junit.Assert.*;

import org.junit.Test;

import packCodigo.Actor;
import packCodigo.Pelicula;
import packCodigo.SingleActores;
import packCodigo.SinglePeliculas;
import packGrafo.GraphHash;

public class TestGraphHash {

	@Test
	public void testCrearGrafo() {
		SinglePeliculas.getSingle().cargarDatos("ficheros/casoVacio.txt");
		
		GraphHash grafo = new GraphHash();
		
		grafo.crearGrafo(SinglePeliculas.getSingle());
		
		assertTrue(grafo.g.isEmpty());
		
		// una peli
		
		Pelicula p1 = new Pelicula("p1");
		
		SinglePeliculas.getSingle().insertarPelicula(p1);
		
		grafo.crearGrafo(SinglePeliculas.getSingle());
		
		assertTrue(grafo.g.get(p1.getNombre()) != null );
		
		assertTrue(grafo.g.get(p1.getNombre()).isEmpty());
		
		// una peli y un actor relacionados
		
		Actor a1 = new Actor("a1");

		p1.insertarActor(a1);
		a1.insertarPelicula(p1);
		
		SinglePeliculas.getSingle().vaciarLista();
		
		SinglePeliculas.getSingle().insertarPelicula(p1);
		SingleActores.getSingle().insertarActor(a1);
		
		grafo.crearGrafo(SinglePeliculas.getSingle());
		
		assertTrue(grafo.g.get(a1.getNombre()).contains(p1.getNombre()));
		
		assertTrue(grafo.g.get(p1.getNombre()).contains(a1.getNombre()));
		
		// un actor en dos peliculas
		
		p1 = new Pelicula("p1");
		Pelicula p2 = new Pelicula("p2");
		
		p1.insertarActor(a1);
		p2.insertarActor(a1);
		a1.insertarPelicula(p1);
		a1.insertarPelicula(p2);
		
		SingleActores.getSingle().vaciarLista();
		SinglePeliculas.getSingle().vaciarLista();
		SinglePeliculas.getSingle().insertarPelicula(p1);
		SinglePeliculas.getSingle().insertarPelicula(p2);
		SingleActores.getSingle().insertarActor(a1);
		
		grafo.crearGrafo(SinglePeliculas.getSingle());
		
		assertTrue(grafo.g.get(a1.getNombre()).contains(p1.getNombre()));
		assertTrue(grafo.g.get(a1.getNombre()).contains(p2.getNombre()));
		assertTrue(grafo.g.get(p1.getNombre()).contains(a1.getNombre()));
		assertTrue(grafo.g.get(p2.getNombre()).contains(a1.getNombre()));
		
		// p3 sin actores
		a1 = new Actor("a1");
		Actor a2 = new Actor("a2");
		p1 = new Pelicula("p1");
		p2 = new Pelicula("p2");
		Pelicula p3 = new Pelicula("p3");
		
		a1.insertarPelicula(p1);
		p1.insertarActor(a1);
		a2.insertarPelicula(p2);
		p2.insertarActor(a2);
		
		SingleActores.getSingle().vaciarLista();
		SinglePeliculas.getSingle().vaciarLista();
		
		SingleActores.getSingle().insertarActor(a1);
		SingleActores.getSingle().insertarActor(a2);
		SinglePeliculas.getSingle().insertarPelicula(p1);
		SinglePeliculas.getSingle().insertarPelicula(p2);
		SinglePeliculas.getSingle().insertarPelicula(p3);
		
		grafo.crearGrafo(SinglePeliculas.getSingle());
		
		assertTrue(grafo.g.get(a1.getNombre()) != null);
		assertTrue(grafo.g.get(a1.getNombre()).contains(p1.getNombre()));
		
		assertTrue(grafo.g.get(a2.getNombre()) != null);
		assertTrue(grafo.g.get(a2.getNombre()).contains(p2.getNombre()));

		assertTrue(grafo.g.get(p1.getNombre()) != null);
		assertTrue(grafo.g.get(p1.getNombre()).contains(a1.getNombre()));
		
		assertTrue(grafo.g.get(p2.getNombre()) != null);
		assertTrue(grafo.g.get(p2.getNombre()).contains(a2.getNombre()));

		assertTrue(grafo.g.get(p3.getNombre()) != null);
		assertTrue(grafo.g.get(p3.getNombre()).isEmpty());
		
		// una pelicula en la que trabajan 3 actores
		a1 = new Actor("a1");
		a2 = new Actor("a2");
		Actor a3 = new Actor("a3");
		p1 = new Pelicula("p1");
		
		p1.insertarActor(a1);
		p1.insertarActor(a2);
		p1.insertarActor(a3);
		a1.insertarPelicula(p1);
		a2.insertarPelicula(p1);
		a3.insertarPelicula(p1);
		
		SingleActores.getSingle().vaciarLista();
		SinglePeliculas.getSingle().vaciarLista();
		
		SingleActores.getSingle().insertarActor(a1);
		SingleActores.getSingle().insertarActor(a2);
		SingleActores.getSingle().insertarActor(a3);
		SinglePeliculas.getSingle().insertarPelicula(p1);
		
		grafo.crearGrafo(SinglePeliculas.getSingle());
		
		assertTrue(grafo.g.get(p1).contains(a1.getNombre()));
		assertTrue(grafo.g.get(p1).contains(a2.getNombre()));
		assertTrue(grafo.g.get(p1).contains(a3.getNombre()));
		assertTrue(grafo.g.get(a1).contains(p1.getNombre()));
		assertTrue(grafo.g.get(a2).contains(p1.getNombre()));
		assertTrue(grafo.g.get(a3).contains(p1.getNombre()));
	}

	@Test
	public void testEstanConectadas() {
		
		// Caso grafo vacio
		SinglePeliculas.getSingle().cargarDatos("ficheros/casoVacio.txt");
		GraphHash grafo = new GraphHash();
		grafo.crearGrafo(SinglePeliculas.getSingle());
		// Test
		assertFalse(grafo.estanConectadas("p1", "a1"));
		
		// Caso grafo con 1 pelicula y sin actores
		Pelicula p1 = new Pelicula("p1");
		SinglePeliculas.getSingle().insertarPelicula(p1);
		grafo.crearGrafo(SinglePeliculas.getSingle());
		// Test
		assertFalse(grafo.estanConectadas("p1", "a1"));
		
		// Caso grafo con una peli y un actor relacionados
		Actor a1 = new Actor("a1");
		p1.insertarActor(a1);
		a1.insertarPelicula(p1);
		SinglePeliculas.getSingle().vaciarLista();
		SinglePeliculas.getSingle().insertarPelicula(p1);
		SingleActores.getSingle().insertarActor(a1);
		grafo.crearGrafo(SinglePeliculas.getSingle());
		// Test
		assertTrue(grafo.estanConectadas(p1.getNombre(), a1.getNombre()));
		
		// Caso grafo con un actor en dos peliculas
		p1 = new Pelicula("p1");
		Pelicula p2 = new Pelicula("p2");
		p1.insertarActor(a1);
		p2.insertarActor(a1);
		a1.insertarPelicula(p1);
		a1.insertarPelicula(p2);
		SingleActores.getSingle().vaciarLista();
		SinglePeliculas.getSingle().vaciarLista();
		SinglePeliculas.getSingle().insertarPelicula(p1);
		SinglePeliculas.getSingle().insertarPelicula(p2);
		SingleActores.getSingle().insertarActor(a1);
		grafo.crearGrafo(SinglePeliculas.getSingle());
		// Test
		assertTrue(grafo.estanConectadas(p1.getNombre(), p2.getNombre()));
		
		// Caso grafo con una pelicula(3) sin actores
		a1 = new Actor("a1");
		Actor a2 = new Actor("a2");
		p1 = new Pelicula("p1");
		p2 = new Pelicula("p2");
		Pelicula p3 = new Pelicula("p3");
		a1.insertarPelicula(p1);
		p1.insertarActor(a1);
		a2.insertarPelicula(p2);
		p2.insertarActor(a2);
		SingleActores.getSingle().vaciarLista();
		SinglePeliculas.getSingle().vaciarLista();
		SingleActores.getSingle().insertarActor(a1);
		SingleActores.getSingle().insertarActor(a2);
		SinglePeliculas.getSingle().insertarPelicula(p1);
		SinglePeliculas.getSingle().insertarPelicula(p2);
		SinglePeliculas.getSingle().insertarPelicula(p3);
		grafo.crearGrafo(SinglePeliculas.getSingle());
		// Test
		assertFalse(grafo.estanConectadas(a1.getNombre(), p2.getNombre()));
		// Test
		assertTrue(grafo.estanConectadas(p2.getNombre(), a2.getNombre()));
		// Test
		assertTrue(grafo.estanConectadas(p3.getNombre(), a1.getNombre()));
	}

}
