package ar.com.interfaz.clases.ejercicios;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import ar.com.utils.TipoParImpar;

public class ThreadPoolEjercicio4 implements Runnable {
	private TipoParImpar tipoHilo;
	
	public ThreadPoolEjercicio4(TipoParImpar tipoHilo) {
		this.tipoHilo = tipoHilo;
	}
	
	@Override
	public void run() {
		int indexInicio = 0;
		switch(tipoHilo) {
			case PAR:
				indexInicio = 0;
				break;
			case IMPAR:
				indexInicio = 1;
				break;
		}
		Thread.currentThread().setName("HILO "+tipoHilo.name());

		for(var i =  indexInicio ; i <= 20; i+=2) {
			System.out.println("El "+Thread.currentThread().getName()+" muestra -> "+i);
		}
		
	}
	
	
	
	public static void main(String[] args)
	{
		final int CANT = 2;
		ExecutorService pool  = Executors.newFixedThreadPool(CANT);
		
		TipoParImpar[] values = TipoParImpar.values();
		for(var k = 0; k < CANT; k++) 
			pool.execute(new ThreadPoolEjercicio4(values[k]));
		
		pool.shutdown();
		
		while(!pool.isTerminated()) {}
		
		System.out.println("\n\nHILO PRINCIPAL TERMINADO !! ");
	}
}
