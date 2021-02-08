package uo270318.mp.tareaS4.post.model;


/**
 * <p>
 * Titulo: Clase Photo
 * </p>
 * <p>
 * Descripcion: Clase que contiene la informacion sobre los post Photo.
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 * 
 * @author Angela Lopez UO270318
 * @version 1.0
 */

public class Photo extends Post {

    /**
     * Atributos
     */
    private String photoPath;
    private String title;

    /**
     * Constructor con parametros heredados de la superclase Post y propios.
     * 
     * @param userID    ID del usuario que escribe el post
     * @param photoPath Nombre del fichero donde se almacena la foto
     * @param title     Titulo de la foto
     */
    public Photo(String userID, String photoPath, String title) {
	super(userID);
	setPhotoPath(photoPath);
	setTitle(title);
    }

    /**
     * Metodo que asigna un nombre al fichero donde se almacena la foto que se
     * pasa como parametro.
     * 
     * @param photoPath Nombre a asignar
     * @throws IllegalArgumentException Cuando el parametro es null o todos los
     *                                  caracteres son blancos.
     */
    protected void setPhotoPath(String photoPath) {
	super.checkString(photoPath);
	this.photoPath = photoPath;
    }

    /**
     * Metodo que asigna un titulo a la foto
     * 
     * @param title Titulo a asignar
     * @throws IllegalArgumentException Cuando el parametro es null o todos los
     *                                  caracteres son blancos.
     */
    protected void setTitle(String title) {
	super.checkString(title);
	this.title = title;
    }

    /**
     * Metodo que devuelve el nombre del fichero donde se almacena la foto.
     * 
     * @return photoPath Nombre del fichero
     */
    protected String getPhotoPath() {
	return photoPath;
    }

    /**
     * Metodo que devuelve el titulo de la foto
     * 
     * @return title Titulo de la foto
     */
    protected String getTitle() {
	return title;
    }

    /**
     * Metodo que formatea la foto a formato HTML.
     * @return Informacion formateada
     */
    @Override
    public String postHTML() {
	return "<img src=" + getPhotoPath() + ">" + getTitle() + "</img>";
    }
    /**
     * Metodo que devuelve una cadena de caracteres que contiene la informacion de la foto.
     * @return str Cadena con la informacion
     */
    @Override
    public String toString() {
	StringBuilder str = new StringBuilder(super.toString());
	str.append("\nPath: ").append(getPhotoPath());
	str.append("\nTitle: ").append(getTitle());
	return str.toString();
    }

}
