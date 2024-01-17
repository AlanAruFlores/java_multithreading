package ar.com.interfaz.clases.ejercicios.transferencia;

public final class Transferencia {
	private CuentaBancaria emisor;
	private CuentaBancaria receptor;
	private Double saldoTransferido;
	public Transferencia(CuentaBancaria emisor, CuentaBancaria receptor, Double saldoTransferido) {
		super();
		this.emisor = emisor;
		this.receptor = receptor;
		this.saldoTransferido = saldoTransferido;
	}
	public CuentaBancaria getEmisor() {
		return emisor;
	}
	public void setEmisor(CuentaBancaria emisor) {
		this.emisor = emisor;
	}
	public CuentaBancaria getReceptor() {
		return receptor;
	}
	public void setReceptor(CuentaBancaria receptor) {
		this.receptor = receptor;
	}
	public Double getSaldoTransferido() {
		return saldoTransferido;
	}
	public void setSaldoTransferido(Double saldoTransferido) {
		this.saldoTransferido = saldoTransferido;
	}
	@Override
	public String toString() {
		return "Transferencia [emisor=" + emisor + ", receptor=" + receptor + ", saldoTransferido=" + saldoTransferido
				+ "]";
	}
	
	
}
