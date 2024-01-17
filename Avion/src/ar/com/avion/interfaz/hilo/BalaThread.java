package ar.com.avion.interfaz.hilo;

import ar.com.avion.interfaz.AvionMover;

public class BalaThread extends Thread{

	
	int posX  = AvionMover.posX;
	int posY = AvionMover.posY; // Mover esto
	
	
	@Override
	public void run() {
		boolean ejecutar = true;
		posY-=2;

		while(ejecutar) {
			if(posY < 0) {
				ejecutar = false;
				break;
			}
			AvionMover.plataforma[posY][posX] = "+";
			AvionMover.plataforma[posY+1][posX]=" ";
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			posY--;
		}
	}
}
