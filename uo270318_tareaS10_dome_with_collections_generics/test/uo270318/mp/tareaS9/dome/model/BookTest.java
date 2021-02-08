package uo270318.mp.tareaS9.dome.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import uo270318.mp.tareaS10.dome.exceptions.RepeatedElementException;


public class BookTest {
    private Book b;

    @Before
    public void setUp() throws Exception {
	b = new Book("El imperio final", "Brandom Sanderson", "978-8466658898",
		"S.A. EDICIONES B", true);
    }

    @Test
    public void testBook() {
	Book book = new Book("Camino de Reyes", "Brandom Sanderson",
		"978-8466647946", "S.A. EDICIONES B", false);
	assertEquals("Camino de Reyes", book.getTitle());
	assertEquals("Brandom Sanderson", book.getAuthor());
	assertEquals("978-8466647946", book.getISBN());
	assertEquals("S.A. EDICIONES B", book.getEditorial());
	assertEquals(false, book.getOwn());
	assertEquals("", book.getComment());
	assertEquals(false, book.getAvailable());
    }

    @Test
    public void testSetTitle() {
	// Titulo correcto
	b.setTitle("newTitle");
	assertEquals("newTitle", b.getTitle());
	// Titulo incorrecto (null)
	try {
	    b = new Book(null, "Brandom Sanderson", "978-8466647946",
		    "S.A. EDICIONES B", false);
	    fail("Se esperaba un error de cadena incorrecta");
	} catch (IllegalArgumentException iae) {
	    assertEquals("La cadena es incorrecta", iae.getMessage());
	}
	// Titulo incorrecto (vacio)
	try {
	    b = new Book("       ", "Brandom Sanderson", "978-8466647946",
		    "S.A. EDICIONES B", false);
	    fail("Se esperaba un error de cadena incorrecta");
	} catch (IllegalArgumentException iae) {
	    assertEquals("La cadena es incorrecta", iae.getMessage());
	}
    }

    @Test
    public void testSetAuthor() {
	// Autor correcto
	b.setAuthor("newAuthor");
	assertEquals("newAuthor", b.getAuthor());
	// Autor incorrecto (null)
	try {
	    b = new Book("Camino de Reyes", null, "978-8466647946",
		    "S.A. EDICIONES B", false);
	    fail("Se esperaba un error de cadena incorrecta");
	} catch (IllegalArgumentException iae) {
	    assertEquals("La cadena es incorrecta", iae.getMessage());
	}
	// Autor incorrecto (vacio)
	try {
	    b = new Book("Camino de Reyes", "        ", "978-8466647946",
		    "S.A. EDICIONES B", false);
	    fail("Se esperaba un error de cadena incorrecta");
	} catch (IllegalArgumentException iae) {
	    assertEquals("La cadena es incorrecta", iae.getMessage());
	}
    }

    @Test
    public void testSetISBN() {
	//ISBN correcto
	b.setISBN("978-8466647946");
	assertEquals("978-8466647946",b.getISBN());
	//ISBN incorrecto (null)
	try {
	    b.setISBN(null);
	    fail("Se esperaba un error de cadena incorrecta");
	} catch (IllegalArgumentException iae) {
	    assertEquals("La cadena es incorrecta", iae.getMessage());
	}
	try {
	    b.setISBN(null);
	    fail("Se esperaba un error de cadena incorrecta");
	} catch (IllegalArgumentException iae) {
	    assertEquals("La cadena es incorrecta", iae.getMessage());
	}
	//ISBN incorrecto (vacio)
	try {
	    b.setISBN("");
	    fail("Se esperaba un error de cadena incorrecta");
	} catch (IllegalArgumentException iae) {
	    assertEquals("La cadena es incorrecta", iae.getMessage());
	}
	//ISBN incorrecto (formato no valido)
	try {
	    b.setISBN("3426");
	    fail("Se esperaba un error de cadena incorrecta");
	} catch (IllegalArgumentException iae) {
	    assertEquals("ISBN invalido", iae.getMessage());
	}
    }
    
