package uo270318.mp.tareaS2.wordAnalyzer.model;

/**
 * <p>
 * Título: Clase WordAnalyzer
 * </p>
 * <p>
 * Descripción: Clase que analiza palabras
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 * 
 * @author Ángela López UO270318
 * @version 1.0
 */

public class WordAnalyzer {

    /**
     * La palabra a analizar
     */
    private String word;

    /**
     * Constructor que crea un objeto analizador de la palabra pasada como
     * parámetro
     * 
     * @param aWord La palabra a ser analizada
     */
    public WordAnalyzer(String aWord) throws IllegalArgumentException {
	// Lanzamos una excepción si se introduce un caracter distinto a a-z
	// o espacio en blanco.
	if (aWord.matches("^[ A-Za-z]+$") || aWord.matches(""))
	    word = aWord;
	else
	    throw new IllegalArgumentException(
		    "Valor inválido.\n Solo se aceptan caracteres de a-z, palabra vacía y espacio.");
    }

    /**
     * Obtiene el primer carácter repetido. Un carácter está <i>repetido</i> si
     * aparece al menos dos veces en posiciones adyacentes. Por ejemplo, 'l'
     * está repetida en "pollo", pero 'o' no está.
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
     * Obtiene el primer carácter múltiple que aparece. Un carácter es
     * <i>múltiple</i> si aparece al menos dos veces en la palabra, no
     * necesariamente en posiciones adyacentes. Por ejemplo, 'o' y 'l' son
     * múltiples en "pollo", pero 'p' no es.
     * 
     * @return el primer carácter múltiple repetido o 0 si no lo encuentra
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
     * /** Encuentra la posición de un carácter en la palabra, comenzando en una
     * posición específica.
     * 
     * @param c   El carácter que se quiere encontrar
     * @param pos La posición de comienzo
     * @return La posición del carácter en la palabra, o -1 si el carácetr no
     *         está en la palabra
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
     * @return el número de grupos de caracteres repetidos
     */
    public int countGroupsOfRepeatedCharacters() {
	int count = 0;
	for (int i = 0; i < word.length() - 1; i++) {
	    if (word.charAt(i) == word.charAt(i + 1)) { // encuentra una
							// repetición
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