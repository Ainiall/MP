package uo.mp.newstand.publication.parser;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import uo.mp.exceptions.ApplicationException;
import uo.mp.newstand.publication.Magazine;
import uo.mp.newstand.publication.Newspaper;
import uo.mp.newstand.publication.Publication;

public class PublicationParserTest {

    private PublicationParser p;
    private List<String> l;

    @Before
    public void setUp() throws Exception {
	p = new PublicationParser();
	l = new LinkedList<String>();
	l.add("periodico	Nueva España	14	30");
	l.add("periodico	El Mundo	4	10");
	l.add("revista	Cosmopolitan	14	30	7");
    }

    @Test
    public void testValidParse() throws ApplicationException {
	List<Publication> list = new LinkedList<Publication>();
	list.add(new Newspaper("Nueva España", 14, 30));
	list.add(new Newspaper("El Mundo", 4, 10));
	list.add(new Magazine("Cosmopolitan", 14, 30, 7));

	// texto valido (tipo correcto, enteros, nombre con mas de 5 caracteres)
	List<Publication> lp = p.parse(l);
	assertEquals(list, lp);
    }

    // TEXTO INVALIDO: ERRORES DE FICHERO
    // la ejecucion continua y se envian errores al log

    @Test
    public void testInvalidParseEmptyLine() throws ApplicationException {
	// texto invalido: insertar linea vacia
	l.add("");
	l.add("revista	Hola,Mundo!	18	20	9");
	List<Publication> lp = p.parse(l);
	assertEquals(4, lp.size());
	// no se inserta la linea vacia pero la ejecucion continua
    }

    @Test
    public void testInvalidParseIncorrectNFields() throws ApplicationException {
	// texto invalido: numero de campos incorrectos
	l.add("periodico	Nueva España	14	30	50");
	List<Publication> lp = p.parse(l);
	assertEquals(3, lp.size());
    }

    @Test
    public void testInvalidParseNotAllowedType() throws ApplicationException {
	// texto invalido: no es de tipo periodico o revista
	l.add("video	Pelicula	14	30");
	List<Publication> lp = p.parse(l);
	assertEquals(3, lp.size());
    }

    @Test
    public void testInvalidParseIncorrectNumberFormat()
	    throws ApplicationException {
	// texto invalido: el formato de numero es erroneo (negativo, decimal,
	// etc)
	l.add("periodico	Nueva España	-4	30");
	l.add("periodico	Nueva España	17.4635		30");

	try {
	    @SuppressWarnings("unused")
	    List<Publication> lp = p.parse(l);
	    fail("Deberia fallar");
	} catch (IllegalArgumentException iae) {
	    assertEquals("No es válido el entero", iae.getMessage());
	}

	try {
	    @SuppressWarnings("unused")
	    List<Publication> lp = p.parse(l);
	    fail("Deberia fallar");
	} catch (IllegalArgumentException iae) {
	    assertEquals("No es válido el entero", iae.getMessage());
	}
    }

    @Test
    public void testInvalidParseEmptyType() throws ApplicationException {
	// texto invalido: tipo vacio
	l.add("	Nueva España	17.4635		30");
	List<Publication> lp = p.parse(l);
	assertEquals(3, lp.size());
    }
    
}
