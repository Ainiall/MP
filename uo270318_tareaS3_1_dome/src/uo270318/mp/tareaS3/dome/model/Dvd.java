package uo270318.mp.tareaS3.dome.model;

import java.io.PrintStream;

/**
 * <p>
 * Titulo: Clase Dvd
 * </p>
 * <p>
 * Descripcion: Clase que contiene la informacion sobre los item Dvd.
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 * @author Angela Lopez UO270318
 * @version 1.0
 */

public class Dvd extends Item {
    private String director;
    private int playingTime;

    /**
     * Constructor con parametros
     * 
     * @param theTitle    Titulo del dvd
     * @param theDirector Director del dvd
     * @param time        Duracion del dvd
     */
    public Dvd(String theTitle, String theDirector, int time) {
	super(theTitle, false, "");
	setDirector(theDirector);
	setPlayingTime(time);
    }

    /**
     * Metodo que asinga director
     * 
     * @param director, cadena de caracteres
     * @throws IllegalArgumentException Cuando el parametro es null o todos los
     *                                  caracteres son blancos.
     */
    public void setDirector(String director) {
	super.assertParamString(director);
	this.director = director;

    }

    /**
     * Metodo que asigna la duracion que se le pase como parametro
     * 
     * @param playingTime Un numero mayor que 0
     */
    protected void setPlayingTime(int playingTime) {
	if (playingTime > 0) {
	    this.playingTime = playingTime;
	}
    }

    /**
     * Metodo que devuelve la duracion del dvd
     * @return duración (entero positivo)
     */
    protected int getPlayingTime() {
	return this.playingTime;
    }

    /**
     * Metodo que devuelve el director del dvd
     * @return director, cadena de caracteres
     */
    public String getDirector() {
	return this.director;
    }

    /**
     * Escribe la informacion en el objeto que recibe como parametro. Con el
     * siguiente formato: DVD: títuloDvd (tiempo mins) Director: nombreDirector
     * Lo tienes (o bien No lo tienes) Comentario: elComentarioDelCd
     *
     * @param out de tipo PrintStream
     */
    public void print(PrintStream out) {
	out.println("DVD: " + getTitle() + " (" + getPlayingTime() + " mins)");
	out.println("Director: " + getDirector());
	if (getOwn()) {
	    out.println("You own it");
	} else {
	    out.println("You do not own it");
	}
	out.println("Comment: " + getComment());
    }

}
