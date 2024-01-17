package ar.com.interfaz.clases.ejercicios.evento;

import java.util.ArrayList;
import java.util.Collection;

public final class Evento {
	
	private String titulo;
	private String descripcion;
	public final Float PRECIO_ENTRADA = 14.4f;
	public Integer CANTIDAD_DISPONIBLE = 100;
	
	private Collection<Comprador> arrCompradores;
	
	
	public Evento(String titulo, String descripcion) {
		this.titulo = titulo;
		this.descripcion = descripcion;
		arrCompradores = new ArrayList<Comprador>();
	}

	public void setComprador(Comprador c) {
		this.arrCompradores.add(c);	
	}
	
	public String mostrarCompradores() {
		String txt  = "";
		
		txt+="INFORMACION DE LOS COMPRADORES \n";
		
		for(Comprador c: arrCompradores) {
			 txt += c.toString()+"\n";
		}
		
		txt+="CANTIDAD BOLETOS: "+ this.CANTIDAD_DISPONIBLE+"\n";
		
		return txt;
		
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	@Override
	public String toString() {
		return "Evento [titulo=" + titulo + ", descripcion=" + descripcion + ", PRECIO_ENTRADA=" + PRECIO_ENTRADA
				+ ", CANTIDAD_DISPONIBLE=" + CANTIDAD_DISPONIBLE + "]";
	}
	
	
}
