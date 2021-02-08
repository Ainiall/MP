package uo270318.mp.s6.greenhouse.model;

import java.io.PrintStream;
import java.util.ArrayList;

/**
 * <p>
 * Title: GreenHouse
 * </p>
 * <p>
 * Description: Clase que simula un invernadero
 * </p>
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * <p>
 * Escuela de Ingeniería Informática
 * </p>
 * <p>
 * Metodología de la Programación
 * </p>
 * 
 * @author Profesores de Metodología de la Programación
 * @version 1.0
 */
public class Greenhouse {

	private final static byte MAX_TEMPERATURE = 22;
	private final static byte MIN_TEMPERATURE = 19;
	private final static double PERCENTAGE = 0.10;

	private ArrayList<Sensor> sensors = new ArrayList<Sensor>();
	private ArrayList<Door> doors = new ArrayList<Door>();
	private ArrayList<Checkable> checkables = new ArrayList<Checkable>();

	private int cont;

	public void add(Sensor sensor) {
		sensors.add(sensor);
		checkables.add(sensor);
	}

	public void add(Door door) {
		doors.add(door);
		if (door instanceof AutomaticDoor) {
			checkables.add((Checkable) door);
		}

	}

	public ArrayList<Checkable> getCheckables() {
		return checkables;
	}

	public void setCheckables(ArrayList<Checkable> checkables) {
		this.checkables = checkables;
	}

	/**
	 * Simula el trabajo de un operador que abre o cierra las puertas teniendo en
	 * cuenta la temperatura
	 * 
	 */
	public void operatorLooksThru(PrintStream out) {
		out.println("****OPERADOR****");
		checkTemperature(out);
	}

	/*
	 * Fuera hace frío, por lo que la apertura de las puertas siempre implica
	 * enfriar el interior.
	 * 
	 * Cuando getAverageTemperature() es mayor que MAX_TEMPERATURE) • Deberían
	 * abrirse algunas puertas para bajar la temperatura (si es posible) • Cada
	 * grado de diferencia (getAverageTemperature()-MAX_TEMPERATURE)) implica la
	 * apertura del 10% de las puertas (si es posible) • Devolver un mensaje que
	 * indique cuántas puertas están a punto de abrirse (si es posible)
	 * 
	 * Cuando getAverageTemperature() es menor que MIN_TEMPERATURE • Deberían
	 * cerrarse algunas puertas para aumentar la temperatura (si es posible) • Cada
	 * grado de diferencia (MIN_TEMPERATURE-getAverageTemperature()) implica el
	 * cierre del 10% de las puertas (si es posible) • Devolver un mensaje que
	 * indique cuántas puertas están a punto de cerrarse (si es posible)
	 * 
	 * En caso contrario, se devolverá un mensaje que indique simplemente la
	 * temperatura media.
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
			// temperatura correcta
			System.out.printf("La temperature %.2f es correcta.\n", averageTemperature);
	}

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
	 * Calcula la temperatura media del invernadero
	 * 
	 * @return La temperatura media del invernadero
	 */
	private double getAverageTemperature() {
		double addition = 0;
		for (Sensor sensor : sensors)
			addition += sensor.getTemperature();
		return addition / sensors.size();
	}
}
