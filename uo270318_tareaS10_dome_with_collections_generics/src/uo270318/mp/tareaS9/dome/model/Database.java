package uo270318.mp.tareaS9.dome.model;

import java.io.PrintStream;

import uo270318.mp.tareaS10.dome.exceptions.ItemNotInCollectionException;
import uo270318.mp.tareaS10.dome.exceptions.RepeatedElementException;
import uo270318.mp.tareaS9.collections_iterators.generics.model.ArrayList;

/**
 * <p>
 * Titulo: Clase Database
 * </p>
 * <p>
 * Descripcion: Clase que funciona como una base de datos. Actua como superclase
 * y maneja los distintos tipos de item.
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 * 
 * @author Angela Lopez UO270318
 * @version 1.0
 */
public class Database {

    private ArrayList<Item> items;
    private ArrayList<Borrowable> borrowables;

    /**
     * Constructor sin parametros
     */
    public Database() {
	items = new ArrayList<Item>();
	borrowables = new ArrayList<Borrowable>();
    }

    /**
     * Metodo que permite insertar un nuevo item a la coleccion.
     * 
     * @param item Nuevo item a insertar.
     * @throws RepeatedElementException 
     * @throws IllegalArgumentException cuando el parametro es null.
     */
    public void add(Item item) throws RepeatedElementException {
	assertParamItem(item);
	if (items.contains(item)) {
		throw new RepeatedElementException(
			"No se admiten items repetidos.");
	} else {
	    items.add(item);
	    if (item instanceof Borrowable) {
		borrowables.add((Borrowable) item);
	    }
	}

    }

    public void remove(Item item) throws ItemNotInCollectionException {
	assertParamItem(item);
	if (searchItem(item) == -1) {
	    throw new ItemNotInCollectionException(
		    "El item no se puede borrar porque no forma parte de la coleccion.");
	}else {
	    items.remove(item);
	}
    }

    /**
     * Metodo que devuelve el numero de items en propiedad.
     * 
     * @return n_items Numero de items en propiedad.
     */
    public int numberOfItemsOwned() {
	int n_items = 0;
	for (Item item : items) {
	    if (item.getOwn()) {
		n_items++;
	    }
	}
	return n_items;
    }

    /**
     * Metodo que busca un item que se le pasa como parametro. Si lo encuentra
     * devuelve su posicion y si no lo encuentra devuelve -1. Como la clase
     * ArrayList ya tiene por defecto un metodo que devuelve esos resultados
     * usaremos ese.
     * 
     * @param theItem Item a buscar.
     * @return items.indexOf(theItem) Posicion donde se encuentra el item. En
     *         caso de no encontrarlo devuelve -1.
     * @throws IllegalArgumentException Cuando el parametro es null.
     */
    public int searchItem(Item theItem) {
	assertParamItem(theItem);
	return items.indexOf(theItem);
    }

    /**
     * Metodo que busca en la coleccion de items el objeto recibido en la
     * llamada (comparacion de estado)
     * 
     * @param theItem Objeto a buscar en la coleccion
     * @return El primer objeto de la coleccion que coincida con el item
     *         recibido de la llamada y null si no se encuentra el item
     * @throws IllegalArgumentException Cuando el parametro es null.
     */
    public Item search(Item theItem) {
	assertParamItem(theItem);
	for (Item item : items) {
	    if (item.equals(theItem)) {
		return item;
	    }
	}
	return null;
    }

    /**
     * Metodo que busca en la coleccion de borrowables el objeto recibido en la
     * llamada (comparacion de estado)
     * 
     * @param theItem Objeto a buscar en la coleccion
     * @return El primer objeto de la coleccion que coincida con el item
     *         recibido de la llamada y null si no se encuentra el item
     * @throws IllegalArgumentException Cuando el parametro es null.
     */
    public Borrowable searchB(Borrowable theItem) {
	assertParamBorrowable(theItem);
	for (Borrowable item : borrowables) {
	    if (item.equals(theItem)) {
		return item;
	    }
	}
	return null;
    }

