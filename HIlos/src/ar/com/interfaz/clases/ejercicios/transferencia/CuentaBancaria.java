package ar.com.interfaz.clases.ejercicios.transferencia;

public final class CuentaBancaria {
	private Integer id;
	private String titular;
	private String alias;
	private Double saldo;
	
	public CuentaBancaria(Integer id, String titular, String alias, Double saldo) {
		super();
		this.id = id;
		this.titular = titular;
		this.alias = alias;
		this.saldo = saldo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	@Override
	public String toString() {
		return "CuentaBancaria [id=" + id + ", titular=" + titular + ", saldo=" + saldo + "]";
	}
	
	
}
