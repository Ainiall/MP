package uo270318.mp.s6.greenhouse.main;

import uo270318.mp.s6.greenhouse.model.AutomaticDoor;
import uo270318.mp.s6.greenhouse.model.Door;
import uo270318.mp.s6.greenhouse.model.Electrician;
import uo270318.mp.s6.greenhouse.model.Greenhouse;
import uo270318.mp.s6.greenhouse.model.HumiditySensor;
import uo270318.mp.s6.greenhouse.model.TemperatureSensor;

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
	 * @param args Argumentos
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
			greenhouse.add(new TemperatureSensor());
			greenhouse.add(new Door());
			greenhouse.add(new AutomaticDoor());
			greenhouse.add(new HumiditySensor());
		}

		greenhouse.operatorLooksThru(System.out);
		greenhouse.operatorLooksThru(System.out);
		greenhouse.operatorLooksThru(System.out);
		
		//Una vez al mes
		Electrician electrician = new Electrician("Manolo");
		electrician.checkElectronicDevices(greenhouse.getCheckables(), System.out);
	}
}
