package uo270318.mp.tareaS3.dome.model;

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

    @Before
    public void setUp() throws Exception {
	d = new Database();
	db = new Database();
	cd = new Cd("cd1", "artist1", 10, 4);
	dvd = new Dvd("dvd1", "director1", 120);
	game = new VideoGame("game1","author1",6,PlatformEnum.NINTENDO);
    }


    @Test
    public void testAdd() {
	//Insertar en coleccion vacia un parametro correcto
	d.add(cd);
	assertEquals(1, d.getNumItems());
	//Insertar en coleccion no vacia un parametro correcto
	d.add(dvd);
	assertEquals(2, d.getNumItems());
	//Insertar en coleccion no vacia un elemento repetido
	d.add(dvd);
	assertEquals(3, d.getNumItems());
	//Insertar un parametro incorrecto en coleccion vacia
	try {
	    db.add(error);
	    fail("Deberia lanzar una excepcion");
	} catch (IllegalArgumentException iae) {
	    assertEquals("El parametro es null", iae.getMessage());
	}
	//Insertar un parametro incorrecto en coleccion no vacia
	try {
	    Item error2 = new Cd(" ","artist2",5,9);
	    d.add(error2);
	    fail("Deberia lanzar una excepcion");
	} catch (IllegalArgumentException iae) {
	    assertEquals("La cadena es incorrecta", iae.getMessage());
	}
	   
    }

    @Test
    public void testNumberOfItemsOwned() {
	//Coleccion vacia
	db.numberOfItemsOwned();
	assertEquals(0,db.numberOfItemsOwned());
	//Insertar un parametro correcto en coleccion vacia
	cd.setOwn(true);
	db.add(cd);
	assertEquals(1,db.numberOfItemsOwned());
	//Insertar en coleccion no vacia un parametro correcto
	dvd.setOwn(true);
	db.add(dvd);
	assertEquals(2, db.numberOfItemsOwned());
	//Insertar en coleccion no vacia un parametro sin propietario
	db.add(game);
	assertEquals(2, db.numberOfItemsOwned());
	
    }

    @Test
    public void testSearchItem() {
	//Coleccion vacia (al no encontrar el elemento devuelve -1)
	assertEquals(-1,d.searchItem(cd));
	//Coleccion con elementos validos (devuelve su posicion)
	d.add(cd);
	d.add(dvd);
	assertEquals(0,d.searchItem(cd));
	assertEquals(1,d.searchItem(dvd));
	//Elemento inexistente en la coleccion
	assertEquals(-1,d.searchItem(game));
	//Fallo por parametro incorrecto
	try {
	    d.add(error);
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

}
