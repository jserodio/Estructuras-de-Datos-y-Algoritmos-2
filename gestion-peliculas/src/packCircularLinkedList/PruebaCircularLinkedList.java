package packCircularLinkedList;

import java.util.Iterator;


public class PruebaCircularLinkedList {
	
	public static void main(String[] args)  {
		
		UnorderedCircularLinkedList<Integer> l = new UnorderedCircularLinkedList<Integer>();
		l.addToRear(1);
		l.addToRear(3);
		l.addToRear(6);
		l.addToRear(7);
		l.addToRear(9);
		l.addToRear(0);
		l.addToRear(20);
		l.addToFront(8);
		//l.remove(new Integer(7));

		
		System.out.println(" Lista ...............");
		l.visualizarNodos();
		System.out.println(" Num elementos: " + l.size());
				
		
		System.out.println("Prueba Find ...............");
		System.out.println("9? " + l.find(9));
		System.out.println("0? " + l.find(0));
		System.out.println("7? " + l.find(7));
		
}
}