    /**
     * Metodo que muestra la informacion referente a cada item.
     * 
     * @param out Parametro que nos indica el tipo de mensaje a mostrar.
     */
    public void list(PrintStream out) {
	for (Item item : items) {
	    out.println(item.toString());
	}
    }

    /**
     * Metodo que calcula el valor total de los items con propietario.
     * 
     * @return value Precio total de los items con propietario
     */
    public double totalValue() {
	double value = 0.0;
	for (Item item : items) {
	    value = value + item.itemValue();
	}
	return value;
    }

    /**
     * Metodo que devuelve el codigo de todos los items de la base de datos
     * unidos por un guion. El codigo esta formado por las 3 primeras letras del
     * titulo y T o F si tiene o no propietario.
     * 
     * @return str Cadena de caracteres con el codigo de los items de la base de
     *         datos.
     */
    public String generateCode() {
	String str = "";
	for (int i = 0; i < items.size() - 1; i++) {
	    str += items.get(i).getCode() + "-";
	}
	if (items.isEmpty()) {
	    return str;
	} else {
	    return str + items.get(items.size() - 1).getCode();
	}
    }

    /**
     * Metodo que muestra los items que pueden ser prestados.
     * 
     * @param out Parametro que nos indica el tipo de mensaje a mostrar.
     */
    public void listBorrowableItems(PrintStream out) {
	for (Borrowable b : borrowables)
	    out.println(b.toString());
    }

    /**
     * Metodo que muestra los items que estan disponibles para ser prestados.
     * 
     * @param out Parametro que nos indica el tipo de mensaje a mostrar.
     */
    public void listAvailableItems(PrintStream out) {
	for (Borrowable b : borrowables)
	    if (b.isAvailableItem())
		out.println(b);
    }

    /**
     * Metodo que presta un item.
     * 
     * @param b Item a prestar
     * @return true si se presta con exito, false si la operacion falla.
     */
    public boolean borrowed(Borrowable b) {
	assertParamBorrowable(b);
	Borrowable borrowed = searchB(b);
	if (borrowed.isAvailableItem()) {
	    return borrowed.borrowed();
	}
	return false;
    }

    /**
     * Metodo que devuelve un item.
     * 
     * @param b Item prestado.
     * @return true si se devuelve con exito, false si la operacion falla.
     */
    public boolean returned(Borrowable b) {
	assertParamBorrowable(b);
	Borrowable borrowed = searchB(b);
	if (borrowed.isAvailableItem() == false) {
	    return borrowed.returned();
	}
	return false;
    }

    /**
     * Metodo que vuelca en el objeto out todos los responsables de los
     * elementos que tienen propietario. En el caso de los CDs, el propietario
     * es el Artista. En el caso de los DVDs, el propietario es el Director. En
     * el caso de los videojuegos, el propietario es el Autor.
     * 
     * @param out Parametro que nos indica el tipo de mensaje a mostrar.
     */
    public void printResponsables(PrintStream out) {
	for (Item item : items) {
	    item.printResponsables(out);
	}
    }

    /**
     * Metodo auxiliar que comprueba la validez del item que se le pasa como
     * parametro. Para ello se comprueba que no sea null.Si lo es lanza una
     * excepcion.
     * 
     * @param item Parametro a validar.
     * @throws IllegalArgumentException Cuando el parametro es null.
     */
    private void assertParamItem(Item item) {
	if (item == null) {
	    throw new IllegalArgumentException("El parametro es null");
	}
    }

    /**
     * Metodo auxiliar que comprueba la validez del borrowable que se le pasa
     * como parametro. Para ello se comprueba que no sea null.Si lo es lanza una
     * excepcion.
     * 
     * @param item Parametro a validar.
     * @throws IllegalArgumentException Cuando el parametro es null.
     */
    private void assertParamBorrowable(Borrowable b) {
	if (b == null) {
	    throw new IllegalArgumentException("El parametro es null");
	}
    }

    /**
     * Metodo auxiliar usado en los test para comprobar el tamaño de la lista.
     * 
     * @return items.size() Tamaño total
     */
    public int getNumItems() {
	return items.size();
    }
}
