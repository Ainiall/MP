package uo270318.mp.tareaS3.dome.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CdTest {
    private Cd cd;

    @Before
    public void setUp() throws Exception {
	cd = new Cd("title1", "artist1", 6, 30);
    }

    @Test
    public void testPrint() {
	cd.print(System.out);
    }

    @Test
    public void testCd() {
	Cd cd2 = new Cd("Come Together", "Beatles", 4, 70);
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
	    cd = new Cd(null, "Beatles", 4, 70);
	    fail("Se esperaba un error de cadena incorrecta");
	} catch (IllegalArgumentException iae) {
	    assertEquals("La cadena es incorrecta", iae.getMessage());
	}
	// Titulo incorrecto (vacio)
	try {
	    cd = new Cd("  ", "Beatles", 4, 70);
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
	    cd = new Cd("Come Together", null, 4, 70);
	    fail("Se esperaba un error de cadena incorrecta");
	} catch (IllegalArgumentException iae) {
	    assertEquals("La cadena es incorrecta", iae.getMessage());
	}
	// Artista incorrecto (vacio)
	try {
	    cd = new Cd("Come Together", " ", 4, 70);
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
	cd = new Cd("Come Together", "Beatles", -9, 70);
	assertEquals(0, cd.getNumberOfTracks());
    }

    @Test
    public void testSetPlayingTime() {
	// Tiempo correcto
	cd.setPlayingTime(90);
	assertEquals(90, cd.getPlayingTime());
	// Tiempo incorrecto
	cd = new Cd("Come Together", "Beatles", 4, -6);
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
}
