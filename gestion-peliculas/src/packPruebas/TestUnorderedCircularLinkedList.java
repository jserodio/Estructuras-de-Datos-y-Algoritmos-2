package packPruebas;

import static org.junit.Assert.*;

import org.junit.Test;

import packCircularLinkedList.UnorderedCircularLinkedList;
import packCodigo.Actor;

public class TestUnorderedCircularLinkedList {

	@Test
	public void testAddToFront() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddToRear() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddAfter() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetDescr() {
		// Crear la lista
		UnorderedCircularLinkedList<Actor> lista = new UnorderedCircularLinkedList<Actor>();
		String expected = "nombre";
		lista.setDescr(expected);
		
		String actual = lista.getDescr();
		assertEquals(expected, actual);
	}

	@Test
	public void testGetDescr() {
		// Crear la lista
		UnorderedCircularLinkedList<Actor> lista = new UnorderedCircularLinkedList<Actor>();
		String expected = "nombre";
		lista.setDescr(expected);
		
		String actual = lista.getDescr();
		assertEquals(expected, actual);
	}

	@Test
	public void testRemoveFirst() {
		Actor expected;
		Actor actual;
		
		// Crear la lista
		UnorderedCircularLinkedList<Actor> lista = new UnorderedCircularLinkedList<Actor>();
		
		// Caso lista vacia
		
			// Test
			expected = null;
			actual = lista.removeFirst();
			assertEquals(expected, actual);
		
		// Caso lista con un actor
		Actor actor = new Actor("actor1");
		lista.addToFront(actor);
		
			// Test
			actual = lista.removeFirst();
			assertEquals(actor, actual);
			
		// Caso lista con 2 actors
		Actor actor2 = new Actor("actor2");
		lista.addToFront(actor);
		lista.addToFront(actor2);
		
			// Test
			actual = lista.removeFirst();
			assertEquals(actor2, actual);
			
		// Caso lista con 3 actors
		Actor actor3 = new Actor("actor3");
		lista.addToFront(actor2);
		lista.addToFront(actor3);
		
			// Test
			actual = lista.removeFirst();
			assertEquals(actor3, actual);
		
	}

	@Test
	public void testRemoveLast() {
		Actor expected;
		Actor actual;
		
		// Crear la lista
		UnorderedCircularLinkedList<Actor> lista = new UnorderedCircularLinkedList<Actor>();
		
		// Caso lista vacia
		
			// Test
			expected = null;
			actual = lista.removeLast();
			assertEquals(expected, actual);
		
		// Caso lista con un actor
		Actor actor = new Actor("actor1");
		lista.addToRear(actor);
		
			// Test
			actual = lista.removeLast();
			assertEquals(actor, actual);
			
		// Caso lista con 2 actors
		Actor actor2 = new Actor("actor2");
		lista.addToRear(actor);
		lista.addToRear(actor2);
		
			// Test
			actual = lista.removeLast();
			assertEquals(actor2, actual);
			
		// Caso lista con 3 actors
		Actor actor3 = new Actor("actor3");
		lista.addToRear(actor2);
		lista.addToRear(actor3);
		
			// Test
			actual = lista.removeLast();
			assertEquals(actor3, actual);
		
	}

	@Test
	public void testRemove() {
		Actor expected;
		Actor actual;
		
		// Crear la lista
		UnorderedCircularLinkedList<Actor> lista = new UnorderedCircularLinkedList<Actor>();
		
		// Caso lista vacia
		
			// Test
			expected = null;
			actual = lista.remove(new Actor("actor1"));
			assertEquals(expected, actual);
		
		// Caso lista con un actor
		Actor actor = new Actor("actor1");
		lista.addToRear(actor);
		
			// Test
			actual = lista.remove(actor);
			assertEquals(actor, actual);
			
		// Caso lista con 2 actors
		Actor actor2 = new Actor("actor2");
		lista.addToRear(actor);
		lista.addToRear(actor2);
		
			// Test
			actual = lista.remove(actor);
			assertEquals(actor, actual);
			
		// Caso lista con 3 actors
		Actor actor3 = new Actor("actor3");
		lista.addToFront(actor);
		lista.addToRear(actor3);
		
			// Test
			actual = lista.remove(actor2);
			assertEquals(actor2, actual);
		
		// Caso si no existe
		Actor actor4 = new Actor("actor4");
		lista.addToRear(actor4);
		
			// Test
			actual = lista.remove(new Actor("actor5"));
			assertFalse(actual.equals(actor4));
	}

	@Test
	public void testFirst() {
		Actor expected;
		Actor actual;
		
		// Crear la lista
		UnorderedCircularLinkedList<Actor> lista = new UnorderedCircularLinkedList<Actor>();
		
		// Caso lista vacia
		
			// Test
			expected = null;
			actual = lista.first();
			assertEquals(expected, actual);
			
		// Caso lista con un actor
		Actor actor = new Actor("actor1");
		lista.addToRear(actor);
		
			// Test
			actual = lista.first();
			assertEquals(actor, actual);
			
		// Caso lista con 2 actors
		Actor actor2 = new Actor("actor2");
		lista.addToRear(actor2);
			
			// Test
			actual = lista.first();
			assertEquals(actor, actual);
			
		// Caso lista con 3 actors
		Actor actor3 = new Actor("actor3");
		lista.addToRear(actor3);
		
			// Test
			actual = lista.first();
			assertEquals(actor, actual);
			
	}