    @Test
    public void testEditorial() {
	// Editorial valida
	b.setAuthor("newEditorial");
	assertEquals("newEditorial", b.getAuthor());
	// Editorial incorrecta (null)
	try {
	    b = new Book("Camino de Reyes", "Brandom Sanderson",
		    "978-8466647946", null, false);
	    fail("Se esperaba un error de cadena incorrecta");
	} catch (IllegalArgumentException iae) {
	    assertEquals("La cadena es incorrecta", iae.getMessage());
	}
	// Editorial incorrecta (vacia)
	try {
	    b = new Book("Camino de Reyes", "Brandom Sanderson",
		    "978-8466647946", "     ", false);
	    fail("Se esperaba un error de cadena incorrecta");
	} catch (IllegalArgumentException iae) {
	    assertEquals("La cadena es incorrecta", iae.getMessage());
	}
    }

    @Test
    public void testSetComment() {
	// Comentario correcto
	b.setComment("comment");
	assertEquals("comment", b.getComment());
	// Comentario incorrecto (null)
	try {
	    b.setComment(null);
	    fail("Se esperaba un error de cadena incorrecta");
	} catch (IllegalArgumentException iae) {
	    assertEquals("La cadena es incorrecta", iae.getMessage());
	}
    }

    @Test
    public void testSetOwn() {
	// Pertenece
	b.setOwn(true);
	assertTrue(b.getOwn());
	// No pertenece
	b.setOwn(false);
	assertFalse(b.getOwn());
    }

    @Test
    public void setBasePrice() {
	// Precio valido
	b.setBasePrice(9.99);
	assertEquals(9.99, b.getBasePrice(), 0.1);
	// Precio invalido
	try {
	    b.setBasePrice(200000.00);
	    fail("Se esperaba un error de cadena incorrecta");
	} catch (IllegalArgumentException iae) {
	    assertEquals("El precio debe estar dentro del rango permitido",
		    iae.getMessage());
	}
	try {
	    b.setBasePrice(-200.00);
	    fail("Se esperaba un error de cadena incorrecta");
	} catch (IllegalArgumentException iae) {
	    assertEquals("El precio debe estar dentro del rango permitido",
		    iae.getMessage());
	}

    }

    @Test
    public void testSetAvailable() {
	// Disponible para prestar
	b.setAvailable(true);
	assertTrue(b.getAvailable());
	// No pertenece
	b.setAvailable(false);
	assertFalse(b.getAvailable());
    }

    @Test
    public void testToString() {
	assertEquals("BOOK: El imperio final" + "\nYou do not own it"
		+ "\nPrice: 0.0" + "\nComment: " + "\nAuthor: Brandom Sanderson"
		+ "\nISBN: 978-8466658898" + "\nEditorial: S.A. EDICIONES B",
		b.toString());
    }

    @Test
    public void testSearch() throws RepeatedElementException {
	Database db = new Database();
	db.add(new Book("book1", "author1", "978-8466647946",
		"S.A. EDICIONES B", false));
	db.add(new Book("book2", "author2", "978-8466647946",
		"S.A. EDICIONES B", false));
	db.add(b);
	// Encuentra al item
	assertEquals(b, db.search(b));
	// No encuentra al item
	assertEquals(null, db.search(new Book("book4", "Brandom Sanderson",
		"978-8466647946", "S.A. EDICIONES B", false)));
    }

    @Test
    public void testIsAvailableItem() {
	// Disponible
	b.setOwn(true);
	b.setAvailable(true);
	assertTrue(b.isAvailableItem());
	// No disponible
	b.setOwn(false);
	assertFalse(b.isAvailableItem());
	b.setOwn(true);
	b.setAvailable(false);
	assertFalse(b.isAvailableItem());
    }

}
