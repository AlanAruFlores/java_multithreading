package ar.com.interfaz.hilos;

public class TrabajoThreadPool implements Runnable {
	
	public String mensaje;
	
	public TrabajoThreadPool(String mensaje) {
		this.mensaje = mensaje;
	}
	
	@Override
	public void run() {
		String nombreDelHilo =Thread.currentThread().getName();
		System.out.println(nombreDelHilo+"(Start) -> "+this.mensaje);
		procesarMensaje();
		System.out.println(nombreDelHilo+"(End)");
	}
	
	public void procesarMensaje() {
		try {
			Thread.sleep(1000);
		}catch(InterruptedException ex) {
			ex.printStackTrace();
		}
		
	}


}
