package uo270318.mp.s6.greenhouse.model;

import java.io.PrintStream;
import java.util.ArrayList;
/**
 * <p>
 * Titulo: Clase Electrician
 * </p>
 * <p>
 * Descripcion: Clase que simula un electricista.
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 * 
 * @author Angela Lopez UO270318
 * @version 1.0
 */
public class Electrician {
	@SuppressWarnings("unused")
	private String name;

	/**
	 * Constructor con parametro.
	 * @param name Nombre del electricista
	 */
	public Electrician(String name) {
		this.name = name;
	}

	/**
	 * Metodo que comprueba los aparatos electronicos (sensores y puertas automaticas). 
	 * Si alguno de estos falla muestra un mensaje.
	 * @param devices Aparatos electronicos a revisar.
	 * @param out Objeto donde se imprime la informacion a mostrar.
	 */
	public void checkElectronicDevices(ArrayList<Checkable> devices, PrintStream out) {
		for (Checkable d : devices) {
			if (d.check()) {
				out.println(d.getType() + " falla.");
			}
		}
	}

}
