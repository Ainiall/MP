package uo.mp.newstand.publication.parser;

import java.util.LinkedList;
import java.util.List;

import uo.mp.exceptions.ApplicationException;
import uo.mp.exceptions.InvalidLineFormatException;
import uo.mp.newstand.publication.Magazine;
import uo.mp.newstand.publication.Newspaper;
import uo.mp.newstand.publication.Publication;
import uo.mp.util.Logger;

public class PublicationParser {
    /**
     * Metodo que parsea la lista de caracteres que se le pasan como parametros
     * a un objeto de tipo publicacion y lo inserta en una lista
     * 
     * @param lines Caracteres
     * @return publications Lista de publicaciones
     * @throws ApplicationException Si ocurre algun error logico
     */
    public List<Publication> parse(List<String> lines)
	    throws ApplicationException {
	List<Publication> publications = (List<Publication>) new LinkedList<Publication>();
	int ln = 1;
	for (String line : lines) {
	    Publication p;
	    try {
		p = parseLine(line, ln);
		publications.add(p);
	    } catch (InvalidLineFormatException ilfe) {
		Logger.log("Error de formato en la linea " + ln + " "
			+ ilfe.getMessage());
	    }
	    ln++;
	}
	return publications;
    }

    /**
     * Metodo que parsea una linea a un objeto tipo publicacion
     * 
     * @param line Linea a parsear
     * @return Objeto de tipo publicacion
     * @throws InvalidLineFormatException Si se intenta parsear una linea que no
     *                                    corresponde a un objeto conocido
     * @throws ApplicationException
     */
    private Publication parseLine(String line, int ln)
	    throws InvalidLineFormatException, ApplicationException {
	checkEmptyLine(line, ln);
	String[] str = line.split("\t");
	String type = str[0];
	switch (type) {
	case "periodico":
	    return createNewsPaper(str, line, ln);
	case "revista":
	    return createmagazine(str, line, ln);
	}
	throw new InvalidLineFormatException("Tipo desconocido", ln, line);
    }

    /**
     * Metodo que devuelve un objeto de tipo Magazine con los datos obtenidos a
     * traves de la linea
     * 
     * @param str  Cadena con informacion sobre la revista
     * @param line Linea de la que obtener informacion
     * @param ln   Numero de linea
     * @return Objeto tipo Magazine con la informacion proveniente del fichero
     * @throws InvalidLineFormatException
     * @throws ApplicationException
     */
    private Publication createmagazine(String[] str, String line, int ln)
	    throws InvalidLineFormatException, ApplicationException {
	chechHasAllParts(5, str, line, ln);
	@SuppressWarnings("unused")
	int i = 1;
	// TODO REVISAR, CAMBIAR ITERADOR
	String name = str[1];
	int stock = toInteger(str[2]);
	int sales = toInteger(str[3]);
	int regularity = toInteger(str[4]);
	return new Magazine(name, stock, sales, regularity);
    }

    /**
     * Metodo que devuelve un objeto de tipo NewsPaper con los datos obtenidos a
     * traves de la linea
     * 
     * @param str  Cadena con informacion sobre el periodico
     * @param line Linea de la que obtener la informacion
     * @param ln   Numero de linea
     * @return Objeto de tipo Newspaper
     * @throws InvalidLineFormatException Si no se puede insertar la linea
     * @throws ApplicationException       Si se producen errores logicos
     */
    private Publication createNewsPaper(String[] str, String line, int ln)
	    throws InvalidLineFormatException, ApplicationException {
	chechHasAllParts(4, str, line, ln);
	@SuppressWarnings("unused")
	int i = 1;
	// TODO REVISAR, CAMBIAR ITERADOR
	String name = str[1];
	int stock = toInteger(str[2]);
	int sales = toInteger(str[3]);
	return new Newspaper(name, stock, sales);
    }

    /**
     * Metodo auxiliar que convierte un objeto String a un entero
     * 
     * @param string Cadena de caracteres a convertir
     * @return Conversion a entero
     * @throws InvalidLineFormatException Si el casteo es invalido
     */
    private int toInteger(String string) throws InvalidLineFormatException {
	try {
	    return Integer.parseInt(string);
	} catch (NumberFormatException ile) {
	    throw new InvalidLineFormatException(string + " no es un entero");
	}
    }

    /**
     * Metodo auxiliar que comprueba si una linea esta vacia
     * 
     * @param line Linea a comprobar
     * @param ln   Numero de linea
     * @throws InvalidLineFormatException Si la linea esta vacia
     */
    private void checkEmptyLine(String line, int ln)
	    throws InvalidLineFormatException {
	if (line.isEmpty() || line.trim() == "") {
	    throw new InvalidLineFormatException("Linea vacia", ln, line);
	}
    }

    /**
     * Metodo auxiliar que comprueba si el numero de campos esta dentro del
     * rango permitido
     * 
     * @param i    Numero de campos
     * @param str  Fichero
     * @param line Linea
     * @param ln   Numero de linea
     * @throws InvalidLineFormatException
     */
    private void chechHasAllParts(int i, String[] str, String line, int ln)
	    throws InvalidLineFormatException {
	if (i != str.length) {
	    throw new InvalidLineFormatException("Numero de campos invalidos",
		    ln, line);
	}
    }
}
