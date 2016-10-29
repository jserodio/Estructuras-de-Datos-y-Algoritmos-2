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
 * 
 * @return	Elemento eliminado. NULL si lista vacia.
 */
public T removeFirst();

/**
 * Elimina el último elemento de la lista.
 * 
 * @return elemento eliminado. NULL si no hay elementos que eliminar.
 */
public T removeLast();

/**
 * Elimina un nodo que se encuentre en la lista ubicado
 * por un valor de referencia.
 * 
 * @param referencia valor del nodo que se desea eliminar.
 * @return elemento eliminado, o null en caso negativo.
 */
public T remove(T elem);

/**
 * Da acceso al primer elemento de la lista
 * @return elemento
 */
public T first();

/**
 * Da acceso al último elemento de la lista
 * @return elemento
 */
public T last();

/**
 * Determina si la lista contiene el elemento dado.
 * 
 * @param elemento
 * @return TRUE si lo encuentra. FALSE si no.
 */
public boolean contains(T elem);

/**
 * Determina si la lista contiene un elemento concreto,
 * y devuelve su referencia.
 * 
 * @param elemento
 * @return referencia al elemento. NULL en caso de no encontrarlo.
 */
public T find(T elem);

/**
 * Determina si la lista está vacía.
 * 
 * @return TRUE si vacio, FALSE si no.
 */
public boolean isEmpty();

/**
 * Determina el número de elementos de la lista.
 * @return cantidad de elementos en la lista.
 */
public int size();

/**
 *  Devuelve un iterador.
 */ 
public Iterator<T> iterator();

}
