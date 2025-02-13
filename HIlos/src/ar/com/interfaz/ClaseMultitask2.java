package ar.com.interfaz;

public class ClaseMultitask2 {

	public static void main(String[] args) {
		
		//Imprimir los caracteres de la a-z
		Thread t1 = new Thread() {
			public void run() {
				System.out.println("CARACTERES DE LA A - Z ");
				for(char aux = 'a' ; aux  <='z'; aux++) 
					System.out.print(aux+" - ");
				
				System.out.println();
				
			}
		};
		
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		
		//Mostrar numeros del 1 - 20 : 
		Thread t2  = new Thread() {
			
			public void run() {
				int i = 0;
				System.out.println();
				while(i<=20) {
					System.out.print(i+"-");
					i++;
				}
				System.out.println();
			}
			
		};
		
		t2.run();
		try {
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		
	}
}
