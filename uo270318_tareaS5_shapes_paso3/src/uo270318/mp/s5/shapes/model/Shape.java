package uo270318.mp.s5.shapes.model;

import java.awt.Color;

public abstract class Shape implements Drawable{

	public static final int MIN_POS = 0;
	public static final int MAX_POS = 100;
	private int posX;
	private int posY;
	private Color color;

	public Shape() {
		super();
	}

	public Shape(int posX, int posY, Color color) {
		setPosX(posX);
		setPosY(posY);
		setColor(color);
	}

	/**
	 * 
	 * @return valor del atributo PosX
	 */
	public int getPosX() {
		return posX;
	}

	/**
	 * Modifica el valor del atributo posX con el nuevo recibido como par�metro
	 * 
	 * @param posX
	 */
	protected void setPosX(int posX) {
		checkPosition(posX);
	
		this.posX = posX;
	}

	public void checkPosition(int pos) {
		if (pos < MIN_POS || pos > MAX_POS)
			throw new IllegalArgumentException("Posici�n X fuera de los l�mites");
	}

	public int getPosY() {
		return posY;
	}

	/**
	 * Modifica el valor del atributo posY con el nuevo recibido como par�metro
	 * 
	 * @param posY
	 */
	protected void setPosY(int posY) {
		checkPosition(posY);
		this.posY = posY;
	}

	/**
	 * 
	 * @return valor del atributo color, de tipo enumerado Color
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * Modifica el valor del atributo color con el nuevo recibido como par�metro
	 * 
	 * @param color
	 */
	protected void setColor(Color color) {
		this.color = color;
	}
	
	

}