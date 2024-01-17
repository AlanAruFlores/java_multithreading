package ar.com.interfaz.clases.ejercicios.botella;

public class Botella implements Runnable{
	
	private final Integer ALTO = 6;
	private final Integer ANCHO  = 4;
	private String[][] botella = new String[ALTO][ANCHO];
	
	private Integer valorSleep;
	
	private String nombreBotella;
	
	public Botella(String nombreBotella) {
		construirBotella();
		valorSleep = generarValorSleep();
		this.nombreBotella = nombreBotella;
		
	}
	
	private Integer generarValorSleep() {
		return (int) (Math.random()*4000+1000);
	}
	
	private void construirBotella() {
		for(int i = 0 ; i < ALTO; i++) {
			for(int j = 0 ; j< ANCHO; j++) {
				if(j == 0 || j == ANCHO-1)
					botella[i][j] = "|";
				else if(i == ALTO-1 && (j != 0 && j != ANCHO-1))
					botella[i][j] = "_";
				else
					botella[i][j] = " ";
			}
			
		}
		
	}
	
	private void mostrarBotella() {
		for(int i = 0 ; i<ALTO; i++) {
			for(int j = 0 ; j<ANCHO; j++) {
				System.out.print(botella[i][j]);
			}
			System.out.println();
		}
	}
	
	private void hacerEspacios(int n) {
		for(var k = 0 ; k<n; k++) {
			System.out.println();
		}
	}
	
	private void llenarBotella(int alto) {
		for(int i  = 0  ; i<ALTO; i++) {
			for(int j = 0 ; j<ANCHO; j++) {
				if(i == alto && (j != 0 && j != ANCHO-1))
					botella[i][j] = "*";
			}
		}
	}
	@Override
	public void run() {

		
		int subida  = ALTO-2;
		ciclo:while(true) {
			try {
				synchronized (this) {
					hacerEspacios(2);
					mostrarBotella(); 
					System.out.println(this.nombreBotella);
					hacerEspacios(2);
					
					if(subida == 0)
						break ciclo;
					llenarBotella(subida);
					subida--;
				}
				Thread.sleep(valorSleep);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName()+ " lleno la "
				+ ""+this.nombreBotella+"\n");
	}
}
