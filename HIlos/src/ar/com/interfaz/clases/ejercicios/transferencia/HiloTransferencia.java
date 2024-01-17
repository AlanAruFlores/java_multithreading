package ar.com.interfaz.clases.ejercicios.transferencia;

public class HiloTransferencia implements Runnable{

	private Transferencia transferencia;
	
	public HiloTransferencia(Transferencia t) {
		this.transferencia = t;
	}
	
	@Override
	public void run() {
		synchronized (this) {
			if(transferencia.getSaldoTransferido() 
					<= this.transferencia.getEmisor().getSaldo()) {
				CuentaBancaria emisor= transferencia.getEmisor();
				Double dineroEmisor  = emisor.getSaldo();
				emisor.setSaldo(dineroEmisor-transferencia.getSaldoTransferido());
				
				CuentaBancaria receptor = transferencia.getReceptor();
				Double dineroReceptor = receptor.getSaldo();
				receptor.setSaldo(dineroReceptor+transferencia.getSaldoTransferido());
				
				EjercicioTransferencia.arrTran.add(transferencia);
			}else {
				System.out.println("TRANSFERENCIA FALLIDA");
			}
		}
	}

}
