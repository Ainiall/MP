package uo270318.mp.s5.shapes.model;

import java.io.PrintStream;

public class Picture implements Drawable{
	private int posX;
	private int posY;
	private int width;
	private int height;
	private String fileName;
	
	public Picture(int x, int y, int w, int h, String name) {
		setPosX(x);
		setPosY(y);
		setWidth(w);
		setHeight(h);
		setFileName(name);
	}
	
	public int getPosX() {
		return posX;
	}

	private void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	private void setPosY(int posY) {
		this.posY = posY;
	}

	public int getWidth() {
		return width;
	}

	private void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	private void setHeight(int height) {
		this.height = height;
	}

	public String getFileName() {
		return fileName;
	}

	private void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public void draw(PrintStream out) {
		out.print("Dibujando una foto: ");
		out.print("(" + getPosX() + ", " + getPosY() + ")");
		out.print(" - Anchura: " + getWidth());
		out.println(" - Altura: " + getHeight());
		out.print(" Nombre: "+getFileName());
	}
	
}
