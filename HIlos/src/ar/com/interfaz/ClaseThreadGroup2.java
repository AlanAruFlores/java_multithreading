package ar.com.interfaz;

public class ClaseThreadGroup2 extends Thread{

	public ClaseThreadGroup2(String nombre, ThreadGroup grupo) {
		super(grupo, nombre);
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			System.out.println("Ejercutando el Hilo "+ Thread.currentThread().getName());
		}
	}
	
	public static void main(String[] args) {
		ThreadGroup tg = new ThreadGroup("Grupo D");
		ThreadGroup tg1 = new ThreadGroup(tg, "Grupo E");
		
		ClaseThreadGroup2 t1 = new ClaseThreadGroup2(" Thread A ", tg);
		ClaseThreadGroup2 t2 = new ClaseThreadGroup2(" Thread B ", tg);

		t1.start();
		t2.start();
		
		tg1.list();
		
		System.out.println("HILOS ACTIVOS EN EL ThreadGroup: "+ tg.activeCount());
		System.out.println("ThreadGroups Activos: "+tg.activeGroupCount());
	
		//Obtengo los hilos activos
		Thread[] hilosActivos  = new Thread[tg.activeCount()];
		int nCantidad = tg.enumerate(hilosActivos);
		
		for(int i = 0 ; i<nCantidad; i++) {
			System.out.println("El hilo '"+hilosActivos[i].getName()+"' esta activo");
		}
		
		//Obtener la prioridad maxima
		int prioridadMaxima = tg.getMaxPriority();
		System.out.println("La prioridad maxima del grupo tg es: "+prioridadMaxima);
		
		//Obtener el ThreadGroup padre de un grupo
		System.out.println("El padre del "+tg1.getName()+" es "+tg1.getParent().getName());
		System.out.println("El padre del "+tg.getName()+" es "+tg.getParent().getName());

		//Verificar si un grupo es Daemon
		
		if(tg.isDaemon()) {
			System.out.println(tg.getName()+" ES DAEMON GROUP");
		}else {
			System.out.println(tg.getName()+" NO ES DAEMON GROUP");
		}
		
		//Destruyendo hilo
		if(!tg1.isDestroyed())
			System.out.println("No esta destruido el grupo 'th1'" );
			
		tg1.destroy();
		
		if(tg1.isDestroyed())
			System.out.println("Esta destruido");
	}
	
}
