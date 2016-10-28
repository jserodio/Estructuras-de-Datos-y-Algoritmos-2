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

	public T removeFirst() {
	// Elimina el primer elemento de la lista
        // Precondición: la lista tiene al menos un elemento
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		return null;
	}

	public T removeLast() {
	// Elimina el último elemento de la lista
        // Precondición: la lista tiene al menos un elemento
			// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		return null;

		   }

	/**
     * Elimina un nodo que se encuentre en la lista ubicado
     * por un valor de referencia.
     * @param referencia valor del nodo que se desea eliminar.
     */
	public T remove(T elem) {
		Node<T> temp = last;
		Node<T> newNodo = last;
		int aux = 0;
		
		if (isEmpty()) {
			return null;
		}
		
		while(!temp.data.equals(elem)){
			aux++;
			newNodo = temp;
			temp = temp.next;
				
			if (aux == count){
					return null;
			}
		}
		
		newNodo.next = temp.next;
		temp.next = null;
		count--;
		
		return temp.data;
	}

	public T first() {
	//Da acceso al primer elemento de la lista
	      if (isEmpty())
	          return null;
	      else return last.next.data;
	}

	public T last() {
	//Da acceso al último elemento de la lista
	      if (isEmpty())
	          return null;
	      else return last.data;
	}

	public boolean contains(T elem) {
		return false;


		   }

	public T find(T elem) {
	//Determina si la lista contiene un elemento concreto, y develve su referencia, null en caso de que no esté
		// COMPLETAR EL CODIGO Y CALCULAR EL COSTE
		return null;


	}

	public boolean isEmpty() 
	//Determina si la lista está vacía
	{ return last == null;};
	
	public int size() 
	//Determina el número de elementos de la lista
	{ return count;};
	
	/** Return an iterator to the stack that iterates through the items . */ 
	   public Iterator<T> iterator() { return new ListIterator(); } 

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
