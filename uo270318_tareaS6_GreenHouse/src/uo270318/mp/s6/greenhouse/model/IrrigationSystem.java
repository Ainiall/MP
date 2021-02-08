package uo270318.mp.s6.greenhouse.model;

/**
 * <p>
 * Titulo: Clase IrrigationSystem
 * </p>
 * <p>
 * Descripcion: Clase que simula un sensor de riego.
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 * 
 * @author Angela Lopez UO270318
 * @version 1.0
 */
public class IrrigationSystem {
	// enumerado con posiciones
	public enum PositionEnum {
		OFF, LOW, MEDIUM, HIGH
	};

	private PositionEnum position;

	/**
	 * Constructor sin parametros que inicializa el sistema de riego a MEDIUM.
	 */
	public IrrigationSystem() {
		position = PositionEnum.MEDIUM;
	}

	/**
	 * Metodo que devuelve la posicion actual del sensor.
	 * 
	 * @return position Posicion actual del sensor.
	 */
	public PositionEnum getPosition() {
		return position;
	}

	/**
	 * Metodo que asigna una posicion que pasa como parametro al sensor.
	 * 
	 * @param position Posicion a asignar
	 */
	public void setPosition(PositionEnum position) {
		this.position = position;
	}

	/**
	 * Metodo que incrementa una posición al sensor.
	 */
	public void increasePosition() {
		switch (getPosition()) {
		case OFF:
			setPosition(PositionEnum.LOW);
			break;
		case LOW:
			setPosition(PositionEnum.MEDIUM);
			break;

		case MEDIUM:
			setPosition(PositionEnum.HIGH);
			break;
		default:
			break;
		}
	}

	/**
	 * Metodo que decrementa una posicion al sensor.
	 */
	public void decreasePosition() {
		switch (getPosition()) {
		case LOW:
			setPosition(PositionEnum.OFF);
			break;
		case MEDIUM:
			setPosition(PositionEnum.LOW);
			break;
		case HIGH:
			setPosition(PositionEnum.MEDIUM);
			break;
		default:
			break;
		}
	}
}
