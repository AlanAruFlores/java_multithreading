package ar.com.interfaz.clases.ejercicios.botella;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * Hacer un ejercicio donde se haga una carrera de que botella
 * se llena mas que otra
 * */
public class EjercicioBotella {
	static final Integer CANT_BOTELLAS = 4;
	
	
	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(CANT_BOTELLAS);
		
		for(int k = 0 ; k < CANT_BOTELLAS; k++)
			pool.execute(new Botella("Botella "+k));
		
		pool.shutdown();
	}
}
