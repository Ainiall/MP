package uo270318.mp.tareaS4.dome.model;

import java.io.PrintStream;
/**
 * <p>
 * Titulo: Clase Cd
 * </p>
 * <p>
 * Descripcion: Clase que contiene la informacion sobre los item Cd.
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 * @author Angela Lopez UO270318
 * @version 1.0
 */
public class Cd extends Item {

    private String artist;
    private int numberOfTracks;
    private int playingTime;

    final static double TAX = 2.0;

    /**
     * Constructor con parametros
     * 
     * @param theTitle  Titulo del cd
     * @param theArtist Artista del cd
     * @param tracks    Numero de pistas del cd
     * @param time      Numero de duracion del cd
     */
    public Cd(String theTitle, String theArtist, int tracks, int time) {
	super(theTitle, false, "",0.0);
	setArtist(theArtist);
	setNumberOfTracks(tracks);
	setPlayingTime(time);
    }

    /**
     * Metodo que asigna artista
     * 
     * @param artist recibe una cadena con el nombre del artista
     * @throws IllegalArgumentException Cuando el parametro es null o todos los
     *                                  caracteres son blancos.
     */
    protected void setArtist(String artist) {
	super.assertParamString(artist);
	this.artist = artist;
    }

    /**
     * Metodo que asigna número de pistas
     * 
     * @param numberOfTracks un valor mayor que 0
     */
    protected void setNumberOfTracks(int numberOfTracks) {
	if (numberOfTracks > 0) {
	    this.numberOfTracks = numberOfTracks;
	}
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
     * Metodo que devuelve el artista del cd
     * @return artista (cadena)
     */
    protected String getArtist() {
	return this.artist;
    }

    /**
     * Metodo que devuelve el numero de pistas del cd
     * @return número de pistas (entero positivo)
     */
    protected int getNumberOfTracks() {
	return this.numberOfTracks;
    }

    /**
     * Metodo que devuelve la duracion del cd
     * @return duración (entero positivo)
     */
    protected int getPlayingTime() {
	return this.playingTime;
    }
    
    /**
     * Metodo que imprime el responsable del CD.
     */
    @Override
    public void printResponsables(PrintStream out) {
	 out.println("El responsable del CD " + this.getTitle()
	    + " es: " + this.getArtist());
    }
    /**
     * Metodo que devuelve el precio total de los CDS
     */
    @Override
    protected double itemValue() {
	return this.getBasePrice() + TAX;
    }

    /**
     * Metodo que imprime toda la informacion del CD.
     */
    @Override
    public String toString() {
	StringBuilder str = new StringBuilder();
	str.append("CD: ").append(getTitle()).append(" (")
		.append(getPlayingTime()).append(")").append(" mins.");
	str.append("\nArtist: ").append(getArtist()).append("\nTracks: ")
		.append(getNumberOfTracks());
	if (getOwn())
	    str.append("\nYou own it");
	else
	    str.append("\nYou do not own it");
	str.append("\nPrice: ").append(getBasePrice());
	str.append("\nComment: ").append(getComment());
	return str.toString();
    }

    /**
     * Metodo que compara si dos cds son iguales por titulo y artista
     */
    @Override
    public boolean equals(Object theItem) {
	if (!(theItem instanceof Cd)) {
	    return false;
	}
	if (this == theItem) {
	    return true;
	}
	Cd cd = (Cd) theItem;
	return (this.getTitle().equals(cd.getTitle())
		&& this.getArtist().equals(cd.getArtist()));
    }

}