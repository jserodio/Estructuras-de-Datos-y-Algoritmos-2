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
	 * Coste: O(n) donde n es el número de elementos.
	 * 
	 * @return elemento eliminado. NULL si no hay elementos que eliminar.
	 */
	public T removeLast() {
		// apuntar al final nodo
		Node<T> current = last;
		T data = null;
		
		// Si no es vacio
		if (!isEmpty()) {
			
			// guardar elemento
			data = last.data;
			
			// Si solo hay un elemento
			if (count==1) {
				// vaciamos la lista
				last = null;
				
			} else {
				
				do {
					current = current.next;
					// hasta que current vuelva a ser el primero
				} while (current.next!=last);				
				// hemos llegado al penultimo
				// apuntar al siguiente no, al siguiente.
				current.next = current.next.next;
				// actualizamos el last
				last = current.next;
			}
			count--;
		}
		
		return data;
	}


	/**
     * Elimina un nodo que se encuentre en la lista ubicado
     * por un valor de referencia.
     * 
     * @param referencia valor del nodo que se desea eliminar.
     * @return elemento eliminado, o null en caso negativo.
     */
	public T remove(T elem) {
		// apuntar al final nodo
		Node<T> current = last;
		T data = null;
		boolean encontrado = false;
		
		// Si no es vacio
		if (!isEmpty()) {
			// Recorrer elementos
			do {
				if (current.next.data.equals(elem)) {
					// para salir del bucle
					encontrado = true;
					// guardar elemento
					data = current.next.data;
					// eliminar nodo (saltarse al siguiente)
					current.next = current.next.next;
					count--;
				}
				current = current.next;
				// hasta que current vuelva a ser el primero
			} while ((current!=last) && (!encontrado));
		}
		
		return data;
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
		
		boolean encontrado = false;
		
		if (!isEmpty()) {
			// Recorrer la lista
			Node<T> current = last.next;
			
			do {
				// comparar
				if (current.data.equals(elem))
					encontrado = true;
				// avanzar al siguiente elemento
				current = current.next;
			} while( (current!=last.next) && (encontrado==false) );
		}
		
		return encontrado;
	}

	/**
	 * Determina si la lista contiene un elemento concreto,
	 * y devuelve su referencia.
	 * 
	 * @param elemento
	 * @return referencia al elemento. NULL en caso de no encontrarlo.
	 */
	public T find(T elem) {
		
		T data = null;
		
		if (!isEmpty()) {
			// Recorrer la lista
			Node<T> current = last.next;
			
			do {
				// comparar
				if (current.data.equals(elem))
					data = current.data;
				// avanzar al siguiente elemento
				current = current.next;
			} while( (current!=last.next) && (data==null) );
		}
		
		return data;
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
		
			private Node<T> current = last;
			boolean firstIteration = true;
			
			/**
			 * Coste: O(1)
			 */
			@Override
			public boolean hasNext() {
				// Si es la primera vez que entra
				if (firstIteration) {
					firstIteration = false;
					return (current != last.next);
				} else {
					// si no
					return (current != last);
				}
			}

			/**
			 * Coste: O(1)
			 */
			@Override
			public T next() {
				//if (!hasNext()) throw new NoSuchElementException();
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
        	if (!isEmpty())
        		System.out.println(this.toString());
		}

        /**
         * Coste: O(n) donde n es el número de elementos.
         */
		@Override
		public String toString() {
			String result = new String();
			Iterator<T> it = iterator();
			T elem;
			while (it.hasNext()) {
				elem = it.next();
				result = result + "[" + elem.toString() + "] \n";
			}
			return "SimpleLinkedList:\n" + result;
		}
}
