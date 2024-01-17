package ar.com.interfaz;


/*Para que 2 hilos trabajen de manera distinta tenemos como primera forma
 * definir 2 clases distintas que implementen de Runnable*/
public class ClaseMultitask {

	public static void main(String[] args) {
		Thread t1 = new Thread(new ClaseMultitaskPar());
		Thread t2 = new Thread(new ClaseMultitaskImpar());

		t1.run();
		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		t2.run();
		try {
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		
	}
}
