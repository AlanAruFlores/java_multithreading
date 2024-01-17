package ar.com.interfaz;

public class ClaseDaemonThread implements Runnable{

	@Override
	public void run() {
		if(Thread.currentThread().isDaemon()) {
			while(true) {
				System.out.println("Recopilando datos...");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		else {
			try {
				System.out.println("Ejecutando Hilo no daemon");
				Thread.sleep(2000);
				System.out.println("Finalizado");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		Thread tDaemon  = new Thread(new ClaseDaemonThread());
		tDaemon.setDaemon(true);
		tDaemon.start();
		
		Thread tNoDaemon = new Thread(new ClaseDaemonThread());
		tNoDaemon.start();
	}
	
}
