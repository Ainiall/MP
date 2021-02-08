package uo270318.mp.tareaS3.post.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * <p>
 * Titulo: Clase PostTest
 * </p>
 * <p>
 * Descripcion: En esta clase se realizan pruebas unitarias referidas a la clase
 * Post.java {@link uo270318.mp.tareaS3.post.model.Post}
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 * 
 * @author Angela Lopez UO270318
 * @version 1.0
 */

public class PostTest {

    private Post msg1;
    @SuppressWarnings("unused")
    private Post msg2;
    @SuppressWarnings("unused")
    private Post msg3;
    private Post photo1;
    @SuppressWarnings("unused")
    private Post photo2;
    @SuppressWarnings("unused")
    private Post photo3;

    /**
     * Metodo que se ejecuta antes que las llamadas a los test, lo que permite
     * inicializar los objetos susceptibles a estudio una sola vez.
     */
    @Before
    public void setUp() {
	msg1 = new Message("user1", "prueba1");
	photo1 = new Photo("user2", "path2", "title2");
    }

    /**
     * Metodo Test que hace referencia a
     * {@link uo270318.mp.tareaS3.post.model.Post#Post(String userID)}.
     */
    @Test
    public void testPost() {
	msg2 = new Message("angela", "prueba");
	photo2 = new Photo("pepito", "ig", "foto1");
	try {
	    photo3 = new Photo("", "", "");
	    fail("Deberia lanzar una excepcion");
	} catch (IllegalArgumentException iae) {
	    assertEquals("La cadena es incorrecta", iae.getMessage());
	}
	try {
	    msg3 = new Message("", "");
	    fail("Deberia lanzar una excepcion");
	} catch (IllegalArgumentException iae) {
	    assertEquals("La cadena es incorrecta", iae.getMessage());
	}
    }

    /**
     * Metodo Test que hace referencia a
     * {@link uo270318.mp.tareaS3.post.model.Post#setIdentifier(String userID)}.
     */
    @Test
    public void testSetIdentifier() {
	msg1.setIdentifier("user2");
	assertEquals(msg1.getIdentifier(), "user2");
	try {
	    photo1.setIdentifier("");
	    fail("Deberia lanzar una excepcion");
	} catch (IllegalArgumentException iae) {
	    assertEquals("La cadena es incorrecta", iae.getMessage());
	}
    }

    /**
     * Metodo Test que hace referencia a
     * {@link uo270318.mp.tareaS3.post.model.Post#print(PrintStream out)}.
     */
    @Test
    public void testPrint() {
	msg1.print(System.out);
	photo1.print(System.out);
    }

}
