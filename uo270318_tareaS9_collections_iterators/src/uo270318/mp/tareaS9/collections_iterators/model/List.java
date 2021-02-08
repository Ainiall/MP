package uo270318.mp.tareaS9.collections_iterators.model;

/**
 * Una colecci�n conocida como <i>secuencia</i>). El usuario de la interfaz
 * tiene un control preciso sobre en qu� parte de la lista se encuentra cada
 * elemento �* insertado. El usuario puede acceder a los elementos por su �ndice
 * entero (posici�n en �* la lista), y buscar elementos en la lista.
 */
public interface List extends Collection {

    // -- Query operations

    /**
     * Devuelve el n�mero de elementos de la lista
     *
     * @return el n�mero de elementos de la lista
     */
    int size();

    /**
     * Devuelve {@code true} si la lista est� vac�a
     *
     * @return {@code true} si la lista no contiene elementos
     */
    boolean isEmpty();

    /**
     * Devuelve {@code true} si la lista contiene el elemento especificado M�s
     * formalmente, devuelve {@code true} si y solo si esta colecci�n contiene
     * al menos un elemento tal que
     * {@code (o == null ? e == null : o.equals(e))}.
     * 
     * @param o elemento a comprobar si est� en la lista
     * @return {@code true} si esta colecci�n contienen el elemento especificado
     */
    boolean contains(Object o);

    // -- Modification operations

    /**
     * A�ade el elemento especificado al final de la lista (es una operaci�n
     * append) Devuelve {@code true} ya que las listas permiten elementos
     * duplicados.
     * 
     * @param element el elemento que se a�ade a la lista
     * @return {@code true} (como se especifica en {@link Collection#add})
     * 
     * @throws ClassCastException       si la clase del elemento especificado
     *                                  impide que se a�ada a esta colecci�n
     * @throws NullPointerException     si el elemento especificado es null y la
     *                                  colecci�n no permite elementos nulos
     * @throws IllegalArgumentException si alguna propiedad del elemento impide
     *                                  que se a�ada a esta colecci�n
     */
    boolean add(Object element);

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
    boolean remove(Object o);

    // -- Positional access operations

    /**
     * Devuelve el elemento que se encuentra en la posici�n index de la lista.
     *
     * @param index �ndice del elemento a recuperar
     * @return El elemento que se encuentra en la posici�n indicada de la lista
     * @throws IndexOutOfBoundsException si index est� fuera del rango
     *                                   ({@code index < 0 || index >= size()})
     */
    Object get(int index);

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
    public Object set(int index, Object element);

    /**
     * Inserta el elemento en la posici�n indicada por index en la lista.
     * Desplaza el elemento actualmente en esa posici�n (si existe) y los
     * elementos posteriores a la derecha (se incrementan en uno los �ndices de
     * los elementos desplazados).
     *
     * @param index   Posicion donde se desea insertar el elemento
     * @param element elemento que se inserta
     * @throws ClassCastException        si la clase del elemento especificado
     *                                   �����* impide que se a�ada a esta
     *                                   colecci�n
     * @throws NullPointerException      si el elemento especificado es nulo y
     *                                   �����* la colecci�n no permite
     *                                   elementos nulos
     * @throws IllegalArgumentException  si alguna propiedad del elemento �����*
     *                                   impide que se a�ada a esta colecci�n
     * @throws IndexOutOfBoundsException si el �ndice est� fuera de rango
     *                                   ({@code index < 0 || index > size()})
     */
    void add(int index, Object element);

    /**
     * Elimina el elemento que se encuentra en la posici�n indicada por index de
     * la lista Desplaza los elementos posteriores a la izquierda (se decrementa
     * en uno los �ndices de los elementos desplazados).
     *
     * @param index �ndice del elemento que se desea eliminar
     * @return El elemento que se encontraba previamente en la posici�n indicada
     * @throws IndexOutOfBoundsException si index est� fuera del rango
     *                                   ({@code index < 0 || index >= size()})
     */
    Object remove(int index);

    /**
     * Elimina todos los elementos de esta lista (operaci�n opcional). La lista
     * estar� vac�a despu�s de la ejecuci�n de este m�todo.
     */
    void clear();

    // -- Search operations

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
    int indexOf(Object o);

    // Comparison and hashing

    /**
     * Compara el objeto especificado con los elementos de la lista. Devuelve
     * {@code true} si y solo si el objeto especificado es tambi�n una lista,
     * ambas listas tienen el mismo tama�o, y todos los correspondientes pares
     * de elementos de las dos listas son <i>equal</i>.
     *
     * @param o el objeto a ser comparado con la lista
     * @return {@code true} si el objeto especificado es igual a la lista
     */
    boolean equals(Object o);

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
    int hashCode();
}
