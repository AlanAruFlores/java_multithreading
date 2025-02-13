package ar.com.interfaz;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ar.com.interfaz.hilos.TrabajoThreadPool;

public class ClaseThreadPool {
	
	public static void main(String[] args) {
		
		//Thread pool con 4 hilos
		ExecutorService threadPool = Executors.newFixedThreadPool(4);
		
		for(int i = 0 ; i<10; i++) {
			TrabajoThreadPool tarea = new TrabajoThreadPool("Mensaje "+(i+1));
			threadPool.execute(tarea);
		}
		
		threadPool.shutdown();
		while(!threadPool.isTerminated()) {}
		System.out.println("Termino la ejecucion de todas las tareas de los hilos");
	}
}
