package ar.com.interfaz;

public class ClaseMultitaskImpar implements Runnable{

	
	//Imprimir numeros impares
	@Override
	public void run() {
		int cont = 0;
		System.out.println("NUMEROS IMPARES");
		while(cont<20) {
			if(cont % 2 != 0)
				System.out.print(cont+"-");
			cont++;
		}
		System.out.println("");
	}
}
