package uo270318.mp.tareaS5.dome.model;

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
 * 
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
	super(theTitle, false, "", 0.0);
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
    protected void setDirector(String director) {
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
     * 
     * @return duración (entero positivo)
     */
    protected int getPlayingTime() {
	return this.playingTime;
    }

    /**
     * Metodo que devuelve el director del dvd
     * 
     * @return director, cadena de caracteres
     */
    protected String getDirector() {
	return this.director;
    }

    /**
     * Metodo que imprime el responsable del DVD.
     */
    @Override
    public void printResponsables(PrintStream out) {
	out.println("El responsable del DVD " + this.getTitle() + " es: "
		+ this.getDirector());
    }

    /**
     * Metodo que devuelve el precio total de los DVD.
     */
    @Override
    protected double itemValue() {
	return this.getBasePrice();
    }

    /**
     * Metodo que imprime toda la informacion del DVD.
     */
    @Override
    public String toString() {
	StringBuilder str = new StringBuilder();
	str.append("DVD: ");
	str.append(super.toString());
	str.append("\nPlaying time: "+getPlayingTime()).append(" mins.");
	str.append("\nDirector: ").append(getDirector());
	return str.toString();
    }

    /**
     * Metodo que compara si dos cds son iguales por titulo y artista
     */
    @Override
    public boolean equals(Object theItem) {
	if (!(theItem instanceof Dvd)) {
	    return false;
	}
	if (this == theItem) {
	    return true;
	}
	Dvd dvd = (Dvd) theItem;
	return (this.getTitle().equals(dvd.getTitle())
		&& this.getDirector().equals(dvd.getDirector()));
    }

}
