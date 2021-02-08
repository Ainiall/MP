package uo270318.mp.tareaS3.dome.model;

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

    /**
     * Constructor con parametros
     * 
     * @param theTitle  Titulo del cd
     * @param theArtist Artista del cd
     * @param tracks    Numero de pistas del cd
     * @param time      Numero de duracion del cd
     */
    public Cd(String theTitle, String theArtist, int tracks, int time) {
	super(theTitle, false, "");
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
    public void setArtist(String artist) {
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
    public String getArtist() {
	return this.artist;
    }

    /**
     * Metodo que devuelve el numero de pistas del cd
     * @return número de pistas (entero positivo)
     */
    public int getNumberOfTracks() {
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
     * Escribe la información en el objeto que recibe como parámetro Con el
     * siguiente formato: CD: títuloCd (tiempo mins) Artista: nombreArtista
     * Pistas: numeroPistas Lo tienes (o bien No lo tienes) Comentario:
     * elComentarioDelCd
     *
     * @param out de tipo PrintStream
     */
    public void print(PrintStream out) {
	out.println("CD: " + getTitle() + " (" + getPlayingTime() + " mins)");
	out.println("Artist: " + getArtist());
	out.println("Tracks: " + getNumberOfTracks());
	if (getOwn()) {
	    out.println("You own it");
	} else {
	    out.println("You do not own it");
	}
	out.println("Comment: " + getComment());
    }
}