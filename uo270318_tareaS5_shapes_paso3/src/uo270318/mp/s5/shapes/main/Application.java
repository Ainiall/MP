package uo270318.mp.s5.shapes.main;

import java.awt.Color;

import uo270318.mp.s5.shapes.model.Circle;
import uo270318.mp.s5.shapes.model.Drawing;
import uo270318.mp.s5.shapes.model.Rectangle;

/**
 * <p>Title: Aplicaci�n</p>
 * <p>Description: Clase para ejecutar la aplicaci�n.</p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Escuela de Ingenier�a Inform�tica</p>
 * <p>Metodolog�a de la Programaci�n</p>
 * 
 * @author  Profesores de Metodolog�a de la programaci�n
 * @version 1.0
 */
public class Application {
	
	/**
	 * M�todo principal para la ejecuci�n del programa
	 * 
	 * @param args No son usados
	 */
	public static void main(String[] args) {
		new Application().run();
	}
	
	/**
	 * Ejecuta la aplicaci�n
	 */
	private void run (){
		Drawing drawing = new Drawing();
		
		Rectangle rectantle1 = new Rectangle(1,2,3,6,Color.RED);
		drawing.add(rectantle1);
		
		Rectangle rectangle2 = new Rectangle(3,4,7,8,Color.BLUE);
		drawing.add(rectangle2);
		
		Circle circle=new Circle(4,5,Color.BLUE,7);
		drawing.add(circle);
		drawing.draw(System.out);
	}

}
