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
	private final ArrayList<Actor> lista = new ArrayList<Actor>();
	private String[] nombresOrdenados;
	
	/**
	 * Mira si está el actor en la lista.
	 * 
	 * @param nombre
	 * @return	Devuelve TRUE si encuentra el actor, si no FALSE.
	 */
	public boolean estaActor(Actor actor) {
		return lista.contains(actor);
	}
	
	/**
	 * Busca el actor y devuelve su posición.
	 * 
	 * @param nombre
	 * @return Devuelve la POSICIÓN donde se encuentra el actor.
	 * 		   Si no encuentra el actor devuelve -1.
	 */
	public int buscarActor(Actor actor) {
		return lista.indexOf(actor);
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
	 * Elimina un actor.
	 * 
	 * @param nombre
	 * @return Devuelve el objeto Actor eliminado. En caso de no eliminarlo devuelve null.
	 */
	public Actor eliminarActor(Actor actor) {
		if (this.estaActor(actor)) {
			return lista.remove(this.buscarActor(actor));
		} else {
			return null;
		}
	}

	/**
	 * Inserta un actor.
	 * @param actor
	 * @return TRUE si lo inserta correctamente, si no FALSE.
	 */
	public boolean insertarActor(Actor actor) {		
		return lista.add(actor);
	}

	/**
	 * Ordenación por QuickSort.
	 * 
	 * @return ArrayList<Actor> ordenado
	 */
	public String[] ordenar() {
		
		// si lista esta vacia
        if (lista.equals(null) || lista.size()==0) {
        	nombresOrdenados = null;
        } else {
	    	// array de strings con tamano original de la lista
	    	nombresOrdenados = lista.stream().map(Actor::getNombre).toArray(String[]::new);
    		// algoritmo de quickSort
        	nombresOrdenados = quickSort(0, lista.size() - 1);
        }
		
		return nombresOrdenados;
	}

	 private String[] quickSort(int lowerIndex, int higherIndex) {
	     int i = lowerIndex;
	     int j = higherIndex;
	     String temp;
	     String pivot = nombresOrdenados[lowerIndex + (higherIndex - lowerIndex) / 2];
	
	     while (i <= j) {
	         while (nombresOrdenados[i].compareToIgnoreCase(pivot) < 0) {
	             i++;
	         }
	
	         while (nombresOrdenados[j].compareToIgnoreCase(pivot) > 0) {
	             j--;
	         }
	
	         if (i <= j) {
	        	 // itercambiar
	    	     temp = nombresOrdenados[i];
	    	     nombresOrdenados[i] = nombresOrdenados[j];
	    	     nombresOrdenados[j] = temp;
	             i++;
	             j--;
	         }
	     }
	     //call quickSort recursively
	     if (lowerIndex < j) {
	    	 quickSort(lowerIndex, j);
	     }
	     if (i < higherIndex) {
	         quickSort(i, higherIndex);
	     }
	     return nombresOrdenados;
	 }

	public ArrayList<Actor> getLista() {
		return lista;
	}

}
