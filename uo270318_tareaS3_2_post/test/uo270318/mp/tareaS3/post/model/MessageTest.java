package uo270318.mp.tareaS3.post.model;

import static org.junit.Assert.*;

import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

/**
 * <p>
 * Titulo: Clase MessageTest
 * </p>
 * <p>
 * Descripcion: En esta clase se realizan pruebas unitarias referidas a la clase
 * Message.java {@link uo270318.mp.tareaS3.post.model.Message}
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 * 
 * @author Angela Lopez UO270318
 * @version 1.0
 */

public class MessageTest {

    /**
     * Declaracion de variables
     */
    private Message msg;
    private Message msg2;
    @SuppressWarnings("unused")
    private Message msgOK;
    @SuppressWarnings("unused")
    private Message msgErrorName;
    @SuppressWarnings("unused")
    private Message msgErrorMessage;

    /**
     * Metodo que se ejecuta antes que las llamadas a los test, lo que permite
     * inicializar los objetos susceptibles a estudio una sola vez.
     */
    @Before
    public void setUp() {
	msg = new Message("Angela", "Hola, Mundo!");
	msg2 = new Message("Usuario", "Post de bienvenida");
    }

    /**
     * Metodo Test que hace referencia a
     * {@link uo270318.mp.tareaS3.post.model.Message#print(PrintStream out)}.
     */
    @Test
    public void testPrint() {
	msg.print(System.out);
	msg2.print(System.out);
    }

    /**
     * Metodo Test que hace referencia a
     * {@link uo270318.mp.tareaS3.post.model.Message#Message(String userID, String message)}.
     */
    @Test
    public void testMessage() {
	// Mensaje valido
	msgOK = new Message("Usuario", "Post de bienvenida");
	// Nombre de usuario no valido (lanza una expcepcion)
	try {
	    msgErrorName = new Message("", "error");
	    fail("Deberia lanzar una excepcion");
	} catch (IllegalArgumentException iae) {
	    assertEquals("La cadena es incorrecta", iae.getMessage());
	}
	// Mensaje no valido (lanza una excepcion)
	try {
	    msgErrorMessage = new Message("Angela", "");
	    fail("Deberia lanzar una excepcion");
	} catch (IllegalArgumentException iae) {
	    assertEquals("La cadena es incorrecta", iae.getMessage());
	}
    }

    /**
     * Metodo Test que hace referencia a
     * {@link uo270318.mp.tareaS3.post.model.Message#setMessage(String message)}.
     */
    @Test
    public void testSetMessage() {
	// Mensaje valido
	msg.setMessage("Nuevo mensaje");
	assertEquals(msg.getMessage(), "Nuevo mensaje");
	// Mensaje no valido (lanza excepcion)
	try {
	    msg2.setMessage("    ");
	    fail("Deberia lanzar una excepcion");
	} catch (IllegalArgumentException iae) {
	    assertEquals("La cadena es incorrecta", iae.getMessage());
	}
    }

    /**
     * Metodo Test que hace referencia a
     * {@link uo270318.mp.tareaS3.post.model.Message#getMessage()}.
     */
    @Test
    public void testGetMessage() {
	// como se ejecutan alfabeticamente tenemos que probar los mensaje
	// antiguos
	assertEquals("Hola, Mundo!", msg.getMessage());
	assertEquals("Post de bienvenida", msg2.getMessage());
	// Al probar los mensajes antiguos se ve que no son iguales
	assertNotEquals("Nuevo mensaje", msg.getMessage());
    }

}
