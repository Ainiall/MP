package uo270318.mp.tareaS3.dome.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VideoGameTest {
    private VideoGame game;

    @Before
    public void setUp() throws Exception {
	game = new VideoGame("title1", "‎company1", 10, PlatformEnum.NINTENDO);
    }

    @Test
    public void testPrint() {
	game.print(System.out);
    }

    @Test
    public void testVideoGame() {
	game = new VideoGame("Super Smash Bros.Ultimate", "‎Nintendo", 8,
		PlatformEnum.NINTENDO);
	assertEquals("Super Smash Bros.Ultimate", game.getTitle());
	assertEquals("‎Nintendo", game.getAuthor());
	assertEquals(8, game.getNumPlayers());
	assertEquals(PlatformEnum.NINTENDO, game.getPlatform());
	assertEquals(false, game.getOwn());
	assertEquals("", game.getComment());
    }

    @Test
    public void testSetTitle() {
	// Titulo correcto
	game.setTitle("newTitle");
	assertEquals("newTitle", game.getTitle());
	// Titulo incorrecto (null)
	try {
	    game = new VideoGame(null, "‎Nintendo", 8, PlatformEnum.NINTENDO);
	    fail("Se esperaba un error de cadena incorrecta");
	} catch (IllegalArgumentException iae) {
	    assertEquals("La cadena es incorrecta", iae.getMessage());
	}
	// Titulo incorrecto (vacio)
	try {
	    game = new VideoGame("     ", "‎Nintendo", 8,
		    PlatformEnum.NINTENDO);
	    fail("Se esperaba un error de cadena incorrecta");
	} catch (IllegalArgumentException iae) {
	    assertEquals("La cadena es incorrecta", iae.getMessage());
	}
    }

    @Test
    public void testSetAuthor() {
	// Autor correcto
	game.setAuthor("newTitle");
	assertEquals("newTitle", game.getAuthor());
	// Autor incorrecto (null)
	try {
	    game = new VideoGame("Super Smash Bros.Ultimate", null, 8,
		    PlatformEnum.NINTENDO);
	    fail("Se esperaba un error de cadena incorrecta");
	} catch (IllegalArgumentException iae) {
	    assertEquals("La cadena es incorrecta", iae.getMessage());
	}
	// Autor incorrecto (vacio)
	try {
	    game = new VideoGame("Super Smash Bros.Ultimate", "     ", 8,
		    PlatformEnum.NINTENDO);
	    fail("Se esperaba un error de cadena incorrecta");
	} catch (IllegalArgumentException iae) {
	    assertEquals("La cadena es incorrecta", iae.getMessage());
	}
    }

    @Test
    public void testSetNumPlayers() {
	// Num jugadores correcto
	game.setNumPlayers(90);
	assertEquals(90, game.getNumPlayers());
	// Num jugadores incorrecto
	game = new VideoGame("Super Smash Bros.Ultimate", "‎Nintendo", -8,
		PlatformEnum.NINTENDO);
	assertEquals(0, game.getNumPlayers());
    }

    @Test
    public void testSetPlatform() {
	// Plataforma correcta
	game.setPlatform(PlatformEnum.XBOX);
	assertEquals(PlatformEnum.XBOX, game.getPlatform());

	assertNotEquals(PlatformEnum.PLAYSTATION, game.getPlatform());
    }

    @Test
    public void testSetComment() {
	// Comentario correcto
	game.setComment("comment");
	assertEquals("comment", game.getComment());
	// Comentario incorrecto (null)
	try {
	    game.setComment(null);
	    fail("Se esperaba un error de cadena incorrecta");
	} catch (IllegalArgumentException iae) {
	    assertEquals("La cadena es incorrecta", iae.getMessage());
	}
    }

    @Test
    public void testSetOwn() {
	// Pertenece
	game.setOwn(true);
	assertTrue(game.getOwn());
	// No pertenece
	game.setOwn(false);
	assertFalse(game.getOwn());
    }
}
