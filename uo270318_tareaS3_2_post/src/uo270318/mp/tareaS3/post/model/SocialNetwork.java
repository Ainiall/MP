package uo270318.mp.tareaS3.post.model;

import java.io.PrintStream;
import java.util.ArrayList;

/**
 * <p>
 * Titulo: Clase SocialNetwork
 * </p>
 * <p>
 * Descripcion: Clase que maneja los distintos tipos de posts.
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 * 
 * @author Angela Lopez UO270318
 * @version 1.0
 */
public class SocialNetwork {
    /**
     * Variable
     */
    private ArrayList<Post> posts;

    /**
     * Constructor sin parametros.
     */
    public SocialNetwork() {
	posts = new ArrayList<Post>();
    }

    /**
     * Metodo que permite insertar un nuevo post a la coleccion.
     * 
     * @param post Nuevo item a insertar.
     * @throws IllegalArgumentException cuando el parametro es null o todos los
     *                                  caracteres son blancos.
     */
    public void add(Post post) {
	assertParamPost(post);
	posts.add(post);
    }

    /**
     * Metodo que imprime los atributos de todos los posts en el objeto out que
     * se le pasa como parametro.
     * 
     * @param out Objeto de tipo PrintStream
     */
    public void printPost(PrintStream out) {
	for (Post post : posts)
	    post.print(out);
    }

    /**
     * Metodo que recibe como parametro un usuario y devuelve una lista con
     * todos sus post.
     * 
     * @param userID ID del usuario a buscar
     * @return userPost ArrayList que contiene todos los post del usuario
     */
    public ArrayList<Post> userPosts(String userID) {
	checkString(userID);
	ArrayList<Post> userPosts = new ArrayList<Post>();
	for (int i = 0; i < posts.size(); i++) {
	    if (posts.get(i).getIdentifier().equals(userID))
		userPosts.add(posts.get(i));
	}
	return userPosts;
    }

    /**
     * Metodo auxiliar que comprueba la validez de la cadena de texto pasada
     * como parametro. Para ello se comprueba que sea distinta de null y no
     * tenga espacios en blanco.
     * 
     * @param string Cadena a validar
     */
    protected void checkString(String string) {
	if (string == null || string.trim().length() == 0) {
	    throw new IllegalArgumentException("La cadena es incorrecta");
	}
    }

    /**
     * Metodo auxiliar que comprueba la validez del post que se le pasa como
     * parametro. Para ello se comprueba que no sea null.Si lo es lanza una
     * excepcion.
     * 
     * @param post Parametro a validar.
     */
    private void assertParamPost(Post post) {
	if (post == null) {
	    throw new IllegalArgumentException("El parametro es null");
	}
    }
}
