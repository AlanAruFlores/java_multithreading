package ar.com.interfaz.clases.ejercicios.impresora;

public class Usuario {
	private String mail;
	private String contrasenia;
	private String nombre;
	
	private Documento doc;
	
	
	
	public Usuario(String mail, String contrasenia, String nombre, Documento doc) {
		super();
		this.mail = mail;
		this.contrasenia = contrasenia;
		this.nombre = nombre;
		this.doc = doc;
	}


	public Usuario(String mail, String contrasenia, String nombre) {
		super();
		this.mail = mail;
		this.contrasenia = contrasenia;
		this.nombre = nombre;
		this.doc = null;
		
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public String getContrasenia() {
		return contrasenia;
	}


	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Documento getDoc() {
		return doc;
	}


	public void setDoc(Documento doc) {
		this.doc = doc;
	}


	@Override
	public String toString() {
		return "Usuario [mail=" + mail + ", nombre=" + nombre + "]";
	}
	
	
}
