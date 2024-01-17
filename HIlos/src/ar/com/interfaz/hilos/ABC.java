package ar.com.interfaz.hilos;

import ar.com.interfaz.EstadoHilo;

//C
public class ABC implements Runnable {

	@Override
	public void run() {
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//Muestro el estado del hilo 1;
		
		System.out.println("Estado del hilo 1, cuando esta en join el hilo 2: "+EstadoHilo.h1.getState());
		
		try {
			Thread.sleep(200); // Aca duerme nuevamente el hilo 2 y es donde esta en TIMED_WAITING
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
