package uo270318.mp.tareaS3.post.model;

import java.io.PrintStream;

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
     * Metodo que vuelca en el objeto out todos los datos del mensaje
     * 
     * @param out Parametro que nos indica el tipo de mensaje a mostrar.
     */
    @Override
    public void print(PrintStream out) {
	super.print(out);
	out.println("Message: " + getMessage());
    }

}
