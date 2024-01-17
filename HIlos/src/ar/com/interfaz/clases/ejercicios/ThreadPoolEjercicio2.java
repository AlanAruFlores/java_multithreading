package ar.com.interfaz.clases.ejercicios;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * Realizar un ejercicio donde se asignen cien numeros a una lista usando 3 hilos
 * */
public class ThreadPoolEjercicio2 implements Runnable{

	static int numeros[] = new int[100];
	static int index = 0;
	
	
	
	static final int CANT = 4;
	
	public static void ingresarValoresPorDefecto() {
		for(int i = 0 ; i<100; i++) {
			numeros[i] = 0;
		}
	}
	
	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newFixedThreadPool(CANT);
		ingresarValoresPorDefecto();
		mostrarArreglo();

		
		for(int i  = 0 ; i < CANT ; i++) 
			threadPool.execute(new ThreadPoolEjercicio2());
		
		mostrarArreglo();
		
		threadPool.shutdown();
		
	}
	public static void mostrarArreglo() {
		for(int i  = 0 ; i<100; i++) {
			for(int j  = 0 ; j<10; j++)
				System.out.print(numeros[i]+" - ");
			System.out.println();
		}
	}



	@Override
	public void run() {
		ciclo: while(true) {
			if(index >= 100)
				break ciclo;
			int n = tenerNumeroAleatorio();
			numeros[index] =n;
			System.out.println(Thread.currentThread().getName()+" inserto -> "+n+ " en la posicion "+index);
			index++;
			
		}
	}
	
	public int tenerNumeroAleatorio() {
		return (int) (Math.random()*100+1);
	}
	
}
