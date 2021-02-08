package uo270318.mp.s6.greenhouse.model;

import java.util.Random;

/**
 * <p>
 * Titulo: Clase HumiditySensor
 * </p>
 * <p>
 * Descripcion: Clase que simula un sensor de humedad.
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 * 
 * @author Angela Lopez UO270318
 * @version 1.0
 */
public class HumiditySensor implements Checkable {

	/**
	 * Metodo que simula la humedad que recoge el sensor. Esta debe estar entre
	 * [20-70].
	 * 
	 * @return Humedad recogida.
	 */
	public int getHumidity() {
		// número aleatorio [20-70]
		return new Random(System.currentTimeMillis()).nextInt(51) + 20;
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
		return "Humidity Sensor";
	}
}
