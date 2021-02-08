package uo270318.mp.s5.shapes.model;

import java.awt.Color;
import java.io.PrintStream;

/**
 * <p>
 * Title: Rect�ngulo
 * </p>
 * <p>
 * Description: Clase que modela un rect�ngulo
 * </p>
 * <p>
 * Copyright: Copyright (c) 2018/p>
 * <p>
 * Escuela de Ingenier�a Inform�tica
 * </p>
 * <p>
 * Metodolog�a de la Programaci�n
 * </p>
 * 
 * @author Profesores de Metodolog�a de la programaci�n
 * @version 1.0
 */

public class Rectangle extends Shape {

	private int width;
	private int height;

	/**
	 * Constructor que recibe todos los datos
	 * 
	 * @param x
	 *            Punto inicial
	 * @param y
	 *            Punto final
	 * @param width
	 *            Anchura
	 * @param height
	 *            Altura
	 * @param color
	 *            Color
	 */

	public Rectangle(int x, int y, int width, int height, Color color) {
		super(x, y, color);
		setWidth(width);
		setHeight(height);
	}

	/**
	 * 
	 * @return valor del atributo width, de tipo int
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Modifica el valor del atributo width con el nuevo recibido como par�metro
	 * 
	 * @param width
	 */
	private void setWidth(int width) {
		if (width <= 0)
			throw new IllegalArgumentException("Valor ancho fuera de limites");
		this.width = width;
	}

	/**
	 * 
	 * @return valor del atributo height, de tipo int
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Modifica el valor del atributo height con el nuevo recibido como par�metro
	 * 
	 * @param height
	 */
	private void setHeight(int height) {
		if (height <= 0)
			throw new IllegalArgumentException("Valor alto fuera de limites");
		this.height = height;
	}

	/**
	 * Muestra por consola los rect�ngulos como coordenadas de una esquina y la
	 * longitud de los lados
	 */
	@Override
	public void draw(PrintStream out) {
		out.print("Dibujando el rectangulo: ");
		out.print("(" + getPosX() + ", " + getPosY() + ")");
		out.print(" - Anchura: " + getWidth());
		out.println(" - Altura: " + getHeight());
	}

}
