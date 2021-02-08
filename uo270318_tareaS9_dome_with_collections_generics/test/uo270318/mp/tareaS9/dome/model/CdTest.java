package uo270318.mp.tareaS9.dome.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import uo270318.mp.tareaS10.dome.exceptions.RepeatedElementException;
import uo270318.mp.tareaS9.dome.model.Cd;
import uo270318.mp.tareaS9.dome.model.Database;

public class CdTest {
    private Cd cd;

    @Before
    public void setUp() throws Exception {
	cd = new Cd("title1", "artist1", 6, 30, false);
    }

    @Test
    public void testCd() {
	Cd cd2 = new Cd("Come Together", "Beatles", 4, 70, false);
	assertEquals("Come Together", cd2.getTitle());
	assertEquals("Beatles", cd2.getArtist());
	assertEquals(70, cd2.getPlayingTime());
	assertEquals(4, cd2.getNumberOfTracks());
	assertEquals(false, cd2.getOwn());
	assertEquals("", cd2.getComment());
    }

    @Test
    public void testSetTitle() {
	// Titulo correcto
	cd.setTitle("newTitle");
	assertEquals("newTitle", cd.getTitle());
	// Titulo incorrecto (null)
	try {
	    cd = new Cd(null, "Beatles", 4, 70, false);
	    fail("Se esperaba un error de cadena incorrecta");
	} catch (IllegalArgumentException iae) {
	    assertEquals("La cadena es incorrecta", iae.getMessage());
	}
	// Titulo incorrecto (vacio)
	try {
	    cd = new Cd("  ", "Beatles", 4, 70, false);
	    fail("Se esperaba un error de cadena incorrecta");
	} catch (IllegalArgumentException iae) {
	    assertEquals("La cadena es incorrecta", iae.getMessage());
	}
    }

    @Test
    public void testSetArtist() {
	// Artista correcto
	cd.setArtist("newArtist");
	assertEquals("newArtist", cd.getArtist());
	// Artista incorrecto (null)
	try {
	    cd = new Cd("Come Together", null, 4, 70, false);
	    fail("Se esperaba un error de cadena incorrecta");
	} catch (IllegalArgumentException iae) {
	    assertEquals("La cadena es incorrecta", iae.getMessage());
	}
	// Artista incorrecto (vacio)
	try {
	    cd = new Cd("Come Together", " ", 4, 70, false);
	    fail("Se esperaba un error de cadena incorrecta");
	} catch (IllegalArgumentException iae) {
	    assertEquals("La cadena es incorrecta", iae.getMessage());
	}
    }

    @Test
    public void testSetNumberOfTracks() {
	// Numero de pistas correcto
	cd.setNumberOfTracks(10);
	assertEquals(10, cd.getNumberOfTracks());
	// Numero de pistas incorrecto
	cd = new Cd("Come Together", "Beatles", -9, 70, false);
	assertEquals(0, cd.getNumberOfTracks());
    }

    @Test
    public void testSetPlayingTime() {
	// Tiempo correcto
	cd.setPlayingTime(90);
	assertEquals(90, cd.getPlayingTime());
	// Tiempo incorrecto
	cd = new Cd("Come Together", "Beatles", 4, -6, false);
	assertEquals(0, cd.getPlayingTime());
    }

    @Test
    public void testSetComment() {
	// Comentario correcto
	cd.setComment("comment");
	assertEquals("comment", cd.getComment());
	// Comentario incorrecto (null)
	try {
	    cd.setComment(null);
	    fail("Se esperaba un error de cadena incorrecta");
	} catch (IllegalArgumentException iae) {
	    assertEquals("La cadena es incorrecta", iae.getMessage());
	}
    }

    @Test
    public void testSetOwn() {
	// Pertenece
	cd.setOwn(true);
	assertTrue(cd.getOwn());
	// No pertenece
	cd.setOwn(false);
	assertFalse(cd.getOwn());
    }

    @Test
    public void setBasePrice() {
	// Precio valido
	cd.setBasePrice(9.99);
	assertEquals(9.99, cd.getBasePrice(), 0.1);
	// Precio invalido
	try {
	    cd.setBasePrice(200000.00);
	    fail("Se esperaba un error de cadena incorrecta");
	} catch (IllegalArgumentException iae) {
	    assertEquals("El precio debe estar dentro del rango permitido",
		    iae.getMessage());
	}
	try {
	    cd.setBasePrice(-200.00);
	    fail("Se esperaba un error de cadena incorrecta");
	} catch (IllegalArgumentException iae) {
	    assertEquals("El precio debe estar dentro del rango permitido",
		    iae.getMessage());
	}

    }

    @Test
    public void testSetAvailable() {
	// Disponible para prestar
	cd.setAvailable(true);
	assertTrue(cd.getAvailable());
	// No pertenece
	cd.setAvailable(false);
	assertFalse(cd.getAvailable());
    }

    @Test
    public void testToString() {
	assertEquals("CD: title1" + "\nYou do not own it" + "\nPrice: 0.0"
		+ "\nComment: " + "\nPlaying time: 30 mins."
		+ "\nArtist: artist1" + "\nTracks: 6", cd.toString());
    }

    @Test
    public void testSearch() throws RepeatedElementException {
	Database db = new Database();
	db.add(new Cd("title", "artist", 3, 18, false));
	db.add(new Cd("title2", "artist2", 5, 17, false));
	db.add(cd);
	// Encuentra al item
	assertEquals(cd, db.search(cd));
	// No encuentra al item
	assertEquals(null,
		db.search(new Cd("title3", "artist2", 5, 57, false)));
    }

    @Test
    public void testIsAvailableItem() {
	//Disponible
	cd.setOwn(true);
	cd.setAvailable(true);
	assertTrue(cd.isAvailableItem());
	//No disponible
	cd.setOwn(false);
	assertFalse(cd.isAvailableItem());
	cd.setOwn(true);
	cd.setAvailable(false);
	assertFalse(cd.isAvailableItem());
    }
}
