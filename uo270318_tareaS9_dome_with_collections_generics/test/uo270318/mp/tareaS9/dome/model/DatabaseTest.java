package uo270318.mp.tareaS9.dome.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import uo270318.mp.tareaS10.dome.exceptions.RepeatedElementException;
import uo270318.mp.tareaS9.dome.model.Book;
import uo270318.mp.tareaS9.dome.model.Borrowable;
import uo270318.mp.tareaS9.dome.model.Cd;
import uo270318.mp.tareaS9.dome.model.Database;
import uo270318.mp.tareaS9.dome.model.Dvd;
import uo270318.mp.tareaS9.dome.model.Item;
import uo270318.mp.tareaS9.dome.model.PlatformEnum;
import uo270318.mp.tareaS9.dome.model.VideoGame;

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
    public void testAdd() throws RepeatedElementException {
	// Insertar en coleccion vacia un parametro correcto
	d.add(cd);
	assertEquals(1, d.getNumItems());
	// Insertar en coleccion no vacia un parametro correcto
	d.add(dvd);
	assertEquals(2, d.getNumItems());
	// Insertar en coleccion no vacia un elemento repetido
	
	try{
	    d.add(dvd);
	    assertEquals(2, d.getNumItems());
	}catch(RepeatedElementException e) {
	    assertEquals("No se admiten items repetidos.",e.getMessage());
	}
	d.add(book);
	assertEquals(3, d.getNumItems());
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
    public void testNumberOfItemsOwned() throws RepeatedElementException {
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
    public void testSearchItem() throws RepeatedElementException {
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
    public void testTotalValue() throws RepeatedElementException {
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
    public void generateCode() throws RepeatedElementException {
	// Coleccion vacia
	assertEquals("", d.generateCode());
	// Coleccion no vacia
	d.add(cd);
	d.add(dvd);
	d.add(game);
	assertEquals("cd1F-dvdF-gamF", d.generateCode());
    }

    @Test
    public void testIsEqualsTo() throws RepeatedElementException {
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
    public void testList() throws RepeatedElementException {
	db.add(dvd);
	game.setComment("new comment");
	game.setOwn(true);
	game.setTitle("new title");
	db.add(game);
	db.list(System.out);
    }

    @Test
    public void testPrintResponsables() throws RepeatedElementException {
	cd.setOwn(true);
	db.add(cd);
	db.add(dvd);
	game.setOwn(true);
	db.add(game);
	db.printResponsables(System.out);
    }

    @Test
    public void testListBorrowableItems() throws RepeatedElementException {
	System.out.println("List Borrowables");
	db.add(cd);
	db.add(book);
	db.add(dvd);
	db.add(game);
	db.listBorrowableItems(System.out);
    }

    @Test
    public void testListAvailableItems() throws RepeatedElementException {
	System.out.println("List Available to borrow\n");
	cd.setOwn(true);
	d.add(cd);
	d.add(book);
	d.listBorrowableItems(System.out);
    }

    @Test
    public void testBorrowed() throws RepeatedElementException {
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
    public void testReturned() throws RepeatedElementException {
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
