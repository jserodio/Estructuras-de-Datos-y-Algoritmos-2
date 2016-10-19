package packCircularLinkedList;

public interface OrderedListADT<T>  extends ListADT<T> {
	
	/**
	 * Añade un elemento a la lista (en el lugar de orden que le corresponde)
	 * @param elem
	 */
	public void add(T elem);

}
