package packCodigo;

import java.util.ArrayList;
import java.util.Collections;

public class SingleActores {

	// start-singleton-pattern
		// lazy-initialization
		private static SingleActores	miSingleActores	= null;

		private SingleActores() {
		}

		public static SingleActores getSingle() {

			if (SingleActores.miSingleActores == null) {
				SingleActores.miSingleActores = new SingleActores();
			}

			return SingleActores.miSingleActores;
		}
		// fin-singleton-pattern

	/*
	 * 
	 * CODIGO DE SINGLEACTORES
	 * 
	 */
	private final ArrayList<Actor>	lista			= new ArrayList<Actor>();
	
	/**
	 * Mira si está el actor en la lista.
	 * 
	 * @param nombre
	 * @return	Devuelve TRUE si encuentra el actor, si no FALSE.
	 */
	public boolean estaActor(String nombre) {
		return lista.contains(nombre);
	}
	
	/**
	 * Busca el actor y devuelve su posición.
	 * 
	 * @param nombre
	 * @return Devuelve la POSICIÓN donde se encuentra el actor.
	 */
	public int buscarActor(String nombre) {
		return lista.indexOf(nombre);
	}
	
	/**
	 * Imprime la lista de actores
	 */
	public void imprimir() {
		// Java 8
		// lista.stream().forEach(actor -> System.out.println('\n' + actor.getNombre()));
		// otra forma en Java 8.
		lista.stream().map(Actor::getNombre).forEach(nombreActor -> System.out.println('\n' + nombreActor));
		// Java moderno
		// for (Actor actor : lista) {
			// System.out.println("\n" + actor.getNombre());
		// }
		System.out.println("Se han listado " + lista.size() + " actores.");
	}

	/**
	 * Elimina un actor dado su nombre.
	 * 
	 * @param nombre
	 * @return Devuelve el objeto Actor eliminado. En caso de no eliminarlo devuelve null.
	 */
	public Actor eliminarActor(String nombre) {
		if (this.estaActor(nombre)) {
			return lista.remove(this.buscarActor(nombre));
		} else {
			return null;
		}
	}

	/**
	 * Inserta un actor nuevo pasandole una instancia de Actor.
	 * Ej: Actor a = new Actor();
	 *     if (insertarActor(a)) {
	 *     	 // actor insertado
	 *     }
	 * @param actor
	 * @return TRUE si lo inserta correctamente, si no FALSE.
	 */
	public boolean insertarActor(Actor actor) {
		if (this.estaActor( actor.getNombre() )) {
			return false;
		} else {		
			return lista.add(actor);
		}
		
	}

	/**
	 * Ordenación por QuickSort.
	 * 
	 * @return ArrayList<Actor> ordenado
	 */
	public ArrayList<Actor> ordenar() {
		ArrayList<Actor> listaOrdenada = new ArrayList<Actor>();
		
		// si lista esta vacia
        if (lista.equals(null) || lista.size()==0){
        	// algoritmo de quickSort
        	String[] nombres = (String[]) lista.stream().map(Actor::getNombre).toArray();
        	String[] nombresOrdenados = quickSort( nombres, 0, lista.size() - 1);
        }	
		
		return listaOrdenada;
	}

	 private String[] quickSort(String[] nombres, int lowerIndex, int higherIndex) {
	     int i = lowerIndex;
	     int j = higherIndex;
	     String temp;
	     String pivot = nombres[lowerIndex + (higherIndex - lowerIndex) / 2];
	
	     while (i <= j) {
	         while (nombres[i].compareToIgnoreCase(pivot) < 0) {
	             i++;
	         }
	
	         while (nombres[j].compareToIgnoreCase(pivot) > 0) {
	             j--;
	         }
	
	         if (i <= j) {
	        	 // itercambiar
	    	     temp = nombres[i];
	    	     nombres[i] = nombres[j];
	    	     nombres[j] = temp;
	             i++;
	             j--;
	         }
	     }
	     //call quickSort recursively
	     if (lowerIndex < j) {
	    	 quickSort(nombres, lowerIndex, j);
	     }
	     if (i < higherIndex) {
	         quickSort(nombres, i, higherIndex);
	     }
	     return nombres;
	 }

	public ArrayList<Actor> getLista() {
		return lista;
	}

}
