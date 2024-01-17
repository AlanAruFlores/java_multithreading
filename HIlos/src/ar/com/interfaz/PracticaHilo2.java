package ar.com.interfaz;

import ar.com.interfaz.clases.ejercicios.HiloNumerosLetras;

public class PracticaHilo2 {
	public static void main(String[] args) {
		HiloNumerosLetras obj = new HiloNumerosLetras(1);
		
		//Hilo de numeros
		Thread hNumero = new Thread(obj);
		hNumero.start();
		
		//Hilo para letras
		Thread hLetras = new Thread(new HiloNumerosLetras(2));
		hLetras.start();
		
	}
}
