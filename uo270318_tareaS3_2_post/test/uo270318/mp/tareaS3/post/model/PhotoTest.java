package uo270318.mp.tareaS3.post.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * <p>
 * Titulo: Clase PhotoTest
 * </p>
 * <p>
 * Descripcion: En esta clase se realizan pruebas unitarias referidas a la clase
 * Photo.java {@link uo270318.mp.tareaS3.post.model.Photo}
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 * 
 * @author Angela Lopez UO270318
 * @version 1.0
 */

public class PhotoTest {
    /**
     * Declaracion de variables
     */
    private Photo photo1;
    private Photo photo2;
    @SuppressWarnings("unused")
    private Photo photo3;
    @SuppressWarnings("unused")
    private Photo photoErrorPath;
    @SuppressWarnings("unused")
    private Photo photoErrorTitle;
    @SuppressWarnings("unused")
    private Photo photoErrorID;

    /**
     * Metodo que se ejecuta antes que las llamadas a los test, lo que permite
     * inicializar los objetos susceptibles a estudio una sola vez.
     */
    @Before
    public void setUp() {
	photo1 = new Photo("Angela", "apuntes", "herencia");
	photo2 = new Photo("Pepito", "ig", "foto1");
    }

    /**
     * Metodo Test que hace referencia a
     * {@link uo270318.mp.tareaS3.post.model.Photo#print(PrintStream out)}.
     */
    @Test
    public void testPrint() {
	photo1.print(System.out);
	photo2.print(System.out);
    }

    /**
     * Metodo Test que hace referencia a
     * {@link uo270318.mp.tareaS3.post.model.Photo#Photo(String userID, String photoPath, String title)}.
     */
    @Test
    public void testPhoto() {
	// Post valido
	photo3 = new Photo("user1", "path1", "title1");
	// Post con path invalido
	try {
	    photoErrorPath = new Photo("user2", "        ", "title2");
	    fail("Deberia lanzar una excepcion");
	} catch (IllegalArgumentException iae) {
	    assertEquals("La cadena es incorrecta", iae.getMessage());
	}
	// Post con titulo invalido
	try {
	    photoErrorTitle = new Photo("user3", "path3", " ");
	    fail("Deberia lanzar una excepcion");
	} catch (IllegalArgumentException iae) {
	    assertEquals("La cadena es incorrecta", iae.getMessage());
	}
	// Post con usuario invalido
	try {
	    photoErrorID = new Photo("", "path4", "title4");
	    fail("Deberia lanzar una excepcion");
	} catch (IllegalArgumentException iae) {
	    assertEquals("La cadena es incorrecta", iae.getMessage());
	}
    }

    /**
     * Metodo Test que hace referencia a
     * {@link uo270318.mp.tareaS3.post.model.Photo#setPhotoPath(String photoPath)}.
     */
    @Test
    public void testSetPhotoPath() {
	// Caso valido
	photo1.setPhotoPath("newPath");
	// Caso invalido (lanza una excepcion)
	try {
	    photo2.setPhotoPath("");
	    fail("Deberia lanzar una excepcion");
	} catch (IllegalArgumentException iae) {
	    assertEquals("La cadena es incorrecta", iae.getMessage());
	}
    }

    /**
     * Metodo Test que hace referencia a
     * {@link uo270318.mp.tareaS3.post.model.Photo#getPhotoPath()}.
     */
    @Test
    public void testGetPhotoPath() {
	// como se ejecutan alfabeticamente tenemos que probar los mensaje
	// antiguos
	assertEquals("apuntes", photo1.getPhotoPath());
	assertEquals("ig", photo2.getPhotoPath());
	// Al probar los mensajes antiguos se ve que no son iguales
	assertNotEquals("newPath", photo1.getPhotoPath());
    }

    /**
     * Metodo Test que hace referencia a
     * {@link uo270318.mp.tareaS3.post.model.Photo#setTitle(String title)}.
     */
    @Test
    public void testSetTitle() {
	// Caso valido
	photo1.setTitle("title1");
	// Caso invalido
	try {
	    photo2.setTitle("");
	    fail("Deberia lanzar una excepcion");
	} catch (IllegalArgumentException iae) {
	    assertEquals("La cadena es incorrecta", iae.getMessage());
	}
    }

    /**
     * Metodo Test que hace referencia a
     * {@link uo270318.mp.tareaS3.post.model.Photo#getTitle()}.
     */
    @Test
    public void testGetTitle() {
	// como se ejecutan alfabeticamente tenemos que probar los mensaje
	// antiguos
	assertEquals("herencia", photo1.getTitle());
	assertEquals("foto1", photo2.getTitle());
	// Al probar los mensajes antiguos se ve que no son iguales
	assertNotEquals("title1", photo1.getTitle());
    }

}
