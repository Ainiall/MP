package uo.mp.hilos;

import java.util.ArrayList;
import java.util.List;

public class MostrarHilos {
	public static void main(String[] args) {
		MostrarHilos.run();
	}

	private static void run() {
		List<Thread> coleccion_hilos = new ArrayList<Thread>();
		coleccion_hilos.add(new MostrarPares());
		coleccion_hilos.add(new Thread(new MostrarImpares()));

		for (Thread thread : coleccion_hilos) {
			try {
				thread.start();
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("MostrarNumeros ha acabado");
	}

}
