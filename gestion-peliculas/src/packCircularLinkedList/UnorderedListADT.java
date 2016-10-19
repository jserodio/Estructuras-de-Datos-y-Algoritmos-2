package packCircularLinkedList;

public interface UnorderedListADT<T> extends ListADT<T> {
	
	/**
	 * a�ade un elemento al comienzo
	 * @param elem
	 */
	public void addToFront(T elem);
	 
	/**
	 * a�ade un elemento al final
	 * @param elem
	 */
	public void addToRear(T elem);
	
	/**
	 * A�ade elem detr�s de otro elemento concreto, target,  que ya se encuentra en la lista
	 * @param elem
	 * @param target
	 */
	public void addAfter(T elem, T target);

}
