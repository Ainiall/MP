package uo270318.mp.tareaS9.collections_iterators.model;

/**
 * <p>
 * Titulo: Clase AbstractList
 * </p>
 * <p>
 * Descripcion: Superclase que contiene atributo y metodos comunes de ArrayList
 * y LinkedList.
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 * 
 * @author Angela Lopez UO270318
 * @version 1.0
 */
public abstract class AbstractList implements List {

    private int numberOfElements;

    public AbstractList() {
	super();
    }

    protected void setNumberOfElements(int num) {
	this.numberOfElements = num;
    }

    protected int getNumberOfElements() {
	return numberOfElements;
    }

    /**
     * Devuelve el número de elementos de la lista
     *
     * @return el número de elementos de la lista
     */
    @Override
    public int size() {
	return numberOfElements;
    }

    /**
     * Devuelve {@code true} si la lista está vacía
     *
     * @return {@code true} si la lista no contiene elementos
     */
    @Override
    public boolean isEmpty() {
	return numberOfElements == 0;
    }

    /**
     * Devuelve {@code true} si la lista contiene el elemento especificado Más
     * formalmente, devuelve {@code true} si y solo si esta colección contiene
     * al menos un elemento tal que
     * {@code (o == null ? e == null : o.equals(e))}.
     * 
     * @param o elemento a comprobar si está en la lista
     * @return {@code true} si esta colección contienen el elemento especificado
     */
    @Override
    public boolean contains(Object o) {
	return (indexOf(o) != -1) ? true : false;
    }

    /**
     * Añade el elemento especificado al final de la lista (es una operación
     * append) Devuelve {@code true} ya que las listas permiten elementos
     * duplicados.
     * 
     * @param o el elemento que se añade a la lista
     * @return {@code true} (como se especifica en {@link Collection#add})
     * 
     * @throws ClassCastException       si la clase del elemento especificado
     *                                  impide que se añada a esta colección
     * @throws NullPointerException     si el elemento especificado es null y la
     *                                  colección no permite elementos nulos
     * @throws IllegalArgumentException si alguna propiedad del elemento impide
     *                                  que se añada a esta colección
     */
    @Override
    public boolean add(Object o) {
	// no se valida, se acepta null
	add(size(), o);
	return true;
    }

    /**
     * Borra el elemento especificado si está en la lista. Si el elemnto no está
     * en la lista no se modifica. Más formalmente, borra el elemento con el
     * índice más bajo{@code i} tal que
     * {@code o == null ? get(i) == null : o.equals(get(i))} (si el elemento
     * existe) Returns {@code true} si la lista contiene el elemento
     * especificado
     * 
     * @param o el element que se desea eliminar
     * @return {@code true} si la lista contiene el elemento especificado
     * @throws UnsupportedOperationException si la operación remove no es
     *                                       soportada por esta lista
     */
    @Override
    public boolean remove(Object o) {
	int pos = (indexOf(o));
	if (pos != -1) {
	    remove(indexOf(o));
	    return true;
	}
	return false;
    }

    /**
     * Metodo auxiliar que valida el indice de la lista pasado como parametro
     * 
     * @param index Indice de la lista
     */
    protected void checkIndex(int index) {
	if ((index < 0) | index > this.size()) {
	    throw new IndexOutOfBoundsException("Invalid index");
	}
    }
}