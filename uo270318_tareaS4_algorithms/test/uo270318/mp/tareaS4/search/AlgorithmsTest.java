package uo270318.mp.tareaS4.search;

import static org.junit.Assert.*;

import org.junit.Test;

import uo270318.mp.tareaS4.dome.model.Cd;
import uo270318.mp.tareaS4.dome.model.Dvd;
/**
 * <p>
 * Titulo: Clase AlgorithmsTest
 * </p>
 * <p>
 * Descripcion: Clase Test de la clase Algorithms
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 * 
 * @author Angela Lopez UO270318
 * @version 1.0
 */
public class AlgorithmsTest {
    private static final Object[] vectorNull = null;

    @Test
    public void testSearchInteger() {
	Object[] integers = { 12, 34, 10, 78 };
	// Encuentra la posicion del objeto
	assertEquals(0, Algorithms.search(integers, 12));
	assertEquals(3, Algorithms.search(integers, 78));
	// No encuentra la posicion del objeto
	assertEquals(-1, Algorithms.search(integers, 90));
	// El objeto o el vector es null
	try {
	    Algorithms.search(integers, null);
	    fail("Deberia lanzar una excepcion");
	} catch (IllegalArgumentException iae) {
	    assertEquals("La cadena es incorrecta", iae.getMessage());
	}
	try {
	    Algorithms.search(vectorNull, 10);
	    fail("Deberia lanzar una excepcion");
	} catch (IllegalArgumentException iae) {
	    assertEquals("La cadena es incorrecta", iae.getMessage());
	}

    }

    @Test
    public void testSearchString() {
	Object[] strings = { "Hola", "test", "adios" };
	// Encuentra la posicion del objeto
	assertEquals(0, Algorithms.search(strings, "Hola"));
	assertEquals(2, Algorithms.search(strings, "adios"));
	// No encuentra la posicion del objeto
	assertEquals(-1, Algorithms.search(strings, " "));
	// El objeto o el vector es null
	try {
	    Algorithms.search(strings, null);
	    fail("Deberia lanzar una excepcion");
	} catch (IllegalArgumentException iae) {
	    assertEquals("La cadena es incorrecta", iae.getMessage());
	}
	try {
	    Algorithms.search(vectorNull, 10);
	    fail("Deberia lanzar una excepcion");
	} catch (IllegalArgumentException iae) {
	    assertEquals("La cadena es incorrecta", iae.getMessage());
	}
    }

    @Test
    public void testSearchCds() {
	Cd cd = new Cd("title1", "artist1", 6, 30);
	Object[] cds = { cd, new Cd("title2", "artist2", 7, 32),
		new Cd("title3", "artist3", 6, 33) };
	// Encuentra la posicion
	assertEquals(1,
		Algorithms.search(cds, new Cd("title2", "artist2", 7, 32)));
	assertEquals(0, Algorithms.search(cds, cd));
	// No encuentra la posicion
	assertEquals(-1,
		Algorithms.search(cds, new Cd("title4", "artist4", 6, 33)));
	// El objeto o el vector es null
	try {
	    Algorithms.search(cds, null);
	    fail("Deberia lanzar una excepcion");
	} catch (IllegalArgumentException iae) {
	    assertEquals("La cadena es incorrecta", iae.getMessage());
	}
	try {
	    Algorithms.search(vectorNull, 10);
	    fail("Deberia lanzar una excepcion");
	} catch (IllegalArgumentException iae) {
	    assertEquals("La cadena es incorrecta", iae.getMessage());
	}
    }

    @Test
    public void testSearchDvds() {
	Dvd dvd = new Dvd("title1", "director1", 6);
	Object[] dvds = { dvd, new Dvd("title2", "director2", 7),
		new Dvd("title3", "director3", 6) };
	// Encuentra la posicion del objeto
	assertEquals(1,
		Algorithms.search(dvds, new Dvd("title2", "director2", 7)));
	assertEquals(0, Algorithms.search(dvds, dvd));
	// No encuentra la posicion del objeto
	assertEquals(-1,
		Algorithms.search(dvds, new Dvd("title4", "director4", 6)));
	// El objeto o el vector es null
	try {
	    Algorithms.search(dvds, null);
	    fail("Deberia lanzar una excepcion");
	} catch (IllegalArgumentException iae) {
	    assertEquals("La cadena es incorrecta", iae.getMessage());
	}
	try {
	    Algorithms.search(vectorNull, 10);
	    fail("Deberia lanzar una excepcion");
	} catch (IllegalArgumentException iae) {
	    assertEquals("La cadena es incorrecta", iae.getMessage());
	}
    }

    @Test
    public void testSearchMix() {
	Cd cd = new Cd("title1", "artist1", 6, 30);
	Object[] vectorObjects = { 1, "one", cd };
	// Encuentra la posicion del objeto
	assertEquals(2, Algorithms.search(vectorObjects,
		new Cd("title1", "artist1", 6, 30)));
	assertEquals(0, Algorithms.search(vectorObjects, 1));
	// No encuentra la posicion del objeto
	assertEquals(-1, Algorithms.search(vectorObjects, 46));
	// El objeto o el vector es null
	try {
	    Algorithms.search(vectorObjects, null);
	    fail("Deberia lanzar una excepcion");
	} catch (IllegalArgumentException iae) {
	    assertEquals("La cadena es incorrecta", iae.getMessage());
	}
	try {
	    Algorithms.search(vectorNull, 10);
	    fail("Deberia lanzar una excepcion");
	} catch (IllegalArgumentException iae) {
	    assertEquals("La cadena es incorrecta", iae.getMessage());
	}
    }
}
