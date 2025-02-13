package ar.com.interfaz.clases.ejercicios;

public class HiloNumerosLetras implements Runnable {
	private int tipoHilo;
	
	public HiloNumerosLetras(int tipo) {
		this.tipoHilo = tipo;
	}
	
	@Override
	public void run() {
		switch(tipoHilo) {
			case 1: 
				mostrarNumeros();
				break;
			case 2:
				mostrarLetras();
		}
	}
	
	public void mostrarNumeros() {
		for(int i=0;i<31;i++)
			System.out.println(i);
	}
	
	public void mostrarLetras() {
		
		for(int i = 65; i<=90 ; i++)
			System.out.println((char)i);
	}

}
