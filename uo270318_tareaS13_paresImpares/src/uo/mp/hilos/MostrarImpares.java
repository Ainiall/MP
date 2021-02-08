package uo.mp.hilos;

public class MostrarImpares implements Runnable {

	@Override
	public void run() {
		for(int i=0;i<100;i++) {
			if(i%2!=0) {
				System.out.println("IMPAR......"+i);
			}
		}
		
	}

}
