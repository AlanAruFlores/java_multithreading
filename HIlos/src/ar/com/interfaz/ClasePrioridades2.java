package ar.com.interfaz;

public class ClasePrioridades2 implements Runnable {
	
	@Override
	public void run() {
		
		String name = Thread.currentThread().getName();
		for(int i = 0 ; i<100; i++) {
			System.out.println(name+" EJECUTANDOSE");
		}
	}
	
	public static void main(String[] args) {
		String[] arrNombres = {
				"MinHilo",
				"MaxHilo"
		} ;
		
		int priority  = Thread.MIN_PRIORITY;
		for(int i = 0 ; i<arrNombres.length; i++) {
			if(i != 0) priority = Thread.MAX_PRIORITY;
			Thread t = new Thread(new ClasePrioridades2());
			t.setPriority(priority);
			t.setName(arrNombres[i]);
			t.start();
		}
		
	}
}
