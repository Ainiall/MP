package uo270318.mp.tareaS3.post.model;

import java.io.PrintStream;
import java.util.ArrayList;

/**
 * <p>
 * Titulo: Clase Post
 * </p>
 * <p>
 * Descripcion: Clase que contiene la informacion sobre los post. Actua como
 * superclase y contiene atributos y metodos comunes.
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 * 
 * @author Angela Lopez UO270318
 * @version 1.0
 */

public class Post extends SocialNetwork {

    private static final int DEFAULT = 0;
    /**
     * Atributos
     */
    private int numOfLikes;
    private ArrayList<String> comments;
    private String userID;

    /**
     * Constructor que inicializa el numero de comentarios a 0, la lista de
     * comentarios vacia y el identificador al valor que se le pasa como
     * parametro.
     * 
     * @param userID Identificador del usuario
     * @throws IllegalArgumentException Cuando el parametro es null o todos los
     *                                  caracteres son blancos.
     */
    public Post(String userID) {
	numOfLikes = DEFAULT;
	comments = new ArrayList<String>();
	setIdentifier(userID);
    }

    /**
     * Metodo que asigna un identificador de usuario.
     * 
     * @param userID Identificador de usuario a asignar
     * @throws IllegalArgumentException Cuando el parametro es null o todos los
     *                                  caracteres son blancos.
     */
    protected void setIdentifier(String userID) {
	super.checkString(userID);
	this.userID = userID;
    }

    /**
     * Metodo que devuelve el identificador del usuario
     * 
     * @return userID Identificador de usuario
     */
    protected String getIdentifier() {
	return userID;
    }

    /**
     * Metodo que devuelve el numero de likes
     * 
     * @return numberOfLikes Numero de likes
     */
    protected int getNumOfLikes() {
	return numOfLikes;
    }

    /**
     * Metodo que vuelca en el objeto out todos los datos del post
     * 
     * @param out Parametro que nos indica el tipo de mensaje a mostrar.
     */
    public void print(PrintStream out) {
	out.println("UserID: " + getIdentifier());
	out.println("Number of likes: " + getNumOfLikes());
	if (!comments.isEmpty()) {
	    out.println("Comments: " + comments);
	}
    }

}
