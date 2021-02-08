package uo270318.mp.tareaS2.wordAnalyzer.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import uo270318.mp.tareaS2.wordAnalyzer.model.WordAnalyzer;

/**
 * <p>
 * Título: Clase WordAnalyzerTest
 * </p>
 * <p>
 * Descripción: En esta clase se realizan pruebas unitarias referidas a la clase
 * WordAnalyzer.java {@link uo270318.mp.tareaS2.wordAnalyzer.model.WordAnalyzer}
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 * 
 * @author Ángela López UO270318
 * @version 1.0
 */
public class WordAnalyzerTest {
    /**
     * Declaración de variables.
     */
    private WordAnalyzer empty, abc, aabc, mississippii, hello, abcc, aaaabcd;
    private WordAnalyzer error, error2, error3, error4;

    /**
     * Método que se ejecuta antes que las llamadas a los test, lo que permite
     * inicializar los objetos susceptibles a estudio una sola vez.
     */
    @Before
    public void setUp() {
	empty = new WordAnalyzer("");
	abc = new WordAnalyzer("abc");
	aabc = new WordAnalyzer("aabc");
	mississippii = new WordAnalyzer("mississippii");
	hello = new WordAnalyzer("hello");
	abcc = new WordAnalyzer("abcc");
	aaaabcd = new WordAnalyzer("aaaabcd");
    }

    /**
     * Metodo Test que hace referencia a
     * {@link uo270318.mp.tareaS2.wordAnalyzer.model.WordAnalyzer#WordAnalyzer(String aWord)}.
     */
    @Test
    public void testWordAnalyzer() {
	assertEquals("abc", abc.getWord());
	assertEquals("", empty.getWord());
	// Se comprueban que las excepciones se lancen correctamente
	try {
	    error = new WordAnalyzer("2");
	} catch (IllegalArgumentException e) {
	    assertEquals("Valor inválido.\n Solo se aceptan caracteres de a-z, "
		    + "palabra vacía y espacio.", e.getMessage());
	}
	try {
	    error2 = new WordAnalyzer("++");
	} catch (IllegalArgumentException e) {
	    assertEquals("Valor inválido.\n Solo se aceptan caracteres de a-z, "
		    + "palabra vacía y espacio.", e.getMessage());
	}
	try {
	    error3 = new WordAnalyzer("123abc");
	} catch (IllegalArgumentException e) {
	    assertEquals("Valor inválido.\n Solo se aceptan caracteres de a-z, "
		    + "palabra vacía y espacio.", e.getMessage());
	}
	try {
	    error4 = new WordAnalyzer(".");
	} catch (IllegalArgumentException e) {
	    assertEquals("Valor inválido.\n Solo se aceptan caracteres de a-z, "
		    + "palabra vacía y espacio.", e.getMessage());
	}
    }

    /**
     * Metodo Test que hace referencia a
     * {@link uo270318.mp.tareaS2.wordAnalyzer.model.WordAnalyzer#firstRepeatedCharacter()}.
     */
    @Test
    public void testFirstRepeatedCharacter() {
	// Palabra vacía (debe devolver un 0)
	assertEquals(0, empty.firstRepeatedCharacter());
	// Palabra sin caracteres repetidos (debe devolver un 0)
	assertEquals(0, abc.firstRepeatedCharacter());
	// Palabra con un caracter repetido al principio de la palabra
	// (debe devolver el primer caracter a)
	assertEquals('a', aabc.firstRepeatedCharacter());
	// Palabra con un caracter repetido en el medio de la palabra
	// (debe devolver el caracter l)
	assertEquals('l', hello.firstRepeatedCharacter());
	// Palabra con un caracter repetido al final de la palabra
	// (debe devolver el caracter c)
	assertEquals('c', abcc.firstRepeatedCharacter());
	// Palabra con distintos caracteres repetidos
	// (debe devolver el caracter s al ser el primero que se repite)
	assertEquals('s', mississippii.firstRepeatedCharacter());
	// Palabra con mas de un caracter repetido mas de 1 vez
	// (debe devolver el caracter a)
	assertEquals('a', aaaabcd.firstRepeatedCharacter());

    }

    /**
     * Metodo Test que hace referencia a
     * {@link uo270318.mp.tareaS2.wordAnalyzer.model.WordAnalyzer#firstMultipleCharacter()}.
     */
    @Test
    public void testFirstMultipleCharacter() {
	// Palabra vacía
	assertEquals(0, empty.firstMultipleCharacter());
	// Palabra sin caracteres múlitples
	assertEquals(0, abc.firstMultipleCharacter());
	// Palabra con un caracter múlitple al principio de la palabra
	assertEquals('a', aabc.firstMultipleCharacter());
	// Palabra con un caracter múlitple en el medio de la palabra
	assertEquals('l', hello.firstMultipleCharacter());
	// Palabra con un caracter múlitple al final de la palabra
	assertEquals('c', abcc.firstMultipleCharacter());
	// Palabra con varios caracteres múlitples
	assertEquals('i', mississippii.firstMultipleCharacter());
	// Palabra con un caracter múlitple repetido
	assertEquals('a', aaaabcd.firstMultipleCharacter());
    }

    /**
     * Metodo Test que hace referencia a
     * {@link uo270318.mp.tareaS2.wordAnalyzer.model.WordAnalyzer#countGroupsOfRepeatedCharacters()}.
     */
    @Test
    public void testCountGroupsOfRepeatedCharacters() {
	// Palabra vacía
	assertEquals(0, empty.countGroupsOfRepeatedCharacters());
	// Palabra sin grupos de caracteres repetidos
	assertEquals(0, abc.countGroupsOfRepeatedCharacters());
	// Palabra con un grupo de caracteres repetidos al principio de la
	// palabra
	assertEquals(1, aabc.countGroupsOfRepeatedCharacters());
	// Palabra con un grupo de caracteres repetidos en el medio de la
	// palabra
	assertEquals(1, hello.countGroupsOfRepeatedCharacters());
	// Palabra con un grupo de caracteres repetidos al final de la palabra
	assertEquals(1, abcc.countGroupsOfRepeatedCharacters());
	// Palabra con varios grupos de caracteres repetidos
	assertEquals(4, mississippii.countGroupsOfRepeatedCharacters());
	// Palabra con un grupo de caracteres repeditos superior a 2
	assertEquals(1, aaaabcd.countGroupsOfRepeatedCharacters());
    }

}
