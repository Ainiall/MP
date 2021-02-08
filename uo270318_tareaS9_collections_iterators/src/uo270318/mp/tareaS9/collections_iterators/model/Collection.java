package uo270318.mp.tareaS9.collections_iterators.model;

/**
 * La interfaz raíz en la <i>jerarquía collection</i>. Una colección representa
 * un grupo de objetos, conocidos como <i>elementos</i>. Algunas colecciones
 * permiten duplicar elementos y otras no. Algunas están ordenadas y otras
 * desordenadas Esta interfaz se utiliza para manejar colecciones genéricas
 */
public interface Collection extends Iterable<Object>{

    // -- Query Operations

    /**
     * Devuelve el número de elementos que hay en la colección
     * 
     * @return El número de elementos de la colección
     */
    int size();

    /**
     * Indica si la colección contiene o no elementos
     * 
     * @return Devuelve {@code true} si la colección no contiene elementos
     *         {@code false} en caso contrario
     */
    boolean isEmpty();

    /**
     * Devuelve {@code true} si la colección contiene el elemento especificado
     * Más formalmente, devuelve {@code true} si y solo si esta colección
     * contiene al menos un elemento tal que
     * {@code (o == null ? e == null : o.equals(e))}.
     * 
     * @param o elemento a comprobar si está en la colección
     * @return {@code true} si esta colección contienen el elemento especificado
     */
    boolean contains(Object o);

    // -- Modification Operations

    /**
     * Añade el elemento especificado al final de la lista (es una operación
     * append) Devuelve {@code true} si la colección cambia como resultado de la
     * llamada. Devuelve {@code false} si la collección no permite elementos
     * duplicados y ya contiene el elemento especificado.)
     * <p>
     * 
     * Las colecciones que soportan esta operación pueden poner limitaciones a
     * los      * elementos. En particular, algunas      * colecciones podrían
     * impedir añadir {@code null}, y otras podrían      * imponer restricciones
     * sobre el tipo de elementos que se pueden añadir.      * Se debe
     * especificar claramente en la documentación de las clases que implementan
     * la interfaz      
     * 
     * @param element el elemento que se añade a la colección
     * @return {@code true} si la colección cambia como consecuencia de la
     *         llamada
     * @throws UnsupportedOperationException si la operación{@code add} no es
     *                                       soportada por esta colección
     * @throws ClassCastException            si la clase del elemento
     *                                       especificado      * impide que se
     *                                       añada a esta colección
     * @throws NullPointerException          si el elemento especificado es null
     *                                       y      * la colección no permite
     *                                       elementos nulos
     * @throws IllegalArgumentException      si alguna propiedad del elemento
     *                                            * impide que se añada a esta
     *                                       colección
     * @throws IllegalStateException         si el elemento no se puede añadir a
     *                                       este      * debido a restricciones
     *                                       de inserción
     */
    boolean add(Object element);

    /**
     * Elimina el elemento de la colección que coincida con el parámetro. Más
     * formalmente, borra un elemento {@code e} tal que
     * {@code o == null ? o == null : o.equals(e))},
     * 
     * 
     * @param o element to be removed from this collection, if present
     * @return {@code true} si el elemento fue borrado {@code false} en caso
     *         contrario
     * @throws UnsupportedOperationException si la operación {@code remove} no
     *                                       está soportada por esta colección
     * 
     */
    boolean remove(Object o);

    /**
     * Elimina todos los elementos de la colección. La colección estará vacía
     * después de esta operación.
     *
     * @throws UnsupportedOperationException si la operación {@code clear} no
     *                                       está soportada por esta colección
     */
    void clear();

    // -- Other operations

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
    String toString();
}
