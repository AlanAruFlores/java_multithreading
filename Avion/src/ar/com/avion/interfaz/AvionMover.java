package ar.com.avion.interfaz;

import java.util.Scanner;

import ar.com.avion.interfaz.hilo.BalaThread;
import ar.com.avion.interfaz.hilo.MostrarThread;

public class AvionMover {

	static final int ANCHO =100;
	static final int ALTO = 25;
	public static String[][] plataforma = new String[ALTO][ANCHO];
	
	static final int DEFAULT_POS_Y  = 12;
	static final int DEFAULT_POS_X  = 50;

	static int [] posicionesGrabadas = new int[2];
	
	static Scanner entrada = new Scanner(System.in);

	public static int posX =DEFAULT_POS_X;
	public static int posY = DEFAULT_POS_Y;

	
	public static boolean continuarJuego = true;
	
	public static void generarPlataforma() {
		for(int i  = 0  ; i<ALTO; i++) {
			for(int j = 0  ; j<ANCHO; j++) {
				if( ( i == 0 || i == ALTO -1 ) || ((i!=0 && i!=ALTO-1) && (j==0 || j == ANCHO-1)))
					plataforma[i][j] = "*";
				else
					plataforma[i][j] = " ";
			}
		}

	}
	
	public static void generarAvion(int posInicialY, int posInicialX) {
		boolean verificar = (posInicialY < 0 || posInicialY+3 >=25) ||
				(posInicialX-3<0 || posInicialX+3 >= 100) ? true : false;
		if(!verificar) {
			posicionesGrabadas[0] = posInicialY; 
			posicionesGrabadas[1] = posInicialX;
			
			//int posInicialY = 12;
			//int posInicialX = 50;
			

		}else {
			posInicialY = posicionesGrabadas[0];
			posInicialX = posicionesGrabadas[1];
			posX = posInicialX;
			posY = posInicialY;
		}
		int count = 1;

		int k = 0 , j = 0 ;
		int auxX  = 0;
		while(k<3) {
			
			j=0;
			auxX = posInicialX;
			while(j < count) {
				plataforma[posInicialY][auxX++] = "*";
				j++;
			}
			
			posInicialX--;
			posInicialY++;
			count+=2;
			k++;
		}
		
	}
	
	public static void mostrarPlataforma() {
		for ( int i = 0 ; i<ALTO; i++) {
			for(int j  = 0 ; j<ANCHO; j++) {
				System.out.print(plataforma[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void mostrarTeclas() {
		System.out.println("[W] ARRIBA | [A] DERECHA | [S] ABAJO | [D] IZQUIERDA | [R] DISPARAR | [?] SALIR" );
	}
	public static void hacerEspacios(int n ) {
		for(int i = 0 ; i<n; i++) {
			System.out.println();
		}
	}
	
	public static void main(String args[]) {	
		MostrarThread mostrarThread = new MostrarThread();
		
		generarPlataforma();
		generarAvion(DEFAULT_POS_Y, DEFAULT_POS_X);
		mostrarThread.start();
		String mov = "";
		

		
		while(true) {			
			mov  =  entrada.next();
			if(mov.equalsIgnoreCase("w"))
				posY-=3;
			else if(mov.equalsIgnoreCase("s"))
				posY+=3;
			else if(mov.equalsIgnoreCase("a"))
				posX+=5;
			else if(mov.equalsIgnoreCase("d"))
				posX-=5;
			else if(mov.equalsIgnoreCase("r")) {
				BalaThread bala = new BalaThread();
				bala.start();
			}
			else {
				continuarJuego = false;
				break;
			}
			generarPlataforma();
			generarAvion(posY, posX);

		}

	}
}
