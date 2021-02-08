package uo270318.mp.tareaS4.dome.model;

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

    @Test
    public void setBasePrice() {
	// Precio valido
	game.setBasePrice(9.99);
	assertEquals(9.99, game.getBasePrice(),0.1);
	// Precio invalido
	try {
	    game.setBasePrice(200000.00);
	    fail("Se esperaba un error de cadena incorrecta");
	} catch (IllegalArgumentException iae) {
	    assertEquals("El precio debe estar dentro del rango permitido",
		    iae.getMessage());
	}
	try {
	    game.setBasePrice(-200.00);
	    fail("Se esperaba un error de cadena incorrecta");
	} catch (IllegalArgumentException iae) {
	    assertEquals("El precio debe estar dentro del rango permitido",
		    iae.getMessage());
	}

    }

    @Test
    public void testToString() {
	assertEquals("VIDEOGAME: title1" + "\nAuthor: ‎company1"
		+ "\nNumPlayers: 10" + "\nYou do not own it" + "\nPrice: 0.0"
		+ "\nComment: " + "\nPlatform: NINTENDO", game.toString());
    }

    @Test
    public void testSearch() {
	Database db = new Database();
	db.add(new VideoGame("title", "‎company", 10, PlatformEnum.NINTENDO));
	db.add(new VideoGame("title2", "‎company2", 10, PlatformEnum.NINTENDO));
	db.add(game);
	// Encuentra al item
	assertEquals(game, db.search(game));
	// No encuentra al item
	assertEquals(null, db.search(new VideoGame("title3", "‎company3", 10,
		PlatformEnum.NINTENDO)));
    }
}
