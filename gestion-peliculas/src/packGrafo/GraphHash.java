package packGrafo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

import packCodigo.Actor;
import packCodigo.Pelicula;
import packCodigo.SinglePeliculas;

public class GraphHash {

	public HashMap<String, ArrayList<String>> g;

	/**
	 * Crea el grafo desde la lista de peliculas
	 * Los nodos son nombres de actores y titulos de peliculas
	 * @param lPeliculas
	 */
	public void crearGrafo (SinglePeliculas lPeliculas) {
		
		g = new HashMap<String, ArrayList<String>>();
		
		if (!lPeliculas.getLista().isEmpty()) {
			// declarar fuera para mejorar la fluidez
			ArrayList<String> nombresActores = null;
			ArrayList<String> nombresPelis = null;
			
			for (Pelicula p : lPeliculas.getLista()) // Coste M (numero de pelis totales) añadido
			{
				
				// Por cada pelicula
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
	 * 
	 * @param p1
	 * @param p2
	 * @return TRUE si tienen un actor en comun, FALSE si no.
	 */
	public boolean estanConectadas(String p1, String p2) {
		
		return false;
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
