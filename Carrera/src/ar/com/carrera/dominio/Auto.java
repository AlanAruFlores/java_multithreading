package ar.com.carrera.dominio;

public abstract class Auto {
	private String marca;
	private String modelo;
	private Integer km;
	private String color;
	
	
	
	public Auto(String marca, String modelo, Integer km, String color) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.km = km;
		this.color = color;
	}
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public Integer getKm() {
		return km;
	}
	public void setKm(Integer km) {
		this.km = km;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Auto [marca=" + marca + ", modelo=" + modelo + ", km=" + km + ", color=" + color + "]";
	}
	
	
}
