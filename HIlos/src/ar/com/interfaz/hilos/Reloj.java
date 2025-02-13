package ar.com.interfaz.hilos;

public class Reloj implements Runnable{

	private int segundos;
	private int minutos;
	private int horas;
	
	public Reloj() {
		segundos = minutos = horas = 0;
	}
	@Override
	public void run() {
		
		try {
			while(true) {
				segundos++;
				if(segundos >= 60) {
					minutos++;
					segundos=0;
				}
				else if(minutos >= 60) {
					horas++;
					minutos =0;
				}
				System.out.println(toString());
				Thread.sleep(1000);				
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public String toString() {
		return (((this.horas<=9)?"0":"") + this.horas)+":"+(((this.minutos<=9)?"0":"") + this.minutos)+":"+
				(((this.segundos<=9)?"0":"") + this.segundos);
	}

}
