package packGrafo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;

import packCodigo.Actor;
import packCodigo.Pelicula;
import packCodigo.SinglePeliculas;

public class GraphHash {

	public HashMap<String, ArrayList<String>>	g;
	public HashMap<String, Double>				h;

	/**
	 * Crea el grafo desde la lista de peliculas Los nodos son nombres de
	 * actores y titulos de peliculas Coste: o( M x N ) donde M es el número de
	 * películas totales. donde N es el número de actores de cada pelicula.
	 *
	 * @param lPeliculas
	 */
	public void crearGrafo(SinglePeliculas lPeliculas) {

		g = new HashMap<String, ArrayList<String>>();

		if (!lPeliculas.getLista().isEmpty()) {
			// declarar fuera para mejorar la fluidez
			ArrayList<String> nombresActores = null;
			ArrayList<String> nombresPelis = null;

			for (Pelicula p : lPeliculas.getLista()) // Coste M (numero de pelis
				// totales) añadido
			{ // Por cada pelicula
				// Si pelicula no esta en el grafo
				if (g.get(p.getNombre()) == null) {
					// Coste despreciable N (numero de actores de cada peli
					// añadido)
					nombresActores = (ArrayList<String>) p.getListaActores()
							.stream().map(a -> a.getNombre())
							.collect(Collectors.toList());
					g.put(p.getNombre(), nombresActores);
				}

				for (Actor a : p.getListaActores()) { // Coste N (numero de
					// actores de cada peli)
					// añadido
					// Si actor no esta en el grafo
					if (g.get(a.getNombre()) == null) {
						// Coste P despreciable (numero de peliculas de cada
						// actor)
						nombresPelis = (ArrayList<String>) a
								.getListaPeliculas().stream()
								.map(peli -> peli.getNombre())
								.collect(Collectors.toList());
						g.put(a.getNombre(), nombresPelis);
					}
				}
			}
		}
	}

