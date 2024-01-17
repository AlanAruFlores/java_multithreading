package ar.com.interfaz;
/*Crea una clase llamada Contador que contenga un atributo que sea un contador,
otro que sea el nombre del hilo y otro que sea el limite del contador, es decir, donde debe acabar*/

import ar.com.interfaz.clases.ejercicios.HiloContador;

public class PracticaHilo3 {
	public static void main(String[] args) {
		
		Thread[] hContadores = {
				new Thread(new HiloContador("H1", 150)),
				new Thread(new HiloContador("H2", 200)),
				new Thread(new HiloContador("H3", 160)),
				new Thread(new HiloContador("H4", 240))
		};
		
		
		for(Thread t : hContadores) {
			t.start();
		}
		
	}
}
