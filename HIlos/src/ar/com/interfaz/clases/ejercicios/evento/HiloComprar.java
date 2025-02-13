package ar.com.interfaz.clases.ejercicios.evento;

public class HiloComprar implements Runnable{

	private Comprador comprador;
	
	
	public HiloComprar(Comprador comprador) {
		super();
		this.comprador = comprador;
	}


	@Override
	public void run() {
		synchronized (this) {
			Integer cantidad = comprarBoletos();
			if(EjercicioEvento.evento.CANTIDAD_DISPONIBLE >= cantidad) {
				comprador.setCantidadBoletos(cantidad);
				EjercicioEvento.evento.CANTIDAD_DISPONIBLE -= cantidad;
				EjercicioEvento.evento.setComprador(comprador);
				System.out.println("El comprador ha terminado su compra!!");

			}
			else
				System.out.println("NO HAY STOCK !!");

		}
	}
	
	public Integer comprarBoletos() {
		return (int)(Math.random()*5+1);
	}

}
