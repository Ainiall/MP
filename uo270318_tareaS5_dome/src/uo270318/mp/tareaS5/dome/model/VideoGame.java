package uo270318.mp.tareaS5.dome.model;

import java.io.PrintStream;
/**
 * <p>
 * Titulo: Clase VideoGame
 * </p>
 * <p>
 * Descripcion: Clase que contiene la informacion sobre los item VideoGame.
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p> 
 * @author Angela Lopez UO270318
 * @version 1.0
 */
public class VideoGame extends Item {

    private String theAuthor;
    private int numPlayers;
    private PlatformEnum platform;

    /**
     * Constructor con parametros
     * 
     * @param title      Titulo
     * @param theAuthor  Autor
     * @param numPLayers Numero de jugadores
     * @param platform   Plataforma
     */
    public VideoGame(String title, String theAuthor, int numPLayers,
	    PlatformEnum platform) {
	super(title, false, "",0.0);
	setAuthor(theAuthor);
	setNumPlayers(numPLayers);
	setPlatform(platform);
    }

    /**
     * Metodo que asigna el autor del videojuego
     * @param author Autor
     * @throws IllegalArgumentException Cuando el parametro es null o todos los
     *                                  caracteres son blancos.
     */
    protected void setAuthor(String author) {
	super.assertParamString(author);
	this.theAuthor = author;
    }

    /**
     * Metodo que asigna el numero de jugadores del videojuego
     * @param numPlayers Numero de jugadores
     */
    protected void setNumPlayers(int numPlayers) {
	if(numPlayers > 0) {
	    this.numPlayers = numPlayers;
	}
    }
    
    /**
     * Metodo que asigna la plataforma del videojuego
     * @param platform Plataforma
     */
    protected void setPlatform(PlatformEnum platform) {
	this.platform = platform;
    }

    /**
     * Metodo que devuelve el autor del videojuego
     * @return theAuthor Autor del videojuego
     */
    public String getAuthor() {
	return theAuthor;
    }
    
    /**
     * Metodo que devuelve el numero de jugadores del videojuego
     * @return numPlayers Numero de jugadores del videojuego
     */
    public int getNumPlayers() {
	return numPlayers;
    }

    /**
     * Metodo que devuelde la plataforma donde se juega el videojuego
     * @return platform Plataforma donde se juega
     */
    public PlatformEnum getPlatform() {
	return platform;
    }

    /**
     * Metodo que imprime informacion sobre el responsable de los videojuegos.
     */
    @Override
    public void printResponsables(PrintStream out) {
	out.println("El responsable del Videojuego " + this.getTitle() + " es "
		+ this.getAuthor());
    }

    /**
     * Metodo que calcula el valor total del videojuego.
     */
    @Override
    protected double itemValue() {
	return this.getBasePrice() + this.getBasePrice() * 0.1;
    }
    
    /**
     * Metodo que imprime toda la informacion sobre los videojuegos en una
     * cadena de caracteres.
     */
    @Override
    public String toString() {
	StringBuilder str = new StringBuilder();
	str.append("VIDEOGAME: ");
	str.append(super.toString());
	str.append("\nAuthor: ").append(getAuthor());
	str.append("\nNumPlayers: ").append(getNumPlayers());
	str.append("\nPlatform: ").append(getPlatform());
	return str.toString();
    }

    /**
     * Metodo que compara si dos cds son iguales por titulo y artista
     */
    @Override
    public boolean equals(Object theItem) {
	if (!(theItem instanceof VideoGame)) {
	    return false;
	}
	if (this == theItem) {
	    return true;
	}
	VideoGame game = (VideoGame) theItem;
	return (this.getAuthor().equals(game.getAuthor())
		&& this.getPlatform().equals(game.getPlatform()));
    }

}
