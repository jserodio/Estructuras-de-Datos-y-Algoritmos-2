package packCodigo;

import java.util.ArrayList;

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
	private ArrayList<Actor> lista = new ArrayList<Actor>();
	private String[] nombresOrdenados;
	
	/**
	 * Mira si está el actor en la lista.
	 * 
	 * @param Actor
	 * @return	Devuelve TRUE si encuentra el actor, si no FALSE.
	 */
	public boolean estaActor(Actor actor) {
		if (this.lista == null)	return false;
		else return lista.contains(actor);
	}
	
	/**
	 * Busca el actor y devuelve su posición.
	 * 
	 * @param Actor
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
		System.out.print("\n");
		if (lista != null) {
			// Java 8
			// lista.stream().forEach(actor -> System.out.println('\n' + actor.getNombre()));
			// otra forma en Java 8.
			lista.stream().map(Actor::getNombre).forEach(nombreActor -> System.out.println("-" + nombreActor));
			// Java moderno
			// for (Actor actor : lista) {
				// System.out.println("\n" + actor.getNombre());
			// }
			System.out.println("\nSe han listado " + lista.size() + " actores.\n");

		} else {
			System.out.println("Debe cargar los datos primero.");
		}
	}

	/**
	 * Elimina un actor.
	 * 
	 * @param Actor
	 * @return Devuelve el objeto Actor eliminado. En caso de no eliminarlo devuelve NULL.
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
	 * Coste: O(n·Log2·n)
	 * 
	 * @return String[] ordenado. NULL si la lista está vacia.
	 */
	public String[] ordenar() {
		
		// si lista esta vacia
        if (lista.equals(null) || lista.size()==0) {
        	nombresOrdenados = null;
        	System.out.println("Debe cargar los datos primero o insertar nuevos.");
        } else {
	    	// array de strings con tamano original de la lista
	    	nombresOrdenados = lista.stream().map(Actor::getNombre).toArray(String[]::new);
    		// algoritmo de quickSort
        	nombresOrdenados = quickSort(0, lista.size() - 1);
        }
		
		return nombresOrdenados;
	}

	private String[] quickSort(int inicio, int fin) {
	     int izq = inicio;
	     int der = fin;
	     String temp;
	     String pivote = nombresOrdenados[inicio + (fin - inicio) / 2];
	
	     while (izq <= der) {
	         while (nombresOrdenados[izq].compareToIgnoreCase(pivote) < 0) {
	             izq++;
	         }
	
	         while (nombresOrdenados[der].compareToIgnoreCase(pivote) > 0) {
	             der--;
	         }
	
	         if (izq <= der) {
	    	     temp = nombresOrdenados[izq];
	    	     nombresOrdenados[izq] = nombresOrdenados[der];
	    	     nombresOrdenados[der] = temp;
	             izq++;
	             der--;
	         }
	     }
	     if (inicio < der) {
	    	 quickSort(inicio, der); // recursividad
	     }
	     if (izq < fin) {
	         quickSort(izq, fin); // recursividad
	     }
	     return nombresOrdenados;
	 }

	public ArrayList<Actor> getLista() {
		return lista;
	}

	/**
	 * Vaciar lista.
	 */
	public void vaciarLista() {
		this.lista = new ArrayList<Actor>();
	}

}
