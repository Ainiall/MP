package uo270318.mp.tareaS9.dome.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import uo270318.mp.tareaS10.dome.exceptions.RepeatedElementException;
import uo270318.mp.tareaS9.dome.model.Database;
import uo270318.mp.tareaS9.dome.model.Dvd;

public class DvdTest {
    private Dvd dvd;

    @Before
    public void setUp() throws Exception {
	dvd = new Dvd("title1", "director2", 120);
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

    @Test
    public void setBasePrice() {
	// Precio valido
	dvd.setBasePrice(9.99);
	assertEquals(9.99, dvd.getBasePrice(), 0.1);
	// Precio invalido
	try {
	    dvd.setBasePrice(200000.00);
	    fail("Se esperaba un error de cadena incorrecta");
	} catch (IllegalArgumentException iae) {
	    assertEquals("El precio debe estar dentro del rango permitido",
		    iae.getMessage());
	}
	try {
	    dvd.setBasePrice(-200.00);
	    fail("Se esperaba un error de cadena incorrecta");
	} catch (IllegalArgumentException iae) {
	    assertEquals("El precio debe estar dentro del rango permitido",
		    iae.getMessage());
	}

    }

    @Test
    public void testToString() {
	assertEquals("DVD: title1" + "\nYou do not own it" + "\nPrice: 0.0"
		+ "\nComment: " + "\nPlaying time: 120 mins."
		+ "\nDirector: director2", dvd.toString());
    }

    @Test
    public void testSearch() throws RepeatedElementException {
	Database db = new Database();
	db.add(new Dvd("title", "director", 120));
	db.add(new Dvd("title2", "director2", 120));
	db.add(dvd);
	// Encuentra al item
	assertEquals(dvd, db.search(dvd));
	// No encuentra al item
	assertEquals(null, db.search(new Dvd("title5", "director5", 120)));
    }
}
