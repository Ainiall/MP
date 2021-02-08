package uo270318.mp.s6.greenhouse.main;

import uo270318.mp.s6.greenhouse.model.AutomaticDoor;
import uo270318.mp.s6.greenhouse.model.Door;
import uo270318.mp.s6.greenhouse.model.Greenhouse;
import uo270318.mp.s6.greenhouse.model.Sensor;

/**
 * <p>Title: Application</p>
 * <p>Description: Clase que ejecuta el programa</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Escuela de Ingeniería Informática</p>
 * <p>Metodología de la Programación</p>
 * 
 * @author Profesores de Metodología de la Programación
 * @version 1.0
 */
public class Application {
	
	/**
	 * Método principal que lanza la aplicación
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new Application().run();
	}

	/**
	 * Método que ejecuta la aplicación
	 */
	public void run() {
		Greenhouse greenhouse = new Greenhouse();

		for(int i=0; i<10; i++) {
			greenhouse.add(new Sensor());
			greenhouse.add(new Door());
			greenhouse.add(new AutomaticDoor());
		}

		greenhouse.operatorLooksThru(System.out);
		greenhouse.operatorLooksThru(System.out);
		greenhouse.operatorLooksThru(System.out);
		
	}
}
