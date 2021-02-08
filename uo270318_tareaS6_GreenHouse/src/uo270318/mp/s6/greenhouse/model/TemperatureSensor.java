package uo270318.mp.s6.greenhouse.model;

import java.util.Random;

/**
 * <p>
 * Titulo: Clase TemperatureSensor
 * </p>
 * <p>
 * Descripcion: Clase que simula un sensor de temperatura.
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 * 
 * @author Angela Lopez UO270318
 * @version 1.0
 */
public class TemperatureSensor implements Checkable{

	/**
	 * Metodo que simula una medicción de temperatura
	 * 
	 * @return La temperatura medida por el sensor
	 */
	public int getTemperature() {
		// número aleatorio [5-40]
		return new Random(System.currentTimeMillis()).nextInt(36)+5;
	}

	/**
	 * Metodo que comprueba si el sensor falla.
	 */
	@Override
	public boolean check() {
		return new Random().nextInt(100) > 90;
	}

	/**
	 * Metodo que devuelve el tipo de aparato electronico.
	 */
	@Override
	public String getType() {
		return "Temperature sensor";	
	}
	
}
