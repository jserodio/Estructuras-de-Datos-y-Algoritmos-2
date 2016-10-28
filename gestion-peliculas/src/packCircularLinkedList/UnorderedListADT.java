package packCircularLinkedList;

public interface UnorderedListADT<T> extends ListADT<T> {
	
	/**
	 * añade un elemento al comienzo
	 * @param elem
	 */
	public void addToFront(T elem);
	 
	/**
	 * añade un elemento al final
	 * @param elem
	 */
	public void addToRear(T elem);
	
	/**
	 * Añade elem detrás de otro elemento concreto, target,  que ya se encuentra en la lista
	 * @param elem
	 * @param target
	 */
	public void addAfter(T elem, T target);

}