	@Test
	public void testLast() {
		Actor expected;
		Actor actual;
		
		// Crear la lista
		UnorderedCircularLinkedList<Actor> lista = new UnorderedCircularLinkedList<Actor>();
		
		// Caso lista vacia
		
			// Test
			expected = null;
			actual = lista.last();
			assertEquals(expected, actual);
			
		// Caso lista con un actor
		Actor actor = new Actor("actor1");
		lista.addToRear(actor);
		
			// Test
			actual = lista.last();
			assertEquals(actor, actual);
			
		// Caso lista con 2 actors
		Actor actor2 = new Actor("actor2");
		lista.addToRear(actor2);
			
			// Test
			actual = lista.last();
			assertEquals(actor2, actual);
			
		// Caso lista con 3 actors
		Actor actor3 = new Actor("actor3");
		lista.addToRear(actor3);
		
			// Test
			actual = lista.last();
			assertEquals(actor3, actual);
			
	}

	@Test
	public void testContains() {
		boolean expected;
		boolean actual;
		
		// Crear la lista
		UnorderedCircularLinkedList<Actor> lista = new UnorderedCircularLinkedList<Actor>();
		
		// Caso lista vacia
		
			// Test
			expected = false;
			actual = lista.contains(new Actor("actor2"));
			assertEquals(expected, actual);
			
		// Caso lista con un actor
		Actor actor = new Actor("actor1");
		lista.addToRear(actor);
		
			// Test
			actual = lista.contains(new Actor("actor2"));
			assertEquals(false, actual);
			
		// Caso lista con 2 actors
		Actor actor2 = new Actor("actor2");
		lista.addToRear(actor2);
			
			// Test
			actual = lista.contains(actor2);
			assertEquals(true, actual);
			
		// Caso lista con 3 actors
		Actor actor3 = new Actor("actor3");
		lista.addToRear(actor3);
		
			// Test
			actual = lista.contains(actor2);
			assertEquals(actor2, actual);
			
	}

	@Test
	public void testFind() {
		Actor expected;
		Actor actual;
		
		// Crear la lista
		UnorderedCircularLinkedList<Actor> lista = new UnorderedCircularLinkedList<Actor>();
		
		// Caso lista vacia
		
			// Test
			expected = null;
			actual = lista.find(new Actor("actor2"));
			assertEquals(expected, actual);
			
		// Caso lista con un actor
		Actor actor = new Actor("actor1");
		lista.addToRear(actor);
		
			// Test
			actual = lista.find(new Actor("actor2"));
			assertEquals(null, actual);
			
		// Caso lista con 2 actors
		Actor actor2 = new Actor("actor2");
		lista.addToRear(actor2);
			
			// Test
			actual = lista.find(actor2);
			assertEquals(actor2, actual);
			
		// Caso lista con 3 actors
		Actor actor3 = new Actor("actor3");
		lista.addToRear(actor3);
		
			// Test
			actual = lista.find(actor2);
			assertEquals(actor2, actual);
		
	}

	@Test
	public void testIsEmpty() {
		boolean expected;
		boolean actual;
		
		// Crear la lista
		UnorderedCircularLinkedList<Actor> lista = new UnorderedCircularLinkedList<Actor>();
		
		// Caso lista vacia
		
			// Test
			expected = true;
			actual = lista.isEmpty();
			assertEquals(expected, actual);
			
		// Caso lista con un actor
		Actor actor = new Actor("actor1");
		lista.addToRear(actor);
		
			// Test
			actual = lista.isEmpty();
			assertEquals(false, actual);
			
		// Caso lista con 2 actors
		Actor actor2 = new Actor("actor2");
		lista.addToRear(actor2);
			
			// Test
			actual = lista.isEmpty();
			assertEquals(false, actual);
			
	}

	@Test
	public void testSize() {
		int expected;
		int actual;
		
		// Crear la lista
		UnorderedCircularLinkedList<Actor> lista = new UnorderedCircularLinkedList<Actor>();
		
		// Caso lista vacia
		
			// Test
			expected = 0;
			actual = lista.size();
			assertEquals(expected, actual);
			
		// Caso lista con un actor
		Actor actor = new Actor("actor1");
		lista.addToRear(actor);
		
			// Test
			expected = 1;
			actual = lista.size();
			assertEquals(expected, actual);
			
		// Caso lista con 2 actors
		Actor actor2 = new Actor("actor2");
		lista.addToRear(actor2);
			
			// Test
			expected = 2;
			actual = lista.size();
			assertEquals(expected, actual);
			
		// Caso lista con 3 actors
		Actor actor3 = new Actor("actor3");
		lista.addToRear(actor3);
			
			// Test
			expected = 3;
			actual = lista.size();
			assertEquals(expected, actual);
	}

	@Test
	public void testIterator() {
		fail("Not yet implemented");
	}

}
