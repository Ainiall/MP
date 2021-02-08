package uo270318.mp.tareaS12.collections_iterators.generics.model;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * <p>
 * Titulo: Clase LinkedList
 * </p>
 * <p>
 * Descripcion: Clase que contiene una implementacion propia de las colecciones
 * LinkedList.
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 * 
 * @author Angela Lopez UO270318
 * @version 1.0
 */
public class LinkedList<T> extends AbstractList<T> {

    private Node head;

    class Node {
	T value;
	Node next;

	Node(T value, Node next) {
	    this.value = value;
	    this.next = next;
	}
    }

    /**
     * Constructor sin parametros
     */
    public LinkedList() {
	this.head = null;
	setNumberOfElements(0);
    }

    public LinkedList(List<T> l) {
	for (int i = 0; i < l.size(); i++) {
	    this.add(l.get(i));
	}
    }

    /**
     * Devuelve el elemento que se encuentra en la posición index de la lista.
     *
     * @param index índice del elemento a recuperar
     * @return El elemento que se encuentra en la posición indicada de la lista
     * @throws IndexOutOfBoundsException si index está fuera del rango
     * ({@code index < 0 || index >= size()})
     */
    @Override
    public T get(int index) {
	checkIndex(index);
	return (T) getNode(index).value;
    }

    /**
     * Reemplaza el elemento de la posición index en la lista con el elemento
     * especificado
     *
     * @param index índice del elemento a reemplazar
     * @param element elemento a almacenar en la posición indicada
     * @return El elemento que se encontraba previamente en la posición index
     * @throws IndexOutOfBoundsException si index está fuera del rango
     * ({@code index < 0 || index > size()})
     */
    @Override
    public T set(int index, T element) {
	checkIndex(index);
	getNode(index).value = element;
	return element;
    }

    /**
     * Inserta el elemento en la posición indicada por index en la lista.
     * Desplaza el elemento actualmente en esa posición (si existe) y los
     * elementos posteriores a la derecha (se incrementan en uno los índices de
     * los elementos desplazados).
     *
     * @param index Posicion donde se desea insertar el elemento
     * @param element elemento que se inserta
     * @throws ClassCastException si la clase del elemento especificado impide
     * que se añada a esta colección
     * @throws NullPointerException si el elemento especificado es nulo y la
     * colección no permite elementos nulos
     * @throws IllegalArgumentException si alguna propiedad del elemento impide
     * que se añada a esta colección
     * @throws IndexOutOfBoundsException si el índice está fuera de rango
     * ({@code index < 0 || index > size()})
     */
    @Override
    public void add(int index, T element) {
	checkIndex(index);
	if (index == 0) {
	    head = new Node(element, head);
	} else {
	    Node previous = getNode(index - 1);
	    previous.next = new Node(element, previous.next);
	}
	setNumberOfElements(getNumberOfElements() + 1);

    }

    /**
     * Elimina el elemento que se encuentra en la posición indicada por index de
     * la lista. Desplaza los elementos posteriores a la izquierda (se
     * decrementa en uno los índices de los elementos desplazados).
     *
     * @param index índice del elemento que se desea eliminar
     * @return El elemento que se encontraba previamente en la posición indicada
     * @throws IndexOutOfBoundsException si index está fuera del rango
     * ({@code index < 0 || index >= size()})
     */
    @SuppressWarnings("unchecked")
    @Override
    public T remove(int index) {
	checkIndex(index);
	if (isEmpty()) {
	    return null;
	}
	Object value;
	if (index == 0) {
	    value = head.value;
	    head = head.next;
	} else {
	    Node previous = getNode(index - 1);
	    value = previous.next.value;
	    previous.next = previous.next.next;
	}
	setNumberOfElements(getNumberOfElements() - 1);
	return (T) value;
    }

    /**
     * Elimina todos los elementos de esta lista (operación opcional).La lista
     * estará vacía después de la ejecución de este método.
     */
    @Override
    public void clear() {
	head = null;
	setNumberOfElements(0);
    }

    /**
     * Devuelve el índice de la primera aparición del elemento en la lista, o -1
     * si la lista no contiene el elemento. Mas formalmente, devuelve el índice
     * más bajo {@code i} tal que
     * {@code (o == null ? get(i) == null : o.equals(get(i)))}, o -1 si no está
     * el elemento.
     *
     * @param o o elemento a buscar
     * @return el índice de la primara aparición del elemento en la lista, o -1
     * si la lista no contiene el elemento
     */
    @Override
    public int indexOf(Object o) {
	Node node = head;
	for (int i = 0; i < size(); i++) {
	    if (node.value == null && o == null) {
		return i;
	    } else if (node.value != null && node.value.equals(o)) {
		return i;
	    }
	    node = node.next;
	}
	return -1;
    }

