package packCircularLinkedList;

public class UnorderedCircularLinkedList<T> extends CircularLinkedList<T> implements UnorderedListADT<T> {
	
	public void addToFront(T elem) {
	// añade un elemento al comienzo
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
	// añade un elemento al final 
		Node<T> newNodo = new Node(elem);
		
		if(isEmpty()){
			last = newNodo;
			newNodo.next = newNodo;
		}else{
			newNodo.next = last.next;
			last.next = newNodo;
			last = newNodo;
		}
		count++;
		
	}
	
	//ESTA SIN TERMINAR
	public void addAfter(T elem, T target) {
	// Añade elem detrás de otro elemento concreto, target,  que ya se encuentra en la lista
		// ¡COMPLETAR OPCIONAL!
		Node<T> newNodo = new Node(elem);
		Node<T> temp = last;
		int aux = 0;
		
		//Busca el objetivo en la lista
		while(!temp.data.equals(target) || aux > size()){
			temp = temp.next;
			aux++;
		}
		//Comprueba si el target esta en la lista
		if (aux > size()){
			System.out.println("Elemento no encontrado");
		}else{
			
				
			}
		}
	}


