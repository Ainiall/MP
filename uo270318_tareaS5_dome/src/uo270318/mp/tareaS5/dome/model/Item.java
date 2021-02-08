package uo270318.mp.tareaS5.dome.model;

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
 * 
 * @author Angela Lopez UO270318
 * @version 1.0
 */
public abstract class Item extends Database {

    private String title;
    private boolean gotIt;
    private String comment;
    private double basePrice;

    /**
     * Constructor con parametros
     * 
     * @param title Titulo
     * @param gotIt Booleano que prueba si tiene pertenencia o no
     * @param comment Descripcion
     * @param basePrice Precio base
     */
    public Item(String title, boolean gotIt, String comment, double basePrice) {
	setTitle(title);
	setOwn(gotIt);
	setComment(comment);
	setBasePrice(basePrice);
    }

    /**
     * Metodo que asigna el titulo que se le pase como parametro
     * 
     * @param title Recibe una cadena con el titutulo
     * @throws IllegalArgumentException Cuando el parametro es null o todos los
     * caracteres son blancos
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
     * @param comment cadena de caracteres
     * @throws IllegalArgumentException Cuando el parametro es null.
     */
    protected void setComment(String comment) {
	assertParamStringNotNull(comment);
	this.comment = comment;
    }

    /**
     * Metodo que asigna un precio base
     * 
     * @param basePrice Precio base
     * @throws IllegalArgumentException Cuando es superior al permitido.
     */
    protected void setBasePrice(double basePrice) {
	assertParamDouble(basePrice);
	this.basePrice = basePrice;
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
     * @return comment Cadena de comentario
     */
    protected String getComment() {
	return comment;
    }

    /**
     * Metodo que devuelve el precio base del item
     * 
     * @return basePrice Precio base
     */
    protected Double getBasePrice() {
	return basePrice;
    }

    /**
     * Metodo que imprime el responsable de cada item.
     */
    public abstract void printResponsables(PrintStream out);

    /**
     * Metodo que imprime toda la informacion del item.
     */
    @Override
    public String toString() {
	StringBuilder str = new StringBuilder();
	str.append(getTitle());
	if (getOwn())
	    str.append("\nYou own it");
	else
	    str.append("\nYou do not own it");
	str.append("\nPrice: ").append(getBasePrice());
	str.append("\nComment: ").append(getComment());
	return str.toString();
    }

    public String getCode() {
	String str = "";
	if (getTitle().length() > 3) {
	    str += getTitle().substring(0, 3);
	} else {
	    str += getTitle();
	}
	if (getOwn()) {
	    str += "T";
	} else {
	    str += "F";
	}
	return str;
    }

    /**
     * Metodo que calcula el valor total de cada item.
     * 
     * @return valor total, tipo double
     */
    protected abstract double itemValue();

    /**
     * Metodo auxiliar que comprueba la validez de la cadena de texto pasada
     * como parametro. Para ello se comprueba que sea distinta de null y no
     * tenga espacios en blanco.
     * 
     * @param string Cadena a validar
     * @throws IllegalArgumentException Cuando el parametro es null o todos los
     * caracteres son blancos.
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
     * Metodo auxiliar que comprueba la validez del precio que se le pasa como
     * parametro. Para ello se comprueba que no supere la cantidad maxima y
     * minima.
     * 
     * @param basePrice Precio a comprobar
     * @throws IllegalArgumentException Cuando el superior al permitido.
     */
    private void assertParamDouble(double basePrice) {
	if (basePrice > 10000.00 || basePrice < 0) {
	    throw new IllegalArgumentException(
		    "El precio debe estar dentro del rango permitido");
	}
    }

}