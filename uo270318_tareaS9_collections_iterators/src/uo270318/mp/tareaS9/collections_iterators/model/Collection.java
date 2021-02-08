package uo270318.mp.tareaS9.collections_iterators.model;

/**
 * La interfaz ra�z en la <i>jerarqu�a collection</i>. Una colecci�n representa
 * un grupo de objetos, conocidos como <i>elementos</i>. Algunas colecciones
 * permiten duplicar elementos y otras no. Algunas est�n ordenadas y otras
 * desordenadas Esta interfaz se utiliza para manejar colecciones gen�ricas
 */
public interface Collection extends Iterable<Object>{

    // -- Query Operations

    /**
     * Devuelve el n�mero de elementos que hay en la colecci�n
     * 
     * @return El n�mero de elementos de la colecci�n
     */
    int size();

    /**
     * Indica si la colecci�n contiene o no elementos
     * 
     * @return Devuelve {@code true} si la colecci�n no contiene elementos
     *         {@code false} en caso contrario
     */
    boolean isEmpty();

    /**
     * Devuelve {@code true} si la colecci�n contiene el elemento especificado
     * M�s formalmente, devuelve {@code true} si y solo si esta colecci�n
     * contiene al menos un elemento tal que
     * {@code (o == null ? e == null : o.equals(e))}.
     * 
     * @param o elemento a comprobar si est� en la colecci�n
     * @return {@code true} si esta colecci�n contienen el elemento especificado
     */
    boolean contains(Object o);

    // -- Modification Operations

    /**
     * A�ade el elemento especificado al final de la lista (es una operaci�n
     * append) Devuelve {@code true} si la colecci�n cambia como resultado de la
     * llamada. Devuelve {@code false} si la collecci�n no permite elementos
     * duplicados y ya contiene el elemento especificado.)
     * <p>
     * 
     * Las colecciones que soportan esta operaci�n pueden poner limitaciones a
     * los ���� * elementos. En particular, algunas �����* colecciones podr�an
     * impedir a�adir {@code null}, y otras podr�an ���� * imponer restricciones
     * sobre el tipo de elementos que se pueden a�adir. �����* Se debe
     * especificar claramente en la documentaci�n de las clases que implementan
     * la interfaz �����
     * 
     * @param element el elemento que se a�ade a la colecci�n
     * @return {@code true} si la colecci�n cambia como consecuencia de la
     *         llamada
     * @throws UnsupportedOperationException si la operaci�n{@code add} no es
     *                                       soportada por esta colecci�n
     * @throws ClassCastException            si la clase del elemento
     *                                       especificado �����* impide que se
     *                                       a�ada a esta colecci�n
     * @throws NullPointerException          si el elemento especificado es null
     *                                       y �����* la colecci�n no permite
     *                                       elementos nulos
     * @throws IllegalArgumentException      si alguna propiedad del elemento
     *                                       �����* impide que se a�ada a esta
     *                                       colecci�n
     * @throws IllegalStateException         si el elemento no se puede a�adir a
     *                                       este �����* debido a restricciones
     *                                       de inserci�n
     */
    boolean add(Object element);

    /**
     * Elimina el elemento de la colecci�n que coincida con el par�metro. M�s
     * formalmente, borra un elemento {@code e} tal que
     * {@code o == null ? o == null : o.equals(e))},
     * 
     * 
     * @param o element to be removed from this collection, if present
     * @return {@code true} si el elemento fue borrado {@code false} en caso
     *         contrario
     * @throws UnsupportedOperationException si la operaci�n {@code remove} no
     *                                       est� soportada por esta colecci�n
     * 
     */
    boolean remove(Object o);

    /**
     * Elimina todos los elementos de la colecci�n. La colecci�n estar� vac�a
     * despu�s de esta operaci�n.
     *
     * @throws UnsupportedOperationException si la operaci�n {@code clear} no
     *                                       est� soportada por esta colecci�n
     */
    void clear();

    // -- Other operations

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
    String toString();
}
