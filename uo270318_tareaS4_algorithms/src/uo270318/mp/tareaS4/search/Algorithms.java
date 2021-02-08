package uo270318.mp.tareaS4.search;

/**
 * <p>
 * Titulo: Clase Algorithms
 * </p>
 * <p>
 * Descripcion: Clase que contiene un metodo search capaz de buscar cualquier
 * tipo de objeto en una coleccion.
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 * 
 * @author Angela Lopez UO270318
 * @version 1.0
 */
public class Algorithms {
    /**
     * Metodo que busca un objeto en una coleccion, ambos pasados como
     * parametros.
     * 
     * @param vector Coleccion en la que se busca el objeto
     * @param object Objeto a buscar
     * @return Posicion en la que se encuentra el objeto. Si no se encuentra se
     *         devuelve -1.
     */
    public static int search(Object[] vector, Object object) {
	assertParams(vector, object);
	for (int i = 0; i < vector.length; i++) {
	    if (vector[i].equals(object)) {
		return i;
	    }
	}
	return -1;
    }

    /**
     * Metodo auxiliar que valida los parametros.
     * 
     * @param vector Coleccion
     * @param object Objeto
     */
    private static void assertParams(Object[] vector, Object object) {
	if (vector == null | object == null) {
	    throw new IllegalArgumentException("La cadena es incorrecta");
	}
    }
}
