package uo270318.mp.tareaS3.dome.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DvdTest {
    private Dvd dvd;

    @Before
    public void setUp() throws Exception {
	dvd = new Dvd("title1", "director2", 120);
    }

    @Test
    public void testPrint() {
	dvd.print(System.out);
    }

    @Test
    public void testDvd() {
	dvd = new Dvd("Star Wars", "George Lucas", 125);

	assertEquals("Star Wars", dvd.getTitle());
	assertEquals("George Lucas", dvd.getDirector());
	assertEquals(125, dvd.getPlayingTime());
	assertEquals(false, dvd.getOwn());
	assertEquals("", dvd.getComment());
    }

    @Test
    public void testSetTitle() {
	// Titulo correcto
	dvd.setTitle("newTitle");
	assertEquals("newTitle", dvd.getTitle());
	// Titulo incorrecto (null)
	try {
	    dvd = new Dvd(null, "George Lucas", 125);
	    fail("Se esperaba un error de cadena incorrecta");
	} catch (IllegalArgumentException iae) {
	    assertEquals("La cadena es incorrecta", iae.getMessage());
	}
	// Titulo incorrecto (vacio)
	try {
	    dvd = new Dvd("  ", "George Lucas", 125);
	    fail("Se esperaba un error de cadena incorrecta");
	} catch (IllegalArgumentException iae) {
	    assertEquals("La cadena es incorrecta", iae.getMessage());
	}
    }

    @Test
    public void testSetDirector() {
	// Director correcto
	dvd.setDirector("newDirector");
	assertEquals("newDirector", dvd.getDirector());
	// Director incorrecto (null)
	try {
	    dvd = new Dvd("Star Wars", null, 125);
	    fail("Se esperaba un error de cadena incorrecta");
	} catch (IllegalArgumentException iae) {
	    assertEquals("La cadena es incorrecta", iae.getMessage());
	}
	// Director incorrecto (vacio)
	try {
	    dvd = new Dvd("Star Wars", "   ", 125);
	    fail("Se esperaba un error de cadena incorrecta");
	} catch (IllegalArgumentException iae) {
	    assertEquals("La cadena es incorrecta", iae.getMessage());
	}
    }

    @Test
    public void testSetPlayingTime() {
	// Tiempo correcto
	dvd.setPlayingTime(90);
	assertEquals(90, dvd.getPlayingTime());
	// Tiempo incorrecto
	dvd = new Dvd("Star Wars", "George Lucas", -125);
	assertEquals(0, dvd.getPlayingTime());
    }

    @Test
    public void testSetComment() {
	// Comentario correcto
	dvd.setComment("comment");
	assertEquals("comment", dvd.getComment());
	// Comentario incorrecto (null)
	try {
	    dvd.setComment(null);
	    fail("Se esperaba un error de cadena incorrecta");
	} catch (IllegalArgumentException iae) {
	    assertEquals("La cadena es incorrecta", iae.getMessage());
	}
    }

    @Test
    public void testSetOwn() {
	// Pertenece
	dvd.setOwn(true);
	assertTrue(dvd.getOwn());
	// No pertenece
	dvd.setOwn(false);
	assertFalse(dvd.getOwn());
    }

}
