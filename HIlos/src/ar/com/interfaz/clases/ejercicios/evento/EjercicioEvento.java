package ar.com.interfaz.clases.ejercicios.evento;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 *Ejercicio: Simulación de un sistema de venta de entradas para un evento

Supongamos que estás desarrollando un sistema de venta de entradas en línea para un evento popular. 
Queremos simular la venta de entradas
utilizando hilos para representar a los compradores que intentan adquirir entradas simultáneamente. 
 * */


public class EjercicioEvento {
	public static Evento evento = new Evento("Evento de comida",
			"Va a ver un gran buffet");
	
	public static Collection<Comprador> compradores =
			new ArrayList<Comprador>();
	
	private static void generarCompradores() {
		for(int i = 0 ; i<40; i++) 
			compradores.add(new Comprador (("Comprador "+(i+1)), ("Apellido "+(i+1)) , i,
					new Date()));
	}
	
	public static void main(String args[]) {
		ExecutorService pool  = Executors.newFixedThreadPool(4);
		
		generarCompradores();
		
		for(int i = 0 ; i<40; i++) 
			pool.execute(new HiloComprar(((List<Comprador>)compradores).get(i)));
	
		pool.shutdown();
		while(!pool.isTerminated()) {}
		
		//Mostramos los compradores
		String txt = evento.mostrarCompradores();
		System.out.println(txt);
	}
	
}
