package packPruebas;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import packCircularLinkedList.UnorderedCircularLinkedList;
import packCodigo.Actor;

public class TestUnorderedCircularLinkedList {

	@Test
	public void testAddToFront() {
		// Crear la lista
		UnorderedCircularLinkedList<Actor> lista = new UnorderedCircularLinkedList<Actor>();
		
		// Lista vacia
		Actor actor1 = new Actor("actor1");
		lista.addToFront(actor1);
		
		assertEquals(1, lista.size());
		assertEquals(actor1, lista.last());
		
		// Lista con 1 nodo
		Actor actor2 = new Actor("actor2");
		lista.addToFront(actor2);
		
		assertEquals(2, lista.size());
		assertEquals(actor1, lista.last());
		
		// Lista con 2 nodos
		Actor actor3 = new Actor("actor3");
		lista.addToFront(actor3);
		
		assertEquals(3, lista.size());
		assertEquals(actor1, lista.last());
	}

	@Test
	public void testAddToRear() {
		// Crear la lista
		UnorderedCircularLinkedList<Actor> lista = new UnorderedCircularLinkedList<Actor>();
		
		// Lista vacia
		Actor actor1 = new Actor("actor1");
		lista.addToRear(actor1);
		
		assertEquals(1, lista.size());
		assertEquals(actor1, lista.last());
		
		// Lista con 1 nodo
		Actor actor2 = new Actor("actor2");
		lista.addToRear(actor2);
		
		assertEquals(2, lista.size());
		assertEquals(actor2, lista.last());
		
		// Lista con 2 nodos
		Actor actor3 = new Actor("actor3");
		lista.addToRear(actor3);
		
		assertEquals(3, lista.size());
		assertEquals(actor3, lista.last());
	}

	@Test
	public void testAddAfter() {
		// Crear la lista
		UnorderedCircularLinkedList<Actor> lista = new UnorderedCircularLinkedList<Actor>();

		Actor actor1 = new Actor("actor1");
		lista.addToRear(actor1);
		
		// Lista con 1 nodo
		Actor actor2 = new Actor("actor2");
		lista.addAfter(actor2, actor1);
		
		assertEquals(2, lista.size());
		assertEquals(actor2, lista.last());
		
		// Lista con 2 nodos
		Actor actor3 = new Actor("actor3");
		lista.addAfter(actor3, actor2);
		
		assertEquals(3, lista.size());
		assertEquals(actor3, lista.last());
		
		// Lista con 3 nodos
		Actor actor4 = new Actor("actor4");
		lista.addAfter(actor4, actor1);
		
		assertEquals(4, lista.size());
		assertEquals(actor3, lista.last());
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
			assertTrue(actual == null);
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
			assertEquals(true, actual);
			
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
		
		// Precondicion: tiene que funcionar contains.
		
		// Crear la lista
		UnorderedCircularLinkedList<Actor> lista = new UnorderedCircularLinkedList<Actor>();
		
		// Crear segunda lista recorriendo la primera
		UnorderedCircularLinkedList<Actor> lista2 = new UnorderedCircularLinkedList<Actor>();
		
		Actor actor = new Actor("actor"), actor2 = actor, actor3 = actor, actor4 = actor,
		actor5 = actor, actor6 = actor;
		
		lista.addToRear(actor);
		lista.addToRear(actor2);
		lista.addToRear(actor3);
		lista.addToRear(actor4);
		lista.addToRear(actor5);
		lista.addToRear(actor6);
		
		Iterator<Actor> it = lista.iterator();
		
		while(it.hasNext()) {
			Actor elem = (Actor) it.next();
			lista2.addToRear(elem);
		}
		
		it = lista2.iterator();
		
		while(it.hasNext()) {
			Actor elem = (Actor) it.next();
			assertTrue(lista.contains(elem));
		}
	}

}
