package uo270318.mp.tareaS3.dome.model;

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
	super(title, false, "");
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
     * Escribe la informacion en el objeto que recibe como parametro Con el
     * siguiente formato: CD: tituloCD (tiempo mins) Artista: nombreArtista
     * Pistas: numeroPistas Lo tienes (o bien No lo tienes) Comentario:
     * elComentarioDelCd
     *
     * @param out de tipo PrintStream
     */
    @Override
    public void print(PrintStream out) {
	out.println("VIDEOGAME: " + getTitle());
	out.println("Author: " + getAuthor());
	out.println("NumPlayers: " + getNumPlayers());
	if (getOwn()) {
	    out.println("You own it");
	} else {
	    out.println("You do not own it");
	}
	out.println("Comment: " + getComment());
	out.println("Platform: " + getPlatform());
    }
}
