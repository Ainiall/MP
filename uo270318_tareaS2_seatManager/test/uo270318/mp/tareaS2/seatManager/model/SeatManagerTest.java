package uo270318.mp.tareaS2.seatManager.model;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

/**
 * <p>
 * Título: Clase SeatManagerTest
 * </p>
 * <p>
 * Descripción: En esta clase se realizan pruebas unitarias referidas a la clase
 * SeatManager.java {@link uo270318.mp.tareaS2.seatManager.model.SeatManager}
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 * 
 * @author Ángela López UO270318
 * @version 1.0
 */
public class SeatManagerTest {
    /**
     * Declaracion de variables
     */
    @SuppressWarnings("unused")
    private SeatManager asientos, asientos2, asientos3, asientos4;
    @SuppressWarnings("unused")
    private Person persona1, persona2, persona3, persona4, persona5, persona6,
	    persona7, persona8;
    private ArrayList<Person> pasajeros;

    /**
     * Método que se ejecuta antes que las llamadas a los test, lo que permite
     * inicializar los objetos susceptibles a estudio una sola vez.
     */
    @Before
    public void setUp() {
	asientos = new SeatManager();
	asientos2 = new SeatManager(7, 4);
	asientos3 = new SeatManager(5, 3);
	persona1 = new Person("Fran", 19); // persona adulta
	persona2 = new Person("Ana", 17); // menor de edad
	persona3 = new Person("Julia", 67); // jubilada
	persona4 = new Person("Pablo", 34); // persona adulta
	persona5 = new Person("Irene", 9); // menor de edad
	persona6 = new Person("Mateo", 25); // persona adulta
	try {
	    persona7 = new Person("Persona", -2); // error
	} catch (IndexOutOfBoundsException e) {
	    assertEquals("La edad debe ser válida (0-110)", e.getMessage());
	}
	try {
	    persona8 = new Person("12", 90);// error
	} catch (IllegalArgumentException e) {
	    assertEquals("El nombre debe contener caracteres a-z",
		    e.getMessage());
	}
	pasajeros = new ArrayList<Person>();
    }

    /**
     * Metodo Test que hace referencia a
     * {@link uo270318.mp.tareaS2.seatManager.model.SeatManager#SeatManager()}.
     */
    @Test
    public void testSeatManager() {
	// Crea una matriz 3*3 por defecto
	assertEquals(3, asientos.getFilas());
	assertEquals(3, asientos.getColumnas());
	// No crea ninguna matriz con otros valores
	assertNotEquals(5, asientos.getFilas());
	assertNotEquals(19, asientos.getColumnas());
    }

    /**
     * Metodo Test que hace referencia a
     * {@link uo270318.mp.tareaS2.seatManager.model.SeatManager#SeatManager(int fila, int columna)}.
     */
    @Test
    public void testSeatManagerIntInt() {
	// Crea una matriz con los valores pasados como parámetros
	assertEquals(7, asientos2.getFilas());
	assertEquals(4, asientos2.getColumnas());
	// No crea una matriz con valores incorrectos (excepciones)
	try {
	    asientos3 = new SeatManager(-1, -6);
	} catch (IllegalArgumentException iae) {
	    assertEquals("El parametro introducido no es válido",
		    iae.getMessage());
	}
	try {
	    asientos4 = new SeatManager(20, 30);
	} catch (IllegalArgumentException iae) {
	    assertEquals("El parametro introducido no es válido",
		    iae.getMessage());
	}
    }

