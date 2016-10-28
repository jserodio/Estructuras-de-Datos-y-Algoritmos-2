package packCircularLinkedList;

import java.util.Iterator;

public interface ListADT<T> {

/**
 * Actualiza el nombre de la lista
 * @param nom
 */
public void setDescr(String nom);

/**
 * Devuelve el nombre de la lista
 * @return
 */
public String getDescr();

/**
 * Elimina el primer elemento de la lista
 * @return
 */
public T removeFirst();

/**
 * Elimina el último elemento de la lista
 * @return
 */
public T removeLast();

/**
 * Elimina un elemento concreto de la lista
 * @param elem
 * @return
 */
public T remove(T elem);

/**
 * Da acceso al primer elemento de la lista
 * @return
 */
public T first();

/**
 * Da acceso al último elemento de la lista
 * @return
 */
public T last();

/**
 * Determina si la lista contiene un elemento concreto
 * @param elem
 * @return
 */
public boolean contains(T elem);

/**
 * Determina si la lista contiene un elemento concreto, y develve su referencia, null en caso de que no esté
 * @param elem
 * @return
 */
public T find(T elem);

/**
 * Determina si la lista está vacía
 * @return
 */
public boolean isEmpty();

/**
 * Determina el número de elementos de la lista
 * @return
 */
public int size();

public Iterator<T> iterator();

}
