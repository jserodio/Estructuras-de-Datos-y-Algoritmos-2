package packPruebas;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.junit.Test;

import packCodigo.Actor;
import packCodigo.Pelicula;
import packCodigo.SingleActores;
import packCodigo.SinglePeliculas;
import packCodigo.Stopwatch;
import packGrafo.GraphHash;

public class TestGraphHash {

	@Test
	public void testCrearGrafo() {
		SinglePeliculas.getSingle().cargarDatos("casoVacio.txt");
		
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
		
		assertTrue(grafo.g.get(p1.getNombre()).contains(a1.getNombre()));
		assertTrue(grafo.g.get(p1.getNombre()).contains(a2.getNombre()));
		assertTrue(grafo.g.get(p1.getNombre()).contains(a3.getNombre()));
		assertTrue(grafo.g.get(a1.getNombre()).contains(p1.getNombre()));
		assertTrue(grafo.g.get(a2.getNombre()).contains(p1.getNombre()));
		assertTrue(grafo.g.get(a3.getNombre()).contains(p1.getNombre()));
	}

	@Test
	public void testEstanConectadas() {
		
		// Caso grafo vacio
		SinglePeliculas.getSingle().cargarDatos("casoVacio.txt");
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
		assertFalse(grafo.estanConectadas(p3.getNombre(), a1.getNombre()));
	}

	@Test
	public void testTimeEstanConectadas() {
		Stopwatch timer = null;
		GraphHash grafo = null;
		List<String> listaActores = null;
		List<String> listaPeliculas = null;
		Random randomIndex = new Random();
		int min = 0;
		int maxA;
		int maxP;
		int cuenta;
		String p1;
		String p2;
		
		System.out.println("\nCargando archivo, espere por favor.");
		timer = new Stopwatch();
		SinglePeliculas.getSingle().cargarDatos("FilmsActors20162017.txt");			
		System.out.println("El archivo ha sido cargado.");
		System.out.println(timer.elapsedTime() + " segundos.\n");
		
		System.out.println("Creando grafo, espere por favor.");
		timer = new Stopwatch();
		grafo = new GraphHash();
		grafo.crearGrafo(SinglePeliculas.getSingle());
		System.out.println("El grafo ha sido creado.");
		System.out.println(timer.elapsedTime() + " segundos.\n");
		
		listaActores = SingleActores.getSingle().getLista().stream()
			.map(a -> a.getNombre())
				.collect(Collectors.toList());
		listaPeliculas = SinglePeliculas.getSingle().getLista().stream()
			.map(p -> p.getNombre())
				.collect(Collectors.toList());
		
		maxA = listaActores.size()-1;
		maxP = listaPeliculas.size()-1;
			
		timer = new Stopwatch();
		cuenta = 0;
		// 10 seconds
		while (timer.elapsedTime()<10) {
			p1 = listaActores.get(randomIndex.nextInt(maxA) + min);
			p2 = listaPeliculas.get(randomIndex.nextInt(maxP) + min);
			grafo.estanConectadas(p1, p2);
			cuenta++;
		}
		System.out.println("Se ha llamado a estanConectadas en 10 segundos: " + cuenta + " veces.");
		System.out.println(timer.elapsedTime() + " segundos.\n");
		
		timer = new Stopwatch();
		cuenta = 0;
		// 1 minute
		while (timer.elapsedTime()<60) {
			p1 = listaActores.get(randomIndex.nextInt(maxA) + min);
			p2 = listaPeliculas.get(randomIndex.nextInt(maxP) + min);
			grafo.estanConectadas(p1, p2);
			cuenta++;
		}
		System.out.println("Se ha llamado a estanConectadas en 1 minuto: " + cuenta + " veces.");
		System.out.println(timer.elapsedTime() + " segundos.\n");
		
		timer = new Stopwatch();
		cuenta = 0;
		// 10 minutes
		while (timer.elapsedTime()<600) {
			p1 = listaActores.get(randomIndex.nextInt(maxA) + min);
			p2 = listaPeliculas.get(randomIndex.nextInt(maxP) + min);
			grafo.estanConectadas(p1, p2);
			cuenta++;
		}
		System.out.println("Se ha llamado a estanConectadas en 10 minutos: " + cuenta + " veces.");
		System.out.println(timer.elapsedTime() + " segundos.\n");
		
		timer = new Stopwatch();
		cuenta = 0;
		// 30 minutes
		while (timer.elapsedTime()<1800) {
			p1 = listaActores.get(randomIndex.nextInt(maxA) + min);
			p2 = listaPeliculas.get(randomIndex.nextInt(maxP) + min);
			grafo.estanConectadas(p1, p2);
			cuenta++;
		}
		System.out.println("Se ha llamado a estanConectadas en 30 minutos: " + cuenta + " veces.");
		System.out.println(timer.elapsedTime() + " segundos.\n");
		
		timer = new Stopwatch();
		cuenta = 0;
		// 60 minutes
		while (timer.elapsedTime()<3600) {
			p1 = listaActores.get(randomIndex.nextInt(maxA) + min);
			p2 = listaPeliculas.get(randomIndex.nextInt(maxP) + min);
			grafo.estanConectadas(p1, p2);
			cuenta++;
		}
		System.out.println("Se ha llamado a estanConectadas en 1 hora: " + cuenta + " veces.");
		System.out.println(timer.elapsedTime() + " segundos.\n");
	}
}
