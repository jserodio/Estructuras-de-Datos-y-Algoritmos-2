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
	 * Precondición: Ninguna.
	 * Postcondición: elimina el primer elemento de la lista.
	 * Coste: O(1)
	 * 
	 * @return	Elemento eliminado. NULL si lista vacia.
	 */
	public T removeFirst() {
		T aux;
		
		if (isEmpty()) {
			return null;
		}
		
		// Guardar el elemento a eliminar
		aux = last.next.data;
		
		// Si solo hay un elemento
		if (this.size() == 1) {
			last = null;
			count = 0;
			return aux;
		} 
		
		// Si hay más elementos
		last.next = last.next.next;
		
		count--;
		return aux;
	}

	/**
	 * Elimina el último elemento de la lista.
	 * Precondición: Ninguna.
	 * Postcondición: elimina el último elemento de la lista.
	 * Coste: 
	 * 
	 * @return elemento eliminado. NULL si no hay elementos que eliminar.
	 */
	public T removeLast() {
		T aux;
		
		if (isEmpty()) {
			return null;
		}
		
		
		
		// Guardar el elemento a eliminar
		aux = last.data;
		/* TODO
		// Si solo hay un elemento
		if (this.size() == 1) {
			
			last = null;
			count = 0;
			return aux;
		} 
		
		// Si hay más elementos
		last.next = last.next.next;
		
		count--;
		*/
		return aux;
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
	 * Coste: O(1)
	 */
	public boolean isEmpty() {
		return last == null;
	};
	
	/**
	 * Determina el número de elementos de la lista.
	 * Coste: O(1)
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
		*/
		private class ListIterator implements Iterator<T> {
		
			private Node<T> current = last.next;
			
			/**
			 * Coste: O(1)
			 */
			@Override
			public boolean hasNext() {
				return (current != last);
			}

			/**
			 * Coste: O(1)
			 */
			@Override
			public T next() {
				if (!hasNext()) throw new NoSuchElementException();
				T item = current.data;
				current = current.next;
				return item;
			} 

   } // Clase privada.
		
		/**
		 * Imprime por pantalla cada nodo.
		 * Coste: O(n) donde n es el número de elementos.
		 */
        public void visualizarNodos() {
			System.out.println(this.toString());
		}

        /**
         * Coste: O(n) donde n es el número de elementos.
         */
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
