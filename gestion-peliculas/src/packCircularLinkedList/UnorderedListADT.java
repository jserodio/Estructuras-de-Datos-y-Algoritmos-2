package packCircularLinkedList;

public interface UnorderedListADT<T> extends ListADT<T> {
	
	/**
	 * Añade un elemento al comienzo de la lista
	 * @param elemento a añadir
	 */
	public void addToFront(T elem);
	 
	/**
	 * Añade un elemento al final de la lista
	 * @param elemento a añadir
	 */
	public void addToRear(T elem);
	
	/**
	 * Añade elem detrás de otro elemento concreto, target,
	 * que ya se encuentra en la lista.
	 * @param elemento, target
	 */
	public void addAfter(T elem, T target);

}
