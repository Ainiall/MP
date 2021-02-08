package uo270318.mp.s6.greenhouse.model;

import java.io.PrintStream;

/**
 * <p>
 * Titulo: Clase Door
 * </p>
 * <p>
 * Descripcion: Clase que simula una puerta.
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 * 
 * @author Angela Lopez UO270318
 * @version 1.0
 */
public class Door {

	private boolean opened;
	
	/**
	 * Constructor sin parametros.
	 */
	public Door() {
		setOpened(false);
	}
	
	/**
	 * Metodo que muestra si la puerta esta abierta o no.
	 * 
	 * @return opened True si esta abierta, false si no lo esta.
	 */
	public boolean isOpened() {
		return opened;
	}
	
	/**
	 * Metodo que abre una puerta.
	 * 
	 * @param out Objeto sobre el que se imprime la informacion
	 */
	public void open(PrintStream out){
		if (!isOpened()) {
			out.println ("  La puerta se abre manualmente");
			setOpened(true);
		}
	}
	
	/**
	 * Metodo que cierra una puerta.
	 * 
	 * @param out Objeto sobre el que se imprime la informacion
	 */
	public void close(PrintStream out){
		if (isOpened()) {
			out.println ("  La puerta se cierra manualmente");
			setOpened(false);
		}
	}

	/**
	 * Metodo que asigna si una puerta esta abierta o cerrada.
	 * @param opened
	 */
	protected void setOpened(boolean opened) {
		this.opened = opened;
	}
}
