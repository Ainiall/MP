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
     * Devuelve el n�mero de elementos de la lista
     *
     * @return el n�mero de elementos de la lista
     */
    @Override
    public int size() {
	return numberOfElements;
    }

    /**
     * Devuelve {@code true} si la lista est� vac�a
     *
     * @return {@code true} si la lista no contiene elementos
     */
    @Override
    public boolean isEmpty() {
	return numberOfElements == 0;
    }

    /**
     * Devuelve {@code true} si la lista contiene el elemento especificado M�s
     * formalmente, devuelve {@code true} si y solo si esta colecci�n contiene
     * al menos un elemento tal que
     * {@code (o == null ? e == null : o.equals(e))}.
     * 
     * @param o elemento a comprobar si est� en la lista
     * @return {@code true} si esta colecci�n contienen el elemento especificado
     */
    @Override
    public boolean contains(Object o) {
	return (indexOf(o) != -1) ? true : false;
    }

    /**
     * A�ade el elemento especificado al final de la lista (es una operaci�n
     * append) Devuelve {@code true} ya que las listas permiten elementos
     * duplicados.
     * 
     * @param o el elemento que se a�ade a la lista
     * @return {@code true} (como se especifica en {@link Collection#add})
     * 
     * @throws ClassCastException       si la clase del elemento especificado
     *                                  impide que se a�ada a esta colecci�n
     * @throws NullPointerException     si el elemento especificado es null y la
     *                                  colecci�n no permite elementos nulos
     * @throws IllegalArgumentException si alguna propiedad del elemento impide
     *                                  que se a�ada a esta colecci�n
     */
    @Override
    public boolean add(Object o) {
	// no se valida, se acepta null
	add(size(), o);
	return true;
    }

    /**
     * Borra el elemento especificado si est� en la lista. Si el elemnto no est�
     * en la lista no se modifica. M�s formalmente, borra el elemento con el
     * �ndice m�s bajo{@code i} tal que
     * {@code o == null ? get(i) == null : o.equals(get(i))} (si el elemento
     * existe) Returns {@code true} si la lista contiene el elemento
     * especificado
     * 
     * @param o el element que se desea eliminar
     * @return {@code true} si la lista contiene el elemento especificado
     * @throws UnsupportedOperationException si la operaci�n remove no es
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