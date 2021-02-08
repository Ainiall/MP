package uo270318.mp.s5.shapes.model;

import java.io.PrintStream;
import java.util.ArrayList;

/**
 * <p>Title: Dibujo</p>
 * <p>Description: Clase que contiene las figuras que serán dibujadas.</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Escuela de Ingeniería Informática</p>
 * <p>Metodología de la Programación</p>
 * 
 * @author Profesores de Metodología de la programación
 * @version 1.0
 */
public class Drawing {

	private ArrayList<Drawable> drawables;
	
	public Drawing(){
		drawables = new ArrayList<Drawable>();		
	}	
	

	public void add(Drawable drawable) {
		drawables.add(drawable);
	}

	public void draw(PrintStream out) {
		for(Drawable d: drawables) {
			d.draw(out);
		}
	}
}
