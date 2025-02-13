package ar.com.interfaz.clases.ejercicios;

import java.util.HashSet;
import java.util.Set;

import ar.com.dominio.Producto;

/*Realizar un ejercicio donde si el tipo de hilo es:
 * 1- Llenar datos de un ArrayList
 * 2- Mostrar datos de un ArrayList*/
public class HiloArrayClases implements Runnable{

	private int tipoHilo;
	static Set<Producto> arrProductos = new HashSet<Producto>();
	
	public HiloArrayClases(int tipoHilo) {
		this.tipoHilo = tipoHilo;
	}
	
	public static void main(String[] args) {
	
		Thread hCargarProductos = new Thread(new HiloArrayClases(1));
		Thread hMostrarProductos = new Thread (new HiloArrayClases(2));
		
		try {
			hCargarProductos.start();
			hCargarProductos.join();
			System.out.println("\n\n");
			hMostrarProductos.start();
			hMostrarProductos.join();
		}catch(InterruptedException ex) {
			ex.printStackTrace();
		}
		
	}
	
	@Override
	public void run() {
		switch(tipoHilo) {
			case 1: 
			try {
				agregarProductosAlSet();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}break;
			case 2:
				mostrarProductos();break;
		}
	}
	
	public void agregarProductosAlSet() throws InterruptedException {
		System.out.println("Agregando productos ....");
		Thread.sleep(2000);
		arrProductos.addAll(new HashSet<Producto>(){{
			add(new Producto(1,"Pan",400.0f, 200));
			add(new Producto(2,"Leche",300.0f, 200));
			add(new Producto(3,"Carne",2000.0f, 400));
			add(new Producto(4,"Galleta", 400.0f, 100));
		}});
	}
	
	public void mostrarProductos() {
		System.out.println("Mostrando productos....");
		try {
			Thread.sleep(4000);
			arrProductos.forEach((x)->{
				System.out.println(x);
			});
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
