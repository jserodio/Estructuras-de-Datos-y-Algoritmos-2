package packCircularLinkedList;

public class UnorderedCircularLinkedList<T> extends CircularLinkedList<T> implements UnorderedListADT<T> {
	
	public void addToFront(T elem) {
	// a�ade un elemento al comienzo
		Node<T> newNodo = new Node(elem);

		if(isEmpty()){
			last = newNodo;
			newNodo.next = newNodo;
		}else{
			newNodo.next = last.next;
			last.next = newNodo;	
		}
		count++;
	}

	public void addToRear(T elem) {
	// a�ade un elemento al final 
		Node<T> newNodo = new Node(elem);
		
		if(isEmpty()){
			last = newNodo;
			newNodo.next = newNodo;
		}else{
			newNodo.next = last.next;
			last.next = newNodo;
		}
		count++;
		
	}
	
	public void addAfter(T elem, T target) {
	// A�ade elem detr�s de otro elemento concreto, target,  que ya se encuentra en la lista
		// �COMPLETAR OPCIONAL!
	}

}
