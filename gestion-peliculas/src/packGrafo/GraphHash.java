package packGrafo;

import java.util.ArrayList;
import java.util.HashMap;

import packCodigo.SinglePeliculas;

public class GraphHash {

	HashMap<String, ArrayList<String>> g;

	/**
	 * Crea el grafo desde la lista de peliculas
	 * Los nodos son nombres de acotres y titulos de peliculas
	 * @param lPeliculas
	 */
	public void crearGrafo (SinglePeliculas lPeliculas) {
		
	}
	
	/**
	 * Siendo p1 y p2 titulos de peliculas, el resultado será
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
