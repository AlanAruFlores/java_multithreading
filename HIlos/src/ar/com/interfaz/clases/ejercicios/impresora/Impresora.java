package ar.com.interfaz.clases.ejercicios.impresora;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

public class Impresora implements Runnable{
	
	private Queue<Documento> cola = new LinkedList<Documento>();
	
	public Impresora(Collection<Documento> arr) {
		cola.addAll(arr);
	}
	
	@Override
	public void run() {
		while(!cola.isEmpty()) {
			Documento docActual  = cola.poll();
			System.out.println("Imprimiendo....");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Se imprimio "+docActual.toString()+"\n\n");			
		}
	}
}
