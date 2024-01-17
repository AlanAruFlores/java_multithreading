package ar.com.interfaz;

import ar.com.interfaz.hilos.ABC;

public class EstadoHilo implements Runnable{
	public static EstadoHilo e1;
	public static Thread h1;
	
	public static void main(String[] args) {
		e1  = new EstadoHilo();
		h1  = new Thread(e1);
		
		System.out.println("Estado inicial del hilo 1: "+ h1.getState());
		h1.start();
		System.out.println("Estado del hilo 1 al ejecutarse: "+h1.getState());
	}

	@Override
	public void run() {
		ABC obj = new ABC();
		Thread h2 = new Thread(obj);
		
		
		System.out.println("Estado del hilo 2 inicial: "+h2.getState());
		h2.start();
		
		System.out.println("Estado del hilo 2 a ejecutarse  : "+h2.getState());
		
		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Estado del hilo 2 al ejecutar sleep en su metodo run() "+ h2.getState());
	
		
		try {
			h2.join();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Estado del hilo 2 al terminarse: "+h2.getState());
	}
}
