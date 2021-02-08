package uo270318.mp.tareaS3.dome.model;

import java.io.PrintStream;
import java.util.ArrayList;

/**
 * <p>
 * Titulo: Clase Database
 * </p>
 * <p>
 * Descripcion: Clase que funciona como una base de datos. Actua como
 * superclase y maneja los distintos tipos de item.
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 * @author Angela Lopez UO270318
 * @version 1.0
 */
public class Database {

    private ArrayList<Item> items;

    /**
     * Constructor sin parametros
     */
    public Database() {
	items = new ArrayList<Item>();
    }

    /**
     * Metodo que permite insertar un nuevo item a la coleccion.
     * 
     * @param item Nuevo item a insertar.
     * @throws IllegalArgumentException cuando el parametro es null.
     */
    public void add(Item item) {
	assertParamItem(item);
	items.add(item);
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
     * Metodo que muestra la informacion referente a cada item.
     * 
     * @param out Parametro que nos indica el tipo de mensaje a mostrar.
     */
    public void list(PrintStream out) {
	for (Item item : items) {
	    item.print(out);
	}
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
	    if (item.getOwn() == true) {
		// solo ejecuta si es un casteo explicito
		if (item instanceof Cd)
		    out.println("El responsable del CD " + item.getTitle()
			    + " es: " + ((Cd) item).getArtist());
		if (item instanceof Dvd)
		    out.println("El responsable del DVD " + item.getTitle()
			    + " es: " + ((Dvd) item).getDirector());
		if (item instanceof VideoGame)
		    out.println("El responsable del Videojuego " + item.getTitle()
			    + " es " + ((VideoGame) item).getAuthor());
	    }
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
     * Metodo auxiliar usado en los test para comprobar el tamaño de la lista.
     * @return items.size() Tamaño total
     */
    public int getNumItems() {
	return items.size();
    }
}