    /**
     * Metodo Test que hace referencia a
     * {@link uo270318.mp.tareaS2.seatManager.model.SeatManager#bookSeat(Person persona, int fila, int columna)}.
     */
    @Test
    public void testBookSeat() {
	// Sentamos a una persona en la posición seleccionada
	assertEquals(true, asientos2.bookSeat(persona1, 3, 2)); // persona
								// adulta
	assertEquals(persona1, asientos2.getPersona(3, 2));
	// Sentamos a otra persona
	assertEquals(true, asientos2.bookSeat(persona2, 3, 3)); // menor
	assertEquals(persona2, asientos2.getPersona(3, 3));
	// Sentamos a otra persona
	assertEquals(true, asientos2.bookSeat(persona3, 0, 0)); // jubilada
	assertEquals(persona3, asientos2.getPersona(0, 0));
	// Sentamos a una persona en un sitio ocupado por una persona adulta
	assertEquals(true, asientos2.bookSeat(persona4, 3, 2));
	assertEquals(persona4, asientos2.getPersona(3, 2));
	// Intentamos sentar a una persona en un sitio ocupado por un jubilado
	// No se sienta, devuelve false
	assertEquals(false, asientos2.bookSeat(persona5, 0, 0));
	assertEquals(persona3, asientos2.getPersona(0, 0));
	// Intentamos sentar a una persona no válida
	try {
	    asientos2.bookSeat(persona7, 0, 0);
	} catch (Exception iae) {
	    assertEquals("El parametro introducido no es válido",
		    iae.getMessage());
	}
	// Intentamos sentar a una persona en una posición no válida
	try {
	    asientos2.bookSeat(persona2, -2, 20);
	} catch (IllegalArgumentException iae) {
	    assertEquals("El parametro introducido no es válido",
		    iae.getMessage());
	}

    }

    /**
     * Metodo Test que hace referencia a
     * {@link uo270318.mp.tareaS2.seatManager.model.SeatManager#findPassengersByAge(int min_edad, int max_edad)}.
     */
    @Test
    public void testFindPassengersByAge() {
	// Se asignan pasajeros a las filas pares (0,2,4,6,..)
	asientos3.bookSeat(persona1, 0, 0); // adulta
	asientos3.bookSeat(persona3, 0, 2); // jubilado
	asientos3.bookSeat(persona4, 2, 0); // adulta
	asientos3.bookSeat(persona5, 4, 1); // menor
	// Se asignan parasejos a las filas impares
	asientos3.bookSeat(persona2, 1, 1); // menor
	asientos3.bookSeat(persona4, 3, 0); // adulta

	// Lista con las personas menores de edad
	assertEquals(persona5, asientos3
		.findPassengersByAge(Person.MIN_EDAD, Person.EDAD_ADULTA)
		.get(0));
	// Lista con personas jubiladas
	assertEquals(persona3, asientos3
		.findPassengersByAge(Person.EDAD_JUBILACION, Person.MAX_EDAD)
		.get(0));
	// Lista con personas adultas sin jubilar
	assertEquals(persona1, asientos3
		.findPassengersByAge(Person.EDAD_ADULTA, Person.EDAD_JUBILACION)
		.get(0));
	assertEquals(persona4, asientos3
		.findPassengersByAge(Person.EDAD_ADULTA, Person.EDAD_JUBILACION)
		.get(1));
	// Pedimos una lista con las personas mayores de edad
	assertEquals(persona1, asientos3
		.findPassengersByAge(Person.EDAD_ADULTA, Person.MAX_EDAD)
		.get(0));
	assertEquals(persona3, asientos3
		.findPassengersByAge(Person.EDAD_ADULTA, Person.MAX_EDAD)
		.get(1));
	assertEquals(persona4, asientos3
		.findPassengersByAge(Person.EDAD_ADULTA, Person.MAX_EDAD)
		.get(2));
	// Lista vacía (rango de edad sin pasajeros)
	assertEquals(pasajeros, asientos.findPassengersByAge(2, 4));
	// Pedimos una lista de personas pasandole parámetros incorrectos
	try {
	    asientos.findPassengersByAge(130, 0);
	} catch (IndexOutOfBoundsException e) {
	    assertEquals("El parametro introducido no es válido",
		    e.getMessage());
	}

    }

}
