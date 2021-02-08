package uo270318.mp.tareaS2.wordAnalyzer.model;

/**
 * <p>
 * T�tulo: Clase WordAnalyzer
 * </p>
 * <p>
 * Descripci�n: Clase que analiza palabras
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 * 
 * @author �ngela L�pez UO270318
 * @version 1.0
 */

public class WordAnalyzer {

    /**
     * La palabra a analizar
     */
    private String word;

    /**
     * Constructor que crea un objeto analizador de la palabra pasada como
     * par�metro
     * 
     * @param aWord La palabra a ser analizada
     */
    public WordAnalyzer(String aWord) throws IllegalArgumentException {
	// Lanzamos una excepci�n si se introduce un caracter distinto a a-z
	// o espacio en blanco.
	if (aWord.matches("^[ A-Za-z]+$") || aWord.matches(""))
	    word = aWord;
	else
	    throw new IllegalArgumentException(
		    "Valor inv�lido.\n Solo se aceptan caracteres de a-z, palabra vac�a y espacio.");
    }

    /**
     * Obtiene el primer car�cter repetido. Un car�cter est� <i>repetido</i> si
     * aparece al menos dos veces en posiciones adyacentes. Por ejemplo, 'l'
     * est� repetida en "pollo", pero 'o' no est�.
     * 
     * @return el primer caracter repetido, o 0 si no lo encuentra
     */
    public char firstRepeatedCharacter() {
	for (int i = 0; i < word.length() - 1; i++) {
	    char ch = word.charAt(i);
	    if (ch == word.charAt(i + 1))
		return ch;
	}
	return 0;
    }

    /**
     * Obtiene el primer car�cter m�ltiple que aparece. Un car�cter es
     * <i>m�ltiple</i> si aparece al menos dos veces en la palabra, no
     * necesariamente en posiciones adyacentes. Por ejemplo, 'o' y 'l' son
     * m�ltiples en "pollo", pero 'p' no es.
     * 
     * @return el primer car�cter m�ltiple repetido o 0 si no lo encuentra
     */
    public char firstMultipleCharacter() {
	for (int i = 0; i < word.length(); i++) {
	    char ch = word.charAt(i);
	    if (find(ch, i + 1) >= 0)
		return ch;
	}
	return 0;
    }

    /**
     * /** Encuentra la posici�n de un car�cter en la palabra, comenzando en una
     * posici�n espec�fica.
     * 
     * @param c   El car�cter que se quiere encontrar
     * @param pos La posici�n de comienzo
     * @return La posici�n del car�cter en la palabra, o -1 si el car�cetr no
     *         est� en la palabra
     */
    private int find(char c, int pos) {
	for (int i = pos; i < word.length(); i++) {
	    if (word.charAt(i) == c) {
		return i;
	    }
	}
	return -1;
    }

    /**
     * Cuenta los grupos de caracteres repetidos. Por ejemplo, "mississippi!!!"
     * tiene cuatro grupos: ss, ss, pp y !!!.
     * 
     * @return el n�mero de grupos de caracteres repetidos
     */
    public int countGroupsOfRepeatedCharacters() {
	int count = 0;
	for (int i = 0; i < word.length() - 1; i++) {
	    if (word.charAt(i) == word.charAt(i + 1)) { // encuentra una
							// repetici�n
		if (i == 0)
		    count++;
		else if (word.charAt(i - 1) != word.charAt(i))
		    count++;
	    }
	}
	return count;
    }

    /**
     * Metodo auxiliar utilizado en los test del constructor.
     * 
     * @return word Palabra almacenada en la cadena de caracteres
     */
    public String getWord() {
	return word;
    }
}