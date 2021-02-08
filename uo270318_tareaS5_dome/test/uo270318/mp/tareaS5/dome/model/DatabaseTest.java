package uo270318.mp.tareaS5.dome.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class DatabaseTest {
    private Item cd;
    private Item dvd;
    private Item game;
    private Database d;
    private Database db;
    private Item error;
    private Item book;

    @Before
    public void setUp() throws Exception {
	d = new Database();
	db = new Database();
	cd = new Cd("cd1", "artist1", 10, 4, false);
	dvd = new Dvd("dvd1", "director1", 120);
	game = new VideoGame("game1", "author1", 6, PlatformEnum.NINTENDO);
	book = new Book("El imperio final", "Brandom Sanderson",
		"978-8466658898", "S.A. EDICIONES B", true);
    }

    @Test
    public void testAdd() {
	// Insertar en coleccion vacia un parametro correcto
	d.add(cd);
	assertEquals(1, d.getNumItems());
	// Insertar en coleccion no vacia un parametro correcto
	d.add(dvd);
	assertEquals(2, d.getNumItems());
	// Insertar en coleccion no vacia un elemento repetido
	d.add(dvd);
	assertEquals(3, d.getNumItems());
	d.add(book);
	assertEquals(4, d.getNumItems());
	// Insertar un parametro incorrecto en coleccion vacia
	try {
	    db.add(error);
	    fail("Deberia lanzar una excepcion");
	} catch (IllegalArgumentException iae) {
	    assertEquals("El parametro es null", iae.getMessage());
	}
	// Insertar un parametro incorrecto en coleccion no vacia
	try {
	    Item error2 = new Cd(" ", "artist2", 5, 9, false);
	    d.add(error2);
	    fail("Deberia lanzar una excepcion");
	} catch (IllegalArgumentException iae) {
	    assertEquals("La cadena es incorrecta", iae.getMessage());
	}

    }

    @Test
    public void testNumberOfItemsOwned() {
	// Coleccion vacia
	db.numberOfItemsOwned();
	assertEquals(0, db.numberOfItemsOwned());
	// Insertar un parametro correcto en coleccion vacia
	cd.setOwn(true);
	db.add(cd);
	assertEquals(1, db.numberOfItemsOwned());
	// Insertar en coleccion no vacia un parametro correcto
	dvd.setOwn(true);
	db.add(dvd);
	assertEquals(2, db.numberOfItemsOwned());
	// Insertar en coleccion no vacia un parametro sin propietario
	db.add(game);
	assertEquals(2, db.numberOfItemsOwned());

    }

    @Test
    public void testSearchItem() {
	// Coleccion vacia (al no encontrar el elemento devuelve -1)
	assertEquals(-1, d.searchItem(cd));
	// Coleccion con elementos validos (devuelve su posicion)
	d.add(cd);
	d.add(dvd);
	assertEquals(0, d.searchItem(cd));
	assertEquals(1, d.searchItem(dvd));
	// Elemento inexistente en la coleccion
	assertEquals(-1, d.searchItem(game));
	// Fallo por parametro incorrecto
	try {
	    d.add(error);
	    fail("Deberia lanzar una excepcion");
	} catch (IllegalArgumentException iae) {
	    assertEquals("El parametro es null", iae.getMessage());
	}
    }

    @Test
    public void testTotalValue() {
	// Coleccion vacia (no hay objetos en propiedad)
	assertEquals(0.0, db.totalValue(), 0.1);
	// Coleccion con items en propiedad con precio por defecto
	db.add(cd);
	db.add(dvd);
	db.add(game);
	assertEquals(2, db.totalValue(), 0.1);
	// Coleccion con items en propiedad con precio nuevo
	cd.setBasePrice(8.0);
	dvd.setBasePrice(10);
	game.setBasePrice(20);
	d.add(cd);
	d.add(dvd);
	d.add(game);
	d.add(book);
	assertEquals(42, d.totalValue(), 0.1);

    }

    @Test
    public void generateCode() {
	// Coleccion vacia
	assertEquals("", d.generateCode());
	// Coleccion no vacia
	d.add(cd);
	d.add(dvd);
	d.add(game);
	assertEquals("cd1F-dvdF-gamF", d.generateCode());
    }

    @Test
    public void testIsEqualsTo() {
	// Buscar en una coleccion vacia un item
	assertNull(d.search(cd));
	// Buscar una coleccion no vacia sin coincidencias
	d.add(cd);
	assertNull(d.search(dvd));
	// Buscar en una coleccion no vacia con coincidencias
	d.add(dvd);
	assertEquals(dvd, d.search(dvd));
	// Buscar un objeto null (lanza excepcion)
	try {
	    d.search(null);
	    fail("Deberia lanzar una excepcion");
	} catch (IllegalArgumentException iae) {
	    assertEquals("El parametro es null", iae.getMessage());
	}

    }

    @Test
    public void testList() {
	db.add(dvd);
	game.setComment("new comment");
	game.setOwn(true);
	game.setTitle("new title");
	db.add(game);
	db.list(System.out);
    }

    @Test
    public void testPrintResponsables() {
	cd.setOwn(true);
	db.add(cd);
	db.add(dvd);
	game.setOwn(true);
	db.add(game);
	db.printResponsables(System.out);
    }

    @Test
    public void testListBorrowableItems() {
	System.out.println("List Borrowables");
	db.add(cd);
	db.add(book);
	db.add(dvd);
	db.add(game);
	db.listBorrowableItems(System.out);
    }

    @Test
    public void testListAvailableItems() {
	System.out.println("List Available to borrow\n");
	cd.setOwn(true);
	d.add(cd);
	d.add(book);
	d.listBorrowableItems(System.out);
    }

    @Test
    public void testBorrowed() {
	// Valido
	book.setOwn(true);
	db.add(cd);
	db.add(book);
	assertTrue(db.borrowed((Borrowable) book));
	// Invalido
	assertFalse(db.borrowed((Borrowable) cd));
	// Invalido (null)
	try {
	    db.borrowed(null);
	    fail("Deberia lanzar una excepcion");
	} catch (IllegalArgumentException iae) {
	    assertEquals("El parametro es null", iae.getMessage());
	}
    }

    @Test
    public void testReturned() {
	// Valido
	book.setOwn(true);
	db.add(cd);
	db.add(book);
	assertTrue(db.returned((Borrowable) cd));
	// Invalido
	assertFalse(db.returned((Borrowable) book));
	// Invalido (null)
	try {
	    db.returned(null);
	    fail("Deberia lanzar una excepcion");
	} catch (IllegalArgumentException iae) {
	    assertEquals("El parametro es null", iae.getMessage());
	}
    }

}
