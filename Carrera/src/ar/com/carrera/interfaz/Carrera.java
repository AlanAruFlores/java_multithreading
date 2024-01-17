package ar.com.carrera.interfaz;

import java.util.HashSet;
import java.util.Set;

import ar.com.carrera.dominio.Auto;
import ar.com.carrera.dominio.AutomovilElectrico;
import ar.com.carrera.dominio.AutomovilesLujo;
import ar.com.carrera.dominio.Deportivo;
import ar.com.carrera.dominio.DeportivoCompacto;
import ar.com.carrera.hilos.AvanzarHilo;

public class Carrera extends Thread {
	public static final Integer FILAS = 20;
	public static final Integer COLUMNAS = 6;
	public static String [][]plataforma = new String[FILAS][COLUMNAS];
	
	static Set<Auto> participantes = new HashSet<Auto>() {{
		add(new Deportivo("Ferrari", "Blue label", 100, "ROJO"));
		add(new AutomovilesLujo("Chevrolet", "Red Label", 80, "AZUL"));
		add(new DeportivoCompacto("Casio", "Black Label", 20, "NEGRO"));
		add(new AutomovilElectrico("KAZC", "Green Label", 60, "VERDE"));
	}};
	
	public static int puesto = 1;
	public static String informacionPuestos = "PUESTOS DE LA CARRERA: \n ----------------------";
	
	
	public static Boolean continua = true;
	
	private static void generarPlataforma() {
		for(int i = 0 ; i<FILAS;i++) {
			for(int j  = 0; j<COLUMNAS; j++) {
				if( (i == 0 || i == FILAS-1) || (j == 0 || j == COLUMNAS-1))
					plataforma[i][j] = "*";
		
				else if( ( i == FILAS-2 && (j != 0 && j != COLUMNAS -1 )) ) 
					plataforma[i][j] = "+";
				else if ( ( i == 1 && (j != 0 && j != COLUMNAS -1 )))
					plataforma[i][j] = "_";
				else
					plataforma[i][j] = " ";
			}
		}
		
		
	}
	
	private static void mostrarPlataforma() {
		hacerEspacios(10);
		for(int i = 0 ; i<FILAS;i++) {
			for(int j  = 0; j<COLUMNAS; j++) {
				System.out.print(plataforma[i][j]+" ");
			}
			System.out.println("");
		}
		
	}
	
	private static void mostrarParticipantes() {
		System.out.println("\n\nPARTICIPANTES DE LA CARRERA:");
		System.out.println("-----------------------------");
		for(Auto p: participantes) {
			System.out.println(p);
		}
	}
	
	private static void hacerEspacios(int n) {
		for(int  i = 0 ; i<n;i++) {
			System.out.println();
		}
	}
	
	
	@Override 
	public void run() {
		while(continua) {
			
			mostrarPlataforma();
			mostrarParticipantes();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(puesto > 4)
				continua = false;
			

		}
		System.out.println("CARRERA FINALIZADA!!");
		hacerEspacios(4);
		System.out.println(informacionPuestos);
	}

	public static void main(String [] args) {
		generarPlataforma();
		
		Thread tCarrera = new Carrera();
		tCarrera.start();
		

		int auxY=  1;
		int prioridad = 0;
		for(Auto auto : participantes) {
			
			if(auto instanceof Deportivo)
				prioridad = 8;
			if(auto instanceof AutomovilesLujo)
				prioridad = 6;
			if(auto instanceof AutomovilElectrico)
				prioridad = 4;
			if(auto instanceof DeportivoCompacto)
				prioridad = 3;
			
			Thread thAuto = new Thread(new AvanzarHilo(auto,auxY++, FILAS-2));
			thAuto.setPriority(prioridad);
			thAuto.start();
		}
		
		
	}
}
