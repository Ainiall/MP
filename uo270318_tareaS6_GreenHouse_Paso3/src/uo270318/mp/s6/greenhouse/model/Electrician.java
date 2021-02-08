package uo270318.mp.s6.greenhouse.model;

import java.io.PrintStream;
import java.util.ArrayList;

public class Electrician {
	@SuppressWarnings("unused")
	private String name;

	public Electrician(String name) {
		this.name = name;
	}

	public void checkElectronicDevices(ArrayList<Checkable> devices, PrintStream out) {
		for (Checkable d : devices) {
			if (d.check()) {
				out.println(d + " falla");
			}
		}
	}
}
