package packCircularLinkedList;

public interface UnorderedListADT<T> extends ListADT<T> {
	
	/**
	 * A�ade un elemento al comienzo de la lista
	 * @param elemento a a�adir
	 */
	public void addToFront(T elem);
	 
	/**
	 * A�ade un elemento al final de la lista
	 * @param elemento a a�adir
	 */
	public void addToRear(T elem);
	
	/**
	 * A�ade elem detr�s de otro elemento concreto, target,
	 * que ya se encuentra en la lista.
	 * @param elemento, target
	 */
	public void addAfter(T elem, T target);

}
