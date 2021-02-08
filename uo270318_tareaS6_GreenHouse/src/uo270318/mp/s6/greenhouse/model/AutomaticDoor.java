package uo270318.mp.s6.greenhouse.model;

import java.io.PrintStream;
import java.util.Random;
/**
 * <p>
 * Titulo: Clase AutomaticDoor
 * </p>
 * <p>
 * Descripcion: Clase que simula una puerta automatica.
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 * 
 * @author Angela Lopez UO270318
 * @version 1.0
 */
public class AutomaticDoor extends Door implements Checkable {

	/**
	 * Metodo que muestra si la puerta esta abierta o no. Devuelve true si esta
	 * abierta y false si no lo esta.
	 */
	@Override
	public boolean isOpened() {
		return super.isOpened();
	}

	/**
	 * Metodo que abre una puerta automatica.
	 */
	@Override
	public void open(PrintStream out) {
		if (!isOpened()) {
			out.println("  Abriendo puerta automática");
			setOpened(true);
		}
	}

	/**
	 * Metodo que cierra una puerta automatica.
	 */
	@Override
	public void close(PrintStream out) {
		if (isOpened()) {
			out.println("  Cerrando puerta automática");
			setOpened(false);
		}
	}

	/**
	 * Metodo que comprueba si una puerta automatica falla.
	 */
	@Override
	public boolean check() {
		return new Random().nextInt(100) > 98;
		// al ser un porcentaje tan pequeño si devuelve verdadero es que falla
	}

	/**
	 * Metodo que devuelve el tipo de aparato electronico.
	 */
	@Override
	public String getType() {
		return "Automatic door";
	}

}
