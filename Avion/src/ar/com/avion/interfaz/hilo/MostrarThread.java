package ar.com.avion.interfaz.hilo;

import ar.com.avion.interfaz.AvionMover;

public class MostrarThread extends Thread{

	
	@Override
	public void run() {
		while(AvionMover.continuarJuego) {
			AvionMover.mostrarPlataforma();
			AvionMover.mostrarTeclas();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}		
	}
}
