package uo270318.mp.s6.greenhouse.model;

import java.io.PrintStream;
import java.util.Random;

public class AutomaticDoor extends Door implements Checkable{

	@Override
	public boolean isOpened() {
		// TODO Auto-generated method stub
		return super.isOpened();
	}

	@Override
	public void open(PrintStream out) {
		if (!isOpened()) {
			out.println ("  La puerta se abre automaticamente ");
			setOpened(true);
		}
	}

	@Override
	public void close(PrintStream out) {
		if (isOpened()) {
			out.println ("  La puerta se cierra ");
			setOpened(false);
		}
	}

	@Override
	public boolean check() {
		return new Random().nextInt(100) > 98;
		//al ser un porcentaje tan pequeño si devuelve verdadero es que falla
	}

	
}
