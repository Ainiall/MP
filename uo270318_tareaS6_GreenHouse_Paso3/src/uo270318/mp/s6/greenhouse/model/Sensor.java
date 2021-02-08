package uo270318.mp.s6.greenhouse.model;

import java.util.Random;

/**
 * <p>Title: Sensor</p>
 * <p>Description: Clase que simula un sensor de temperatura</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Escuela de Ingeniería Informática</p>
 * <p>Metodología de la Programación</p>
 * 
 * @author Profesores de Metodología de la Programación
 * @version 1.0
 */
public class Sensor implements Checkable{

	/**
	 * Simula una medicción de temperatura
	 * 
	 * @return La temperatura medida por el sensor
	 */
	public int getTemperature() {
		// número aleatorio [5-40]
		return new Random(System.currentTimeMillis()).nextInt(36)+5;
		
	}

	@Override
	public boolean check() {
		return new Random().nextInt(100) > 90;
	}
	
}
