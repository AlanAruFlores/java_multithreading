package ar.com.interfaz;

import ar.com.interfaz.hilos.PrimerHilo;
import ar.com.interfaz.hilos.PrimerRunnable;

public class CrearHilo {
	
	public static void main(String[] args) {
		
		//1ra forma de crear un hilo
		PrimerHilo h1 = new PrimerHilo();
		
		h1.start();
		System.out.println(h1.isAlive()); // verifico se esta vivo

		
		//2da forma de crear un hilo
		
		Runnable obj = new PrimerRunnable();
		Thread h2 = new Thread(obj);
		
		h2.start();
		
		//3ra forma de crear un hilo
		Thread h3  = new Thread("Hilo 3");

		System.out.println("Soy el "+h3.getName());
		h3.setName("Tercer Hilo" );
		System.out.println("Soy "+h3.getName());

		
		//4ta forma
		
		Runnable obj2 = new PrimerRunnable();
		Thread h4 = new Thread(obj2,"Hilo 4");
		
		
		h4.start();
		System.out.println("Hilo: "+h4.getName());
	}
}
