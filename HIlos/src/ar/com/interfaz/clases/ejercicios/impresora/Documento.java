package ar.com.interfaz.clases.ejercicios.impresora;

public final class Documento {
	private String titulo;
	private String contenido;
	private TipoDocumento formato;
	
	public Documento(String titulo, String contenido, TipoDocumento formato) {
		super();
		this.titulo = titulo;
		this.contenido = contenido;
		this.formato = formato;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	public TipoDocumento getFormato() {
		return formato;
	}
	public void setFormato(TipoDocumento formato) {
		this.formato = formato;
	}
	@Override
	public String toString() {
		return titulo+"." + formato;
	}
	
	
}
