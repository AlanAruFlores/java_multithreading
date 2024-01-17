package ar.com.interfaz;

public class ClasePrioridades {
	
	public static void main(String[] args) {
		
		Thread hiloPrincipal = Thread.currentThread();
		System.out.println("PRIORIDAD DEL HILO: "+hiloPrincipal.getPriority());
		
		hiloPrincipal.setPriority(7);
		System.out.println("PRIORIDAD DEL HILO: "+hiloPrincipal.getPriority());

		hiloPrincipal.setPriority(Thread.MAX_PRIORITY);
		System.out.println("PRIORIDAD DEL HILO: "+hiloPrincipal.getPriority());
		
		try {
			hiloPrincipal.setPriority(11);
			System.out.println("PRIORIDAD DEL HILO: "+hiloPrincipal.getPriority());
		}catch(IllegalArgumentException ex)
		{
			System.err.println("NO SE PUEDE ESCRIBIR UN VALOR QUE NO ESTE EN EL RANGO 1-10");
		}

	}
	
}
