package ar.com.interfaz;

public class ClaseThreadGroup implements Runnable{

	@Override
	public void run() {
		System.out.println("Soy el hilo "+Thread.currentThread().getName());
	}
	
	public static void main(String[] args) {
		ThreadGroup grupoHilos = new ThreadGroup("Grupo A");
		Thread h1  = new Thread(grupoHilos, new ClaseThreadGroup(), "uno");
		Thread h2  = new Thread(grupoHilos, new ClaseThreadGroup(), "dos");
		Thread h3  = new Thread(grupoHilos, new ClaseThreadGroup(), "tres");

		h1.start();
		h2.start();
		h3.start();
	
		
		System.out.println("Informacion del ThreadGroup: ");
		//Obtengo el nombre del grupo de hilos
		System.out.println("Nombre del grupo: "+grupoHilos.getName());
		grupoHilos.list(); // imprimo informacion del grupo
	
	}
}
