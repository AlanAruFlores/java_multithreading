package ar.com.interfaz.clases.ejercicios.transferencia;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * Supongamos que estás desarrollando un sistema bancario 
 * y necesitas simular transferencias entre cuentas concurrentes.
 *  Cada cuenta bancaria tiene un saldo inicial
 *  y las transferencias deben ser seguras en un entorno multihilo.
 * */
public class EjercicioTransferencia {

	static Collection<CuentaBancaria> arrCbus  =new ArrayList<>();
	static Collection<Transferencia> arrTran  =new ArrayList<>();
	static final int CANTIDAD_MAXIMA = 100;
	
	public static void main(String[] args) {
		
		Runnable rData = new Runnable() {
			public void run() {
				for(int i = 0 ; i < CANTIDAD_MAXIMA; i++)
					arrCbus.add(new CuentaBancaria(i+1, "titular "+i, "alias "+i, 1000.0));
				System.out.println("Los datos ya se cargaron");
			}
		};
		
		Thread tData = new Thread(rData);
		try{
			tData.start();
			tData.join();
		}catch(InterruptedException ex) {
			ex.printStackTrace();
		}
		
		//Realizamos las transferencias
		ExecutorService pool = Executors.newFixedThreadPool(4);
		for(int i = 0 ; i<20; i++) {
			Thread tTransferencia  = new Thread(
					new HiloTransferencia(
							new Transferencia(getCuentaById(), getCuentaById(), getMonto())));
			pool.execute(tTransferencia);
			
		}
		pool.shutdown();
		
		while(!pool.isTerminated()) {}
		
		System.out.println("\nTRANSFERENCIA REALIZADAS:");
		mostrarTransferencias();
		
	}
	
	private static void mostrarTransferencias() {
		for(Transferencia t: arrTran) {
			System.out.println(t+"\n\n");
		}
	}
	
	private static CuentaBancaria getCuentaById() {
		Integer idRandom = (int)(Math.random()*CANTIDAD_MAXIMA);
		return ((List<CuentaBancaria>)arrCbus).get(idRandom);
	}
	
	private static Double getMonto() {
		Double monto = Math.random()*600+200;
		return monto;
	}
}