    /**
     * Devuelve el valor hash code para esta lista. El hash code de la lista es
     * el resultado de la del siguiente cálculo:
     * 
     * <pre>
     * int hashCode = 1;
     * for (Object e : list)
     *     hashCode = 31 * hashCode + (e == null ? 0 : e.hashCode());
     * </pre>
     * 
     * Esto asegura que {@code list1.equals(list2)} implica que
     * {@code list1.hashCode() == list2.hashCode()}
     *
     *
     * @return el valor hash code para esta lista
     */
    @Override
    public int hashCode() {
	int hashCode = 1;
	// no hay iterador creado, no se puede usar foreach
	for (Node node = head; node != null; node = node.next)
	    hashCode = 31 * hashCode + (node == null ? 0 : node.hashCode());
	return hashCode;
    }

    /**
     * Compara el objeto especificado con los elementos de la lista. Devuelve
     * {@code true} si y solo si el objeto especificado es también una lista,
     * ambas listas tienen el mismo tamaño, y todos los correspondientes pares
     * de elementos de las dos listas son <i>equal</i>.
     *
     * @param obj el objeto a ser comparado con la lista
     * @return {@code true} si el objeto especificado es igual a la lista
     */
    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (!(obj instanceof List)) {
	    return false;
	}
	@SuppressWarnings("rawtypes")
	LinkedList other = (LinkedList) obj;
	if (size() != other.size()) {
	    return false;
	}
	int i = 0;
	// head de la lista que invoca el metodo
	for (Node node = head; node != null; node = node.next) {
	    Object e1 = node.value;
	    Object e2 = other.get(i);
	    if (!(e1 == null ? e2 == null : e1.equals((e2)))) {
		return false;
	    }
	    i++;
	}
	return true;
    }

    /**
     * Devuelve la representación textual de la colección. Una lista de
     * elementos encerrados entre corchetes (<tt>"[]"</tt>). Los elementos etán
     * separados por una coma y un espacio <tt>", "</tt>. Los elementos se
     * convierten a strings invocando a su método {@code toString}. Esto es:
     * "[el1, el2, ..., eln]" donde eli es la representación textual de su i-th
     * elemento
     *
     * @return un string con la representación textual de la colección
     */
    @Override
    public String toString() {
	StringBuilder sb = new StringBuilder("[");
	Node node = head;
	if (!isEmpty()) {
	    for (int i = 0; i < size() - 1; i++) {
		if (node.value != null) {
		    sb.append(node.value.toString()).append(", ");
		} else {
		    sb.append("null").append(", ");
		}
		node = node.next;
	    }
	    if (node.value != null) {
		sb.append(node.value.toString());
	    } else {
		sb.append("null");
	    }
	}
	sb.append("]");
	return sb.toString();
    }

    /**
     * Metodo auxiliar que permite obtener el nodo de una posicion que se le
     * pasa como parametro
     * 
     * @param index Posicion a buscar
     * @return node Nodo que se encuentra en esa posicion
     */
    private Node getNode(int index) {
	checkIndex(index);
	Node node = head;
	int position = 0;
	while (position < index) {
	    node = node.next;
	    position++;
	}
	return node;
    }

    /**
     * Iterador que nos permite recorrer la coleccion
     */
    @SuppressWarnings("unchecked")
    @Override
    public Iterator<T> iterator() {
	return (Iterator<T>) new LinkedListIterator();
    }

    /**
     * Iterador LinkedList
     * 
     * @author angela
     */
    private class LinkedListIterator implements Iterator<Object> {
	private Node n = head;
	private Node lastReturned = null;

	/**
	 * Metodo que indica si hay un elemento siguiente al que iterar en la
	 * coleccion
	 */
	@Override
	public boolean hasNext() {
	    return n != null;
	}

	/**
	 * Metodo que devuelve el objeto siguiente de la coleccion
	 */
	@Override
	public Object next() {
	    if (hasNext()) {
		lastReturned = n;
		n = n.next;
		return lastReturned.value;
	    } else {
		throw new NoSuchElementException("There are not more elements");
	    }

	}

    }
}