	/**
	 * Siendo p1 y p2 titulos de peliculas o actores, el resultado será TRUE si
	 * hay una cadena de relaciones que une a p1 y p2. Precondicion: p1 y p2 son
	 * diferentes. Coste: Caso peor o(N)
	 *
	 * Donde N es el número de actores y películas.
	 *
	 * @param p1
	 * @param p2
	 * @return TRUE si tienen un actor en comun, FALSE si no.
	 */
	public boolean estanConectadas(String p1, String p2) {

		if (g.isEmpty() || g.get(p1) == null || g.get(p2) == null)
			return false;
		else {
			// Dequeue = cola doble (bicola):
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
				elemExaminados.add(c);
			}

			String actual = porExaminar.poll();
			boolean encontrado = actual.equals(p2);
			// mientras el elemento no sea el buscado
			// y la cola de búsqueda ten(encontrado == false)ento(actual !=
			// null)contrado == false && actual != null) {
			// obtener contactos del actual en la cola e introducirlos en la
			// cola
			while (encontrado == false && actual != null) {
				// obtener contactos del actual en la cola e introducirlos en la
				// cola
				contactos = g.get(actual);
				for (String c : contactos) {
					if (!elemExaminados.contains(c)) {
						porExaminar.offer(c);
						elemExaminados.add(c);
					}
				}

				actual = porExaminar.poll();
				if (actual != null) {
					encontrado = actual.equals(p2);
				}
			}

			return encontrado;
		}
	}

	public ArrayList<String> estanConectadasS(String p1, String p2) {
		if (g.isEmpty() || g.get(p1) == null || g.get(p2) == null)
			return null;
		else {
			// Dequeue = cola doble (bicola):
			// https://en.wikipedia.org/wiki/Double-ended_queue#Complexity
			// Operaciones de Queue que no producen excepción:
			// offer(e) = insert (añadir al final de la cola)
			// poll() = remove (eliminar primer elemento)
			// peek() = first (acceder al primer elemento de la cola)
			Queue<String> porExaminar = new ArrayDeque<String>();
			HashSet<String> elemExaminados = new HashSet<String>();
			// Stack que llevara todos los elementos examinados;
			Stack<String> recorrido = new Stack<String>();
			// opcional: Queue<Integer> q = new LinkedList<Integer>();

			// Obtener los contactos del actor o pelicula
			ArrayList<String> contactos = g.get(p1);
			if (contactos.isEmpty()) return null;

			elemExaminados.add(p1);

			// por cada contacto, añadirlo en una cola para examinar
			for (String c : contactos) {
				porExaminar.offer(c);
				elemExaminados.add(c);
			}

			String actual = porExaminar.poll();
			boolean encontrado = actual.equals(p2);
			recorrido.push(p1);
			recorrido.push(actual);
			// mientras el elemento no sea el buscado
			// y la cola de búsqueda tenga al menos un elemento(encontrado ==
			// false)ual)(actual != null)ncontrado == false && actual != null) {
			while (encontrado == false && actual != null) {
				// obtener contactos del actual en la cola e introducirlos en la
				// cola
				contactos = g.get(actual);
				for (String c : contactos) {
					if (!elemExaminados.contains(c)) {
						porExaminar.offer(c);
						elemExaminados.add(c);
					}
				}

				actual = porExaminar.poll();
				if (actual != null) {
					encontrado = actual.equals(p2);
					recorrido.push(actual);

				}
			}
			// recorre el grafo a la inversa por el camino mas corto
			if (encontrado) {
				String popped = recorrido.pop();
				ArrayList<String> camino = new ArrayList<String>();
				camino.add(popped);
				contactos = g.get(popped);
				while (!recorrido.empty()) {
					popped = recorrido.pop();
					for (String c : contactos) {
						if (c.equals(popped) && elemExaminados.contains(popped)) {
							camino.add(popped);
							contactos = g.get(popped);
						}
					}

				}
				Collections.reverse(camino);
				return camino;
			} else
				return null;
		}
	}

	public void imrimirOrdenado() {
		for (Map.Entry entry : h.entrySet()) {
			System.out.println("Clave : " + entry.getKey() + " Valor : "
					+ entry.getValue());
		}
	}

	/**
	 * El algoritmo PageRank calcula la probabilidad de que una persona,
	 * accediendo al grafo y siguiendo enlaces, llegue a un nodo en particular.
	 * El cálculo de PageRank requiere varios pases, llamados iteraciones, para
	 * ajustar el valor aproximado.
	 *
	 * Coste: Donde
	 *
	 * @return HashMap<String, Double> devuelve un mapa de actores con su
	 *         PageRank asociado.
	 */
	public HashMap<String, Double> pageRank() {
		final double DAMPINGFACTOR = 0.85F;
		h.clear();
		Double sizeG = (double) g.size();
		// primera interacion
		for (String key : g.keySet()) {
			h.put(key, 1.0 / sizeG);
		}
		double actual = 1.0 / sizeG;
		// Primera vuelta A, luego B, Luego C y luego D.
		for (Entry<String, ArrayList<String>> item : g.entrySet()) {
			double anterior;
			do {
				anterior = actual;
				// Que nodos apuntan a A?
				// creo un array con los relacionados
				ArrayList<String> aux = new ArrayList<String>(g.get(item
						.getKey()));
				// para acumular el sumatorio
				Double Sumatorio = 0.0;
				for (String i : aux) {
					// añade a lo ya sumado la division del page rank entre la
					// cantidad de relazionados
					Sumatorio = Sumatorio + h.get(i) / g.get(i).size();
				}
				h.replace(item.getKey(), (1 - DAMPINGFACTOR) / h.size()
						+ DAMPINGFACTOR * Sumatorio);
				actual = 0.0;
				for (Double sum : h.values()) {
					actual += sum;
				}

			} while (GraphHash.absoluto(actual - anterior) >= 0.0001F);
		}

		return h;
	}

	/**
	 * Imprimir
	 */
	public void print() {
		int i = 1;
		for (String s : g.keySet()) {
			System.out.print("Element: " + i++ + " " + s + " --> ");
			for (String k : g.get(s)) {
				System.out.println(k + " ### ");
			}
			System.out.println();
		}
	}

	private static double absoluto(double a) {
		return a <= 0.0F ? 0.0F - a : a;
	}
}
