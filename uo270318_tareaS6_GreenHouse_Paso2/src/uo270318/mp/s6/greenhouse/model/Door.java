package uo270318.mp.s6.greenhouse.model;

import java.io.PrintStream;

/**
 * <p>Title: Door</p>
 * <p>Description: Clase que simula una puerta</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Escuela de Ingenier�a Inform�tica</p>
 * <p>Metodolog�a de la Programaci�n</p>
 * 
 * @author Profesores de Metodolog�a de la Programaci�n
 * @version 1.0
 */
public class Door {

	private boolean opened;
	
	public Door() {
		setOpened(false);
	}

	public boolean isOpened() {
		return opened;
	}
	
	public void open(PrintStream out){
		if (!isOpened()) {
			out.println ("  La puerta se abre manualmente");
			setOpened(true);
		}
	}
	
	public void close(PrintStream out){
		if (isOpened()) {
			out.println ("  La puerta se cierra manualmente");
			setOpened(false);
		}
	}

	protected void setOpened(boolean opened) {
		this.opened = opened;
	}
}
