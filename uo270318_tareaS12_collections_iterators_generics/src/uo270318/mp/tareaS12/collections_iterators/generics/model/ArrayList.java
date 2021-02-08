package uo270318.mp.tareaS12.collections_iterators.generics.model;

import java.util.Iterator;
import java.util.NoSuchElementException;


/**
 * <p>
 * Titulo: Clase ArrayList
 * </p>
 * <p>
 * Descripcion: Clase que contiene una implementacion propia de las colecciones
 * ArrayList.
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 * 
 * @author Angela Lopez UO270318
 * @version 1.0
 * @param <T> tipo generico
 */
public class ArrayList<T> extends AbstractList<T> {

    private T[] elements;

    private static final int INITIAL_CAPACITY = 20;

    /**
     * Constructor con parametros que inicializa el ArrayList con una capacidad
     * que se le pasa como parametro.
     * 
     * @param capacity Capacidad del array.
     */
    @SuppressWarnings("unchecked")
    public ArrayList(int capacity) {
	elements = (T[])new Object[capacity];
	setNumberOfElements(0);
    }

    /**
     * Constructor sin parametros que inicializa el ArrayList a una capacidad
     * por defecto
     */
    public ArrayList() {
	this(INITIAL_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public ArrayList(List<T> l) {
	elements =(T[]) new Object[l.size()];
	for(T object:l) {
	    this.add(object);
	}
    }
    /**
     * Devuelve el elemento que se encuentra en la posici�n index de la lista.
     *
     * @param index �ndice del elemento a recuperar
     * @return El elemento que se encuentra en la posici�n indicada de la lista
     * @throws IndexOutOfBoundsException si index est� fuera del rango
     *                                   ({@code index < 0 || index >= size()})
     */
    @Override
    public T get(int index) {
	checkIndex(index);
	return elements[index];
    }

    /**
     * Reemplaza el elemento de la posici�n index en la lista con el elemento
     * especificado
     *
     * @param index   �ndice del elemento a reemplazar
     * @param element elemento a almacenar en la posici�n indicada
     * @return El elemento que se encontraba previamente en la posici�n index
     * @throws IndexOutOfBoundsException si index est� fuera del rango
     *                                   ({@code index < 0 || index > size()})
     */
    @Override
    public T set(int index, T element) {
	checkIndex(index);
	elements[index] = element;
	return element;
    }

    /**
     * Inserta el elemento en la posici�n indicada por index en la lista.
     * Desplaza el elemento actualmente en esa posici�n (si existe) y los
     * elementos posteriores a la derecha (se incrementan en uno los �ndices de
     * los elementos desplazados).
     *
     * @param index   Posicion donde se desea insertar el elemento
     * @param element elemento que se inserta
     * @throws ClassCastException        si la clase del elemento especificado
     *                                   impide que se a�ada a esta colecci�n
     * @throws NullPointerException      si el elemento especificado es nulo y
     *                                   la colecci�n no permite elementos nulos
     * @throws IllegalArgumentException  si alguna propiedad del elemento impide
     *                                   que se a�ada a esta colecci�n
     * @throws IndexOutOfBoundsException si el �ndice est� fuera de rango
     *                                   ({@code index < 0 || index > size()})
     */
    @Override
    public void add(int index, T element) {
	checkIndex(index);
	if (size() >= elements.length) {
	    moreMemory(size() + 1);
	}
	for (int i = size(); i > index; i--) {
	    elements[i] = elements[i - 1];
	}
	elements[index] = element;
	setNumberOfElements(getNumberOfElements() + 1);
    }

    /**
     * Elimina el elemento que se encuentra en la posici�n indicada por index de
     * la lista. Desplaza los elementos posteriores a la izquierda (se
     * decrementa en uno los �ndices de los elementos desplazados).
     *
     * @param index �ndice del elemento que se desea eliminar
     * @return El elemento que se encontraba previamente en la posici�n indicada
     * @throws IndexOutOfBoundsException si index est� fuera del rango
     *                                   ({@code index < 0 || index >= size()})
     */
    @SuppressWarnings("unchecked")
    @Override
    public T remove(int index) {
	checkIndex(index);
	if (isEmpty()) {
	    return null;
	}
	Object value = elements[index];
	for (int j = index; j < size() - 1; j++)
	    elements[j] = elements[j + 1];
	setNumberOfElements(getNumberOfElements() - 1);
	return (T) value;
    }

    /**
     * Elimina todos los elementos de esta lista (operaci�n opcional).La lista
     * estar� vac�a despu�s de la ejecuci�n de este m�todo.
     */
    @SuppressWarnings("unchecked")
    @Override
    public void clear() {
	elements = (T[]) new Object[INITIAL_CAPACITY];
	setNumberOfElements(0);
    }

    /**
     * Devuelve el �ndice de la primera aparici�n del elemento en la lista, o -1
     * si la lista no contiene el elemento. Mas formalmente, devuelve el �ndice
     * m�s bajo {@code i} tal que
     * {@code (o == null ? get(i) == null : o.equals(get(i)))}, o -1 si no est�
     * el elemento.
     *
     * @param o o elemento a buscar
     * @return el �ndice de la primara aparici�n del elemento en la lista, o -1
     *         si la lista no contiene el elemento
     */
    @Override
    public int indexOf(Object o) {
	for (int i = 0; i < size(); i++) {
	    if (elements[i] != null && elements[i].equals(o)) {
		return i;
	    } else if (o == null && elements[i] == null) {
		return i;
	    }
	}
	return -1;
    }

    /**
     * Devuelve la representaci�n textual de la colecci�n. Una lista de
     * elementos encerrados entre corchetes (<tt>"[]"</tt>). Los elementos et�n
     * separados por una coma y un espacio <tt>", "</tt>. Los elementos se
     * convierten a strings invocando a su m�todo {@code toString}. Esto es:
     * "[el1, el2, ..., eln]" donde eli es la representaci�n textual de su i-th
     * elemento
     *
     * @return un string con la representaci�n textual de la colecci�n
     */
    @Override
    public String toString() {
	StringBuilder sb = new StringBuilder("[");
	if (!isEmpty()) {
	    for (int i = 0; i < size() - 1; i++) {
		if (elements[i] != null) {
		    sb.append(elements[i].toString()).append(", ");
		} else {
		    sb.append("null").append(", ");
		}
	    }
	    if (elements[size() - 1] == null) {
		sb.append("null");
	    } else {
		sb.append(elements[size() - 1].toString());
	    }

	}
	sb.append("]");
	return sb.toString();
    }

    /**
     * Devuelve el valor hash code para esta lista. El hash code de la lista es
     * el resultado de la del siguiente c�lculo:
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
	int pos = 0;
	int hashCode = 1;
	// no hay iterador creado, no se puede usar foreach
	for (Object e = elements[0]; e != null; e = elements[pos + 1]) {
	    hashCode = 31 * hashCode + (e == null ? 0 : e.hashCode());
	}
	return hashCode;
    }

    /**
     * Compara el objeto especificado con los elementos de la lista. Devuelve
     * {@code true} si y solo si el objeto especificado es tambi�n una lista,
     * ambas listas tienen el mismo tama�o, y todos los correspondientes pares
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
	List other = (List) obj;
	if (size() != other.size()) {
	    return false;
	}
	for (int i = 0; i < size() - 1; i++) {
	    if (!(elements[i].equals(other.get(i)))) {
		return false;
	    }
	}
	return true;

    }

    /**
     * Metodo auxiliar que permite pedir mas memoria para ampliar el tama�o del
     * array
     * 
     * @param elemPos elementos a ampliar
     */
    private void moreMemory(int elemPos) {
	if (elemPos > elements.length) {
	    @SuppressWarnings("unchecked")
	    T[] aux = (T[]) new Object[Math.max(elemPos, 2 * elements.length)];
	    System.arraycopy(elements, 0, aux, 0, elements.length);
	    elements = aux;
	}
    }

    /**
     * Iterador que nos permite recorrer la coleccion
     */
    @SuppressWarnings("unchecked")
    @Override
    public Iterator<T> iterator() {
	return (Iterator<T>) new ArrayListIterator();
    }

    /**
     * Iterador ArrayList
     * 
     * @author angela
     */
    private class ArrayListIterator implements Iterator<Object> {
	private int position = 0;
	private Object lastReturned;

	/**
	 * Metodo que indica si hay un elemento siguiente al que iterar en la
	 * coleccion
	 */
	@Override
	public boolean hasNext() {
	    return position != size();
	}

	/**
	 * Metodo que devuelve el objeto siguiente de la coleccion
	 */
	@Override
	public Object next() {
	    if (hasNext()) {
		lastReturned = elements[position++];
		return lastReturned;
	    } else {
		throw new NoSuchElementException("There are not more elements");
	    }
	}

	/**
	 * Metodo que elimina el objeto actual de la coleccion
	 */
	@Override
	public void remove() {
	    if (lastReturned != null) {
		ArrayList.this.remove(position - 1);
		position--;
		lastReturned = null;
	    } else {
		throw new IllegalStateException();
	    }

	}
    }

}
