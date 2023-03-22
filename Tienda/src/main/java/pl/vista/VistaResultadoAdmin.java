package pl.vista;

import java.io.PrintWriter;

import dl.Producto;

public class VistaResultadoAdmin implements Vista {
	private final Producto p;
	private final String mensaje;
	
	public VistaResultadoAdmin(Producto p, String mensaje) {
		this.p = p;
		this.mensaje = mensaje;
	}
	
	@Override
	public void print(PrintWriter pw) {
		pw.println(Utilidades.DOCTYPE);
		pw.println(Utilidades.headConTitleStyle("ARTÍCULO AÑADIDO", "estilo.css"));
		pw.println("<body>");
		pw.println("<h1>Artículo " + p.getDescripcion() + " dado de alta en la categoría " + p.getTipo() +" con un precio de " + p.getPrecio() + " euros</h1>");
		pw.println("<h2>Alta producto (null) o no alta producto (mensaje error): " + mensaje + "</h2>"); 
		pw.println(Utilidades.FIN);
	}
	

}
