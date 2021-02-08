package uo270318.mp.tareaS3.dome.model;

import java.io.PrintStream;

/**
 * <p>
 * Titulo: Clase Item
 * </p>
 * <p>
 * Descripcion: Clase que contiene la informacion comun sobre los distintos item
 * disponibles.
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 * @author Angela Lopez UO270318
 * @version 1.0
 */
public class Item extends Database {

    private String title;
    private boolean gotIt;
    private String comment;

    /**
     * Constructor con parametros
     * 
     * @param title       Titulo
     * @param gotIt       Booleano que prueba si tiene pertenencia o no
     * @param comment     Descripcion
     */
    public Item(String title, boolean gotIt, String comment) {
	setTitle(title);
	setOwn(gotIt);
	setComment(comment);
    }

    /**
     * Metodo que asigna el titulo que se le pase como parametro
     * 
     * @param title Recibe una cadena con el titutulo
     * @throws IllegalArgumentException Cuando el parametro es null o todos los
     *                                  caracteres son blancos
     */
    protected void setTitle(String title) {
	assertParamString(title);
	if (title != null) {
	    this.title = title;
	}
    }

    /**
     * Metodo que asigna si tiene o no propietario
     * 
     * @param ownIt, true para indicar que tiene propietario
     */
    protected void setOwn(boolean ownIt) {
	gotIt = ownIt;
    }

    /**
     * Asigna un comentario
     * 
     * @param comment, cadena de caracteres
     * @throws IllegalArgumentException Cuando el parametro es null.
     */
    protected void setComment(String comment) {
	assertParamStringNotNull(comment);
	this.comment = comment;
    }

    /**
     * Metodo que devuelve el titulo del item
     * 
     * @return título (cadena)
     */
    protected String getTitle() {
	return this.title;
    }

    /**
     * Metodo que devuelve si el item tiene propietario o no
     * 
     * @return true si tiene propietario,
     */
    protected boolean getOwn() {
	return gotIt;
    }

    /**
     * Metodo que devuelve el comentario del item
     * 
     * @return comentario cadena
     */
    protected String getComment() {
	return comment;
    }

    /**
     * Metodo auxiliar que comprueba la validez de la cadena de texto pasada
     * como parametro. Para ello se comprueba que sea distinta de null y no
     * tenga espacios en blanco.
     * 
     * @param string Cadena a validar
     * @throws IllegalArgumentException Cuando el parametro es null o todos los
     *                                  caracteres son blancos.
     */
    protected void assertParamString(String string) {
	if (string == null || string.trim().length() == 0) {
	    throw new IllegalArgumentException("La cadena es incorrecta");
	}
    }

    /**
     * Metodo auxiliar que comprueba la validez de la cadena de texto pasada
     * como parametro. Para ello se comprueba que sea distinta de null.
     * 
     * @param string Cadena a validar
     * @throws IllegalArgumentException Cuando el parametro es null.
     */
    protected void assertParamStringNotNull(String string) {
	if (string == null) {
	    throw new IllegalArgumentException("La cadena es incorrecta");
	}
    }
     
    /**
     * Metodo que imprime la informacion sobre el item en cuestion.
     * 
     * @param out de tipo PrintStream
     */
    protected void print(PrintStream out) {

    }
}