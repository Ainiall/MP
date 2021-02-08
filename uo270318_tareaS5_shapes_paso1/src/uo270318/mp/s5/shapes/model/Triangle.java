package uo270318.mp.s5.shapes.model;

import java.awt.Color;
import java.io.PrintStream;

public class Triangle extends Shape {
	private int posX2;
	private int posY2;
	private int posX3;
	private int posY3;

	public Triangle(int x1, int y1, int x2, int y2,int x3, int y3, Color color) {
		super(x1, y2, color);
		setPosX2(x2);
		setPosX3(x3);
		setPosY2(y2);
		setPosY3(y3);
	}


	public int getPosX2() {
		return posX2;
	}


	private void setPosX2(int posX2) {
		this.posX2 = posX2;
	}


	public int getPosY2() {
		return posY2;
	}


	private void setPosY2(int posY2) {
		this.posY2 = posY2;
	}


	public int getPosX3() {
		return posX3;
	}


	private void setPosX3(int posX3) {
		this.posX3 = posX3;
	}


	public int getPosY3() {
		return posY3;
	}


	private void setPosY3(int posY3) {
		this.posY3 = posY3;
	}


	@Override
	public void draw(PrintStream out) {
		out.print("Dibujando el triangulo: ");
		out.print("(" + getPosX() + ", " + getPosY() + ")");
		out.print("(" + getPosX2() + ", " + getPosY2() + ")");
		out.print("(" + getPosX3() + ", " + getPosY3() + ")");
	}

}
