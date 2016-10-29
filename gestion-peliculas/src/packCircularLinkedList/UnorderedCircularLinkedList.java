package packCircularLinkedList;

public class UnorderedCircularLinkedList<T> extends CircularLinkedList<T> implements UnorderedListADT<T> {
	
	/**
	 * A�ade un elemento al comienzo de la lista
	 * Coste: O(1)
	 * @param elemento a a�adir
	 */
	public void addToFront(T elem) {
	// a�ade un elemento al comienzo
		Node<T> newNodo = new Node<T>(elem);

		if(isEmpty()){
			last = newNodo;
			newNodo.next = newNodo;
		}else{
			newNodo.next = last.next;
			last.next = newNodo;	
		}
		count++;
	}

	/**
	 * A�ade un elemento al final de la lista
	 * Coste: O(1)
	 * @param elemento a a�adir
	 */
	public void addToRear(T elem) {
		// crear el primer nodo
		Node<T> nodo = new Node<T>(elem);
		
		if (isEmpty()) {
			nodo.next = nodo;
			last = nodo;
		}
		
		nodo.next = last.next;
		last.next = nodo;
		last = nodo;
		
		count++;
	}
	
	/**
	 * A�ade elem detr�s de otro elemento concreto, target,
	 * que ya se encuentra en la lista.
	 * Opcional.
	 * Coste: O(n) donde n es el numero de elementos.
	 * 
	 * Precondiciones: La lista tiene al menos 1 elemento.
	 * 				   Elemento target existe en la lista.
	 * 
	 * Postcondiciones: Queda el elemento insertado justo despu�s.
	 *  
	 * @param elemento, target
	 */
	public void addAfter(T elem, T target) {
		Node<T> nodo = new Node<T>(elem);
		Node<T> nodoT = new Node<T>(target);
		
		// recorrer la lista hasta que el actual sea
		// nodo T, entonces realizar las operaciones.
		Node<T> current;
		current = last.next;
		
		while (!current.data.equals(nodoT.data)) {
			current = current.next;
		}
		
		if (current.data.equals(this.last.data)) {
			last = nodo;
		}
		
		// Al salir del bucle, current es el target
		nodo.next = current.next;
		current.next = nodo;
		
		count++;
	}
	
}


