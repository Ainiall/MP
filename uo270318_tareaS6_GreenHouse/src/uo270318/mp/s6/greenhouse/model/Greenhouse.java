package uo270318.mp.s6.greenhouse.model;

import java.io.PrintStream;
import java.util.ArrayList;

import uo270318.mp.s6.greenhouse.model.IrrigationSystem.PositionEnum;

/**
 * <p>
 * Titulo: Clase GreenHouse
 * </p>
 * <p>
 * Descripcion: Clase que simula un invernadero.
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 * 
 * @author Angela Lopez UO270318
 * @version 1.0
 */
public class Greenhouse {

	/**
	 * Constantes
	 */
	private final static byte MAX_TEMPERATURE = 22;
	private final static byte MIN_TEMPERATURE = 19;
	private final static byte MAX_HUMIDITY = 55;
	private final static byte MIN_HUMIDITY = 45;
	private final static double PERCENTAGE = 0.10;

	private ArrayList<TemperatureSensor> tSensors = new ArrayList<TemperatureSensor>();
	private ArrayList<HumiditySensor> hSensors = new ArrayList<HumiditySensor>();
	private ArrayList<Door> doors = new ArrayList<Door>();
	private ArrayList<Checkable> checkables = new ArrayList<Checkable>();
	private IrrigationSystem irrigationSystem = new IrrigationSystem();

	private int cont;

	/**
	 * Metodo que inserta los sensores de temperatura
	 * 
	 * @param sensor Sensor de temperatura
	 */
	public void add(TemperatureSensor sensor) {
		tSensors.add(sensor);
		checkables.add(sensor);
	}

	/**
	 * Metodo que inserta los sensores de humedad
	 * 
	 * @param sensor Sensor de humedad
	 */
	public void add(HumiditySensor sensor) {
		hSensors.add(sensor);
		checkables.add(sensor);
	}

	/**
	 * Metodo que inserta las puertas
	 * 
	 * @param door Puerta
	 */
	public void add(Door door) {
		doors.add(door);
		if (door instanceof AutomaticDoor) {
			checkables.add((Checkable) door);
		}

	}

	/**
	 * Metodo que devuelve la lista de aparatos que revisa el electricista
	 * 
	 * @return checkables Lista de aparatos revisables
	 */
	public ArrayList<Checkable> getCheckables() {
		return checkables;
	}

	/**
	 * Metodo que asigna los aparatos que revisa el electricista
	 * 
	 * @param checkables Aparatos a revisar
	 */
	public void setCheckables(ArrayList<Checkable> checkables) {
		this.checkables = checkables;
	}

	/**
	 * Simula el trabajo de un operador que abre o cierra las puertas teniendo en
	 * cuenta la temperatura y la humedad
	 * 
	 * @param out Objeto sobre el que se imprime la informacion
	 */
	public void operatorLooksThru(PrintStream out) {
		out.println("****OPERADOR****");
		checkTemperature(out);
		checkHumidity(out);
	}

	/**
	 * Metodo que controla la temperatura del invernadero. Para ello abre o cierra
	 * las puertas segun la temperatura sea mayor o menor que la permitida (para
	 * ello se abre o cierra un 10% de las puertas por cada grado de diferencia).
	 * 
	 * @param out Objeto sobre el que se imprime el mensaje de informacion.
	 */
	private void checkTemperature(PrintStream out) {
		double averageTemperature = getAverageTemperature();
		if (averageTemperature > MAX_TEMPERATURE) {
			int difference = (int) averageTemperature - MAX_TEMPERATURE;
			int doorsToOpen = (int) (difference * PERCENTAGE * doors.size());
			int openedDoors = openDoors(doorsToOpen, out);
			out.printf("Puertas a abrir...%d Puertas abiertas %d\n", doorsToOpen, openedDoors);
		}
		if (averageTemperature < MIN_TEMPERATURE) {
			int difference = (int) (MIN_TEMPERATURE - averageTemperature);
			int doorsToClose = (int) (difference * PERCENTAGE * doors.size());
			int closedDoors = closeDoors(doorsToClose, out);
			out.printf("Puertas a cerrar...%d Puertas cerradas %d\n", doorsToClose, closedDoors);
		} else
			out.printf("La temperatura %.2f es correcta.\n", averageTemperature);
	}

