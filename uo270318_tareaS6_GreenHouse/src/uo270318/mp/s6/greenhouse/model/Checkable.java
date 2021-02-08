package uo270318.mp.s6.greenhouse.model;

/**
 * <p>
 * Titulo: Interfaz Checkable
 * </p>
 * <p>
 * Descripcion: Interfaz que declara los metodos comunes de los objetos
 * revisables.
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 * 
 * @author Angela Lopez UO270318
 * @version 1.0
 */
public interface Checkable {
	boolean check(); // false si no

	String getType();
}
