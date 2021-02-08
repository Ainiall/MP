package uo270318.mp.s5.shapes.model;

import java.awt.Color;
import java.io.PrintStream;

public class Triangle extends Shape {
	private int posX2;
	private int posY2;
	private int posX3;
	private int posY3;

	public Triangle(int x1, int y1, int x2, int y2, Color color) {
		super(x1, y2, color);
		
	}


	public int getPosX2() {
		return posX2;
	}


	@SuppressWarnings("unused")
	private void setPosX2(int posX2) {
		this.posX2 = posX2;
	}


	public int getPosY2() {
		return posY2;
	}


	@SuppressWarnings("unused")
	private void setPosY2(int posY2) {
		this.posY2 = posY2;
	}


	public int getPosX3() {
		return posX3;
	}


	@SuppressWarnings("unused")
	private void setPosX3(int posX3) {
		this.posX3 = posX3;
	}


	public int getPosY3() {
		return posY3;
	}


	@SuppressWarnings("unused")
	private void setPosY3(int posY3) {
		this.posY3 = posY3;
	}


	@Override
	public void draw(PrintStream out) {
		// TODO Auto-generated method stub

	}

}
