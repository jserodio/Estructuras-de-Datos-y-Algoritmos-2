package packCircularLinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CircularLinkedList<T> implements ListADT<T> {

	// Atributos
	protected Node<T> last; // apuntador al ultimo
	protected String descr;  // descripción
	protected int count;

	// Constructor
	public CircularLinkedList() {
		last = null;
		descr = "";
		count = 0;
	}
	
	public void setDescr(String nom) {
		descr = nom;
	}

	public String getDescr() {
		return descr;
	}

	/**
	 * Elimina el primer elemento de la lista
	 * Precondición: la lista tiene al menos un elemento
	 * COMPLETAR EL CODIGO Y CALCULAR EL COSTE
	 */
	public T removeFirst() {
	
		return null;
	}

	/**
	 * Elimina el último elemento de la lista.
	 * Precondición: la lista tiene al menos un elemento.
	 * Postcondición: elimina el último elemento de la lista.
	 * 
	 * COMPLETAR EL CODIGO Y CALCULAR EL COSTE
	 */
	public T removeLast() {
	 
		return null;
	}

	/**
	 * Elimina un elemento concreto de la lista
	 * 
	 * COMPLETAR EL CODIGO Y CALCULAR EL COSTE
	 */
	public T remove(T elem) {
	
		return null;

	}
	
	/**
	 * Da acceso al primer elemento de la lista
	 */
	public T first() {
	      if (isEmpty())
	          return null;
	      else return last.next.data;
	}

	/**
	 * Da acceso al último elemento de la lista
	 */
	public T last() {
	      if (isEmpty())
	          return null;
	      else return last.data;
	}

	/**
	 * Determina si la lista contiene el elemento dado.
	 * 
	 * @param elemento
	 * @return TRUE si lo encuentra. FALSE si no.
	 */
	public boolean contains(T elem) {
	
		return false;
	}

	/**
	 * Determina si la lista contiene un elemento concreto,
	 * y devuelve su referencia.
	 * 
	 * @param elemento
	 * @return referencia al elemento. NULL en caso de no encontrarlo.
	 */
	public T find(T elem) {
		
		return null;
	}
	
	/**
	 * Determina si la lista está vacía.
	 */
	public boolean isEmpty() {
		return last == null;
	};
	
	/**
	 * Determina el número de elementos de la lista.
	 */
	public int size() {
		return count;
	};
	
	/**
	 *  Return an iterator to the stack that iterates through the items.
	 */ 
	   public Iterator<T> iterator() {
		   return new ListIterator();
	   } 

	   /**
	    * Clase privada ListIterator.
	    * COMPLETAR EL CODIGO Y CALCULAR EL COSTE 
	    */
	   private class ListIterator implements Iterator<T> {

		@Override
		public boolean hasNext() {
			// TODO
			return false;
		}

		@Override
		public T next() {
			// TODO
			return null;
		} 

	   } // Clase privada.
		
		/**
		 * Imprime por pantalla cada nodo.
		 */
        public void visualizarNodos() {
			System.out.println(this.toString());
		}

		@Override
		public String toString() {
			String result = new String();
			Iterator<T> it = iterator();
			while (it.hasNext()) {
				T elem = it.next();
				result = result + "[" + elem.toString() + "] \n";
			}	
			return "SimpleLinkedList " + result + "]";
		}

}
