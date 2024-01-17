package ar.com.interfaz.clases.ejercicios.evento;

import java.util.Date;

public abstract class Persona {
	private String nombre;
	private String apellido;
	private Integer edad;
	private final Date fechaNacimiento;
	
	public Persona(String nombre, String apellido, Integer edad, Date fechaNacimiento) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", fechaNacimiento="
				+ fechaNacimiento.toString()+ "]";
	}
	
	
	
	
}
