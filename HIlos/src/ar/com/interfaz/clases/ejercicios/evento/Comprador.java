package ar.com.interfaz.clases.ejercicios.evento;

import java.util.Date;

public final class Comprador extends Persona{

	private Integer cantidadBoletos;
	
	
	public Comprador(String nombre, String apellido, Integer edad, Date fechaNacimiento) {
		super(nombre, apellido, edad, fechaNacimiento);
		
		this.cantidadBoletos =  0;
		
	}

	public Comprador(String nombre, String apellido, Integer edad, Date fechaNacimiento,
			Integer cantidadBoletos) {
		super(nombre, apellido, edad, fechaNacimiento);
		
		this.cantidadBoletos = cantidadBoletos;
	}
	
	public Integer getCantidadBoletos() {
		return cantidadBoletos;
	}

	public void setCantidadBoletos(Integer cantidadBoletos) {
		this.cantidadBoletos = cantidadBoletos;
	}

	@Override
	public String toString() {
		return super.toString()+ " [cantidadBoletos=" + cantidadBoletos + "]";
	}
	

}
