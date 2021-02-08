package uo270318.mp.tareaS4.post.model;


/**
 * <p>
 * Titulo: Clase Message
 * </p>
 * <p>
 * Descripcion: Clase que contiene la informacion sobre los post Message.
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 *  
 * @author Angela Lopez UO270318
 * @version 1.0
 */
public class Message extends Post {
    /**
     * Atributo
     */
    private String message;

    /**
     * Constructor con parametros heredados de la superclase Post y propios.
     * 
     * @param userID  ID del usuario que escribe el mensaje
     * @param message Mensaje del post
     * @throws IllegalArgumentException Cuando el parametro es null o todos los
     *                                  caracteres son blancos.
     */
    public Message(String userID, String message) {
	super(userID);
	setMessage(message);
    }

    /**
     * Metodo que asigna un mensaje que se le pasa como parametro al post
     * 
     * @param message Mensaje a asignar
     * @throws IllegalArgumentException Cuando el parametro es null o todos los
     *                                  caracteres son blancos.
     */
    protected void setMessage(String message) {
	super.checkString(message);
	this.message = message;
    }

    /**
     * Metodo que devuelve el mensaje del post
     * 
     * @return message Mensaje del post
     */
    protected String getMessage() {
	return message;
    }

     /**
     * Metodo que formatea el mensaje a formato HTML.
     * @return Informacion formateada
     */
    @Override
    public String postHTML() {
	return "<p>" + getMessage() + "</p>";
    }

    /**
     * Metodo que devuelve una cadena de caracteres que contiene la informacion de la foto.
     * @return str Cadena con la informacion
     */
    @Override
    public String toString() {
	StringBuilder str = new StringBuilder(super.toString());
	str.append("\nMessage: ").append(getMessage());
	return str.toString();
    }

}