	/**
	 * Metodo que controla la humedad del invernadero. Para ello se sube o baja el
	 * nivel del sistema de riego segun se pase 20 veces el limite o no. Por defecto
	 * el sistema de riego esta en MEDIUM.
	 * 
	 * @param out Objeto sobre el que se imprime el mensaje de informacion.
	 */
	private void checkHumidity(PrintStream out) {
		double averageHumidity = getAverageHumidity();
		if (averageHumidity > (MAX_HUMIDITY + 20)) {
			irrigationSystem.setPosition(PositionEnum.LOW);
			out.printf("Humedad %.2f superior 20 veces al limite.Sistema de riego: %s.\n", averageHumidity,
					irrigationSystem.getPosition().name());
		} else if (averageHumidity < (MIN_HUMIDITY - 20)) {
			irrigationSystem.setPosition(PositionEnum.HIGH);
			out.printf("Humedad %.2f inferior 20 veces al limite.Sistema de riego: %s.\n", averageHumidity,
					irrigationSystem.getPosition().name());
		} else if (averageHumidity > MAX_HUMIDITY) {
			irrigationSystem.decreasePosition();
			out.printf("Humedad %.2f superior al limite.Sistema de riego: %s.\n", averageHumidity,
					irrigationSystem.getPosition().name());
		} else if (averageHumidity < MIN_HUMIDITY) {
			irrigationSystem.increasePosition();
			out.printf("Humedad %.2f inferior al limite.Sistema de riego: %s.\n", averageHumidity,
					irrigationSystem.getPosition().name());
		} else {
			out.printf("La humedad %.2f es correcta.Sistema de riego: %s.\n", averageHumidity,
					irrigationSystem.getPosition().name());
		}
	}

	/**
	 * Metodo que cierra las puertas que se le pasan como parametro (siempre que
	 * esten disponibles para ser cerradas)
	 * 
	 * @param doorsToClose Puertas a cerrar
	 * @param out Objeto sobre el que se imprime la informacion.
	 * @return cont Numero de puertas cerradas.
	 */
	private int closeDoors(int doorsToClose, PrintStream out) {
		cont = 0;
		for (int i = 0; i < doors.size() && cont < doorsToClose; i++) {
			Door d = doors.get(i);
			if (d.isOpened()) {
				d.close(out);
				cont++;
			}
		}
		return cont;
	}

	/**
	 * Metodo que abre las puertas que se le pasan como parametro (siempre que
	 * esten disponibles para ser abiertas)
	 * 
	 * @param doorsToClose Puertas a abrir
	 * @param out Objeto sobre el que se imprime la informacion.
	 * @return cont Numero de puertas abiertas.
	 */
	private int openDoors(int doorsToOpen, PrintStream out) {
		cont = 0;
		// un foreach aumenta la complejidad del algoritmo ya que sigue recorriendo la
		// coleccion
		for (int i = 0; i < doors.size() && cont < doorsToOpen; i++) {
			Door d = doors.get(i);
			if (!d.isOpened()) {
				d.open(out);
				cont++;
			}
		}
		return cont;
	}

	/**
	 * Metodo que calcula la temperatura media del invernadero.
	 * 
	 * @return La temperatura media del invernadero
	 */
	private double getAverageTemperature() {
		double addition = 0;
		for (TemperatureSensor sensor : tSensors)
			addition += sensor.getTemperature();
		return addition / tSensors.size();
	}

	/**
	 * Metodo que calcula la humedad media del invernadero.
	 * 
	 * @return La humedad media del invernadero
	 */
	private double getAverageHumidity() {
		int addition = 0;
		for (HumiditySensor sensor : hSensors)
			addition += sensor.getHumidity();
		return addition / hSensors.size();
	}

}
