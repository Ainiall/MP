package uo270318.mp.s5.shapes.model;

import java.awt.Color;
import java.io.PrintStream;

public class Circle extends Shape {
	private int radious;

	public Circle(int posX, int posY, Color color, int radious) {
		super(posX, posY, color);
		setRadious(radious);
	}
	private void setRadious(int radious) {
		super.checkPosition(radious);
		this.radious = radious;
	}

	public int getRadious() {
		return radious;
	}

	/**
	 * Muestra por consola los rectángulos como coordenadas de una esquina y la
	 * longitud de los lados
	 */
	@Override
	public void draw(PrintStream out) {
		out.print("Dibujando el circulo: ");
		out.print("(" + getPosX() + ", " + getPosY() + ")");
		out.print(" - Radio " + getRadious());
	}
}
