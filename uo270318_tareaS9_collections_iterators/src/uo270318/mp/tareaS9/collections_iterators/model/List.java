package uo270318.mp.tareaS9.collections_iterators.model;

/**
 * Una colección conocida como <i>secuencia</i>). El usuario de la interfaz
 * tiene un control preciso sobre en qué parte de la lista se encuentra cada
 * elemento  * insertado. El usuario puede acceder a los elementos por su índice
 * entero (posición en  * la lista), y buscar elementos en la lista.
 */
public interface List extends Collection {

    // -- Query operations

    /**
     * Devuelve el número de elementos de la lista
     *
     * @return el número de elementos de la lista
     */
    int size();

    /**
     * Devuelve {@code true} si la lista está vacía
     *
     * @return {@code true} si la lista no contiene elementos
     */
    boolean isEmpty();

    /**
     * Devuelve {@code true} si la lista contiene el elemento especificado Más
     * formalmente, devuelve {@code true} si y solo si esta colección contiene
     * al menos un elemento tal que
     * {@code (o == null ? e == null : o.equals(e))}.
     * 
     * @param o elemento a comprobar si está en la lista
     * @return {@code true} si esta colección contienen el elemento especificado
     */
    boolean contains(Object o);

    // -- Modification operations

    /**
     * Añade el elemento especificado al final de la lista (es una operación
     * append) Devuelve {@code true} ya que las listas permiten elementos
     * duplicados.
     * 
     * @param element el elemento que se añade a la lista
     * @return {@code true} (como se especifica en {@link Collection#add})
     * 
     * @throws ClassCastException       si la clase del elemento especificado
     *                                  impide que se añada a esta colección
     * @throws NullPointerException     si el elemento especificado es null y la
     *                                  colección no permite elementos nulos
     * @throws IllegalArgumentException si alguna propiedad del elemento impide
     *                                  que se añada a esta colección
     */
    boolean add(Object element);

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
    boolean remove(Object o);

    // -- Positional access operations

    /**
     * Devuelve el elemento que se encuentra en la posición index de la lista.
     *
     * @param index índice del elemento a recuperar
     * @return El elemento que se encuentra en la posición indicada de la lista
     * @throws IndexOutOfBoundsException si index está fuera del rango
     *                                   ({@code index < 0 || index >= size()})
     */
    Object get(int index);

    /**
     * Reemplaza el elemento de la posición index en la lista con el elemento
     * especificado
     *
     * @param index   índice del elemento a reemplazar
     * @param element elemento a almacenar en la posición indicada
     * @return El elemento que se encontraba previamente en la posición index
     * @throws IndexOutOfBoundsException si index está fuera del rango
     *                                   ({@code index < 0 || index > size()})
     */
    public Object set(int index, Object element);

    /**
     * Inserta el elemento en la posición indicada por index en la lista.
     * Desplaza el elemento actualmente en esa posición (si existe) y los
     * elementos posteriores a la derecha (se incrementan en uno los índices de
     * los elementos desplazados).
     *
     * @param index   Posicion donde se desea insertar el elemento
     * @param element elemento que se inserta
     * @throws ClassCastException        si la clase del elemento especificado
     *                                        * impide que se añada a esta
     *                                   colección
     * @throws NullPointerException      si el elemento especificado es nulo y
     *                                        * la colección no permite
     *                                   elementos nulos
     * @throws IllegalArgumentException  si alguna propiedad del elemento      *
     *                                   impide que se añada a esta colección
     * @throws IndexOutOfBoundsException si el índice está fuera de rango
     *                                   ({@code index < 0 || index > size()})
     */
    void add(int index, Object element);

    /**
     * Elimina el elemento que se encuentra en la posición indicada por index de
     * la lista Desplaza los elementos posteriores a la izquierda (se decrementa
     * en uno los índices de los elementos desplazados).
     *
     * @param index índice del elemento que se desea eliminar
     * @return El elemento que se encontraba previamente en la posición indicada
     * @throws IndexOutOfBoundsException si index está fuera del rango
     *                                   ({@code index < 0 || index >= size()})
     */
    Object remove(int index);

    /**
     * Elimina todos los elementos de esta lista (operación opcional). La lista
     * estará vacía después de la ejecución de este método.
     */
    void clear();

    // -- Search operations

    /**
     * Devuelve el índice de la primera aparición del elemento en la lista, o -1
     * si la lista no contiene el elemento. Mas formalmente, devuelve el índice
     * más bajo {@code i} tal que
     * {@code (o == null ? get(i) == null : o.equals(get(i)))}, o -1 si no está
     * el elemento.
     *
     * @param o o elemento a buscar
     * @return el índice de la primara aparición del elemento en la lista, o -1
     *         si la lista no contiene el elemento
     */
    int indexOf(Object o);

    // Comparison and hashing

    /**
     * Compara el objeto especificado con los elementos de la lista. Devuelve
     * {@code true} si y solo si el objeto especificado es también una lista,
     * ambas listas tienen el mismo tamaño, y todos los correspondientes pares
     * de elementos de las dos listas son <i>equal</i>.
     *
     * @param o el objeto a ser comparado con la lista
     * @return {@code true} si el objeto especificado es igual a la lista
     */
    boolean equals(Object o);

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
    int hashCode();
}
