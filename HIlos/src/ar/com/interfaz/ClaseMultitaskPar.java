package ar.com.interfaz;

public class ClaseMultitaskPar implements Runnable{
	
	//Vamos a imprimir los numero pares
	@Override
	public void run() {
		System.out.println("NUMEROS PARES");
		for(int i = 0 ; i<20; i+=2) {
			System.out.print(i +"-");
		}
		System.out.println();
	}
}
