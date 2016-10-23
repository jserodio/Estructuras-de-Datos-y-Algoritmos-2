package packCircularLinkedList;

public class UnorderedCircularLinkedList<T> extends CircularLinkedList<T> implements UnorderedListADT<T> {
	
	/**
	 * Añade un elemento al comienzo de la lista
	 * 
	 * @param elemento a añadir
	 */
	public void addToFront(T elem) {
		// crear el primer nodo
		Node<T> nodo = new Node<T>(elem);
		
		if (this.size() == 0) {
			nodo.next = nodo;
			this.last = nodo;
		}
		
		nodo.next = this.last.next;
		this.last.next = nodo;	
		
		this.count++;
	}

	/**
	 * Añade un elemento al final de la lista
	 * 
	 * @param elemento a añadir
	 */
	public void addToRear(T elem) {
		// crear el primer nodo
		Node<T> nodo = new Node<T>(elem);
		
		if (this.size() == 0) {
			nodo.next = nodo;
			this.last = nodo;
		}
		
		nodo.next = this.last.next;
		this.last.next = nodo;
		this.last = nodo;
		
		this.count++;
	}
	
	/**
	 * Añade elem detrás de otro elemento concreto, target,
	 * que ya se encuentra en la lista.
	 * Opcional.
	 * 
	 * Precondiciones: La lista tiene al menos 1 elemento.
	 * 				   Elemento target existe en la lista.
	 * 
	 * Postcondiciones: Queda el elemento insertado justo después.
	 *  
	 * @param elemento, target
	 */
	public void addAfter(T elem, T target) {
		Node<T> nodo = new Node<T>(elem);
		Node<T> nodoT = new Node<T>(target);
		
		// recorrer la lista hasta que el actual sea
		// nodo T, entonces realizar las operaciones.
		Node<T> current;
		current = this.last.next;
		
		while (!current.data.equals(nodoT.data)) {
			current = current.next;
		}
		
		if (current.data.equals(this.last.data)) {
			this.last = nodo;
		}
		
		// Al salir del bucle, current es el target
		nodo.next = current.next;
		current.next = nodo;
		
		this.count++;
	}

}
