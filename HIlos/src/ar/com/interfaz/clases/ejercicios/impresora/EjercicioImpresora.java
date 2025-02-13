package ar.com.interfaz.clases.ejercicios.impresora;

import java.util.ArrayList;
import java.util.Collection;

/*
 * Imagina que estás desarrollando un sistema para simular la impresión
 *  de documentos en una impresora compartida.
 *  Varios usuarios intentarán imprimir documentos de manera concurrente,
 *  y queremos garantizar que la impresión sea segura y eficiente.
 * */

public class EjercicioImpresora {
	static Collection <Usuario> usuarios = new ArrayList<Usuario>() {
		{
			for(int i  = 0 ; i<20; i++) 
				add(new Usuario("mai"+i+"@gmail", "nombre "+i,"contrasenia "+i,
						new Documento("titulo "+i, "contenido "+i, 
								(int) (Math.random()*2+1) == 1 ? TipoDocumento.DOCX : TipoDocumento.PDF)));
		}
	};
	
	
	static Collection<Documento> docs = new ArrayList<Documento>() {
		{
			for(Usuario usuario : usuarios) {
				add(usuario.getDoc());
			}
		}
	};
	
	
	
	public static void main(String[] args) {
		Thread tImpresora = new Thread(new Impresora(docs));
		tImpresora.start();
		try {
			tImpresora.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			System.out.println("LA IMPRESORA TERMINO SU TRABAJO!!");
		}
	}
	
}
