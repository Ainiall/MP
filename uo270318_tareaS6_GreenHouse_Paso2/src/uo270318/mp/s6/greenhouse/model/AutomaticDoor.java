package uo270318.mp.s6.greenhouse.model;

import java.io.PrintStream;

public class AutomaticDoor extends Door {

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

	
}
