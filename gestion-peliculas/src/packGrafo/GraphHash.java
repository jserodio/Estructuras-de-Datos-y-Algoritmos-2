package packGrafo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;
import java.util.stream.Collectors;

import packCodigo.Actor;
import packCodigo.Pelicula;
import packCodigo.SinglePeliculas;

public class GraphHash {

	public HashMap<String, ArrayList<String>> g;

	/**
	 * Crea el grafo desde la lista de peliculas
	 * Los nodos son nombres de actores y titulos de peliculas
	 * Coste: o( M x ( N/2 + N x ( P/2 ) ) ) aproximadamente o ( M x 3/2N x P/2 )
	 * donde M es el número de películas totales.
	 * donde N es el número de actores de cada pelicula.
	 * donde P es el número de películas de cada actor. 
	 * 
	 * @param lPeliculas
	 */
	public void crearGrafo (SinglePeliculas lPeliculas) {
		
		g = new HashMap<String, ArrayList<String>>();
		
		if (!lPeliculas.getLista().isEmpty()) {
			// declarar fuera para mejorar la fluidez
			ArrayList<String> nombresActores = null;
			ArrayList<String> nombresPelis = null;
			
			for (Pelicula p : lPeliculas.getLista()) // Coste M (numero de pelis totales) añadido
			{ // Por cada pelicula
				// Si pelicula no esta en el grafo
				if (g.get(p.getNombre()) == null) {
					// Coste N (numero de actores de cada peli añadido)
					nombresActores = (ArrayList<String>) p.getListaActores().stream()
							 .map(a -> a.getNombre())
							   .collect(Collectors.toList()); // !! a ver si no peta ese casting...
					g.put(p.getNombre(), nombresActores);
				}
				
				for (Actor a : p.getListaActores()) { // Coste N
					// Si actor no esta en el grafo
					if (g.get(a.getNombre()) == null) {
						// Coste P (numero de peliculas de cada actor)
						nombresPelis = (ArrayList<String>) a.getListaPeliculas().stream()
								 .map(peli -> peli.getNombre())
								   .collect(Collectors.toList()); // !! a ver si no peta ese casting...
						g.put(a.getNombre(), nombresPelis);
					}
				}	
			}
		}
	}
	
	/**
	 * Siendo p1 y p2 titulos de peliculas o actores, el resultado será
	 * TRUE si hay una cadena de relaciones que une a p1 y p2.
	 * Precondicion: p1 y p2 son diferentes.
	 * Coste:	Caso peor o(N)
	 * 			Caso medio o(N/2)
	 * 			Caso mejor o(1)
	 * Donde N es el número de actores y películas.
	 * 
	 * @param p1
	 * @param p2
	 * @return TRUE si tienen un actor en comun, FALSE si no.
	 */
	public boolean estanConectadas(String p1, String p2) {
		
		if (g.isEmpty() || g.get(p1) == null || g.get(p2) == null) return false;
		else {
			// Dequeue = cola doblemente ligada:
			// https://en.wikipedia.org/wiki/Double-ended_queue#Complexity
			// Operaciones de Queue que no producen excepción:
			// offer(e) = insert (añadir al final de la cola)
			// poll() = remove (eliminar primer elemento)
			// peek() = first (acceder al primer elemento de la cola)
			Queue<String> porExaminar = new ArrayDeque<String>();
			HashSet<String> elemExaminados = new HashSet<String>();
			// opcional: Queue<Integer> q = new LinkedList<Integer>();
			
			// Obtener los contactos del actor o pelicula
			ArrayList<String> contactos = g.get(p1);
			if (contactos.isEmpty()) return false;
			
			elemExaminados.add(p1);
			
			// por cada contacto, añadirlo en una cola para examinar
			for (String c : contactos) {
				porExaminar.offer(c);
			}
			
			String actual = porExaminar.poll();
			boolean encontrado = actual.equals(p2);
			// mientras el elemento no sea el buscado
			// y la cola de búsqueda tenga al menos un elemento
			while ((encontrado == false) && (actual != null)) {
				// nos aseguramos de no dar vueltas infinitas
				// en caso de haber examinado un elemento varias veces
				if (!elemExaminados.contains(actual)) {
					// no es el que buscamos, lo añadimos a elementos examinados
					elemExaminados.add(actual);
					// obtener contactos del actual en la cola e introducirlos en la cola
					contactos = g.get(actual);
					for (String c : contactos) {
						porExaminar.offer(c);
					}
				}
				actual = porExaminar.poll();
				if (actual != null) encontrado = actual.equals(p2);
			}
			
			return encontrado;
		}
	}

	/**
	 * Imprimir
	 */
	public void print() {
		int i = 1;
		for (String s: g.keySet()){
			System.out.print("Element: " + i++ + " " + s + " --> ");
			for (String k: g.get(s)) {
				System.out.println(k + " ### ");
			}
			System.out.println();
		}
	}
}
