package ar.com.interfaz;

public class PracticaHiloI implements Runnable{

	static int[] arr = new int [10];
	static int n = 0;
	
	//Llenar un arreglo usando hilos y mostrarlos en pantalla
	public static void main(String[] args) {
		Runnable obj = new PracticaHiloI();
		
		Thread h1 = new Thread(obj, "Hilo 1");
		Thread h2 = new Thread(obj, "Hilo 2");
		
		/*
		 * Agrega los elementos de forma desordenada, es decir sin seguir la secuencia 
		 * h1.start();
		 * h2.start();
		 * */
		try {		
			h1.start();
			h1.join();
			h2.start();
			h2.join();
			
			System.out.println("Mostrando el arreglo ....");
			Thread.sleep(2000);
			
			for(int i = 0 ; i<arr.length; i++)
				System.out.print(arr[i]+" - ");
			
			System.out.println();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
	}
	
	@Override
	public void run() {
		int i = 0;
		var nombre = Thread.currentThread().getName();
		while(i<5) {
			var value = 10 * (n+1);		
			System.out.println("El "+nombre+" agregar el valor "+value+" al arreglo");
			arr[n] = value;
			n++;
			i++;
		}
	}
	
	
	
}
