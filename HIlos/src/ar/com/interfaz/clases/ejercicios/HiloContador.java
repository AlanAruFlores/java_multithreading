package ar.com.interfaz.clases.ejercicios;

public class HiloContador implements Runnable{
	private String nombre;
	private int limite;
	private int contador = 0;
	
	public HiloContador(String nombre, int limite) {
		this.nombre = nombre;
		this.limite = limite;
		 
	}
	
	@Override
	public void run() {
		for(contador = 0; contador < limite; contador++) {
			System.out.println(nombre+"->"+contador);
		}
	}
}
