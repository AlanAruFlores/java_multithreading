package ar.com.interfaz.clases.ejercicios;

import ar.com.interfaz.hilos.Reloj;

public class HiloReloj {
	
	public static void main(String[] args) {
		Thread reloj1 =  new Thread(new Reloj());
		reloj1.start();
	}
	
}
